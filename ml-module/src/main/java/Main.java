import com.db.mlmodule.models.BitCoinCurrencyRate;
import com.mongodb.spark.MongoSpark;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.ml.regression.LinearRegression;
import org.apache.spark.ml.regression.LinearRegressionModel;
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
        Dataset<Row> dataset = spark.read().format("libsvm").json(rdd.toJSON());

        Dataset<BitCoinCurrencyRate> result = rdd.as(Encoders.bean(BitCoinCurrencyRate.class));


        LinearRegression lr = new LinearRegression()
                .setMaxIter(10)
                .setRegParam(0.3)
                .setElasticNetParam(0.8);
        LinearRegressionModel lrModel = lr.fit(dataset);
        if (true) {
            throw new RuntimeException("Coefficients: "
                    + lrModel.coefficients() + " Intercept: " + lrModel.intercept());
        }
        System.out.println("Coefficients: "
                + lrModel.coefficients() + " Intercept: " + lrModel.intercept());

        result.show();
        List<BitCoinCurrencyRate> currencyRates = result.collectAsList();
        System.out.println(currencyRates);
        sparkContext.close();
    }
}
