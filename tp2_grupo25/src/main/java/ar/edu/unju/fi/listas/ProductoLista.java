package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.entity.Producto;

@Component
public class ProductoLista {
    private List<Producto> productos;
    private List<Producto> productosEncontrados;

    public List<Producto> getProductosEncontrados() {
        return productosEncontrados;
    }

    public void setProductosEncontrados(List<Producto> productosEncontrados) {
        this.productosEncontrados = productosEncontrados;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public ProductoLista(){
        productos = new ArrayList<Producto>();
        productos.add(new Producto("Shampoo antiseptico", 1, 200, "Higiene", (byte) 20));
        productos.add(new Producto("Jabon Pulguicida", 2, 100, "Higiene", (byte) 0));
        productos.add(new Producto("Correa y Collar Premium", 3, 150, "Juguete", (byte) 5));
        productos.add(new Producto("Cepillo para perros y gatos", 4, 400, "Juguete", (byte) 40));
        productos.add(new Producto("Hueso de Soga Anti Estres", 5, 700, "Juguete", (byte) 30));

        productosEncontrados = new ArrayList<>();

        
    }
}
