package  festivosco.api.dominio.dtos;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TablaDeFestivosDTO {
 
    @Id
    private Integer id;
    private String nombre;
    private Integer dia;
    private Integer mes;
    private Integer diaspascua;
    private String tipoid;
    private String pais;

    
    public TablaDeFestivosDTO() {
    }


    public TablaDeFestivosDTO(Integer id, String nombre, Integer dia, Integer mes, Integer diaspascua,
            String tipoid, String pais) {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diaspascua = diaspascua;
        this.tipoid = tipoid;
        this.pais = pais;
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


    public Integer getDiaspascua() {
        return diaspascua;
    }


    public void setDiaspascua(Integer diaspascua) {
        this.diaspascua = diaspascua;
    }


    public String getTipoid() {
        return tipoid;
    }


    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }


    public String getPais() {
        return pais;
    }


    public void setPais(String pais) {
        this.pais = pais;
    }

    
}
