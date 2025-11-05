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


    @GetMapping("/listar")
    public List<Festivo> listar() {
        return servicio.listar();
    }

    @GetMapping("/obtener/{id}")
    public Festivo obtener(@PathVariable int id) {
        return servicio.obtener(id);
    }

    @PostMapping("/agregar")
    public Festivo agregar(@RequestBody Festivo festivo) {
        return servicio.agregar(festivo);
    }

    @PutMapping("/modificar")
    public Festivo modificar(@RequestBody Festivo festivo) {
        return servicio.modificar(festivo);
    }

    @DeleteMapping("/eliminar/{id}")
    public boolean eliminar(@PathVariable int id) {
        return servicio.eliminar(id);
    }


    @GetMapping("/esFestivo/{idPais}/{anio}/{mes}/{dia}")
    public boolean esFestivo(
            @PathVariable int idPais,
            @PathVariable int anio,
            @PathVariable int mes,
            @PathVariable int dia) {
        return servicio.esFestivo(dia, mes, anio, idPais);
    }

  
    @GetMapping("/listar/{idPais}/{anio}")
    public List<Festivo> listarPorAnio(
            @PathVariable int idPais,
            @PathVariable int anio) {
        return servicio.listarFestivosPorAnio(idPais, anio);
    }
}
