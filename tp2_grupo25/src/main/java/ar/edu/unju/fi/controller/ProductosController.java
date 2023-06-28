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

import ar.edu.unju.fi.entity.Producto;
import ar.edu.unju.fi.service.IProductoService;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/productos")
public class ProductosController {
    
    @Autowired
    private IProductoService productoService;

    @GetMapping("/listado")
    public String productosPage(Model model){
        model.addAttribute("productos", productoService.getListaProducto());

        model.addAttribute("producto", productoService.getProducto());

        return "productos";
    }

    /* 
    Para la busqueda obtenemos del objeto Producto el nombre.
 */
    @PostMapping("/buscar")
    public String buscarProducto(@ModelAttribute("producto") Producto producto, Model model){
        //ModelAndView modelView = new ModelAndView("sucursales");

        Boolean buscar = true;
        

        model.addAttribute("productosEncontrado", productoService.buscar(producto.getNombre()));        
        model.addAttribute("buscar", buscar);


        return "productos";
    }

    
    @GetMapping("/nuevo-producto")
    public String nuevoProductoPage(Model model){
        model.addAttribute("producto", productoService.getProducto());
        return "nuevo_producto";
    }

 // Guardamos el objeto Producto con los datos del Form en listaProductos
    @PostMapping("/guardar") // Tp5 pt2 @valid y BindingResult
    public ModelAndView getGuardarProductoPage(@Valid @ModelAttribute("producto") Producto producto , BindingResult result){
        ModelAndView modelView = new ModelAndView("productos"); // nombre de la pagina
        if(result.hasErrors()){
            modelView.setViewName("nuevo_producto");
            modelView.addObject("producto", producto);
            return modelView;
        }
        productoService.guardar(producto); //  agrega el nuevo objeto al array
        modelView.addObject("productos", productoService.getListaProducto());
        return modelView;
    }

    // Modificar
    @GetMapping("/modificar/{nombre}")
    public String getModificarProductoPage(Model model, @PathVariable(value="nombre")String nombre){
        boolean edicion = true;
        
        model.addAttribute("producto", productoService.getBy(nombre));
        model.addAttribute("edicion", edicion);

        return "nuevo_producto";
    }

    @PostMapping("/modificar")
    public String modificarSucursal(@Valid @ModelAttribute("producto") Producto producto, BindingResult result, Model model){
        
        if(result.hasErrors()){
            boolean edicion = true;
            model.addAttribute("edicion", edicion);
            return "nuevo_producto";
        }

        productoService.modificar(producto);
        return "redirect:/productos/listado";
    }

    // Eliminar producto
    @GetMapping("/eliminar/{nombre}")
    public String elimarProducto(@PathVariable(value="nombre")String nombre){

        productoService.eliminar(nombre);

        return "redirect:/productos/listado";
    }
}
