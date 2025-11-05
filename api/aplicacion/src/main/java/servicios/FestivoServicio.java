package festivosco.api.aplicacion.servicios;

import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

import festivosco.api.dominio.entidades.Festivo;
import festivosco.api.core.servicios.ServicioFechas;
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
        return repositorio.findById(id).orElse(null);
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
     
        var festivosFijos = repositorio.buscarFestivoPorFecha(dia, mes, idPais);
        if (!festivosFijos.isEmpty()) {
            return true;
        }

     
        LocalDate pascua = ServicioFechas.getDomingoPascua(anio);
        LocalDate fechaConsulta = LocalDate.of(anio, mes, dia);

      
        var festivos = repositorio.findAll().stream()
                .filter(f -> f.getPais() != null && f.getPais().getId() == idPais)
                .toList();

        for (Festivo f : festivos) {
            if (f.getDiasPascua() != null) {
               
                LocalDate fechaFestivo = ServicioFechas.agregarDias(pascua, f.getDiasPascua());

               
                if (f.getTipo() != null && f.getTipo().getTipo().equalsIgnoreCase("Ley Emiliani")) {
                    fechaFestivo = ServicioFechas.siguienteLunes(fechaFestivo);
                }

               
                if (fechaFestivo.equals(fechaConsulta)) {
                    return true;
                }
            }
        }

        return false; 
    }

    @Override
    public List<Festivo> listarFestivosPorAnio(int idPais, int anio) {
        
        return repositorio.findAll().stream()
                .filter(f -> f.getPais() != null && f.getPais().getId() == idPais)
                .toList();
    }
}
