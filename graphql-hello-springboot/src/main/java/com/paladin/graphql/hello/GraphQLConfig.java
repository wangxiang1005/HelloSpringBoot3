package com.paladin.graphql.hello;

import com.paladin.graphql.hello.entity.BoardGame;
import com.paladin.graphql.hello.entity.VideoGame;
import graphql.kickstart.tools.SchemaParserDictionary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.HashMap;

@Configuration
public class GraphQLConfig {
    @Bean
    public SchemaParserDictionary getSchemaParser() {
        SchemaParserDictionary dictionary = new SchemaParserDictionary();
        dictionary.add(new HashMap() {{
            //key为type名称,value为对应的entity class的类型对象
            put("BoardGame", BoardGame.class);
            put("VideoGame", VideoGame.class);
        }});
        return dictionary;
    }
}