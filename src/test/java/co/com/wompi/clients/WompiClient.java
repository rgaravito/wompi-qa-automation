package co.com.wompi.clients;

import io.restassured.RestAssured;
import io.restassured.response.Response;

/**
 * Cliente HTTP para interactuar con la API de Wompi
 */
public class WompiClient {

    // URL base del ambiente UAT Sandbox de Wompi
    private static final String BASE_URL = "https://api-sandbox.co.uat.wompi.dev/v1";

    // Llaves de autenticación
    private String publicKey;
    private String privateKey;

    /**
     * Constructor que inicializa el cliente con las llaves de autenticación
     */
    public WompiClient(String publicKey, String privateKey) {
        this.publicKey = publicKey;
        this.privateKey = privateKey;
        RestAssured.baseURI = BASE_URL;
    }

    /**
     * Obtiene información del merchant usando la public key
     * Endpoint: GET /merchants/{public_key}
     */
    public Response getMerchant() {
        System.out.println("Obteniendo información del merchant...");
        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + publicKey)
                .when()
                .get("/merchants/" + publicKey);

        System.out.println("Respuesta Merchant: " + response.getStatusCode());
        return response;
    }

    /**
     * Crea una nueva transacción PSE
     * Endpoint: POST /transactions
     * Usa la private key para operaciones de escritura
     */
    public Response createTransaction(Object transactionRequest) {
        System.out.println("Creando transacción PSE...");
        System.out.println("Datos: " + transactionRequest.toString());

        // Usar private key para crear transacciones (si está disponible)
        String authKey = (privateKey != null) ? privateKey : publicKey;

        Response response = RestAssured
                .given()
                .header("Authorization", "Bearer " + authKey)
                .header("Content-Type", "application/json")
                .body(transactionRequest)
                .when()
                .post("/transactions");

        System.out.println("Respuesta Transacción: " + response.getStatusCode());
        return response;
    }
}