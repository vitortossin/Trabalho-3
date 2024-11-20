package view;

import controller.PacienteController;
import model.Paciente;

import java.util.Scanner;

public class PacienteView {
    private Scanner scanner;
    private PacienteController controller;

    public PacienteView(PacienteController controller) {
        this.scanner = new Scanner(System.in);
        this.controller = controller;
    }

    public void menu() {
        int opcao;
        do {
            System.out.println("1. Cadastrar Paciente");
            System.out.println("2. Consultar Paciente");
            System.out.println("3. Atualizar Paciente");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> cadastrarPaciente();
                case 2 -> consultarPaciente();
                case 3 -> atualizarPaciente();
                case 4 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida!");
            }
        } while (opcao != 4);
    }

    private void cadastrarPaciente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        Paciente paciente = new Paciente(nome, cpf, dataNascimento, endereco, telefone, email);
        controller.cadastrarPaciente(paciente);
    }

    private void consultarPaciente() {
        System.out.print("CPF do paciente: ");
        String cpf = scanner.nextLine();
        Paciente paciente = controller.consultarPaciente(cpf);
        if (paciente != null) {
            System.out.println("Paciente encontrado: " + paciente.getNome());
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    private void atualizarPaciente() {
        System.out.print("CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("Novo Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Nova Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Novo Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Novo Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Novo E-mail: ");
        String email = scanner.nextLine();

        Paciente novosDados = new Paciente(nome, cpf, dataNascimento, endereco, telefone, email);
        controller.atualizarDadosPaciente(cpf, novosDados);
    }
}
