package festivosco.api.infraestructura.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFestivoRepositorio extends JpaRepository<festivo, Integer> {

    @Query("SELECT f FROM festivo f WHERE f.nombre LIKE '%' || ?1|| '%' ORDER BY f.nombre ASC")
    public List<festivo> buscar(String nombre);

    @Query("SELECT f FROM festivo f WHERE f.dia = :dia AND f.mes = :mes AND f.pais.id = :idPais")
    List<festivo> buscarFestivoPorFecha(@Param("dia") int dia,
            @Param("mes") int mes,
            @Param("idPais") int idPais);

}
