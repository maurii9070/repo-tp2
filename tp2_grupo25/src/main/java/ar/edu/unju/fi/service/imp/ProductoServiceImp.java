package ar.edu.unju.fi.service.imp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ProductoLista;
import ar.edu.unju.fi.model.Producto;
import ar.edu.unju.fi.service.IProductoService;

@Service
public class ProductoServiceImp implements IProductoService {
    
    @Autowired
    private ProductoLista listaProductos;
    @Autowired
    private Producto producto;

    

    public List<Producto> getListaProducto(){
        return listaProductos.getProductos();
    }

    @Override
    public Producto getProducto(){
        return producto;
    }

    // Guardar producto
    public void guardar(Producto producto){
        listaProductos.getProductos().add(producto);
    }

    public Producto getBy(String nombre){
        Producto productoEncontrado = producto;

        // Si la lista está vacia, devolvemos null para el mensaje en HTML
        if(listaProductos.getProductos().size() == 0){
            productoEncontrado = null;
            return productoEncontrado;
        }
        
        for(Producto prod : listaProductos.getProductos()){
            if (prod.getNombre().equals(nombre)){
                productoEncontrado = prod;
                break;
            } else{
                productoEncontrado = null;
            }
        }

        return productoEncontrado;
    }

    // Modificar producto
    public void modificar(Producto producto){
        for(Producto prod : listaProductos.getProductos()){
            if(prod.getNombre().equals(producto.getNombre())){
                prod.setNombre(producto.getNombre());
                prod.setCategoria(producto.getCategoria());
                prod.setCodigo(producto.getCodigo());
                prod.setDescuento(producto.getDescuento());
                prod.setPrecio(producto.getPrecio());                
            }
        }
    }

    // Eliminar producto
    public void eliminar(String nombre){
        for(Producto prod : listaProductos.getProductos()){
            if(prod.getNombre().equals(nombre)){
                listaProductos.getProductos().remove(prod);
                break;
            }
        }
    }

    // Buscar producto
    public List<Producto> buscar(String nombre){
        
        if(listaProductos.getProductos().size() > 0){

            // Vaciar el array, para una nueva busqueda
            listaProductos.getProductosEncontrados().clear(); 

            for(Producto prod : listaProductos.getProductos()){
                // Si el nombre en la lista contiene "nombre" se agrega a la lista de
                // Productos encontrados
                if(prod.getNombre().contains(nombre)){
                    listaProductos.getProductosEncontrados().add(prod);
                }
            }
        }
        
        return listaProductos.getProductosEncontrados();
    }
}
