package pl.matigre.curreny_exchange.mapper;

import pl.matigre.curreny_exchange.client.dto.RateDto;
import pl.matigre.curreny_exchange.client.dto.RateMainDto;
import pl.matigre.curreny_exchange.model.Rate;
import pl.matigre.curreny_exchange.model.RateMain;

import java.util.stream.Collectors;

public class RateDtoToModelMapper {

    public RateMain mapRateMainDtoToRateMain(RateMainDto rateMainDto) {

        return RateMain.builder()
                .table(rateMainDto.getTable())
                .code(rateMainDto.getCode())
                .currency(rateMainDto.getCurrency())
                .rates(rateMainDto.getRates().stream()
                        .map(this::mapRate).collect(Collectors.toList()))
                .build();
    }

    private Rate mapRate(RateDto rateDto) {

        return Rate.builder()
                .no(rateDto.getNo())
                .effectiveDate(rateDto.getEffectiveDate())
                .mid(rateDto.getMid())
                .build();
    }
}
