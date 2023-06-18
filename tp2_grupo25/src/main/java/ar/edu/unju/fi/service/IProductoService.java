package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Producto;

public interface IProductoService {
    List<Producto> getListaProducto();

    Producto getProducto();

    // Guardar producto
    void guardar(Producto producto);

    Producto getBy(String nombre);

    // Modificar prod
    void modificar(Producto producto);

    // eliminar prod
    void eliminar(String nombre);

}
