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

import ar.edu.unju.fi.entity.Servicio;
import ar.edu.unju.fi.service.IServicioService;

@Controller
@RequestMapping("/servicios")
public class ServicioPaseoController {

    @Autowired
    private IServicioService servicioService;

    @GetMapping("/listado")
    public String getServicioDePaseoPage(Model model){
        model.addAttribute("servicios", servicioService.getListaServicio());
        
        // Instanciamos un nuevo objeto Servicio (no parametrisado) para prepararlo para la busqueda
        model.addAttribute("servicio", servicioService.getServicio());
        
        return "serviciodepaseos";
    }

    /* 
    Para la busqueda obtenemos del objeto Servicio el nombre.
    Reutilizamos el metodo getBy (para buscar por el nombre)
 */
    @PostMapping("/buscar")
    public String buscarSucursal(@ModelAttribute("servicio") Servicio servicio, Model model){
        //ModelAndView modelView = new ModelAndView("sucursales");

        Boolean buscar = true;
        
        // Buscando por el nombre de mascota
        model.addAttribute("servicioEncontrado", servicioService.getBy(servicio.getNombreMascota()));
        model.addAttribute("buscar", buscar);

        return "serviciodepaseos";
    }

    

    @GetMapping("/nuevo-servicio/{dia}/{paseador}")
    public String getNuevoServicioPage(Model model, @PathVariable(value="dia")String dia, @PathVariable(value="paseador")String paseador){
        model.addAttribute("servicio", servicioService.getServicio());
        model.addAttribute("dia", dia);
        model.addAttribute("paseador", paseador);
      
        return "nuevo_servicio";
    }

    @PostMapping("/guardar")
    public ModelAndView getGuardarServicioPage(@ModelAttribute("servicio") Servicio servicio, BindingResult result){
        ModelAndView modelView = new ModelAndView("serviciodepaseos");

        servicioService.guardar(servicio);
        modelView.addObject("servicios", servicioService.getListaServicio());
        return modelView;
    }


    // Modificar Servicio
    @GetMapping("/modificar/{nombreMascota}") // Traemos el nombre de la mascota
    public String getModificarServicioPage(Model model, @PathVariable(value="nombreMascota")String nombreMascota){

        boolean edicion = true;         

        model.addAttribute("servicio", servicioService.getBy(nombreMascota)); // Enviamos nuestro servicio encontrado
        model.addAttribute("edicion", edicion); // Enviamos esta variable booleana para saber si editamos o agregamos un nuevo servicio
        return "nuevo_servicio";
    }


    @PostMapping("/modificar")
    public String modificarSucursal(@ModelAttribute("servicio") Servicio servicio){    // Al hacer submit en el form capturamos el objeto a editar   

        servicioService.modificar(servicio);

        return "redirect:/servicios/listado"; // Nos dirigimos hacia el listado de servicios
    }




    //Eliminar Servicio    
    @GetMapping("/eliminar/{nombreMascota}")// Traemos el nombre de la mascota para luego iterar en la lista de Servicios
    public String eliminarMascota(@PathVariable(value = "nombreMascota")String nombreMascota){
        servicioService.eliminar(nombreMascota);
        return "redirect:/servicios/listado";
    }
}

