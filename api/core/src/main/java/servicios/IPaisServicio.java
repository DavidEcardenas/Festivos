package festivosco.api.core.servicios;

import festivosco.api.dominio.entidades.Pais;
import java.util.List;

public interface IPaisServicio {

    List<Pais> listar();

    Pais obtener(int id);

    Pais agregar(Pais pais);

    Pais modificar(Pais pais);

    boolean eliminar(int id);
}
