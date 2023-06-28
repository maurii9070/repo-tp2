package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Component
@Entity
@Table(name = "Servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "serv_id")
    private Long id;

    @Column(name = "serv_mascota", length = 10, nullable = false)
    @NotEmpty(message = "El campo no puede estar vacio")
    private String nombreMascota;

    @Column(name = "serv_duenio", length = 10, nullable = false)
    @NotEmpty(message = "El campo no puede estar vacio")
    private String nombreDuenio;

    @Column(name = "serv_dia", length = 10, nullable = false)
    private String diaPaseo;

    @Column(name = "serv_paseador", length = 10, nullable = false)
    private String paseadorNombre;

    @Column(name = "serv_horario", length = 10, nullable = false)
    @NotEmpty(message = "Debe seleccionar un horario")
    private String horarioPaseo;

    
    public Servicio() {
    }


    public Servicio(String nombreMascota, String nombreDuenio, String diaPaseo, String paseadorNombre,
            String horarioPaseo) {
        this.nombreMascota = nombreMascota;
        this.nombreDuenio = nombreDuenio;
        this.diaPaseo = diaPaseo;
        this.paseadorNombre = paseadorNombre;
        this.horarioPaseo = horarioPaseo;
    }


    public String getNombreMascota() {
        return nombreMascota;
    }


    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }


    public String getNombreDuenio() {
        return nombreDuenio;
    }


    public void setNombreDuenio(String nombreDuenio) {
        this.nombreDuenio = nombreDuenio;
    }


    public String getDiaPaseo() {
        return diaPaseo;
    }


    public void setDiaPaseo(String diaPaseo) {
        this.diaPaseo = diaPaseo;
    }


    public String getPaseadorNombre() {
        return paseadorNombre;
    }


    public void setPaseadorNombre(String paseadorNombre) {
        this.paseadorNombre = paseadorNombre;
    }


    public String getHorarioPaseo() {
        return horarioPaseo;
    }


    public void setHorarioPaseo(String horarioPaseo) {
        this.horarioPaseo = horarioPaseo;
    }

    
}
