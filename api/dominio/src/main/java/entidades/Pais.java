package festivosco.api.dominio.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "pais")
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_pais")
    @SequenceGenerator(name = "secuencia_pais", sequenceName = "secuencia_pais", allocationSize = 1)
    private Integer id;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    public Pais() {}


    public Pais(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
