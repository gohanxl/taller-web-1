package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.modelo.Usuario;
import com.google.gson.JsonObject;
import com.google.gson.internal.LinkedTreeMap;
import com.mercadopago.MercadoPago;
import com.mercadopago.core.MPApiResponse;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MercadoPagoTest {

    @Test
    public void pagoErroneoTest() throws Exception {
        MercadoPago.SDK.cleanConfiguration();

        MercadoPago.SDK.setAccessToken("TEST-258421991393118-051723-0e688fa5657ce8baede14eb54e347cde-568420128");
        MercadoPago.SDK.setClientSecret(System.getenv("UnsrID9XHVEWNImkLs6jRw0KPBz2ZJb4"));
        MercadoPago.SDK.setClientId(System.getenv("258421991393118"));

        String token = "751b15d080b4f37d9cd5a98e21795a83";
        Float precio = 500F;
        String metodoDePago = "visa";
        Integer cuotas = 1;
        String mail = "test_user_53646357@testuser.com";
        String descripcion = "Harry Potter";

        String estadoDePago = "bad request";

        Payment payment = new Payment()
                .setTransactionAmount(precio)
                .setToken(token)
                .setDescription(descripcion)
                .setInstallments(cuotas)
                .setPaymentMethodId(metodoDePago)
                .setPayer(new Payer()
                        .setEmail(mail));
        payment.save();

        if(payment.getStatus() != null){
            Payment.Status estado = payment.getStatus();
            estadoDePago = estado.toString();
        }

        assertEquals("bad request", estadoDePago);
    }
}

