package com.db.consumer.dao;


import com.db.consumer.models.BitCoinCurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BitCoinCurrencyRepository extends MongoRepository<BitCoinCurrencyRate, String> {
}
