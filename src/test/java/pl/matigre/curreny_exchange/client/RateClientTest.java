package pl.matigre.curreny_exchange.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateClientTest {

    @Mock
    private RateClient rateClient;

    @Test
    void should_getRateForObject_return_RateMain() {
        //given
        final RateMain expected = rateMain();
        final String table = "a";
        final String code = "eur";
        when(rateClient.getRateForObject(table, code)).thenReturn(expected);

        //when
        RateMain result = rateClient.getRateForObject(table, code);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private RateMain rateMain() {
        return RateMain.builder()
                .table("a")
                .currency("eur")
                .code("dolar amerykański")
                .rates(asList(rate()))
                .build();
    }

    private Rate rate() {
        BigDecimal bigDecimal = BigDecimal.valueOf(13234.65);
        LocalDate date = LocalDate.of(2000, 5, 12);
        return Rate.builder()
                .no("213s")
                .mid(bigDecimal)
                .effectiveDate(date)
                .build();
    }

}