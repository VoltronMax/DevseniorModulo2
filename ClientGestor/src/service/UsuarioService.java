package service;
import model.*;

public class UsuarioService {

    private Usuario[] usuarios;
    private int totalUsuarios;

    public UsuarioService(){
        usuarios = new Usuario[50];
        totalUsuarios = 0;
    }
    
    public boolean crearUsuario(Usuario user, Usuario autor){
        if(autor.getRol()!=Rol.ADMINISTRADOR)
        return false;
        
        for (Usuario u : usuarios) {
            if (u != null && (u.getUsername().equals(user.getUsername()) || u.getId().equals(user.getId()))){
                return false;
            }
        }
        if (totalUsuarios <usuarios.length){
            usuarios[totalUsuarios++] = user;
            autor.setAction("Creo usuario: " + user.getUsername());
            return true;
        }
        return true;
    }

    public Usuario buscarPorUsername(String username){
        for (Usuario u : usuarios) {
            if (u != null && u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public Usuario Login (String username, String password){
        var u = buscarPorUsername(username);
        if (u != null && u.checkPassword(password)){
            u.setAction("Inicio de sesion");
            return u;
        }
        return null;
    }

    public boolean eliminarUsuario(String username, Usuario autor){
        if (!autor.getRol().equals(Rol.ADMINISTRADOR)) {
            return false;
        }

        for (int i = 0; i < totalUsuarios; i++) {
            if (usuarios[i] != null && usuarios[i].getUsername().equals(username)) {
                autor.setAction("Elimino usuario: " + username);
                usuarios[i] = usuarios[--totalUsuarios];
                usuarios[totalUsuarios] = null;
                return true;
            }
        }
        return false;
            
        }

        public boolean actualizarPerfil(Usuario solicitante, String nuevoNombre, String passActual, String passNueva){
            if(nuevoNombre!= null && !nuevoNombre.isEmpty()){
                solicitante.setName(nuevoNombre);
            }

            var passCambio = solicitante.updatePassword(passActual, passNueva);
            solicitante.setAction("Actualizo perfil");
            return passCambio;
        }
    }

