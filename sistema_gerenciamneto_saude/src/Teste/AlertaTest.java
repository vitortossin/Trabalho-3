package Teste;
import model.Alerta;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlertaTest {

    @Test
    public void testCriacaoAlerta() {
        Alerta alerta = new Alerta("Emergência", "Pressão arterial muito alta", "Maria", "Dr. João", "2024-12-07");

        assertEquals("Emergência", alerta.getTipo());
        assertEquals("Pressão arterial muito alta", alerta.getMensagem());
        assertEquals("Maria", alerta.getPaciente());
        assertEquals("Dr. João", alerta.getMedico());
        assertEquals("2024-12-07", alerta.getDataAlerta());
    }

    @Test
    public void testAtualizacaoMensagem() {
        Alerta alerta = new Alerta("Emergência", "Pressão arterial muito alta", "Maria", "Dr. João", "2024-12-07");

        alerta.setMensagem("Paciente estabilizado");

        assertEquals("Paciente estabilizado", alerta.getMensagem());
    }
}

