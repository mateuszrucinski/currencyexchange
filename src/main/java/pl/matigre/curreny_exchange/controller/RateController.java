package pl.matigre.curreny_exchange.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.matigre.curreny_exchange.model.RateMain;
import pl.matigre.curreny_exchange.service.RateService;

@RestController
@RequiredArgsConstructor
public class RateController {

    private final RateService rateService;


    @GetMapping("/rate/{table}/{code}")
    public RateMain getRate(@PathVariable String table, @PathVariable String code) {
        return rateService.getRate(table, code);
    }
}
