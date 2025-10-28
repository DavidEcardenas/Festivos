package festivosco.api.aplicacion.servicios;

import org.springframework.stereotype.Service;
import java.util.List;
import festivosco.api.dominio.entidades.Pais;
import festivosco.api.core.servicios.IPaisServicio;
import festivosco.api.infraestructura.repositorios.IPaisRepositorio;

@Service
public class PaisServicio implements IPaisServicio {

    private final IPaisRepositorio repositorio;

    public PaisServicio(IPaisRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Pais> listar() {
        return repositorio.findAll();
    }

    @Override
    public Pais obtener(int id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Pais agregar(Pais pais) {
        pais.setId(0);
        return repositorio.save(pais);
    }

    @Override
    public Pais modificar(Pais pais) {
        if (repositorio.findById(pais.getId()).isEmpty())
            return null;
        return repositorio.save(pais);
    }

    @Override
    public boolean eliminar(int id) {
        try {
            repositorio.deleteById(id);
            return true;
        } catch (Exception ex) {
            System.out.println("Error al eliminar país: " + ex.getMessage());
            return false;
        }
    }
}
