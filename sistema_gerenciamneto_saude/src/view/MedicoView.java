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
            System.out.println("Menu Médico:");
            System.out.println("1. Cadastrar Médico");
            System.out.println("2. Listar Médicos");
            System.out.println("3. Buscar Médico por CRM");
            System.out.println("4. Alterar Dados do Médico");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (escolha) {
                case 1:
                    cadastrarMedico();
                    break;
                case 2:
                    listarMedicos();
                    break;
                case 3:
                    buscarMedicoPorCRM();
                    break;
                case 4:
                    alterarDadosMedico();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void cadastrarMedico() {
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

        medicoController.cadastrarMedico(nome, especialidade, crm, email, telefone);
    }

    private void listarMedicos() {
        List<Medico> medicos = medicoController.listarMedicos();
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            for (Medico medico : medicos) {
                System.out.println(medico);
            }
        }
    }

    private void buscarMedicoPorCRM() {
        System.out.print("Informe o CRM do médico: ");
        String crm = scanner.nextLine();
        Medico medico = medicoController.buscarMedicoPorCRM(crm);
        if (medico != null) {
            System.out.println(medico);
        } else {
            System.out.println("Médico não encontrado.");
        }
    }

    private void alterarDadosMedico() {
        System.out.print("Informe o CRM do médico a ser alterado: ");
        String crm = scanner.nextLine();
        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Especialidade: ");
        String especialidade = scanner.nextLine();
        System.out.print("Novo Email: ");
        String email = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();

        medicoController.alterarDadosMedico(crm, nome, especialidade, email, telefone);
    }
}
