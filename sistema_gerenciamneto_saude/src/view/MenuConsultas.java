package view;
import model.Consultas;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuConsultas {

    private ArrayList<Consultas> consultas = new ArrayList<>();

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu de Consultas ===");
            System.out.println("1. Agendar Consulta");
            System.out.println("2. Consultar Consultas");
            System.out.println("3. Atualizar Consulta");
            System.out.println("4. Cancelar Consulta");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    agendarConsulta(scanner);
                    break;
                case 2:
                    consultarConsultas();
                    break;
                case 3:
                    atualizarConsulta(scanner);
                    break;
                case 4:
                    cancelarConsulta(scanner);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void agendarConsulta(Scanner scanner) {
        System.out.print("Data e hora da consulta (ex: 2024-12-15 14:30): ");
        String dataHora = scanner.nextLine();
        System.out.print("Nome do médico: ");
        String medico = scanner.nextLine();
        System.out.print("Nome do paciente: ");
        String paciente = scanner.nextLine();
        System.out.print("Diagnóstico inicial (opcional): ");
        String diagnostico = scanner.nextLine();
        System.out.print("Prescrição inicial (opcional): ");
        String prescricao = scanner.nextLine();

        Consultas consulta = new Consultas(dataHora, medico, paciente);
        consulta.setDiagnostico(diagnostico);
        consulta.setPrescricao(prescricao);

        consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso!");
    }

    private void consultarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta agendada.");
        } else {
            System.out.println("\n=== Lista de Consultas ===");
            for (Consultas consulta : consultas) {
                System.out.println("Data e Hora: " + consulta.getDataHora());
                System.out.println("Médico: " + consulta.getMedico());
                System.out.println("Paciente: " + consulta.getPaciente());
                System.out.println("Diagnóstico: " + consulta.getDiagnostico());
                System.out.println("Prescrição: " + consulta.getPrescricao());
                System.out.println("----------------------------");
            }
        }
    }

    private void atualizarConsulta(Scanner scanner) {
        System.out.print("Digite a data e hora da consulta a ser atualizada: ");
        String dataHora = scanner.nextLine();

        for (Consultas consulta : consultas) {
            if (consulta.getDataHora().equals(dataHora)) {
                System.out.print("Novo diagnóstico (deixe vazio para não alterar): ");
                String novoDiagnostico = scanner.nextLine();
                if (!novoDiagnostico.isEmpty()) {
                    consulta.setDiagnostico(novoDiagnostico);
                }

                System.out.print("Nova prescrição (deixe vazio para não alterar): ");
                String novaPrescricao = scanner.nextLine();
                if (!novaPrescricao.isEmpty()) {
                    consulta.setPrescricao(novaPrescricao);
                }

                System.out.println("Consulta atualizada com sucesso!");
                return;
            }
        }
        System.out.println("Consulta não encontrada.");
    }

    private void cancelarConsulta(Scanner scanner) {
        System.out.print("Digite a data e hora da consulta a ser cancelada: ");
        String dataHora = scanner.nextLine();

        boolean removido = consultas.removeIf(consulta -> consulta.getDataHora().equals(dataHora));
        if (removido) {
            System.out.println("Consulta cancelada com sucesso!");
        } else {
            System.out.println("Consulta não encontrada.");
        }
    }
}
