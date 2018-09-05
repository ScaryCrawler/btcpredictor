package com.ilay.redditcrawler.models;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Currency {
    @Id
    @GeneratedValue
    private int id;

    private String code;
    private String symbol;
}
