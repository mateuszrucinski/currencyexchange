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
        final Rate rate = getRate();
        final RateMain expected = getMain(rate);
        final String table = "a";
        final String code = "eur";
        when(rateClient.getRateForObject(table, code)).thenReturn(expected);

        //when
        final RateMain result = rateService.getRate(table, code);

        //then
        assertThat(result).isEqualTo(expected);
    }

    private RateMain getMain(Rate rate) {
        final RateMain expected = new RateMain();
        expected.setTable("a");
        expected.setCode("eur");
        expected.setCurrency("sjdskm");
        expected.setRates(asList(rate));

        return expected;
    }

    private Rate getRate() {
        final Rate rate = new Rate();
        LocalDate localDate = LocalDate.of(2021, 05, 10);
        rate.setEffectiveDate(localDate);
        BigDecimal bd = new BigDecimal(3.7493);
        rate.setMid(bd);
        rate.setNo("088/A/NBP/2021");
        return rate;
    }

    private RateMainDto getMainDto(RateDto rateDto) {
        final RateMainDto expected = new RateMainDto();
        expected.setTable("a");
        expected.setCode("eur");
        expected.setCurrency("sjdskm");
        expected.setRates(asList(rateDto));

        return expected;
    }

    private RateDto getRateDto() {
        final RateDto rateDto = new RateDto();
        LocalDate localDate = LocalDate.of(2021, 05, 10);
        rateDto.setEffectiveDate(localDate);
        BigDecimal bd = new BigDecimal(3.7493);
        rateDto.setMid(bd);
        rateDto.setNo("088/A/NBP/2021");
        return rateDto;
    }

}