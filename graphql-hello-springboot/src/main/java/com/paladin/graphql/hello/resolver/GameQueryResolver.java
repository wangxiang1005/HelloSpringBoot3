package com.paladin.graphql.hello.resolver;

import com.paladin.graphql.hello.entity.*;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameQueryResolver implements GraphQLQueryResolver {
    public List<Game> getGames(GetGamesRequest request){
        return List.of(    //假装做了查询
                VideoGame.videoGameBuilder()
                        .id(1)
                        .name("The Elder Scroll V: Skyrim")
                        .price(59.99f)
                        .publishedDate("2011-11-11")
                        .type(GameType.VideoGame)
                        .isMultiPlayer(false)
                        .build(),
                BoardGame.boardGameBuilder()
                        .id(2)
                        .name("Dungeons & Dragons")
                        .price(10f)
                        .publishedDate("1976-01-26")
                        .type(GameType.BoardGame)
                        .minAmountOfPlayers(2)
                        .maxAmountOfPlayers(7)
                        .build()
        );
    }
}