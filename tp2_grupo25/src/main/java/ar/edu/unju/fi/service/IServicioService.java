package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Servicio;

/**
 * IServicioService
 */
public interface IServicioService {

    List<Servicio> getListaServicio();    

    Servicio getServicio();

    // guardar
    void guardar(Servicio servicio);

    Servicio getBy(String nombre);

    // Modificar
    void modificar(Servicio servicio);

    // Eliminar
    void eliminar(String nombreMascota);
}