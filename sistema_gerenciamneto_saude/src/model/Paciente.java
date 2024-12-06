package model;

import java.util.List;

public class Paciente {
    private String nome;
    private final String cpf;
    private String dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    private List<String> historicoDoencas;
    private List<String> medicamentos;

    public Paciente(String nome, String cpf, String dataNascimento, String endereco, String telefone, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHistoricoDoencas(List<String> historicoDoencas) {
        this.historicoDoencas = historicoDoencas;
    }

    public List<String> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<String> medicamentos) {
        this.medicamentos = medicamentos;
    }
}
