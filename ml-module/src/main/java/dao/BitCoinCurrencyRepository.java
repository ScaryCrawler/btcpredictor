package dao;

import models.BitCoinCurrencyRate;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BitCoinCurrencyRepository extends MongoRepository<BitCoinCurrencyRate, String> {
}
