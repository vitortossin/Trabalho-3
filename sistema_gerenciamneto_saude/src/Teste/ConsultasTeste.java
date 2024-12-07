package Teste;

import org.junit.jupiter.api.Test;
import  model.Consultas;
import static junit.framework.TestCase.assertEquals;

public class ConsultasTeste {

    @Test
    public void testCriacaoConsulta() {
        Consultas consulta = new Consultas("2024-12-10 14:00", "Dr. João", "Maria");

        assertEquals("2024-12-10 14:00", consulta.getDataHora());
        assertEquals("Dr. João", consulta.getMedico());
        assertEquals("Maria", consulta.getPaciente());
    }

    @Test
    public void testAtualizacaoDiagnosticoPrescricao() {
        Consultas consulta = new Consultas("2024-12-10 14:00", "Dr. João", "Maria");

        consulta.setDiagnostico("Hipertensão");
        consulta.setPrescricao("Medicamento A - 2x ao dia");

        assertEquals("Hipertensão", consulta.getDiagnostico());
        assertEquals("Medicamento A - 2x ao dia", consulta.getPrescricao());
    }
}

