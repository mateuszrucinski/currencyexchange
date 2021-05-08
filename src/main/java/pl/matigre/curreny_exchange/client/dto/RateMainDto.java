package pl.matigre.curreny_exchange.client.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
//@JsonDeserialize(as = RateMainDto.class)
//@RequiredArgsConstructor
public class RateMainDto {

    private String table;

    private String currency;

    private String code;

//    private List<RateDto> rates;

}
