# graphql-hello-springboot

[测试链接1](http://127.0.0.1:8014/hello/world)

## 打开测试平台
[http://localhost:8014/playground]()

**输入：**
query{
    getGames(request: {}){
        id
        name
        publishedDate
        price
        type
        ... on VideoGame{
            isMultiPlayer
        }
        ... on BoardGame{
            minAmountOfPlayers
            maxAmountOfPlayers
        }
    }
}

**输出：**
{
    "data": {
        "getGames": [
            {
                "id": 1,
                "name": "The Elder Scroll V: Skyrim",
                "publishedDate": "2011-11-11",
                "price": 59.99,
                "type": "VideoGame",
                "isMultiPlayer": false
            },
            {
                "id": 2,
                "name": "Dungeons & Dragons",
                "publishedDate": "1976-01-26",
                "price": 10,
                "type": "BoardGame",
                "minAmountOfPlayers": 2,
                "maxAmountOfPlayers": 7
            }
        ]
    }
}