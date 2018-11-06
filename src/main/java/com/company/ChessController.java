package com.company;

import com.monri.common.vertx.web.Controller;
import io.vertx.ext.web.Router;
import org.jetbrains.annotations.Nullable;

public class ChessController implements Controller {

    @Override
    public void registerRoutes(Router router) {
        router.get("/getTurns/:gameId/:limit").handler(routingContext -> {
            String gameId = routingContext.pathParam("gameId");
            Integer limit = Integer.parseInt(routingContext.pathParam("limit"));


        });
    }

    @Override
    public @Nullable String mountPoint() {
        return null;
    }
}
