package controller;

import model.*;
import service.UsuarioService;

public class SistemaController {

    private UsuarioService servicio;

    public SistemaController(){
        this.servicio = new UsuarioService();
    }

        public Usuario login (String username, String password){
            return servicio.Login(username, password);
        }

        public boolean crearUsuario(String nombre, Long id, String username, Rol rol, Usuario autor){
            Usuario nuevo = rol == rol.ADMINISTRADOR ? new Administrador(username, id, username, username, rol) : new Estandar(username, id, username, username, rol);
            return servicio.crearUsuario(nuevo, autor);
        }

        public boolean eliminarUsuario(String username, Usuario autor){
            return servicio.eliminarUsuario(username, autor);
        }

        public boolean actualizarPerfil(Usuario usuario, String nuevoNombre, String viejaContraseña, String nuevaContraseña){
            return servicio.actualizarPerfil(usuario, nuevoNombre, viejaContraseña, nuevaContraseña);
        }

        public void mostrarHistorial(Usuario usuario){
            usuario.showHistorial();
        }
    }

    
