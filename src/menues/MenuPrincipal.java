package menues;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.usuarios.Cliente;
import modelos.usuarios.Empleado;

public class MenuPrincipal {

    private boolean continuar = true;
    private Scanner sc;
    ArrayList<Empleado> listaEmpleados;
    ArrayList<Cliente> listaClientes;

    public MenuPrincipal(Scanner sc, ArrayList<Empleado> listaEmpleados, ArrayList<Cliente> listaClientes) {
        this.sc = sc;
        this.listaEmpleados = listaEmpleados;
        this.listaClientes = listaClientes;
    }

    private void mostrarOpciones() {
        System.out.println("---------------------------------------------");
        System.out.println("BIENVENIDO A PURIN MARKET");
        System.out.println(" 0 - SALIR DEL PROGRAMA");
        System.out.println(" 1 - REGISTRO/LOGIN");
        System.out.println("---------------------------------------------");
        System.out.print("Por favor, elija una de las siguientes opciones: ");
    }

    public void iniciar() {
        while (continuar) {
            int opcion = this.elegirOpcion();
            this.realizarOpcion(opcion);
        }
    }

    private int elegirOpcion() {
        this.mostrarOpciones();
        int opcion = this.sc.nextInt();
        return opcion;
    }

    private void finalizar() {
        this.continuar = false;
        System.out.println("----------------------------------------------");
        System.out.println("HAS SALIDO DEL PROGRAMA, QUE TENGAS UN BUEN DIA");
        System.out.println("----------------------------------------------");
    }

    private void realizarOpcion(int opcion) {
        switch (opcion) {
            case 0:
                this.finalizar();
                break;
            case 1:
                MenuRegistroLogin mRegistroLogin = new MenuRegistroLogin(listaEmpleados, listaClientes, sc);
                mRegistroLogin.iniciar();
                break;
            default:
                System.out.println("----------------------------------------------");
                System.out.println("OPCION INCORRECTA, INGRESE UNA OPCION VALIDA");
                System.out.println("----------------------------------------------");
                break;
        }
    }
}
