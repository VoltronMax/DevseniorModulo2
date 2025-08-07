package model;

public class HistorialAccion {

    private String description;
    private Long time;
    
    public HistorialAccion(String description){
        this.description = description;
        this.time = System.currentTimeMillis();
    }

    public String getDescription() {
        return description;
    }

    public Long getTime() {
        return time;
    }

    public String toString(){
        return "[" + time + "]" + description;
    }

}
