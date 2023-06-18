package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.SucursalLista;
import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;

@Service
public class SucursalServiceImp implements  ISucursalService{
    @Autowired
    private SucursalLista listaSucursales;
    @Autowired
    private Sucursal sucursal;

    // Obtener la lista de sucursales
    public List<Sucursal> getListaSucursal(){
        return listaSucursales.getSucursales();
    }

    @Override
    public Sucursal getSucursal(){
        return sucursal;
    }

    // Agregar una sucursal a la lista de Sucursales
    public void guardarSucursal(Sucursal sucursal){
        listaSucursales.getSucursales().add( sucursal);
    }

    // Obtener sucursal
    public Sucursal getBy(String nombre){
        Sucursal sucursalEncontrada = sucursal; // Instanciamos un nuevo objeto sucursal
        for(Sucursal sucu : listaSucursales.getSucursales()){ // Iteramos en lista sucursal
            if(sucu.getNombre().equals(nombre)){ // Encontramos la sucursal a modificar
                sucursalEncontrada = sucu;
                break;
            } else{
                sucursalEncontrada = null; // Necesario para la busqueda
            }
        }
        return sucursalEncontrada;
    }

    // Modificar una sucursal
    public void modificarSucursal(Sucursal sucursal){
        for(Sucursal sucu : listaSucursales.getSucursales()){ // Iteramos sobre la lista de sucursales
            if(sucu.getNombre().equals(sucursal.getNombre())){ // Al encontrar coincidencia reemplazamos
                sucu.setNombre(sucursal.getNombre());
                sucu.setEncargadoNombre(sucursal.getEncargadoNombre());
                sucu.setDireccion(sucursal.getDireccion());
            }
         }
    }
    
// Eliminar sucursal
    public void eliminarSucursal(String nombre){
        for(Sucursal sucu : listaSucursales.getSucursales()){ //Iteramos sobre la lista de sucursales
            if(sucu.getNombre().equals(nombre)){ // Encontramos la sucursal a eliminar
                listaSucursales.getSucursales().remove(sucu); // Removemos de la lista
                break;
            }
        }
    }
    
}
