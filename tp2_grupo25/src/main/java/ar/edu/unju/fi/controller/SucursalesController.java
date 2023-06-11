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

import ar.edu.unju.fi.listas.SucursalLista;
import ar.edu.unju.fi.model.Sucursal;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/sucursales")
public class SucursalesController {


    @Autowired
    private SucursalLista listaSucursales;

    @Autowired 
    private Sucursal sucursal;

    @GetMapping("/listado")
    public String getSucursalesPage(Model model){
        model.addAttribute("sucursales", listaSucursales.getSucursales());
        return "sucursales";
    }

    // Preparamos el objeto para guardarlo en la lista de sucursales
    @GetMapping("/nueva-sucursal") // Agregamos la direccion al formulario de nueva sucursal
    public String nuevaSucursalPage(Model model){
        model.addAttribute("sucursal", sucursal); // Instanciamos una nueva sucursal para enviar...
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

        listaSucursales.getSucursales().add(sucursal); // Trae el arrayList y agrega el nuevo objeto al array
        modelView.addObject("sucursales", listaSucursales.getSucursales());

        return modelView;
    }

    // Modificar una sucursal 
    @GetMapping("/modificar/{nombre}") // Traemos el nombre de una sucursal a editar
    public String getModificarSucursalPage(Model model, @PathVariable(value = "nombre") String nombre){
        Sucursal sucursalEncontrada = sucursal; // Instanciamos un nuevo objeto sucursal
        boolean edicion = true; // Avisar que estamos en el modo edicion
        for(Sucursal sucu : listaSucursales.getSucursales()){ // Iteramos en lista sucursal
            if(sucu.getNombre().equals(nombre)){ // Encontramos la sucursal a modificar
                sucursalEncontrada = sucu;
            }
        }
        model.addAttribute("sucursal", sucursalEncontrada); // Enviamos el objeto encontrado
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

         for(Sucursal sucu : listaSucursales.getSucursales()){ // Iteramos sobre la lista de sucursales
            if(sucu.getNombre().equals(sucursal.getNombre())){ // Al encontrar coincidencia reemplazamos
                sucu.setNombre(sucursal.getNombre());
                sucu.setEncargadoNombre(sucursal.getEncargadoNombre());
                sucu.setDireccion(sucursal.getDireccion());
            }
         }

         return "redirect:/sucursales/listado";
    }

    // Eliminar sucursal
    @GetMapping("/eliminar/{nombre}")
    public String elimarSucursal(@PathVariable(value="nombre")String nombre){
        for(Sucursal sucu : listaSucursales.getSucursales()){ //Iteramos sobre la lista de sucursales
            if(sucu.getNombre().equals(nombre)){ // Encontramos la sucursal a eliminar
                listaSucursales.getSucursales().remove(sucu); // Removemos de la lista
                break;
            }
        }
        return "redirect:/sucursales/listado";
    }
}