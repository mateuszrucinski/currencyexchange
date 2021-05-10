package pl.matigre.curreny_exchange.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Rate {

    private String no;

    private LocalDate effectiveDate;

    private BigDecimal mid;

    public Rate() {
    }

    public Rate(String no, LocalDate effectiveDate, BigDecimal mid) {
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
