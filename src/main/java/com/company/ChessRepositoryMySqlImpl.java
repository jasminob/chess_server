package com.company;

import io.reactivex.Single;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.jdbc.JDBCClient;
import org.intellij.lang.annotations.Language;

import java.util.List;
import java.util.UUID;

public class ChessRepositoryMySqlImpl implements ChessRepository {
    JDBCClient client;

    public ChessRepositoryMySqlImpl(Vertx vertx) {

        JsonObject object = new JsonObject().put("url", "sql7.freemysqlhosting.net" )
                .put("driver_class", "com.mysql.cj.jdbc.Driver" )
                .put("user", "sql7264347")
                .put("password", "aQQn5yzdUz");
        client = JDBCClient.createShared(vertx, object);
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

        @Language("MySQL")
        String sql = "SELECT * FROM chessturn WHERE game_id = ? ORDER BY created_at desc ";

        if (limit > 0) {
            sql += "limit ?";
        }

        JsonArray arcs = new JsonArray();
        arcs.add(gameId.toString());
        if (limit > 0)
            arcs.add(limit);

        return client.rxQueryWithParams(sql, arcs)
                .map(e -> e.getRows());

    }
}
