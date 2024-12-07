package model;

public class Medicacao {
    private String nome;
    private String dosagem;
    private String frequencia;
    private String descricao;
    private String medico; // Nome ou referência ao médico
    private String dataPrescricao;

    // Construtor
    public Medicacao(String nome, String dosagem, String frequencia, String descricao, String medico, String dataPrescricao) {
        this.nome = nome;
        this.dosagem = dosagem;
        this.frequencia = frequencia;
        this.descricao = descricao;
        this.medico = medico;
        this.dataPrescricao = dataPrescricao;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDosagem() { return dosagem; }
    public void setDosagem(String dosagem) { this.dosagem = dosagem; }

    public String getFrequencia() { return frequencia; }
    public void setFrequencia(String frequencia) { this.frequencia = frequencia; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getMedico() { return medico; }
    public void setMedico(String medico) { this.medico = medico; }

    public String getDataPrescricao() { return dataPrescricao; }
    public void setDataPrescricao(String dataPrescricao) { this.dataPrescricao = dataPrescricao; }
}

