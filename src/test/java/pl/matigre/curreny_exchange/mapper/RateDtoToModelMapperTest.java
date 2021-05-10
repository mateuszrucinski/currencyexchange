package pl.matigre.curreny_exchange.mapper;

import org.junit.jupiter.api.Test;
import pl.matigre.curreny_exchange.client.dto.RateDto;
import pl.matigre.curreny_exchange.client.dto.RateMainDto;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RateDtoToModelMapperTest {

    private RateDtoToModelMapper mapper = new RateDtoToModelMapper();

    @Test
    void should_map_rate_dto_to_model() {
        //given
        final RateMain expected = rateMain();
        final RateMainDto given = rateMainDto();
        //when
        final RateMain result = mapper.mapRateMainDtoToRateMain(given);
        //then
        assertThat(result).isNotNull();
        assertThat(result).usingRecursiveComparison().isEqualTo(expected);
    }

    @Test
    void should_throw_exception_when_parameter_is_null() {
        //given

        //when&then
        assertThrows(NullPointerException.class, () -> mapper.mapRateMainDtoToRateMain(null));
    }

    private RateMainDto rateMainDto() {
        RateDto rateDto = new RateDto();


        RateMainDto rateMainDto = new RateMainDto("a", "dolar amerykański", "usd", asList(rateDto));

        return rateMainDto;
    }

    private RateMain rateMain() {
        Rate rate = new Rate();

        RateMain rateMain = new RateMain("a", "dolar amerykański", "usd", asList(rate));

        return rateMain;
    }
}