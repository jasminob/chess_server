package com.company;

import com.monri.common.vertx.Main;
import io.vertx.core.Future;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerOptions;
import io.vertx.core.json.JsonArray;
import io.vertx.ext.web.Router;

public class ChessVerticle extends Main {
    @Override
    public void start(Future<Void> startFuture) {
        super.start(startFuture);

        HttpServer server = vertx.createHttpServer(new HttpServerOptions().setPort(8080).setHost("0.0.0.0"));

        ChessController controller = new ChessController();

        Router router = Router.router(vertx);
        controller.registerRoutes(router);

        server.requestHandler(router::accept).listen();
    }
}
