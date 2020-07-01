package ar.edu.unlam.tallerweb1.servicios;


import ar.edu.unlam.tallerweb1.modelo.Libro;
import ar.edu.unlam.tallerweb1.modelo.Usuario;
import com.mercadopago.exceptions.MPConfException;
import com.mercadopago.exceptions.MPException;
import com.mercadopago.resources.Payment;

public interface ServicioPagar {
     Payment pagarLibro(
            String token,
            Double precio,
            String metodoDePago,
            Integer cuotas,
            String mail,
            String descripcion,
            Long publicacion_id,
            Usuario comprador)
            throws MPException, MPConfException;
}
