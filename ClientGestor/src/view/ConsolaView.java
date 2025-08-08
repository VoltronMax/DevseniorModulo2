package view;

import java.util.Scanner;
import controller.SistemaController;
import model.Usuario;
import model.Rol;

public class ConsolaView {

    private Scanner sc = new Scanner(System.in);
    private SistemaController controlador = new SistemaController();

    public ConsolaView (SistemaController controlador){
        this.controlador = controlador;
    }

    public boolean mostrarMenu(Usuario u){
        while (true){
            System.out.printf("\nBienvenido: %s, Con rol de: %s", u.getName(), u.getRol());
            System.out.println("\n.:Opciones:.\n");
            System.out.println("""
                1. Actualizar perfil
                2. Ver historial de acciones
                    """);
                    if (u.getRol() == Rol.ADMINISTRADOR) {
                        System.out.println("""
                                3. Crear usuario
                                4. Eliminar usuario
                                """);
                    }
                System.out.println("0. Cerrar sesion");

                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                    System.out.println("\n.:Actualizacion de usuario:.\n");
                    System.out.println("Ingrese su nuevo nombre");
                    String newName = sc.nextLine();
                    System.out.println("Confirme su contraseña actual para continuar");
                    String password = sc.nextLine();
                    System.out.println("Ingrese la nueva contraseña");
                    String newPassword = sc.nextLine();
                    boolean actualizar = controlador.actualizarPerfil(u, newName, password, newPassword);
                    System.out.println(actualizar ? "Perfil actualizado con exito" : "Contraseña incorrecta");
                    break;

                    case 2:
                    controlador.mostrarHistorial(u);
                    break;

                    case 3:
                    if(u.getRol() == Rol.ADMINISTRADOR){
                    System.out.println("\n.:Creacion de usuario:.\n");
                    System.out.println("Ingrese su nombre");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese un id");
                    Long id = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Ingrese un apodo");
                    String username = sc.nextLine();
                    System.out.println("Contraseña:");
                    String pw = sc.nextLine();
                    System.out.println("Roles: Administrador/Estandar");
                    Rol rol = Rol.valueOf(sc.next().toUpperCase());

                    boolean creado = controlador.crearUsuario(nombre, id, username, pw, rol, u);
                    System.out.println(creado ? "Usuario creado exitosamente" : "Error al crear usuario");
                    break;
                    }

                    case 4:
                    if(u.getRol()==Rol.ADMINISTRADOR){
                        System.out.println("Ingrese el usuario a eliminar");
                        String user = sc.nextLine();
                        boolean eliminado = controlador.eliminarUsuario(user, u);
                        System.out.println(eliminado ? "Usuario encontrado y eliminado con exito" : "Error a la hora de eliminar usuario");
                        break;
                    }

                    case 0:
                    System.out.println("Cerrando sesion");
                    controlador.logout();
                    break;

                    default:
                    System.out.println("Opcion no valida");
                        break;
                }
        }
        

    }



}