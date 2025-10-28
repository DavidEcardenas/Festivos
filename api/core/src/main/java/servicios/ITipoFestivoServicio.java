package festivosco.api.core.servicios;

import festivosco.api.dominio.entidades.TipoFestivo;
import java.util.List;

public interface ITipoFestivoServicio {

    List<TipoFestivo> listar();

    TipoFestivo obtener(int id);

    TipoFestivo agregar(TipoFestivo tipoFestivo);

    TipoFestivo modificar(TipoFestivo tipoFestivo);

    boolean eliminar(int id);
}
