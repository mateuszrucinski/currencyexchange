package pl.matigre.curreny_exchange.client.dto;

import lombok.*;

import java.util.List;

////@JsonDeserialize(as = RateMainDto.class)
////@RequiredArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateMainDto {

    private String table;

    private String currency;

    private String code;

    private List<RateDto> rates;

}
