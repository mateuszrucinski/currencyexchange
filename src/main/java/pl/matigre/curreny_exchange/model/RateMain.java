package pl.matigre.curreny_exchange.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
public class RateMain {

    private String table;

    private String currency;

    private String code;

    private List<Rate> rates;
}
