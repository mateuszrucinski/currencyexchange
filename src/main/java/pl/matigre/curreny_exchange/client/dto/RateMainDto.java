package pl.matigre.curreny_exchange.client.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonDeserialize(as = RateMainDto.class)
//@RequiredArgsConstructor
public class RateMainDto {

    private String table;

    private String currency;

    private String code;

    private List<RateDto> rates;

}
