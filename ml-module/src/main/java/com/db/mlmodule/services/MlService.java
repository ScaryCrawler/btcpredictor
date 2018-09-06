package com.db.mlmodule.services;

import com.db.mlmodule.models.BitCoinCurrencyRate;

import java.util.List;

public interface MlService {
    List<BitCoinCurrencyRate> fitModel();
}
