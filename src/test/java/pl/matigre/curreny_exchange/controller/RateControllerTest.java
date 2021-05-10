package pl.matigre.curreny_exchange.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;
import pl.matigre.curreny_exchange.service.RateService;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateControllerTest {

    @InjectMocks
    private RateController rateController;

    @Mock
    private RateService rateService;

    @Test
    void should_getRate_getRateService() {
        //given
        RateMain expected = rateMain();
        final String table = "a";
        final String code = "eur";
        when(rateService.getRate(table, code)).thenReturn(expected);
        //when
        RateMain result = rateController.getRate(table, code);

        //then
        assertThat(result).isEqualTo(expected);

    }

    private RateMain rateMain() {
        return RateMain.builder()
                .table("a")
                .currency("eur")
                .code("eur")
                .rates(asList(rate()))
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