package pl.matigre.curreny_exchange.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.matigre.curreny_exchange.client.dto.RateMainDto;
import pl.matigre.curreny_exchange.mapper.RateDtoToModelMapper;
import pl.matigre.curreny_exchange.model.RateMain;

@Component
public class RateClient {

    public static final String URI_RATE = "https://api.nbp.pl/api/exchangerates/rates/";
    private final RestTemplate restTemplate = new RestTemplate();
    private final RateDtoToModelMapper rateDtoToModelMapper;

    public RateClient(RateDtoToModelMapper rateDtoToModelMapper) {
        this.rateDtoToModelMapper = rateDtoToModelMapper;
    }

    public RateMain getRateForObject(String table, String code) {
        RateMainDto rateMainDto = restTemplate.getForObject(URI_RATE + "{table}/{rate}",
                RateMainDto.class, table, code);

        return rateDtoToModelMapper.mapRateMainDtoToRateMain(rateMainDto);
    }
}
