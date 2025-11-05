package festivosco.api.dominio.entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "festivo")
public class Festivo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_festivo")
    @SequenceGenerator(name = "secuencia_festivo", sequenceName = "secuencia_festivo", allocationSize = 1)
    private Integer id;

   
    @Column(name = "dia", nullable = false)
    private Integer dia;

    @Column(name = "mes", nullable = false)
    private Integer mes;

    @Column(name = "nombre", length = 150, nullable = false)
    private String nombre;

    @Column(name = "diaspascua")
    private Integer diasPascua;

    @ManyToOne
    @JoinColumn(name = "tipoid", referencedColumnName = "id",nullable = false)
    private TipoFestivo tipo;

    @ManyToOne
    @JoinColumn(name = "paisid", referencedColumnName = "id",nullable = false)
    private Pais pais;

    public Festivo() {
    }
  

    public Festivo(Integer id, Integer dia, Integer mes, String nombre, Integer diasPascua, TipoFestivo tipo,
            Pais pais) {
        this.id = id;
        this.dia = dia;
        this.mes = mes;
        this.nombre = nombre;
        this.diasPascua = diasPascua;
        this.tipo = tipo;
        this.pais = pais;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDia() {
        return dia;
    }

    public void setDia(Integer dia) {
        this.dia = dia;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDiasPascua() {
        return diasPascua;
    }

    public void setDiasPascua(Integer diasPascua) {
        this.diasPascua = diasPascua;
    }

    public TipoFestivo getTipo() {
        return tipo;
    }

    public void setTipo(TipoFestivo tipo) {
        this.tipo = tipo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }


}
