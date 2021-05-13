package pl.matigre.curreny_exchange.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;
import pl.matigre.curreny_exchange.service.RateService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT) //for RestTemplate
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
class RateControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    private RateService service;

    @Test
    void should_getRate() throws JSONException {
        //given
        final RateMain rateMain = rateMain();
        when(service.getRate("a", "eur")).thenReturn(rateMain);
        final String expected = "{\"table\":\"a\",\"currency\":\"eur\",\"code\":\"1\",\"rates\":[{\"no\":null,\"effectiveDate\":null,\"mid\":null}]}";
        //when
        ResponseEntity<String> response = testRestTemplate.getForEntity("/rate/a/eur", String.class);

        //then
        assertThat(response).isNotNull();
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertEquals(MediaType.APPLICATION_JSON, response.getHeaders().getContentType());
        JSONAssert.assertEquals(expected, response.getBody(), false);

        verify(service, times(1)).getRate("a", "eur"); // parametr times nie jest potrzebny jesli wartość równa się 1 to jest domyślna wartość
    }

    private RateMain rateMain() {
        return RateMain.builder()
                .table("a")
                .currency("eur")
                .code("1")
                .rates(asList(Rate.builder().build()))
                .build();
    }

    private Rate rate() {
        BigDecimal bigDecimal = BigDecimal.valueOf(4.5631);
        LocalDate date = LocalDate.of(2021, 5, 10);
        return Rate.builder()
                .no("088/A/NBP/2021")
                .mid(bigDecimal)
                .effectiveDate(date)
                .build();
    }
}