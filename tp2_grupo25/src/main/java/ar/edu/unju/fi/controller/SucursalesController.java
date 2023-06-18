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

import ar.edu.unju.fi.model.Sucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {

    @Autowired
    private ISucursalService sucursalService;

    @GetMapping("/listado")
    public String getSucursalesPage(Model model){
        model.addAttribute("sucursales", sucursalService.getListaSucursal());

        return "sucursales";
    }


    // Preparamos el objeto para guardarlo en la lista de sucursales
    @GetMapping("/nueva-sucursal") // Agregamos la direccion al formulario de nueva sucursal
    public String nuevaSucursalPage(Model model){
        model.addAttribute("sucursal", sucursalService.getSucursal()); // Instanciamos una nueva sucursal para enviar...
        return "nueva_sucursal";                               // a nueva sucursal
    }

    // Guardar una sucursal
    @PostMapping("/guardar")
    public ModelAndView guardarSucursalPage(@Valid @ModelAttribute("sucursal") Sucursal sucursal, BindingResult result){
        ModelAndView modelView = new ModelAndView("sucursales");

        if(result.hasErrors()){
            modelView.setViewName("nueva_sucursal");
            modelView.addObject("producto", sucursal);
            return modelView;
        }

        sucursalService.guardarSucursal(sucursal); // Trae el arrayList y agrega el nuevo objeto al array
        modelView.addObject("sucursales", sucursalService.getListaSucursal());

        return modelView;
    }

    // Modificar una sucursal 
    @GetMapping("/modificar/{nombre}") // Traemos el nombre de una sucursal a editar
    public String getModificarSucursalPage(Model model, @PathVariable(value = "nombre") String nombre){
       
        boolean edicion = true; // Avisar que estamos en el modo edicion
        
        model.addAttribute("sucursal", sucursalService.getBy(nombre)); // Enviamos el objeto encontrado
        model.addAttribute("edicion", edicion);

        return "nueva_sucursal";
    }

    @PostMapping("/modificar")
    public String modificarSucursal(@Valid @ModelAttribute("sucursal")Sucursal sucursal, BindingResult result, Model model){ //Tenemos el objeto modificado

        if(result.hasErrors()){
            boolean edicion = true;
            model.addAttribute("edicion", edicion);
            return "nueva_sucursal";
        }

         sucursalService.modificarSucursal(sucursal);

         return "redirect:/sucursales/listado";
    }

    // Eliminar sucursal
    @GetMapping("/eliminar/{nombre}")
    public String elimarSucursal(@PathVariable(value="nombre")String nombre){
        sucursalService.eliminarSucursal(nombre);
        return "redirect:/sucursales/listado";
    }
}