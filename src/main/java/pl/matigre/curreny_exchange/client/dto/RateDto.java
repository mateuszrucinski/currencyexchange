package pl.matigre.curreny_exchange.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

import java.math.BigDecimal;
import java.time.LocalDate;


//@NoArgsConstructor
//@AllArgsConstructor
////@RequiredArgsConstructor
////@JsonDeserialize(as = RateDto.class)
public class RateDto {

    private String no;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("effectiveDate")
    private LocalDate effectiveDate;

    private BigDecimal mid;

    public RateDto() {
    }

    public RateDto(String no, LocalDate effectiveDate, BigDecimal mid) {
        this.no = no;
        this.effectiveDate = effectiveDate;
        this.mid = mid;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public BigDecimal getMid() {
        return mid;
    }

    public void setMid(BigDecimal mid) {
        this.mid = mid;
    }
}
