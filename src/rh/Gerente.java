/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh;

/**
 *
 * @author Alumnos
 */
public class Gerente extends Empleado{
    
    private boolean tieneCarro;
    private boolean vacacionesPagadas;

    public Gerente( String nombre, double sueldo, boolean tieneCarro, boolean vacacionesPagadas) {
        super(nombre, sueldo);
        this.tieneCarro = tieneCarro;
        this.vacacionesPagadas = vacacionesPagadas;
    }

    public boolean isTieneCarro() {
        return tieneCarro;
    }

    public boolean isVacacionesPagadas() {
        return vacacionesPagadas;
    }
    
    
    
}
