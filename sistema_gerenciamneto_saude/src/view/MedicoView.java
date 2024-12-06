package view;

import controller.MedicoController;
import model.Medico;

import java.util.List;
import java.util.Scanner;

public class MedicoView {

    private MedicoController medicoController;
    private Scanner scanner;

    public MedicoView(MedicoController medicoController) {
        this.medicoController = medicoController;
        this.scanner = new Scanner(System.in);
    }

    public void menu() {
        while (true) {
            System.out.println("\n=== Menu Médico ===");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Listar Médicos");
            System.out.println("3. Buscar Médico por CRM");
            System.out.println("4. Alterar Dados do Médico");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (escolha) {
                case 1 -> cadastrarMedico();
                case 2 -> listarMedicos();
                case 3 -> buscarMedicoPorCRM();
                case 4 -> alterarDadosMedico();
                case 5 -> {
                    System.out.println("Saindo do sistema...");
                    return;
                }
                default -> System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private void cadastrarMedico() {
        System.out.println("\n=== Cadastrar Médico ===");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("CRM: ");
        String crm = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        boolean sucesso = medicoController.cadastrarMedico(nome, especialidade, crm, email, telefone);
        if (sucesso) {
            System.out.println("Médico cadastrado com sucesso.");
        } else {
            System.out.println("Erro ao cadastrar médico. Verifique os dados e tente novamente.");
        }
    }

    private void listarMedicos() {
        System.out.println("\n=== Listar Médicos ===");
        List<Medico> medicos = medicoController.listarMedicos();
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            medicos.forEach(System.out::println);
        }
    }

    private void buscarMedicoPorCRM() {
        System.out.println("\n=== Buscar Médico por CRM ===");
        System.out.print("Informe o CRM do médico: ");
        String crm = scanner.nextLine();
        Medico medico = medicoController.buscarMedicoPorCRM(crm);
        if (medico != null) {
            System.out.println(medico);
        } else {
            System.out.println("Médico não encontrado com o CRM informado.");
        }
    }

    private void alterarDadosMedico() {
        System.out.println("\n=== Alterar Dados do Médico ===");
        System.out.print("Informe o CRM do médico a ser alterado: ");
        String crm = scanner.nextLine();
        Medico medico = medicoController.buscarMedicoPorCRM(crm);

        if (medico == null) {
            System.out.println("Médico não encontrado. Operação cancelada.");
            return;
        }

        System.out.println("Deixe o campo vazio para manter os dados atuais.");
        System.out.print("Novo Nome (Atual: " + medico.getNome() + "): ");
        String nome = scanner.nextLine();
        System.out.print("Nova Especialidade (Atual: " + medico.getEspecialidade() + "): ");
        String especialidade = scanner.nextLine();
        System.out.print("Novo Email (Atual: " + medico.getEmail() + "): ");
        String email = scanner.nextLine();
        System.out.print("Novo Telefone (Atual: " + medico.getTelefone() + "): ");
        String telefone = scanner.nextLine();

        boolean sucesso = medicoController.alterarDadosMedico(
                crm,
                nome.isEmpty() ? medico.getNome() : nome,
                especialidade.isEmpty() ? medico.getEspecialidade() : especialidade,
                email.isEmpty() ? medico.getEmail() : email,
                telefone.isEmpty() ? medico.getTelefone() : telefone
        );

        if (sucesso) {
            System.out.println("Dados do médico atualizados com sucesso.");
        } else {
            System.out.println("Erro ao atualizar os dados do médico.");
        }
    }
}

