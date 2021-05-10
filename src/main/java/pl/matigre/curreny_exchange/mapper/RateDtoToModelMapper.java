package pl.matigre.curreny_exchange.mapper;

import pl.matigre.curreny_exchange.client.dto.RateDto;
import pl.matigre.curreny_exchange.client.dto.RateMainDto;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;

import java.util.stream.Collectors;

public class RateDtoToModelMapper {

    public RateMain mapRateMainDtoToRateMain(RateMainDto rateMainDto) {

        RateMain rateMain = new RateMain(
                rateMainDto.getTable(),
                rateMainDto.getCurrency(),
                rateMainDto.getCode(),
                rateMainDto.getRates().stream().map(this::mapRate).collect(Collectors.toList())
        );
        return rateMain;
    }

    private Rate mapRate(RateDto rateDto) {
        Rate rate = new Rate(rateDto.getNo(), rateDto.getEffectiveDate(), rateDto.getMid());

        return rate;
    }
}
