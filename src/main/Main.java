package main;

import java.util.ArrayList;
import java.util.Scanner;

import menues.MenuPrincipal;
import modelos.usuarios.Cliente;
import modelos.usuarios.Empleado;

public class Main {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

       MenuPrincipal menu = new MenuPrincipal(sc, listaEmpleados, listaClientes);

        menu.iniciar();

    }
}
