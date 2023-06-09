package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Consejo;

/**
 * IConsejoService
 */
public interface IConsejoService {

    List<Consejo> getListaConsejo();

    Consejo getConsejo();

    // Guardar consejo
    void guardar(Consejo consejo);

    Consejo getBy(String titulo);

    // Modificar
    void modificar(Consejo consejo);

    // Eliminar
    void eliminar(String titulo);

    // Buscar
    List<Consejo> buscar(String nombre);
}