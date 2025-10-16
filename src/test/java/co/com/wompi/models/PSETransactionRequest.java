package co.com.wompi.models;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Modelo de datos para representar una solicitud de transacción PSE
 * Implementa el patrón DTO para la API de Wompi
 */
public class PSETransactionRequest {

    // Campos principales de la transacción
    public int amount_in_cents;          // Monto en centavos (ej: 3000000 = $30,000 COP)
    public String currency;              // Moneda (COP para Colombia)
    public String customer_email;        // Email del cliente
    public PaymentMethod payment_method; // Método de pago configurado
    public String reference;             // Referencia única de la transacción

    /**
     * Clase interna que representa el método de pago PSE
     */
    public static class PaymentMethod {
        public String type;  // Tipo de pago: "PSE"

        @JsonProperty("user_type")
        public int user_type; // Tipo de usuario: 0=Persona, 1=Empresa

        @JsonProperty("financial_institution_code")
        public String financial_institution_code; // Código del banco (ej: "1022"=Bancolombia)

        @JsonProperty("user_legal_id_type")
        public String user_legal_id_type; // Tipo de documento: CC, TI, CE, etc.

        @JsonProperty("user_legal_id")
        public String user_legal_id; // Número de documento

        @JsonProperty("payment_description")
        public String paymentDescription; // Descripción del pago

        /**
         * Constructor para crear un método de pago PSE
         */
        public PaymentMethod(String type, int userType, String financialInstitutionCode,
                             String userLegalIdType, String userLegalId, String paymentDescription) {
            this.type = type;
            this.user_type = userType;
            this.financial_institution_code = financialInstitutionCode;
            this.user_legal_id_type = userLegalIdType;
            this.user_legal_id = userLegalId;
            this.paymentDescription = paymentDescription;
        }

        /**
         * Representación en string para logging y debugging
         */
        @Override
        public String toString() {
            return String.format(
                    "PaymentMethod{type='%s', user_type=%d, bank='%s', doc_type='%s', doc_number='%s'}",
                    type, user_type, financial_institution_code, user_legal_id_type, user_legal_id
            );
        }
    }

    /**
     * Constructor principal para crear una solicitud de transacción PSE
     */
    public PSETransactionRequest(int amountInCents, String currency, String customerEmail,
                                 String reference, PaymentMethod paymentMethod) {
        this.amount_in_cents = amountInCents;
        this.currency = currency;
        this.customer_email = customerEmail;
        this.reference = reference;
        this.payment_method = paymentMethod;
    }

    /**
     * Representación legible de la transacción para logging
     */
    @Override
    public String toString() {
        return String.format(
                "PSETransactionRequest{amount=%,d %s, email='%s', reference='%s', %s}",
                amount_in_cents, currency, customer_email, reference, payment_method
        );
    }
}