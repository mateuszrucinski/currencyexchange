package pl.matigre.curreny_exchange.mapper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.matigre.curreny_exchange.client.dto.RateDto;
import pl.matigre.curreny_exchange.client.dto.RateMainDto;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class RateDtoToModelMapperTest {

    @InjectMocks
    private RateDtoToModelMapper mapper;

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
        return RateMainDto.builder()
                .code("1")
                .currency("dolar amerykański")
                .rates(asList(RateDto.builder()
                        .build()))
                .table("a")
                .build();
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