package com.paladin.graphql.hello.entity;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
public class VideoGame extends Game{
    private boolean isMultiPlayer;
    @Builder(builderMethodName = "videoGameBuilder")
    public VideoGame(Integer id, String name, Float price, String publishedDate, GameType type, boolean isMultiPlayer) {
        super(id, name, price, publishedDate, type);
        this.isMultiPlayer = isMultiPlayer;
    }
}