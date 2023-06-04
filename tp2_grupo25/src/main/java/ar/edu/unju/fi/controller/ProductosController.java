package ar.edu.unju.fi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.listas.ProductoLista;
import ar.edu.unju.fi.model.Producto;

@Controller
@RequestMapping("/productos")
public class ProductosController {

    @Autowired 
    private ProductoLista listaProductos; // Traemos producto lista desde el contenedor de spring (inyeccion de independencias)

    @Autowired
    private Producto producto; // Traemos producto desde el contenedor de spring (inyeccion de independencias)
    
    @GetMapping("/listado")
    public String productosPage(Model model){
        model.addAttribute("productos", listaProductos.getProductos());
        return "productos";
    }
    
    @GetMapping("/nuevo-producto")
    public String nuevoProductoPage(Model model){
        model.addAttribute("producto", producto);
        return "nuevo_producto";
    }

    @PostMapping("/guardar")
    public ModelAndView getGuardarProductoPage(@ModelAttribute("producto") Producto producto){
        ModelAndView modelView = new ModelAndView("productos"); // nombre de la pagina
        listaProductos.getProductos().add(producto); // Trae el arrayList y agrega el nuevo objeto al array
        modelView.addObject("productos", listaProductos.getProductos());
        return modelView;
    }

    // Modificar
    @GetMapping("/modificar/{nombre}")
    public String getModificarProductoPage(Model model, @PathVariable(value="nombre")String nombre){
        Producto productoEncontrado = producto;
        boolean edicion = true;
        for(Producto prod : listaProductos.getProductos()){
            if (prod.getNombre().equals(nombre)){
                productoEncontrado = prod;
                break;
            }
        }
        model.addAttribute("producto", productoEncontrado);
        model.addAttribute("edicion", edicion);

        return "nuevo_producto";
    }

    @PostMapping("/modificar")
    public String modificarSucursal(@ModelAttribute("producto") Producto producto){
        for(Producto prod : listaProductos.getProductos()){
            if(prod.getNombre().equals(producto.getNombre())){
                prod.setCategoria(producto.getCategoria());
                prod.setCodigo(producto.getCodigo());
                prod.setDescuento(producto.getDescuento());
                prod.setPrecio(producto.getPrecio());
                
            }
        }
        return "redirect:/productos/listado";
    }

    // Eliminar producto
    @GetMapping("/eliminar/{nombre}")
    public String elimarProducto(@PathVariable(value="nombre")String nombre){
        for(Producto prod : listaProductos.getProductos()){
            if(prod.getNombre().equals(nombre)){
                listaProductos.getProductos().remove(prod);
                break;
            }
        }
        return "redirect:/productos/listado";
    }
}
