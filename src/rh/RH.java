/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rh;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.awt.*;

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
        int opcion = 0;
        MenuOpciones m = new MenuOpciones();

        System.out.println("--------------------------------------------");
        System.out.println("         RECURSOS HUMANOS VSANDOVAL");
        do {
            try {
                System.out.println("--------------------------------------------");
                System.out.println("---------------" + Console_Colors.ANSI_PURPLE + "Menu Principal" + Console_Colors.ANSI_RESET + "---------------");
                System.out.println("1. Ingresar Empleados");
                System.out.println("2. Ver Empleados");
                System.out.println("3. Salir");
                System.out.println("--------------------------------------------");
                System.out.print(">>");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println();
                        System.out.println(Console_Colors.ANSI_PURPLE + "1. Ingresar Empleados" + Console_Colors.ANSI_RESET);
                        m.OpcionIngresar();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println(Console_Colors.ANSI_PURPLE + "2. Ver Empleados" + Console_Colors.ANSI_RESET);
                        m.OpcionVer();
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato Invalido." + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }
        } while (opcion != 3);
    }

}
