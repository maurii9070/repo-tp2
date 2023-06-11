package ar.edu.unju.fi.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.NotEmpty;

@Component
public class Sucursal {

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;

    @NotEmpty(message = "El encargado es obligatorio")
    private String encargadoNombre;

    @NotEmpty(message = "La direccion es obligatoria")
    private String direccion;
    
    public Sucursal() {
    }

    public Sucursal(String nombre, String encargadoNombre, String direccion) {
        this.nombre = nombre;
        this.encargadoNombre = encargadoNombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargadoNombre() {
        return encargadoNombre;
    }

    public void setEncargadoNombre(String encargadoNombre) {
        this.encargadoNombre = encargadoNombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    
}
