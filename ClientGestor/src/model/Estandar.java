package model;

public class Estandar extends Usuario {

    public Estandar(String name, Long id, String username, String password) {
        super(name, id, username, password, Rol.ESTANDAR);
    }
}
