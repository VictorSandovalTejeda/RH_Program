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
 * @author pc HP
 */
public class MenuOpciones {

    Scanner sc = new Scanner(System.in);
    Empleado[] arregloEmpleado;

    public void OpcionIngresar() {
        int cantEmp = 0;
        int tipoEmp;
        int carro, vacaciones, regalias, horasextras; //captura las respuesta con enteros para luego convertirla a booleano.
        boolean tieneCarro, vacacionesPagadas, tieneregalias;
        String nombre;
        double sueldo;

        do {
            try {
                System.out.println("Cuantos empleados va a ingresar?                    " + Console_Colors.ANSI_BLUE + "←Ingrese <0> para regresar" + Console_Colors.ANSI_RESET);
                cantEmp = sc.nextInt();
                if (cantEmp >= 1) {
                    arregloEmpleado = new Empleado[cantEmp];

                    for (int i = 0; i < arregloEmpleado.length; i++) {
                        sc.nextLine();
                        System.out.println(Console_Colors.ANSI_GREEN + (i + 1) + " EMPLEADO" + Console_Colors.ANSI_RESET);
                        System.out.print("Nombre del Empleado >");
                        nombre = sc.nextLine();
                        System.out.print("Sueldo del Empleado >");
                        sueldo = sc.nextDouble();
                        System.out.println("-----Tipo Empleado-----");
                        System.out.println("1. Gerente");
                        System.out.println("2. Operario");
                        System.out.println("-----------------------");
                        System.out.print(">>");
                        tipoEmp = sc.nextInt();
                        switch (tipoEmp) {
                            case 1:
                                System.out.println("Ingrese <1> si la empresa paga carro, y cualquier otro numero caso contrario.");
                                System.out.print(">>");
                                carro = sc.nextInt();
                                tieneCarro = (carro == 1);
                                System.out.println("Ingrese <1> si la empresa le paga vacaciones, y cualquier otro numero caso contrario.");
                                System.out.print(">>");
                                vacaciones = sc.nextInt();
                                vacacionesPagadas = (vacaciones == 1);
                                arregloEmpleado[i] = new Gerente(nombre, sueldo, tieneCarro, vacacionesPagadas);

                                break;
                            case 2:
                                System.out.println("Cuantas horas extras a realizado?");
                                System.out.print(">>");
                                horasextras = sc.nextInt();
                                System.out.println("Ingrese <1> si el empleado tiene regalias, y cualquier otro numero caso contrario.");
                                System.out.print(">>");
                                regalias = sc.nextInt();
                                tieneregalias = (regalias == 1);
                                arregloEmpleado[i] = new Operario(nombre, sueldo, horasextras, tieneregalias);
                                break;
                            default:
                                break;
                        }
                    }
                    System.out.println("-----" + Console_Colors.ANSI_GREEN + "Los Empleados fueron ingresados exitosamente" + Console_Colors.ANSI_RESET + "-----");
                    System.out.println();
                    cantEmp = 0;
                } else {

                }
            } catch (InputMismatchException e) {
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato invalido" + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }
        } while (cantEmp != 0);

    }

    public void OpcionVer() {
        int opcion = 0;

        do {
            try {
                System.out.println("Que tipo de Empleado desea ver?                    " + Console_Colors.ANSI_BLUE + "←Ingrese <0> para regresar" + Console_Colors.ANSI_RESET);
                System.out.println("-----Tipo Empleado-----");
                System.out.println("1. Gerentes");
                System.out.println("2. Operarios");
                System.out.println("-----------------------");
                System.out.print(">>");
                opcion = sc.nextInt();
                System.out.println();
                switch (opcion) {
                    case 1:
                        Gerente temp;
                        String tieneCarro;
                        String vacaciones;
                        System.out.println("__________________________________________________");
                        System.out.println(Console_Colors.ANSI_PURPLE + "                     GERENTES                     " + Console_Colors.ANSI_RESET);
                        System.out.println("__________________________________________________");
                        System.out.printf("%-20s%-10s%-9s%-10s%n", "NOMBRE", "SUELDO", "CARRO", "VACACIÓN");
                        System.out.println("__________________________________________________");
                        for (int i = 0; i < arregloEmpleado.length; i++) {
                            if (arregloEmpleado[i] instanceof Gerente) {
                                temp = (Gerente) arregloEmpleado[i];
                                System.out.printf("%-20s%-10s%-9s%-10s%n", arregloEmpleado[i].getNombre(), arregloEmpleado[i].getSueldo(), convertirBoolean(temp.isTieneCarro()), convertirBoolean(temp.isVacacionesPagadas()));
                            }
                        }
                        System.out.println("__________________________________________________");
                        System.out.println();
                        break;
                    case 2:
                        Operario tmp;
                        System.out.println("__________________________________________________");
                        System.out.println(Console_Colors.ANSI_PURPLE + "                    OPERARIOS                     " + Console_Colors.ANSI_RESET);
                        System.out.println("__________________________________________________");
                        System.out.printf("%-20s%-10s%-10s%-10s%n", "NOMBRE", "SUELDO", "H.E.", "REGALIA");
                        System.out.println("__________________________________________________");
                        for (int i = 0; i < arregloEmpleado.length; i++) {
                            if (arregloEmpleado[i] instanceof Operario) {
                                tmp = (Operario) arregloEmpleado[i];
                                System.out.printf("%-20s%-10s%-10d%-10s%n", arregloEmpleado[i].getNombre(), arregloEmpleado[i].getSueldo(), tmp.getHoraextra(), convertirBoolean(tmp.isTieneregalias()));
                            }
                        }
                        System.out.println("__________________________________________________");
                        System.out.println();
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println(Console_Colors.ANSI_RED + "**Ingreso un dato invalido" + Console_Colors.ANSI_RESET);
                System.out.println();
                sc.nextLine();
            }

        } while (opcion != 0);

    }

    public String convertirBoolean(boolean b) {
        String temp;

        if (b == false) {
            temp = "No";
        } else {
            temp = "Si";
        }
        return temp;
    }

}
