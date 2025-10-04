package festivosco.api.dominio.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_festivo")
public class TipoFestivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_tipo")
    @SequenceGenerator(name = "secuencia_tipo", sequenceName = "secuencia_tipo", allocationSize = 1)
    private Integer id;

    private String tipo;

    public TipoFestivo() {}

    public TipoFestivo(Integer id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
