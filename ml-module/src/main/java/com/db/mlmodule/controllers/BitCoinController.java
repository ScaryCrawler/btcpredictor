package com.db.mlmodule.controllers;

import com.db.mlmodule.models.BitCoinCurrencyRate;
import com.db.mlmodule.services.MlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BitCoinController {
    @Autowired
    private MlService mlService;

    @GetMapping("/predictedRates")
    public List<BitCoinCurrencyRate> getAllRates() {
        return mlService.fitModel();
    }
}
