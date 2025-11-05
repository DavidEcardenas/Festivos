package festivosco.api.presentacion.controladores;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import festivosco.api.dominio.entidades.Festivo;
import festivosco.api.core.servicios.IFestivoServicio;

@RestController
@RequestMapping("/api/festivos")
public class FestivoControlador {

    private final IFestivoServicio servicio;

    public FestivoControlador(IFestivoServicio servicio) {
        this.servicio = servicio;
    }

    // Listar todos los festivos
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Festivo> listar() {
        return servicio.listar();
    }

    // Obtener un festivo por ID
    @RequestMapping(value = "/obtener/{id}", method = RequestMethod.GET)
    public Festivo obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    // Agregar un nuevo festivo
    @RequestMapping(value = "/agregar", method = RequestMethod.POST)
    public Festivo agregar(@RequestBody Festivo festivo) {
        return servicio.agregar(festivo);
    }

    // Modificar un festivo
    @RequestMapping(value = "/modificar", method = RequestMethod.PUT)
    public Festivo modificar(@RequestBody Festivo festivo) {
        return servicio.modificar(festivo);
    }

    // Eliminar un festivo
    @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }

    // ✅ Extra: verificar si una fecha es festiva
    @RequestMapping(value = "/esFestivo/{idPais}/{anio}/{mes}/{dia}", method = RequestMethod.GET)
    public boolean esFestivo(@PathVariable int idPais, @PathVariable int anio, @PathVariable int mes, @PathVariable int dia) {
        return servicio.esFestivo(dia, mes, anio, idPais);
    }

    // ✅ Extra: listar festivos por país y año
    @RequestMapping(value = "/listar/{idPais}/{anio}", method = RequestMethod.GET)
    public List<Festivo> listarPorAnio(@PathVariable int idPais, @PathVariable int anio) {
        return servicio.listarFestivosPorAnio(idPais, anio);
    }
}
