package com.book.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Policy {
    String name;
    String description;
    String scope1;
    String scope2;
    String scope3;
    Date launchtime;
}
