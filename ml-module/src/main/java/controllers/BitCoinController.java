package controllers;

import dao.BitCoinCurrencyRepository;
import models.BitCoinCurrencyRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BitCoinController {
    @Autowired
    private BitCoinCurrencyRepository bitCoinCurrencyRepository;

    @GetMapping("/rawRates")
    public List<BitCoinCurrencyRate> getAllRates() {
        return bitCoinCurrencyRepository.findAll();
    }


}
