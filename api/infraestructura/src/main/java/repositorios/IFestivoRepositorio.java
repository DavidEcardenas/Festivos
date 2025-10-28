package festivosco.api.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import festivosco.api.dominio.entidades.Festivo;
import java.util.List;

@Repository
public interface IFestivoRepositorio extends JpaRepository<Festivo, Integer> {

    @Query("SELECT f FROM Festivo f WHERE LOWER(f.nombre) LIKE LOWER(CONCAT('%', :nombre, '%')) ORDER BY f.nombre ASC")
    List<Festivo> buscar(@Param("nombre") String nombre);

    @Query("SELECT f FROM Festivo f WHERE f.dia = :dia AND f.mes = :mes AND f.pais.id = :idPais")
    List<Festivo> buscarFestivoPorFecha(@Param("dia") int dia,
                                        @Param("mes") int mes,
                                        @Param("idPais") int idPais);
}

