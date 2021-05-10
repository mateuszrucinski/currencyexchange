package pl.matigre.curreny_exchange.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

////@RequiredArgsConstructor
////@JsonDeserialize(as = RateDto.class)
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RateDto {

    private String no;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("effectiveDate")
    private LocalDate effectiveDate;

    private BigDecimal mid;

}
