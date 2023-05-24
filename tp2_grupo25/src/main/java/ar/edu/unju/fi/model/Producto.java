package ar.edu.unju.fi.model;

public class Producto {
	private String nombre;
    private int codigo;
    private float precio;
    private String categoria;
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
