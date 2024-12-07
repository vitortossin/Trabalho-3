package view;
import model.Medicacao;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuMedicacao {

    private ArrayList<Medicacao> medicacoes = new ArrayList<>();

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Menu de Medicações ===");
            System.out.println("1. Prescrever Medicamento");
            System.out.println("2. Consultar Medicamentos");
            System.out.println("3. Ajustar Dosagem ou Frequência");
            System.out.println("4. Cancelar Prescrição");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    prescreverMedicamento(scanner);
                    break;
                case 2:
                    consultarMedicacoes();
                    break;
                case 3:
                    ajustarMedicacao(scanner);
                    break;
                case 4:
                    cancelarPrescricao(scanner);
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void prescreverMedicamento(Scanner scanner) {
        System.out.print("Nome do medicamento: ");
        String nome = scanner.nextLine();
        System.out.print("Dosagem: ");
        String dosagem = scanner.nextLine();
        System.out.print("Frequência: ");
        String frequencia = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Nome do médico: ");
        String medico = scanner.nextLine();
        System.out.print("Data de prescrição: ");
        String dataPrescricao = scanner.nextLine();

        medicacoes.add(new Medicacao(nome, dosagem, frequencia, descricao, medico, dataPrescricao));
        System.out.println("Medicamento prescrito com sucesso!");
    }

    private void consultarMedicacoes() {
        if (medicacoes.isEmpty()) {
            System.out.println("Nenhum medicamento prescrito.");
        } else {
            System.out.println("\n=== Lista de Medicamentos ===");
            for (Medicacao medicacao : medicacoes) {
                System.out.println("Nome: " + medicacao.getNome());
                System.out.println("Dosagem: " + medicacao.getDosagem());
                System.out.println("Frequência: " + medicacao.getFrequencia());
                System.out.println("Descrição: " + medicacao.getDescricao());
                System.out.println("Médico: " + medicacao.getMedico());
                System.out.println("Data: " + medicacao.getDataPrescricao());
                System.out.println("-----------------------------");
            }
        }
    }

    private void ajustarMedicacao(Scanner scanner) {
        System.out.print("Digite o nome do medicamento para ajustar: ");
        String nome = scanner.nextLine();
        for (Medicacao medicacao : medicacoes) {
            if (medicacao.getNome().equalsIgnoreCase(nome)) {
                System.out.print("Nova dosagem: ");
                medicacao.setDosagem(scanner.nextLine());
                System.out.print("Nova frequência: ");
                medicacao.setFrequencia(scanner.nextLine());
                System.out.println("Medicação ajustada com sucesso!");
                return;
            }
        }
        System.out.println("Medicamento não encontrado.");
    }

    private void cancelarPrescricao(Scanner scanner) {
        System.out.print("Digite o nome do medicamento para cancelar: ");
        String nome = scanner.nextLine();
        boolean removido = medicacoes.removeIf(medicacao -> medicacao.getNome().equalsIgnoreCase(nome));
        if (removido) {
            System.out.println("Prescrição do medicamento \"" + nome + "\" cancelada.");
        } else {
            System.out.println("Medicamento \"" + nome + "\" não encontrado.");
        }
    }
}


