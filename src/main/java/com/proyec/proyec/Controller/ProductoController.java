package com.proyec.proyec.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyec.proyec.Model.Productos;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/Productos")
public class ProductoController {

    private List<Productos> productos = new ArrayList<>(
        Arrays.asList(
            new Productos(123, "Coffe", 7000, 100), 
            new Productos(234, "Leche", 9000, 50)
        )
    );

    @GetMapping("")
    public List<Productos> getProductos(
        @RequestParam(required = false, defaultValue = "") String nombre
    ) 
    {
        if (nombre.equals("")) {
            return productos;
        } else {
            return getProductosPorNombre(nombre);
        }
        
        
    }


    @GetMapping("/{id}")
    public Productos getProducto(@PathVariable int id){
        for (Productos producto : productos){
                if (producto.getIdProducto() == id) {
                    return producto;            
                }
            }
        return null;
    }
    
    private List<Productos> getProductosPorNombre(String nombre) {
        List<Productos> productosNombres = new ArrayList<>();
        // productosNombres.add(produ)
        
        for (Productos producto : productos){
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productosNombres.add(producto);  
            }
        }
        
        return productosNombres;
    }
}
