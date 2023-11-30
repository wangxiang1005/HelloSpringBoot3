package com.paladin.graphql.hello.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetGamesRequest {
    private Integer id;
    private Integer publisherId;
    private String name;
    private String publishedDate;
    private Float price;
    private GameType type;
}