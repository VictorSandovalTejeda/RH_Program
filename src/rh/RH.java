/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Alumnos
 */
public class RH {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int cantEmp = 0;
        String nombre;
        double sueldo;
        int carro, vacaciones, regalias;
        boolean tieneCarro = false;
        boolean vacacionesPagadas = false;
        int horasextras;
        boolean tieneregalias = false;
        int tipoEmp;

        do {
            try {
                System.out.println("Cuantos empleados va a ingresar?            ←Ingrese <0> para salir");
                cantEmp = sc.nextInt();
                Empleado[] arregloEmpleado = new Empleado[cantEmp];

                for (int i = 0; i < arregloEmpleado.length; i++) {
                    System.out.println("Ingrese Nombre del Empleado #" + (i + 1) + ":");
                    System.out.print("•→");
                    nombre = sc.nextLine();
                    System.out.println("Ingrese Sueldo del Empleado:");
                    System.out.print("•→");
                    sueldo = sc.nextDouble();
                    System.out.println("--------------");
                    System.out.println("1. Gerente");
                    System.out.println("2. Operario");
                    System.out.println("--------------");
                    System.out.print("•→");
                    tipoEmp = sc.nextInt();
                    switch (tipoEmp) {
                        case 1:
                            System.out.println("Ingrese <1> si la empresa paga carro, y cualquier otro numero caso contrario.");
                            System.out.print("•→");
                            carro = sc.nextInt();
                            if (carro == 1) {
                                tieneCarro = true;
                            }
                            System.out.println("Ingrese <1> si la empresa paga vacaciones, y cualquier otro numero caso contrario.");
                            System.out.print("•→");
                            vacaciones = sc.nextInt();
                            if (vacaciones == 1) {
                                vacacionesPagadas = true;
                            }
                            arregloEmpleado[i] = new Gerente(nombre, sueldo, tieneCarro, vacacionesPagadas);

                            break;
                        case 2:
                            System.out.println("Cuantas horas extras a realizado?");
                            System.out.print("•→");
                            horasextras = sc.nextInt();
                            System.out.println("Ingrese <1> si el empleado tiene regalias, y cualquier otro numero caso contrario.");
                            System.out.print("•→");
                            regalias = sc.nextInt();
                            if (regalias == 1) {
                                tieneregalias = true;
                            }
                            arregloEmpleado[i] = new Operario(nombre, sueldo, horasextras, tieneregalias);
                            break;
                        default:
                            break;
                    }

                }

                System.out.println("GERENTES");
                for (int i = 0; i < arregloEmpleado.length; i++) {
                    System.out.println("Nombre: " + arregloEmpleado[i].getNombre()
                            + " --- Sueldo: " + arregloEmpleado[i].getSueldo());

                }

                Operario tmp;
                System.out.println("OPERARIOS");
                for (int i = 0; i < arregloEmpleado.length; i++) {
                    if (arregloEmpleado[i] instanceof Operario) {
                        tmp = (Operario) arregloEmpleado[i];
                        if (tmp.getHoraextra() > 0) {
                            System.out.println(tmp.getNombre() + " tiene "
                                    + tmp.getHoraextra() + " horas extras.");
                        }else{
                            System.out.println(tmp.getNombre() + " no tiene horas extras.");
                        }
                    }

                }
            } catch (InputMismatchException e) {

            }
        } while (cantEmp != 0);
    }

}
