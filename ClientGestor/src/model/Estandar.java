package model;

public class Estandar extends Usuario {

    public Estandar(String name, Long id, String username, String password, Rol rol) {
        super(name, id, username, password, Rol.ESTANDAR);
    }
}
