package festivosco.api.aplicacion.servicios;

import org.springframework.stereotype.Service;
import java.util.List;
import festivosco.api.dominio.entidades.Festivo;
import festivosco.api.core.servicios.IFestivoServicio;
import festivosco.api.infraestructura.repositorios.IFestivoRepositorio;

@Service
public class FestivoServicio implements IFestivoServicio {

    private final IFestivoRepositorio repositorio;

    public FestivoServicio(IFestivoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Festivo> listar() {
        return repositorio.findAll();
    }

    @Override
    public Festivo obtener(int id) {
        var festivoEncontrado = repositorio.findById(id);
        return festivoEncontrado.orElse(null);
    }

    @Override
    public Festivo agregar(Festivo festivo) {
        festivo.setId(0);
        return repositorio.save(festivo);
    }

    @Override
    public Festivo modificar(Festivo festivo) {
        if (repositorio.findById(festivo.getId()).isEmpty())
            return null;
        return repositorio.save(festivo);
    }

    @Override
    public boolean eliminar(int id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            System.out.println("Error al eliminar festivo: " + ex.getMessage());
            return false;
        }
    }



    @Override
    public boolean esFestivo(int dia, int mes, int anio, int idPais) {
       
        var festivos = repositorio.buscarFestivoPorFecha(dia, mes, idPais);
        if (!festivos.isEmpty()) {
            return true;
        }

       
        return false;
    }

    @Override
    public List<Festivo> listarFestivosPorAnio(int idPais, int anio) {

        return repositorio.findAll()
                .stream()
                .filter(f -> f.getPais().getId() == idPais)
                .toList();
    }
}
