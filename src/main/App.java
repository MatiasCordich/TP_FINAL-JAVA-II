package main;

import java.util.ArrayList;
import java.util.Scanner;

import menues.MenuRegistroLogin;
import modelos.usuarios.Cliente;
import modelos.usuarios.Empleado;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Empleado> listaEmpleados = new ArrayList<Empleado>();
        ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

        MenuRegistroLogin mLoginRegistro = new MenuRegistroLogin(listaEmpleados, listaClientes, sc);

        mLoginRegistro.iniciar();

    }
}
