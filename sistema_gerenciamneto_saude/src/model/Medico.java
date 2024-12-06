package model;

public class Medico {
    private String nome;
    private String especialidade;
    private final String crm;
    private String email;
    private String telefone;

    public Medico(String nome, String especialidade, String crm, String email, String telefone) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.crm = crm;
        this.email = email;
        this.telefone = telefone;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCrm() {
        return crm;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Médico: " + nome + ", Especialidade: " + especialidade + ", CRM: " + crm;
    }
}
