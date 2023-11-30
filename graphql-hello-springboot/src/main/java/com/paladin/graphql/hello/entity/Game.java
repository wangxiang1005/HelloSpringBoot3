package com.paladin.graphql.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    private Integer id;
    private String name;
    private Float price;
    private String publishedDate;
    private GameType type;
}