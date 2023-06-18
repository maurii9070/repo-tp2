package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.model.Sucursal;


public interface ISucursalService {
    List<Sucursal> getListaSucursal();    

    Sucursal getSucursal();

    // Guardar
    void guardarSucursal(Sucursal sucursal);

    Sucursal getBy(String nombre);

    // Modificar
    void modificarSucursal(Sucursal sucursal);

    // Eliminar
    void eliminarSucursal(String nombre);

}