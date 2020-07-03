package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioPublicacion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import com.mercadopago.*;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.List;

@Service("servicioPagar")
@Transactional
public class ServicioPagarImp implements ServicioPagar{

    private RepositorioPublicacion servicioPublicacionDao;
    private RepositorioUsuario servicioUsuarioDao;
    private ServicioComprar servicioComprar;

    @Autowired
    public ServicioPagarImp(RepositorioPublicacion servicioPublicacionDao, RepositorioUsuario servicioUsuarioDao,ServicioComprar servicioComprar){
        this.servicioPublicacionDao = servicioPublicacionDao;
        this.servicioUsuarioDao = servicioUsuarioDao;
        this.servicioComprar = servicioComprar;
    }

    @Override
    public Payment pagarLibro(String token, Double precio, String metodoDePago, Integer cuotas, String mail, String descripcion, Long publicacion_id, Usuario comprador) throws MPException, MPConfException, MessagingException {
        MercadoPago.SDK.setAccessToken("TEST-258421991393118-051723-0e688fa5657ce8baede14eb54e347cde-568420127");
        MercadoPago.SDK.setClientSecret(System.getenv("UnsrID9XHVEWNImkLs6jRw0KPBz2ZJb4"));
        MercadoPago.SDK.setClientId(System.getenv("258421991393118"));

        String estadoDePago = "bad request";

        Payment payment = new Payment()
                .setTransactionAmount(precio.floatValue())
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

        if(estadoDePago.equals("approved")){
            Publicacion publicacion = servicioPublicacionDao.buscarPublicacionPorId(publicacion_id);
            servicioComprar.comprarLibro(publicacion, comprador, precio);
        }

        return payment;
    }

    @Override
    public Integer pagarConPuntos(Long publicacionId, Usuario usuario, Double precioDeCompra){
        Publicacion publicacion = servicioPublicacionDao.buscarPublicacionPorId(publicacionId);
        Integer puntosACanjear = servicioPublicacionDao.getValorEnPuntos(publicacion);
        Integer puntosRestantes = servicioPublicacionDao.canjearPuntos(publicacion, usuario, puntosACanjear);

        if(puntosRestantes != null){
            if(precioDeCompra == 0) {
                Compra compra = new Compra(publicacion, usuario, precioDeCompra);
                servicioPublicacionDao.cargarCompra(compra);
            }
        }

        return puntosRestantes;
    }
}
