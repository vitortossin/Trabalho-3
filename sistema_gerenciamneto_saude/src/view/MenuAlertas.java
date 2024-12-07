package view;
import model.Alerta;
import model.Alerta;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuAlertas {

    private ArrayList<Alerta> alertas = new ArrayList<>();

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu de Alertas ===");
            System.out.println("1. Gerar Alerta");
            System.out.println("2. Consultar Alertas");
            System.out.println("3. Encerrar Alerta");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    gerarAlerta(scanner);
                    break;
                case 2:
                    consultarAlertas();
                    break;
                case 3:
                    encerrarAlerta(scanner);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void gerarAlerta(Scanner scanner) {
        System.out.print("Tipo do alerta (Emergência/Anormalidade): ");
        String tipo = scanner.nextLine();
        System.out.print("Mensagem: ");
        String mensagem = scanner.nextLine();
        System.out.print("Nome do paciente: ");
        String paciente = scanner.nextLine();
        System.out.print("Nome do médico: ");
        String medico = scanner.nextLine();
        System.out.print("Data do alerta: ");
        String dataAlerta = scanner.nextLine();

        alertas.add(new Alerta(tipo, mensagem, paciente, medico, dataAlerta));
        System.out.println("Alerta gerado com sucesso!");
    }

    private void consultarAlertas() {
        if (alertas.isEmpty()) {
            System.out.println("Nenhum alerta gerado.");
        } else {
            System.out.println("\n=== Lista de Alertas ===");
            for (Alerta alerta : alertas) {
                System.out.println("Tipo: " + alerta.getTipo());
                System.out.println("Mensagem: " + alerta.getMensagem());
                System.out.println("Paciente: " + alerta.getPaciente());
                System.out.println("Médico: " + alerta.getMedico());
                System.out.println("Data: " + alerta.getDataAlerta());
                System.out.println("------------------------");
            }
        }
    }

    private void encerrarAlerta(Scanner scanner) {
        System.out.print("Digite o tipo do alerta para encerrar: ");
        String tipo = scanner.nextLine();
        boolean removido = alertas.removeIf(alerta -> alerta.getTipo().equalsIgnoreCase(tipo));
        if (removido) {
            System.out.println("Alerta(s) do tipo \"" + tipo + "\" encerrado(s).");
        } else {
            System.out.println("Nenhum alerta do tipo \"" + tipo + "\" encontrado.");
        }
    }
}

