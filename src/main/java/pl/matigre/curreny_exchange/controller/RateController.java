package pl.matigre.curreny_exchange.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.matigre.curreny_exchange.model.RateMain;
import pl.matigre.curreny_exchange.service.RateService;

@RestController
public class RateController {

    private final RateService rateService;

    public RateController(RateService rateService) {
        this.rateService = rateService;
    }

    @GetMapping("/rate/{table}/{code}")
    public RateMain getRate(@PathVariable String table, @PathVariable String code) {
        return rateService.getRate(table, code);
    }
}
