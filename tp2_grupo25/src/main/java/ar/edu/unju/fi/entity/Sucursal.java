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
@Table(name="sucursales")
public class Sucursal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "suc_id")
    private Long id;

    @Column(name = "suc_nombre", length = 30, nullable = false)
    @NotEmpty(message = "El nombre es obligatorio")
    private String nombre;

    @Column(name = "suc_encargado", length = 20, nullable = false)
    @NotEmpty(message = "El encargado es obligatorio")
    private String encargadoNombre;

    @Column(name = "suc_direccion", length = 40, nullable = false)
    @NotEmpty(message = "La direccion es obligatoria")
    private String direccion;

    @Column(name = "suc_estado")
    private boolean estado;
    
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
