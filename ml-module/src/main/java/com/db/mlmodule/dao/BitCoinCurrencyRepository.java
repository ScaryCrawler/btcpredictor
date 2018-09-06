package com.db.mlmodule.dao;

import com.db.mlmodule.models.BitCoinCurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BitCoinCurrencyRepository extends MongoRepository<BitCoinCurrencyRate, String> {
}
