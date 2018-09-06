package com.db.mlmodule.services;

import com.mongodb.spark.MongoSpark;
import com.db.mlmodule.models.BitCoinCurrencyRate;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MlServiceImpl implements MlService {
    @Override
    @Scheduled(fixedDelay = 10000)
    public List<BitCoinCurrencyRate> fitModel() {
        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MongoSpark")
                .config("spark.mongodb.input.uri", "mongodb://localhost:27017/btccrawler.bitCoinCurrencyRate")
                .config("spark.mongodb.output.uri", "mongodb://localhost:27017/btccrawler.bitCoinCurrencyRate")
                .getOrCreate();

        JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());

        Dataset<Row> rdd = MongoSpark.load(sparkContext).toDF();

        Dataset<BitCoinCurrencyRate> result = rdd.as(Encoders.bean(BitCoinCurrencyRate.class));

        List<BitCoinCurrencyRate> currencyRates = result.collectAsList();
        sparkContext.close();

        return currencyRates;
    }
}
