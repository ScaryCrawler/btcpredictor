package com.ilay.redditcrawler.dao;

import com.ilay.redditcrawler.models.BitCoinCurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BitcoinCurrencyRateRepository extends MongoRepository<BitCoinCurrencyRate, String> {
}
