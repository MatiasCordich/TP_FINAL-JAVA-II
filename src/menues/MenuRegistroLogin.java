package menues;

import java.util.ArrayList;
import java.util.Scanner;

import modelos.Usuario;

public class MenuRegistroLogin {

    // Atributos
    private ArrayList<Usuario> listaUsuarios;
    private Scanner sc;
    private boolean continuar = true;

    // Constructor
    public MenuRegistroLogin(ArrayList<Usuario> listaUsuarios, Scanner sc) {
        this.listaUsuarios = listaUsuarios;
        this.sc = sc;
    }

    // Genericos
    private void mostrarOpciones() {
        System.out.println("---------------------------------------------");
        System.out.println("BIENVENIDO AL SISTEMA DE ALTA DE USUARIO");
        System.out.println(" 1 - LOGIN");
        System.out.println(" 2 - REGISTRO");
        System.out.print("Por favor, elija una de las siguientes opciones: ");
        System.out.println("---------------------------------------------");
    }

    private void mostrarOpcionRoles() {
        System.out.println("---------------------------------------------");
        System.out.println(" 1 - CLIENTE");
        System.out.println(" 2 - EMPLEADO");
        System.out.print("Por favor, elija uno de los roles: ");
        System.out.println("---------------------------------------------");
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

    private String asignarRol() {

        boolean seguir = true;

        String rolAsignado = "";

        while (seguir) {
            this.mostrarOpcionRoles();
            int opcion = this.sc.nextInt();

            if (opcion == 1) {
                rolAsignado = "CLIENTE";
                seguir = false;
            } else if (opcion == 2) {
                rolAsignado = "EMPLEADO";
                seguir = false;
            } else {
                System.out.println("Opcion invalida. Por favor, ingrese una opcion valida");
            }
        }

        return rolAsignado;
    }

    private void realizarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                this.loginUsuario();
                break;
            case 2:
                this.registroUsuario();
                break;
            default:
                System.out.println("----------------------------------------------");
                System.out.println("OPCION INCORRECTA, INGRESE UNA OPCION VALIDA");
                System.out.println("----------------------------------------------");
                break;
        }
    }

    // Metodos del menu
    private void registroUsuario() {
        System.out.println("--------------------- REGISTRO ---------------------");

        // Ingrso el nombre del usuario
        System.out.print("Nombre de usuario: ");
        String nombreIngresado = this.sc.next();

        // Verifico si el usuario ya existe
        boolean existeUsuario = this.validarExistenciaUsuario(nombreIngresado);

        // Si el nombre del usuario existe lanzo un mensaje de error
        if (existeUsuario) {
            System.out.println("El usuario ya existe. Por favor, elija otro nombre de usuario.");
            return;
        }

        // Caso contrario procedo a seguir con el registro 

        // Ingreso la clave
        System.out.print("Contraseña: ");
        String claveIngresada = this.sc.next();

        // Reingreso la clave
        System.out.print("Ingrese la contraseña nuevamente: ");
        String confirmarClave = this.sc.nextLine();

        // Valido si ambas claves ingresadas son iguales
        boolean sonIguales = this.validarClaves(claveIngresada, confirmarClave);

        // Si las contraseñas ingresadas no coinciden lanzo un mensaje de rror
        if (!sonIguales) {
            System.out.println("Las contraseñas no coinciden. Intente nuevamente.");
            return;
        }

        // Caso contrario procedo a seguir con el registro 

        // Le asigno un rol al usuario
        String rolIngresado = this.asignarRol().toLowerCase();

        // Si el rol que le asigne al usuario es EMPLEADO solicito la clave adicional
        if (rolIngresado.equals("empleado")) {
            System.out.print("Ingrese la clave de empleado: ");
            String claveEmpleado = this.sc.next();

            if (!claveEmpleado.equals("pepepiola123")) {
                System.out.println("Clave de empleado incorrecta. Registro fallido.");
                return;
            }
        }

        // Creo el nuevo usuario
        Usuario nuevoUsuario = new Usuario(nombreIngresado, claveIngresada, rolIngresado);

        // Almaceno el nuevo usuario en la lista
        listaUsuarios.add(nuevoUsuario);

        System.out.println("Registro exitoso. ¡Bienvenido!");

    }

    private void loginUsuario() {
        System.out.println("--------------------- LOGIN ---------------------");

        // Ingreso el nombre de Usuario
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = this.sc.next();

        // Valido que exista dicho usuario
        boolean existeUsuario = this.validarExistenciaUsuario(nombreUsuario);

        // Si el usuario no existe lanzo un mensaje de error
        if (!existeUsuario) {
            System.out.println("El usuario no existe. Por favor, registrese o vuelve a intentarlo");
            return;
        }

        // Caso contrario procedo a seguir con el logue
        System.out.print("Contraseña: ");
        String claveUsuario  = this.sc.next();

        // Verifico que la contraseña sea correcta
        boolean validarClave = this.validarClave(claveUsuario);

        if (validarClave) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
        } else {
            System.out.println("Contraseña incorrecta. Inicio de sesión fallido.");
        }

    }

    // Verifiar si el usuario existe
    private boolean validarExistenciaUsuario(String nombreUsuario) {

        // Parto con una premisa booleana
        boolean existeUsuario = false;

        // Recorro la lista de Usuarios 
        for (Usuario usuario : listaUsuarios) {

            // Si el nombre dle usuario de turno es igual al nombre del usuario que ingresamos entonces el valor de mi premisa sera TRUE
            if (nombreUsuario.equals(usuario.getNombreUsuario())) {
                existeUsuario = true;
                break;
            }
        }

        // Devuelvo el valor final de la premisa
        return existeUsuario;
    }

    // Validar igualdad de la contraseña reingresada
    private boolean validarClaves(String clave, String claveReingresada) {

        // Parto con una premisa booleana
        boolean sonIguales = false;

        // Comparo las dos claves que recibi por parámetro
        if (clave.equals(claveReingresada)) {

            // Si son iguales entonces el valor de mi premisa será TURE
            sonIguales = true;
        }
        
        // Devuelvo el valor final de la premisa
        return sonIguales;
    }

    // Validar la contraseña 
     private boolean validarClave(String claveIngresada) {

        // Parto con una premisa booleana
        boolean sonIguales = false;

        // Recorro la lista de Usuarios
        for (Usuario usuario : listaUsuarios) {

            // Verifico que la clave del usuario de turno es igual a la clave ingresada por parámetro
            if (usuario.getClaveUsuario().equals(claveIngresada)) {

                // Si son iguales entonces el valor de mi premisa será TURE
                sonIguales = true;
                break;
            }
        }

        // Devuelvo el valor final de la premisa
        return sonIguales;
    }

}
