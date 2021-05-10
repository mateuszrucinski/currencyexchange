package pl.matigre.curreny_exchange.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.matigre.curreny_exchange.client.dto.RateMainDto;
import pl.matigre.curreny_exchange.mapper.RateDtoToModelMapper;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;

import java.math.BigDecimal;
import java.time.LocalDate;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RateClientTest {

    @InjectMocks
    private RateClient rateClient;

    @Mock
    private RateDtoToModelMapper rateDtoToModelMapper;

    @Test
    void should_getRateForObject_return_RateMain() {
        //given
        final RateMain expected = rateMain();
        final String table = "a";
        final String code = "eur";
        when(rateDtoToModelMapper.mapRateMainDtoToRateMain(any(RateMainDto.class))).thenReturn(expected);

        //when
        RateMain result = rateClient.getRateForObject(table, code);

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
