package com.company;

import io.reactivex.Single;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;

import java.util.List;
import java.util.UUID;

public class ChessServiceImpl implements ChessService {

    ChessRepository chessRepository;

    public ChessServiceImpl(Vertx vertx) {
        chessRepository = new ChessRepositoryMySqlImpl(vertx);
    }

    @Override
    public Single<JsonObject> createGame() {
        return null;
    }

    @Override
    public Single<JsonObject> createPlayer(UUID gameId, String color) {
        return null;
    }

    @Override
    public Single<List<JsonObject>> getPlayersInGame(UUID gameId) {
        return null;
    }

    @Override
    public Single<JsonObject> createChessTurn(String fromPos, String toPos, String color, UUID gameId) {
        return null;
    }

    @Override
    public Single<List<JsonObject>> getTurns(UUID gameId, int limit) {

        return chessRepository.getTurns(gameId, limit);

    }
}
