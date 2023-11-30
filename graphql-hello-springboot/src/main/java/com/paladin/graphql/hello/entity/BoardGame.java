package com.paladin.graphql.hello.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class BoardGame extends Game{
    private int minAmountOfPlayers;
    private int maxAmountOfPlayers;
    @Builder(builderMethodName = "boardGameBuilder")
    public BoardGame(Integer id, String name, Float price, String publishedDate, GameType type, Integer minAmountOfPlayers, Integer maxAmountOfPlayers) {
        super(id, name, price, publishedDate, type);
        this.minAmountOfPlayers = minAmountOfPlayers;
        this.maxAmountOfPlayers = maxAmountOfPlayers;
    }
}