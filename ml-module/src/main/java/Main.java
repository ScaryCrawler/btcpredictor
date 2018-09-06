import com.db.mlmodule.models.BitCoinCurrencyRate;
import com.mongodb.spark.MongoSpark;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .master("local")
                .appName("MongoSpark")
                .config("spark.mongodb.input.uri", "mongodb://localhost:27017/btccrawler.bitCoinCurrencyRate")
                .config("spark.mongodb.output.uri", "mongodb://localhost:27017/btccrawler.bitCoinCurrencyRate")
                .getOrCreate();

        JavaSparkContext sparkContext = new JavaSparkContext(spark.sparkContext());

        Dataset<Row> rdd = MongoSpark.load(sparkContext).toDF();

        Dataset<BitCoinCurrencyRate> result = rdd.as(Encoders.bean(BitCoinCurrencyRate.class));

        result.show();
        List<BitCoinCurrencyRate> currencyRates = result.collectAsList();
        System.out.println(currencyRates);
        sparkContext.close();
    }
}
