import controller.PacienteController;
import controller.MedicoController;
import view.*;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    menu();





    }
    public static void menu() {
        PacienteController pacienteController = new PacienteController();
        MedicoController medicoController = new MedicoController();
        PacienteView pacienteView = new PacienteView(pacienteController);
        MenuMedicacao MenuMedicacao = new MenuMedicacao();
        MenuAlertas menuAlertas = new MenuAlertas();
        MedicoView medicoView = new MedicoView(medicoController);
        MenuConsultas menuConsultas = new MenuConsultas();
        while (true) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Cadastrar Paciente");
            System.out.println("3. Menu Medicacao");
            System.out.println("4. Menu Consultas");
            System.out.println("5. Menu Alertas");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (escolha) {
                case 1 -> medicoView.menu();
                case 2 -> pacienteView.menu();
                case 3 -> MenuMedicacao.exibirMenu();
                case 4 -> menuAlertas.exibirMenu();
                case 5 -> menuConsultas.exibirMenu();
                case 6 -> {

                        System.out.println("Saindo do sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
