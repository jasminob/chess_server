package com.company;

import io.reactivex.Single;
import io.vertx.core.json.JsonObject;

import java.util.List;
import java.util.UUID;

public interface ChessService {
    Single<JsonObject> createGame();
    Single<JsonObject> createPlayer(UUID gameId, String color);
    Single<List<JsonObject>> getPlayersInGame(UUID gameId);
    Single<JsonObject> createChessTurn(String fromPos, String toPos, String color, UUID gameId);

    /**
     *
     * @param gameId
     * @param limit - if negative returns all turns
     * @return
     */
    Single<List<JsonObject>> getTurns(UUID gameId, int limit);

}
