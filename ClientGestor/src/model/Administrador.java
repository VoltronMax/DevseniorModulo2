package model;

public class Administrador extends Usuario{

    public Administrador(String name, Long id, String username, String password) {
        super(name, id, username, password, Rol.ADMINISTRADOR);
        
    }
    
}
