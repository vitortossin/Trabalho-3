package controller;

import model.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoController {

    private final List<Medico> medicos;

    public MedicoController() {
        this.medicos = new ArrayList<>();
    }

    public boolean cadastrarMedico(String nome, String especialidade, String crm, String email, String telefone) {
        Medico medico = new Medico(nome, especialidade, crm, email, telefone);
        medicos.add(medico);
        System.out.println("Médico " + nome + " cadastrado com sucesso.");
        return false;
    }

    public List<Medico> listarMedicos() {
        return medicos;
    }

    public Medico buscarMedicoPorCRM(String crm) {
        for (Medico medico : medicos) {
            if (medico.getCrm().equals(crm)) {
                return medico;
            }
        }
        return null;
    }

    public boolean alterarDadosMedico(String crm, String nome, String especialidade, String email, String telefone) {
        Medico medico = buscarMedicoPorCRM(crm);
        if (medico != null) {
            medico.setNome(nome);
            medico.setEspecialidade(especialidade);
            medico.setEmail(email);
            medico.setTelefone(telefone);
            System.out.println("Dados do médico alterados com sucesso.");
        } else {
            System.out.println("Médico não encontrado.");
        }
        return false;
    }
}
