package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.listas.ServicioLista;
import ar.edu.unju.fi.service.IServicioService;

@Service
public class ServicioServiceImp implements IServicioService {
    
    @Autowired
    private ServicioLista listaServicios;
    @Autowired
    private Servicio servicio;

    // Obtener servicios
    public List<Servicio> getListaServicio(){
        return listaServicios.getServicios();
    }

    @Override
    public Servicio getServicio(){
        return servicio;
    }

    // Guardar servicio
    public void guardar(Servicio servicio){
        listaServicios.getServicios().add( servicio);
    }

    public Servicio getBy(String nombre){
        Servicio servicioEncontrado = servicio; // Instanciamos un nuevo servicio
        for(Servicio serv : listaServicios.getServicios()){ // Iteramos en la lista de servicios
            if (serv.getNombreMascota().equals(nombre)){ // Buscamos coincidencias por el nombre de la mascota
                servicioEncontrado = serv; // Si encuentra, servicioEncontrado guardará a ese servicio encontrado
                break; // Salimos del for
            } else{
                servicioEncontrado = null;
            }
        }
        return servicioEncontrado;
    }

    // Modificar Servicio
    public void modificar(Servicio servicio){
        for(Servicio serv : listaServicios.getServicios()){ // Iteramos en la lista
            if(serv.getNombreMascota().equals(servicio.getNombreMascota())){ // Buscamos por el nombre de la mascota, para remplazar los campos editados
                serv.setNombreMascota(servicio.getNombreMascota()); // Aqui se reemplazan los datos, al encontrar coincidencias con el nombre mascota
                serv.setNombreDuenio(servicio.getNombreDuenio());
                serv.setDiaPaseo(servicio.getDiaPaseo());
                serv.setPaseadorNombre(servicio.getPaseadorNombre());
                serv.setHorarioPaseo(servicio.getHorarioPaseo());               
            }
        }
    }

    public void eliminar(String nombreMascota){
        for(Servicio serv : listaServicios.getServicios()){ //Iteramos
            if(serv.getNombreMascota().equals(nombreMascota)){ // Obtenemos el objeto con el nombre de la mascota
                listaServicios.getServicios().remove(serv); // Removemos el objeto 
                break;
            }
        }
    }

}