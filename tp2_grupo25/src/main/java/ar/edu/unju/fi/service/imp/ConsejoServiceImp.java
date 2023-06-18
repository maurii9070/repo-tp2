package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.listas.ConsejoLista;
import ar.edu.unju.fi.model.Consejo;
import ar.edu.unju.fi.service.IConsejoService;

@Service
public class ConsejoServiceImp implements IConsejoService {
    
    @Autowired
    private ConsejoLista listaConsejos;
    @Autowired
    private Consejo consejo;

    public List<Consejo> getListaConsejo(){
        return listaConsejos.getConsejos();
    }

    @Override
    public Consejo getConsejo(){
        return consejo;
    }

    // Guardar consejo
    public void guardar(Consejo consejo){
        listaConsejos.getConsejos().add(consejo);
    }

    public Consejo getBy(String titulo){
        Consejo consejoEncontrado = consejo; // Instanciamos un nuevo consejo
        for(Consejo cons : listaConsejos.getConsejos()){ // Iteramos la lista de consejos
            if (cons.getTitulo().equals(titulo)){   // Si encuentra, consejoEncontrado guardará a ese consejo encontrado
                consejoEncontrado = cons;
                break;
            }
        }

        return consejoEncontrado;
    }

    // Modificar Consejo
    public void modificar(Consejo consejo){
        for(Consejo cons : listaConsejos.getConsejos()){
            if(cons.getTitulo().equals(consejo.getTitulo())){
                cons.setTitulo(consejo.getTitulo());
                cons.setImgUrl(consejo.getImgUrl());
                cons.setConsejo(consejo.getConsejo());             
            }
        }
    }

    // Eliminar consejo
    public void eliminar(String titulo){
        for(Consejo cons : listaConsejos.getConsejos()){ // Buscamos, al coincidir los titulos, se elimina dicho consejo
            if(cons.getTitulo().equals(titulo)){
                listaConsejos.getConsejos().remove(cons);
                break;
            }
        }
    }

    // Buscar consejos
    public List<Consejo> buscar(String titulo){
        if(listaConsejos.getConsejos().size() > 0){

            // Vaciar el array, para una nueva busqueda
            listaConsejos.getConsejosEncotrados().clear(); 

            for(Consejo consj : listaConsejos.getConsejos()){
                // Si el nombre en la lista contiene "nombre" se agrega a la lista de
                // Productos encontrados
                if(consj.getTitulo().contains(titulo)){
                    listaConsejos.getConsejosEncotrados().add(consj);
                }
            }
        }

        return listaConsejos.getConsejosEncotrados();
    }

}
