package pl.matigre.curreny_exchange.service;

import org.springframework.stereotype.Service;
import pl.matigre.curreny_exchange.client.RateClient;
import pl.matigre.curreny_exchange.model.RateMain;

@Service
public class RateService {

    private final RateClient rateClient;

    public RateService(RateClient rateClient) {
        this.rateClient = rateClient;
    }

    public RateMain getRate(String table, String code) {
        return rateClient.getRateForObject(table, code);
    }
}
