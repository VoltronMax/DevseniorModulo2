package model;

/**
 * Superclase abstracta, define un objeto de tipo Usuario que contiene un nombre, id, username, contraseña,
 * rol, un arreglo con objetos de tipo HistorialAccion, y numero de acciones registradas
 */
public abstract class Usuario {
    protected String name;
    protected Long id;
    protected String username;
    protected String password;
    protected Rol rol;
    protected HistorialAccion[] historial;
    protected int accionesRegistradas;
    
    /**
     *Constructor para objetos por herencia de tipo Usuario
     * @param name Nombre del usuario
     * @param id Id del usuario
     * @param username Apodo del usuario
     * @param password Contraseña del usuario
     * @param rol Rol del usuario
     */

    public Usuario(String name, Long id, String username, String password, Rol rol){
        this.name = name;
        this.id = id;
        this.username = username;
        this.password = password;
        this.rol = rol;
        historial = new HistorialAccion[100];
        accionesRegistradas = 0;
    }

    /**
     * Metodo booleano que recibe por parametro una contraseña
     * @param password contraseña previa a verificacion
     * @return True: si la contraseña coincide con el objeto.
     * False: Si no coincide con el objeto.
     */
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

    /**
     * Metodo encargado de llenar la lista de acciones por usuario
     * Si la cantidad de acciones registradas es menor al limite del
     * arreglo de objetos Historial, estas son agregadas con su respectiva
     * descripcion y tiempo. Por cada accion agregada, se suma unitariamente
     * la variable de accionesRegistradas, y a su vez, la ubicacion del arreglo
     * donde sera agregado el objeto Historial ira aumentando.
    
     */
    public void setAction(String description){
        if (accionesRegistradas<historial.length){
            historial[accionesRegistradas++] = new HistorialAccion(description);
        }
    }

    /**
     * Metodo encargado de mostrar el arreglo de objetos Historial.
     * Enseña los historiales hasta el limite que tenga el dato de
     * AccionesRegistradas
     */
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
