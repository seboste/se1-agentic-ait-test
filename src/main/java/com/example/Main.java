package com.example;

import io.javalin.Javalin;
import io.javalin.http.Context;
import java.math.BigInteger;

/**
 * Main application class that starts the web server.
 */
public class Main {

    private static final int DEFAULT_PORT = 8080;
    private static final FactorialCalculator calculator = new FactorialCalculator();

    public static void main(String[] args) {
        int port = getPort();
        Javalin app = createApp();
        app.start(port);
        System.out.println("Factorial calculator web app started on port " + port);
    }

    /**
     * Creates and configures the Javalin application.
     *
     * @return configured Javalin app
     */
    public static Javalin createApp() {
        Javalin app = Javalin.create(config -> {
            config.showJavalinBanner = false;
        });

        // Factorial endpoint: GET /factorial/{number}
        app.get("/factorial/{number}", Main::handleFactorialRequest);

        return app;
    }

    /**
     * Handles the factorial calculation request.
     *
     * @param ctx the Javalin context
     */
    private static void handleFactorialRequest(Context ctx) {
        String numberParam = ctx.pathParam("number");
        
        try {
            int number = Integer.parseInt(numberParam);
            BigInteger result = calculator.calculate(number);
            
            ctx.json(new FactorialResponse(number, result.toString()));
        } catch (NumberFormatException e) {
            ctx.status(400).json(new ErrorResponse("Invalid number format: " + numberParam));
        } catch (IllegalArgumentException e) {
            ctx.status(400).json(new ErrorResponse(e.getMessage()));
        } catch (Exception e) {
            ctx.status(500).json(new ErrorResponse("Internal server error"));
        }
    }

    /**
     * Gets the port from environment variable or uses default.
     *
     * @return the port number
     */
    private static int getPort() {
        String portEnv = System.getenv("PORT");
        if (portEnv != null && !portEnv.isEmpty()) {
            try {
                return Integer.parseInt(portEnv);
            } catch (NumberFormatException e) {
                System.out.println("Invalid PORT environment variable, using default: " + DEFAULT_PORT);
            }
        }
        return DEFAULT_PORT;
    }

    /**
     * Response record for successful factorial calculation.
     */
    record FactorialResponse(int number, String factorial) {}

    /**
     * Response record for error messages.
     */
    record ErrorResponse(String error) {}
}
