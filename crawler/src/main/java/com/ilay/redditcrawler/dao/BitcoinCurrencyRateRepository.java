package com.ilay.redditcrawler.dao;

import com.ilay.redditcrawler.models.BitcoinCurrencyRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

public interface BitcoinCurrencyRateRepository extends
        CrudRepository<BitcoinCurrencyRate, Integer> {
}
