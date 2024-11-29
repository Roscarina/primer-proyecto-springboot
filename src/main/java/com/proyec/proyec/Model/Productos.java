package com.proyec.proyec.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor


public class Productos {

    private int idProducto;
    private String Nombre;
    private int Valor;
    private int Cantidad;

}
