package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ServicioLista;
import ar.edu.unju.fi.model.Servicio;

@Controller
@RequestMapping("/servicios")
public class ServicioPaseoController {

    @Autowired
    private Servicio servicio;

    @Autowired
    private ServicioLista listaServicios;

    @GetMapping("/listado")
    public String getServicioDePaseoPage(Model model){
        model.addAttribute("servicios", listaServicios.getServicios());
        return "serviciodepaseos";
    }

    @GetMapping("/nuevo-servicio/{dia}/{paseador}")
    public String getNuevoServicioPage(Model model, @PathVariable(value="dia")String dia, @PathVariable(value="paseador")String paseador){
        model.addAttribute("servicio", servicio);
        model.addAttribute("dia", dia);
        model.addAttribute("paseador", paseador);
      
        return "nuevo_servicio";
    }

    @PostMapping("/guardar")
    public ModelAndView getGuardarServicioPage(@ModelAttribute("servicio") Servicio servicio, BindingResult result){
        ModelAndView modelView = new ModelAndView("serviciodepaseos");

        listaServicios.getServicios().add(servicio);
        modelView.addObject("servicios", listaServicios.getServicios());
        return modelView;
    }


    // Modificar Servicio
    @GetMapping("/modificar/{nombreMascota}") // Traemos el nombre de la mascota
    public String getModificarServicioPage(Model model, @PathVariable(value="nombreMascota")String nombreMascota){
        Servicio servicioEncontrado = servicio; // Instanciamos un nuevo servicio
        boolean edicion = true; 
        for(Servicio serv : listaServicios.getServicios()){ // Iteramos en la lista de servicios
            if (serv.getNombreMascota().equals(nombreMascota)){ // Buscamos coincidencias por el nombre de la mascota
                servicioEncontrado = serv; // Si encuentra, servicioEncontrado guardará a ese servicio encontrado
                break; // Salimos del for
            }
        }
        model.addAttribute("servicio", servicioEncontrado); // Enviamos nuestro servicio encontrado
        model.addAttribute("edicion", edicion); // Enviamos esta variable booleana para saber si editamos o agregamos un nuevo servicio
        return "nuevo_servicio";
    }


    @PostMapping("/modificar")
    public String modificarSucursal(@ModelAttribute("servicio") Servicio servicio){    // Al hacer submit en el form capturamos el objeto a editar   

        for(Servicio serv : listaServicios.getServicios()){ // Iteramos en la lista
            if(serv.getNombreMascota().equals(servicio.getNombreMascota())){ // Buscamos por el nombre de la mascota, para remplazar los campos editados
                serv.setNombreMascota(servicio.getNombreMascota()); // Aqui se reemplazan los datos, al encontrar coincidencias con el nombre mascota
                serv.setNombreDuenio(servicio.getNombreDuenio());
                serv.setDiaPaseo(servicio.getDiaPaseo());
                serv.setPaseadorNombre(servicio.getPaseadorNombre());
                serv.setHorarioPaseo(servicio.getHorarioPaseo());               
            }
        }
        return "redirect:/servicios/listado"; // Nos dirigimos hacia el listado de servicios
    }




    //Eliminar Servicio    
    @GetMapping("/eliminar/{nombreMascota}")// Traemos el nombre de la mascota para luego iterar en la lista de Servicios
    public String eliminarMascota(@PathVariable(value = "nombreMascota")String nombreMascota){
        for(Servicio serv : listaServicios.getServicios()){ //Iteramos
            if(serv.getNombreMascota().equals(nombreMascota)){ // Obtenemos el objeto con el nombre de la mascota
                listaServicios.getServicios().remove(serv); // Removemos el objeto 
                break;
            }
        }
        return "redirect:/servicios/listado";
    }
}
