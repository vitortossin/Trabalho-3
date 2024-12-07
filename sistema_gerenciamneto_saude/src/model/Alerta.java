package model;

public class Alerta {
    private String tipo;
    private String mensagem;
    private String paciente;
    private String medico;
    private String dataAlerta;

    // Construtor
    public Alerta(String tipo, String mensagem, String paciente, String medico, String dataAlerta) {
        this.tipo = tipo;
        this.mensagem = mensagem;
        this.paciente = paciente;
        this.medico = medico;
        this.dataAlerta = dataAlerta;
    }

    // Getters e Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getMensagem() { return mensagem; }
    public void setMensagem(String mensagem) { this.mensagem = mensagem; }

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public String getMedico() { return medico; }
    public void setMedico(String medico) { this.medico = medico; }

    public String getDataAlerta() { return dataAlerta; }
    public void setDataAlerta(String dataAlerta) { this.dataAlerta = dataAlerta; }
}

