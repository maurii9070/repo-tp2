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

import ar.edu.unju.fi.entity.Consejo;
import ar.edu.unju.fi.service.IConsejoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/consejos")
public class ConsejosSaludController {


    @Autowired
    private IConsejoService consejoService;
    
    @GetMapping("/listado") // entramos al listado e imprimimos los consejos guardados en lista
    public String getConsejosSaludPage(Model model){
        model.addAttribute("consejos", consejoService.getListaConsejo());

        model.addAttribute("consejo", consejoService.getConsejo());
        return "consejosdesalud";
    }

    /* 
    Para la busqueda obtenemos del objeto consejo el titulo.
    Realizamos la busqueda por titulo
 */
    @PostMapping("/buscar")
    public String buscarProducto(@ModelAttribute("consejo") Consejo consejo, Model model){
        //ModelAndView modelView = new ModelAndView("sucursales");

        Boolean buscar = true;
        

        model.addAttribute("consejosEncontrados", consejoService.buscar(consejo.getTitulo()));        
        model.addAttribute("buscar", buscar);


        return "consejosdesalud";
    }

   
    @GetMapping("/nuevo-consejo") // Ingresamos al formulario para agregar un nuevo Consejo o Editar
    public String getNuevoConsejoPage(Model model){
        model.addAttribute("consejo", consejoService.getConsejo()); // Instanciamos un nuevo consejo y lo preparamos para agregarlo a la lista
        return "nuevo_consejo";
    }

    // Guardar un nuevo consejo
    @PostMapping("/guardar")
    public ModelAndView guardarConsejo(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result){
        
        ModelAndView modelView = new ModelAndView("consejosdesalud"); // nombre de la pagina
        // Al clickear Agregar consejo, verificamos si hay errores en los campos
        if(result.hasErrors()){
            modelView.setViewName("nuevo_consejo");
            modelView.addObject("consejo", consejo);
            return modelView;
        }

        // Si no hay errores, continuamos agregando el nuevo consejo a la lista de consejos
        consejoService.guardar(consejo);; // Trae el arrayList y agrega el nuevo objeto al array
        modelView.addObject("consejos", consejoService.getListaConsejo());
        return modelView;
    }

    // Modificar
    @GetMapping("/modificar/{titulo}") // Traemos el titulo del consejo 
    public String getModificarConsejoPage(Model model, @PathVariable(value="titulo")String titulo){
        boolean edicion = true;
        
        model.addAttribute("consejo", consejoService.getBy(titulo)); // Enviamos nuestro consejo encontrado
        model.addAttribute("edicion", edicion); // Enviamos para edicion

        return "nuevo_consejo";
    }

    @PostMapping("/modificar")
    public String modificarSucursal(@Valid @ModelAttribute("consejo") Consejo consejo, BindingResult result, Model model){
        // Al clickear Modificar verificamos si hay errores en los campos
        if(result.hasErrors()){
            boolean edicion = true;
            model.addAttribute("edicion", edicion);
            return "nuevo_consejo";
        }
        
        // Si pasamos los errores, vamos a la funcion que modifica el Consejo
        consejoService.modificar(consejo);

        return "redirect:/consejos/listado";
    }

    // Eliminar producto
    @GetMapping("/eliminar/{titulo}") // Traemos el titulo para luego buscarlo en la lista
    public String elimarProducto(@PathVariable(value="titulo")String titulo){
        
        consejoService.eliminar(titulo);

        return "redirect:/consejos/listado";
    }
}
