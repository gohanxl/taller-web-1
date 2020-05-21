package ar.edu.unlam.tallerweb1.persistencia;

import com.mercadopago.MercadoPago;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MercadoPagoTest {

    @Test
    public void attributesConfigurationTests() throws Exception {
        MercadoPago.SDK.cleanConfiguration();

        MercadoPago.SDK.setClientSecret("Zek56oXTfHzkD0od5U4UKWhQMcMxADzG");
        MercadoPago.SDK.setClientId("511257988168082");
        MercadoPago.SDK.setAccessToken("TEST-511257988168082-051223-b9cb322b4e4707a6c96a78b65242ae78-285177117");

        assertEquals("Client Secret must be \"CLIENT_SECRET\" at this point", MercadoPago.SDK.getClientSecret(), "Zek56oXTfHzkD0od5U4UKWhQMcMxADzG");
        assertEquals("Client Id must be \"CLIENT_ID\" at this point", MercadoPago.SDK.getClientId(), "511257988168082");
        assertEquals("Access Token must be \"ACCESS_TOKEN\" at this point", MercadoPago.SDK.getAccessToken(), "TEST-511257988168082-051223-b9cb322b4e4707a6c96a78b65242ae78-285177117");

        MercadoPago.SDK.setBaseUrl("https://overriden.mercadopago.com");
        assertEquals("MPBase url must be default \"https://overriden.mercadopago.com\" at this point", MercadoPago.SDK.getBaseUrl(), "https://overriden.mercadopago.com");
    }
}

