package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;

@Component
public class Servicio {
    // Validaciones
    @NotEmpty(message = "El campo no puede estar vacio")
    private String nombreMascota;

    @NotEmpty(message = "El campo no puede estar vacio")
    private String nombreDuenio;

    private String diaPaseo;

    private String paseadorNombre;

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
