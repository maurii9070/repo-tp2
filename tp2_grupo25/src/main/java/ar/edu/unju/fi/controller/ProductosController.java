package ar.edu.unju.fi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ProductoLista;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    ProductoLista listaProductos = new ProductoLista();

    @GetMapping("/listado")
    public String productosPage(Model model){
        model.addAttribute("productos", listaProductos.getProductos());
        return "productos";
    }
    
    @GetMapping("/nuevo-producto")
    public String nuevoProductoPage(Model model){
        model.addAttribute("producto", new Producto());
        return "nuevo_producto";
    }

    @PostMapping("/guardar")
    public ModelAndView getGuardarProductoPage(@ModelAttribute("producto") Producto producto){
        ModelAndView modelView = new ModelAndView("productos"); // nombre de la pagina
        listaProductos.getProductos().add(producto); // Trae el arrayList y agrega el nuevo objeto al array
        modelView.addObject("productos", listaProductos.getProductos());
        return modelView;
    }
}
