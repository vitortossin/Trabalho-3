import controller.PacienteController;
import controller.MedicoController;
import view.PacienteView;
import view.MedicoView;

public class Main {
    public static void main(String[] args) {
        PacienteController pacienteController = new PacienteController();
        MedicoController medicoController = new MedicoController();

        PacienteView pacienteView = new PacienteView(pacienteController);
        MedicoView medicoView = new MedicoView(medicoController);

        pacienteView.menu();
        medicoView.menu();
    }
}
