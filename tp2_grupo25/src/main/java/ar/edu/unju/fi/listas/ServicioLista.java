package ar.edu.unju.fi.listas;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Servicio;

@Component
public class ServicioLista {
    private List<Servicio> servicios;

    public List<Servicio> getServicios(){
        return servicios;
    }

    public void setServicios(List<Servicio> servicios){
        this.servicios = servicios;
    }

    public ServicioLista(){
        servicios = new ArrayList<Servicio>();
    }
}
