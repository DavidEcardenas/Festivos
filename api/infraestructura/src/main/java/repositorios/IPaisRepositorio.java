package festivosco.api.infraestructura.repositorios;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import festivosco.api.dominio.entidades.*;


import java.util.List;

@Repository
public interface IPaisRepositorio extends JpaRepository<Pais, Integer> {

    @Query("SELECT p FROM Pais p WHERE p.nombre LIKE %?1% ORDER BY p.nombre ASC")
    List<Pais> buscar(String nombre);

}
