package com.ilay.redditcrawler.models;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder
public class BitCoinCurrencyRate {
    @Id
    private String id;

    private double buy;
    private double sell;

    private String code;

    private LocalDateTime time;
}
