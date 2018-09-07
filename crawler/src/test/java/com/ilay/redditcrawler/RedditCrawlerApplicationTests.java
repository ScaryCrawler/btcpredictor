package com.ilay.redditcrawler;

import com.ilay.redditcrawler.dao.BitcoinCurrencyRateRepository;
import com.ilay.redditcrawler.models.BitCoinCurrencyRate;
import org.bson.types.ObjectId;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedditCrawlerApplicationTests {

    @Autowired
    private BitcoinCurrencyRateRepository repository;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(repository);
    }

    @Test
    public void dataLoadedToDataBase(){
        String objectId = ObjectId.get().toString();
        repository.save(BitCoinCurrencyRate.builder()
                .buy(123.1)
                .sell(123.1)
                .code("USD")
                .time(LocalDateTime.now())
                .id(objectId)
                .build());

        Optional<BitCoinCurrencyRate> savedObject = repository.findById(objectId);
        Assert.assertTrue(savedObject.isPresent());
        repository.deleteById(objectId);
    }

}
