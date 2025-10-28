package festivosco.api.aplicacion.servicios;

import org.springframework.stereotype.Service;
import java.util.List;
import festivosco.api.dominio.entidades.TipoFestivo;
import festivosco.api.core.servicios.ITipoFestivoServicio;
import festivosco.api.infraestructura.repositorios.ITipoFestivoRepositorio;

@Service
public class TipoFestivoServicio implements ITipoFestivoServicio {

    private final ITipoFestivoRepositorio repositorio;

    public TipoFestivoServicio(ITipoFestivoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<TipoFestivo> listar() {
        return repositorio.findAll();
    }

    @Override
    public TipoFestivo obtener(int id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public TipoFestivo agregar(TipoFestivo tipoFestivo) {
        tipoFestivo.setId(0);
        return repositorio.save(tipoFestivo);
    }

    @Override
    public TipoFestivo modificar(TipoFestivo tipoFestivo) {
        if (repositorio.findById(tipoFestivo.getId()).isEmpty())
            return null;
        return repositorio.save(tipoFestivo);
    }

    @Override
    public boolean eliminar(int id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            System.out.println("Error al eliminar tipo festivo: " + ex.getMessage());
            return false;
        }
    }
}
