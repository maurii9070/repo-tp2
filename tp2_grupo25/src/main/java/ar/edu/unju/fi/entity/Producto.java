package ar.edu.unju.fi.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

@Component
@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
	private Long id;

	@Column(name = "prod_nombre", length = 20, nullable = false)
    @NotEmpty(message="Nombre no puede estar vacio")
    private String nombre;

	@Column(name = "prod_codigo", length = 10, nullable = false)
    @Positive(message = "El codigo debe ser positivo")
    private int codigo;

	@Column(name = "prod_precio", length = 10, nullable = false)
    @Positive(message = "El precio debe ser positivo")
    private float precio;

	@Column(name = "prod_categoria", length = 10, nullable = false)
    @NotBlank(message = "Debe seleccionar una categoria")
    private String categoria;

	@Column(name = "prod_descuento", length = 5, nullable = false)
    @Min(value = 0, message = "El valor minimo del descuento es 0")
    @Max(value = 50, message = "El valor maximo del descuento es de %50")
    @PositiveOrZero(message = "El descuento debe ser cero o positivo")
    private byte descuento;
    
    public Producto() {
    	
    }
    public Producto(String nombre, int codigo, float precio, String categoria, byte descuento) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.precio = precio;
        this.categoria = categoria;
        this.descuento = descuento;
    }
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public byte getDescuento() {
		return descuento;
	}
	public void setDescuento(byte descuento) {
		this.descuento = descuento;
	}
    
    public float calcularDescuento() {
    	return this.precio - ((this.precio * this.descuento) / 100);
    }
}
