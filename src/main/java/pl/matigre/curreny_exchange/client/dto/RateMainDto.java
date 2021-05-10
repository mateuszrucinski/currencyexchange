package pl.matigre.curreny_exchange.client.dto;

import java.util.List;


//@NoArgsConstructor
//@AllArgsConstructor
////@JsonDeserialize(as = RateMainDto.class)
////@RequiredArgsConstructor
public class RateMainDto {

    private String table;

    private String currency;

    private String code;

    private List<RateDto> rates;

    public RateMainDto() {
    }

    public RateMainDto(String table, String currency, String code, List<RateDto> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<RateDto> getRates() {
        return rates;
    }

    public void setRates(List<RateDto> rates) {
        this.rates = rates;
    }
}
