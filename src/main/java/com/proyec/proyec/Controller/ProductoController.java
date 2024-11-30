package com.proyec.proyec.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyec.proyec.Model.Productos;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/Productos")
public class ProductoController {

    private List<Productos> productosAlmacenados = new ArrayList<>(
        Arrays.asList(
            new Productos(123, "Coffe", 7000, 100), // 0 
            new Productos(234, "Leche", 9000, 50), // 1
            new Productos(456, "Papas", 2000, 10) 
        )
    );

    @GetMapping("")
    public List<Productos> getProductos(
        @RequestParam(required = false, defaultValue = "") String nombre
    ) 
    {
        if (nombre.equals("")) {
            return productosAlmacenados;
        } else {
            return getProductosPorNombre(nombre);
        }
        
        
    }

    @GetMapping("/{id}")
    public Productos getProducto(@PathVariable int id){
        for (Productos producto : productosAlmacenados){
                if (producto.getIdProducto() == id) {
                    return producto;            
                }
            }
        return null;
    }
    
    private List<Productos> getProductosPorNombre(String nombre) {
        List<Productos> productosNombres = new ArrayList<>();
        // productosNombres.add(produ)
        
        for (Productos producto : productosAlmacenados){
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                productosNombres.add(producto);  
            }
        }
        
        return productosNombres;
    }

    @PostMapping("")
    public Productos agregarProducto(@RequestBody Productos entity) {
        productosAlmacenados.add(entity);
        return entity;
    }
    
    @DeleteMapping("/{id}")
    public void deleteProductos(@PathVariable int id){
        for (int i = 0; i < productosAlmacenados.size() ; i++){
            Productos productoD = productosAlmacenados.get(i);
            if (productoD.getIdProducto() ==  id){
            // if (productosAlmacenados.get(i).getIdProducto() == id )
                productosAlmacenados.remove(i);
            }
        }
    }

    @PutMapping("/{id}")
    public void actualizarProducto(@PathVariable int id, @RequestBody Productos entity) {
        for (int i = 0; i < productosAlmacenados.size(); i++){
            Productos productosA = productosAlmacenados.get(i);
            if (productosA.getIdProducto() == id){
                productosAlmacenados.set(i, entity);
            }
        }
    }

}
