package model;

public class HistorialAccion {

    /**
     * Clase que crea un objeto de tipo accion que contiene una descripcion de la accion
     * realizaada y el tiempo exacto en que fue solicitado el servicio
     */

    //Atributos
    private String description;
    private Long time;
    
    /**
     * Constructor de acciones individuales
     * @param description Breve descripcion de la accion realizada
     */
    public HistorialAccion(String description){
        this.description = description;
        this.time = System.currentTimeMillis();
    }

    /**
     * Metodo. Devuelve la accion registrada
     * @return Accion registrada
     */
    public String getDescription() {
        return description;
    }

    /**
     *Metodo. Devuelve el tiempo exacto en que se registro la accion
     * @return Devuelve el tiempo exacto del servicio usado
     */
    public Long getTime() {
        return time;
    }

    /**
     * Metodo. Devuelve en formato la descripcion y tiempo del servicio realizado
     */
    public String toString(){
        return "[" + time + "]" + description;
    }

}
