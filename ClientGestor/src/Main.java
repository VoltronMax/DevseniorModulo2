import controller.SistemaController;
import model.Administrador;
import model.*;
import view.ConsolaView;

public class Main {

    public static void main(String[] args) {
        SistemaController controlador = new SistemaController();

        Usuario admin = new Administrador("Andres Colmenares", 1L, "AndresSeñor", "Soyunadmindevseñor");
        controlador.createUserWithoutVerification(admin);

        ConsolaView vista = new ConsolaView(controlador);
        vista.iniciar();
    }
    
}
