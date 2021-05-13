package pl.matigre.curreny_exchange.controller;

import org.json.JSONException;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import org.springframework.test.context.junit4.SpringRunner;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;
import pl.matigre.curreny_exchange.service.RateService;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@EnableAutoConfiguration(exclude = SecurityAutoConfiguration.class)
public class RateControllerJUnit4Test {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private RateService service;

    @Test
    public void should_get_rate() throws JSONException {
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
                .code("1")
                .currency("eur")
                .rates(asList(Rate.builder()
                        .build()))
                .table("a")
                .build();
    }
}
