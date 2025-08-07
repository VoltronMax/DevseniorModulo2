package model;

public abstract class Usuario {
    protected String name;
    protected Long id;
    protected String username;
    protected String password;
    protected Rol rol;
    protected HistorialAccion[] historial;
    protected int accionesRegistradas;
    
    public Usuario(String name, Long id, String username, String password, Rol rol){
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
        historial = new HistorialAccion[100];
        accionesRegistradas = 0;
    }

    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    public void setAction(String description){
        if (accionesRegistradas<historial.length){
            historial[accionesRegistradas++] = new HistorialAccion(description);
        }
    }

    public void showHistorial(){
        for (int i = 0; i < accionesRegistradas; i++) {
            System.out.println(historial[i]);
        }
    }

    //Getters

    public Rol getRol(){
        return rol;
    }

    public String getName(){
        return name;
    }

    public Long getId(){
        return id;
    }

    public String getUsername(){
        return username;
    }

    //Setters

    public void setName(String name){
        this.name = name;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public boolean updatePassword(String actual, String nueva){
        if(this.password.equals(actual) && !this.password.equals(nueva)){
            this.password = nueva;
            return true;
        }
        return false;
    }
}
