package controller;

import model.Paciente;
import java.util.ArrayList;
import java.util.List;

public class PacienteController {
    private final List<Paciente> pacientes;

    public PacienteController() {
        this.pacientes = new ArrayList<>();
    }

    public void cadastrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        System.out.println("Paciente cadastrado com sucesso: " + paciente.getNome());
    }

    public Paciente consultarPaciente(String cpf) {
        return pacientes.stream()
                .filter(p -> p.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public void atualizarDadosPaciente(String cpf, Paciente novosDados) {
        Paciente paciente = consultarPaciente(cpf);
        if (paciente != null) {
            paciente.setNome(novosDados.getNome());
            paciente.setDataNascimento(novosDados.getDataNascimento());
            paciente.setEndereco(novosDados.getEndereco());
            paciente.setTelefone(novosDados.getTelefone());
            paciente.setEmail(novosDados.getEmail());
            System.out.println("Dados do paciente atualizados com sucesso.");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
