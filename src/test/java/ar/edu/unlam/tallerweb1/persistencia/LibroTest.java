package ar.edu.unlam.tallerweb1.persistencia;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Libro;
import org.hibernate.Session;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

public class LibroTest extends SpringTest {

    @Test
    @Transactional @Rollback
    public void insertarLibro() {
        //preparacion
        Libro pepe = new Libro();
        pepe.setNombre("Pepe the Argento");
        pepe.setIsbn("1231245125");
        pepe.setPrecio(500.00);
        //ejecucion
        final Session session = session();
        session.save(pepe);
        //comprobacion
        Libro buscado = session.get(Libro.class, pepe.getId());
        assertThat(buscado).isNotNull();
    }

    @Test
    @Transactional @Rollback
    public void modificarLibro() {
        //preparacion
        Libro pepe = new Libro();
        pepe.setNombre("Pepe the Argento");
        pepe.setIsbn("1231245125");
        pepe.setPrecio(500.00);
        //ejecucion
        final Session session = session();
        session.save(pepe);

        pepe.setPrecio(600.00);
        session.update(pepe);

        //comprobacion
        Libro buscado = session.get(Libro.class, pepe.getId());
        assertThat(buscado.getPrecio()).isEqualTo(600.00);
    }

    @Test
    @Transactional @Rollback
    public void eliminarLibro() {
        //preparacion
        Libro libroParaEliminar = new Libro();
        libroParaEliminar.setNombre("Pepe the Argento");
        libroParaEliminar.setIsbn("1231245125");
        libroParaEliminar.setPrecio(500.00);
        //ejecucion
        final Session session = session();
        session.save(libroParaEliminar);

        session.delete(libroParaEliminar);
        //comprobacion
        Libro buscado = session.get(Libro.class, libroParaEliminar.getId());
        assertThat(buscado).isNull();
    }

    //insertar modificar(update) y borrar(delete), test para cada unoe
}
