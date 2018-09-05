package com.ilay.redditcrawler.models;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@Builder
public class BitcoinCurrencyRate {
    @Id
    @GeneratedValue
    private int id;

    private double buy;
    private double sell;

    private String code;
}
