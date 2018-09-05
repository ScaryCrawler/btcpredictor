package com.ilay.redditcrawler.models;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Currency {
    @Id
    private int id;

    private String code;
    private String symbol;
}
