package festivosco.api.core.servicios;

import festivosco.api.dominio.entidades.Festivo;
import java.util.List;

public interface IFestivoServicio {

    List<Festivo> listar();

    Festivo obtener(int id);

    Festivo agregar(Festivo festivo);

    Festivo modificar(Festivo festivo);

    boolean eliminar(int id);

    
    boolean esFestivo(int dia, int mes, int anio, int idPais);

    List<Festivo> listarFestivosPorAnio(int idPais, int anio);
}
