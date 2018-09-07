package com.db.mlmodule.models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
public class BitCoinCurrencyRate implements Serializable {
    private double buy;
    private double sell;

    private String code;

    private Timestamp time;
}