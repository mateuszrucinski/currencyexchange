package pl.matigre.curreny_exchange.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.matigre.curreny_exchange.client.RateClient;
import pl.matigre.curreny_exchange.client.dto.RateDto;
import pl.matigre.curreny_exchange.client.dto.RateMainDto;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateServiceTest {

    @Mock
    private RateClient rateClient;

    @InjectMocks
    private RateService rateService;

    @Test
    void should_getRate_return_getRateForObject() {
        //given
        final RateMain expected = rateMain();
        final String table = "a";
        final String code = "eur";
        when(rateClient.getRateForObject(table, code)).thenReturn(expected);

        //when
        final RateMain result = rateService.getRate(table, code);

        //then
        assertThat(result).isEqualTo(expected);
    }


    private RateMain rateMain() {
        return RateMain.builder()
                .code("1")
                .currency("dolar amerykański")
                .rates(asList(Rate.builder()
                        .build()))
                .table("a")
                .build();
    }

}