package pl.matigre.curreny_exchange.model;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Builder
public class Rate {

    private String no;

    private LocalDate effectiveDate;

    private BigDecimal mid;
}
