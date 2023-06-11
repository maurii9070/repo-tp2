package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Sucursal;

@Component
public class SucursalLista {
    private List<Sucursal> sucursales;

    public List<Sucursal> getSucursales(){
        return sucursales;
    }

    public void setSucursales(List<Sucursal> sucursales){
        this.sucursales = sucursales;
    }

    public SucursalLista(){
        sucursales = new ArrayList<Sucursal>();
        sucursales.add(new Sucursal("Patitas 1", "Victor Blanco", "Av. Belgrano 788"));
        sucursales.add(new Sucursal("Patitas 2", "Daniel Angelici", "Alvear 666"));
        sucursales.add(new Sucursal("Patitas 3", "Cristina Fernandez", "Av. J. Domingo Peron 555"));
        sucursales.add(new Sucursal("Patitas 4", "Daniela Chayle", "Necochea 123"));
    }
}
