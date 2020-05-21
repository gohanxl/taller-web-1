package ar.edu.unlam.tallerweb1.servicios;

import ar.edu.unlam.tallerweb1.modelo.Compra;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Publicacion;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioLibro;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuario;
import com.mercadopago.*;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;
import com.mercadopago.resources.datastructures.payment.Payer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("servicioPagar")
@Transactional
public class ServicioPagarImp implements ServicioPagar{

    private RepositorioLibro servicioLibroDao;
    private RepositorioUsuario servicioUsuarioDao;
    private ServicioComprar servicioComprar;

    @Autowired
    public ServicioPagarImp(RepositorioLibro servicioLibroDao, RepositorioUsuario servicioUsuarioDao,ServicioComprar servicioComprar){
        this.servicioLibroDao = servicioLibroDao;
        this.servicioUsuarioDao = servicioUsuarioDao;
        this.servicioComprar = servicioComprar;
    }

    @Override
    public String pagarLibro(String token, Float precio, String metodoDePago, Integer cuotas, String mail, String descripcion, Long libro_id) throws MPException, MPConfException {

        Usuario comprador = new Usuario(mail, "123", "Rol", "Comprador");
        servicioUsuarioDao.cargarUsuario(comprador);

        MercadoPago.SDK.setAccessToken("TEST-258421991393118-051723-0e688fa5657ce8baede14eb54e347cde-568420127");
        MercadoPago.SDK.setClientSecret(System.getenv("UnsrID9XHVEWNImkLs6jRw0KPBz2ZJb4"));
        MercadoPago.SDK.setClientId(System.getenv("258421991393118"));

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

        if(estadoDePago.equals("approved")){
            Libro libro = servicioLibroDao.buscarLibro(libro_id);
            Compra compra = new Compra(libro, comprador);
            servicioLibroDao.cargarCompra(compra);
        }

        return estadoDePago;
    }
}
