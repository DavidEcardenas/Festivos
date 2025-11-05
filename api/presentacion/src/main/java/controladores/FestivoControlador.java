package festivosco.api.presentacion.controladores;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import festivosco.api.dominio.entidades.*;
import festivosco.api.core.servicios.*;

@RestController
@RequestMapping("/api/festivos")
public class FestivoControlador {

    private final IFestivoServicio servicio;

    public FestivoControlador(IFestivoServicio servicio) {
        this.servicio = servicio;
    }

    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    }

    
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Festivo obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Festivo agregar(@RequestBody Festivo festivo) {
        return servicio.agregar(festivo);
    }

    
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Festivo modificar(@RequestBody Festivo festivo) {
        return servicio.modificar(festivo);
    }

    
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

    
    @RequestMapping(value = "/esFestivo/{idPais}/{anio}/{mes}/{dia}", method = RequestMethod.GET)
    public boolean esFestivo(@PathVariable int idPais, @PathVariable int anio, @PathVariable int mes, @PathVariable int dia) {
        return servicio.esFestivo(dia, mes, anio, idPais);
    }

    
    @RequestMapping(value = "/listar/{idPais}/{anio}", method = RequestMethod.GET)
    public List<Festivo> listarPorAnio(@PathVariable int idPais, @PathVariable int anio) {
        return servicio.listarFestivosPorAnio(idPais, anio);
    }
}
