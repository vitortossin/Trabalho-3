package model;

public class Consultas {
    private String dataHora;
    private String medico; // Nome ou referência ao médico
    private String paciente; // Nome ou referência ao paciente
    private String diagnostico;
    private String prescricao;

    // Construtor
    public Consultas(String dataHora, String medico, String paciente) {
        this.dataHora = dataHora;
        this.medico = medico;
        this.paciente = paciente;
    }

    // Getters e Setters
    public String getDataHora() { return dataHora; }
    public void setDataHora(String dataHora) { this.dataHora = dataHora; }

    public String getMedico() { return medico; }
    public void setMedico(String medico) { this.medico = medico; }

    public String getPaciente() { return paciente; }
    public void setPaciente(String paciente) { this.paciente = paciente; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getPrescricao() { return prescricao; }
    public void setPrescricao(String prescricao) { this.prescricao = prescricao; }
}

