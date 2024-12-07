package Teste;
import model.Medicacao;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MedicacaoTest {

    @Test
    public void testCriacaoMedicacao() {
        Medicacao medicacao = new Medicacao("Paracetamol", "500mg", "8h", "Analgésico", "Dr. João", "2024-12-05");

        assertEquals("Paracetamol", medicacao.getNome());
        assertEquals("500mg", medicacao.getDosagem());
        assertEquals("8h", medicacao.getFrequencia());
        assertEquals("Analgésico", medicacao.getDescricao());
        assertEquals("Dr. João", medicacao.getMedico());
        assertEquals("2024-12-05", medicacao.getDataPrescricao());
    }

    @Test
    public void testAtualizacaoDosagemFrequencia() {
        Medicacao medicacao = new Medicacao("Paracetamol", "500mg", "8h", "Analgésico", "Dr. João", "2024-12-05");

        medicacao.setDosagem("750mg");
        medicacao.setFrequencia("6h");

        assertEquals("750mg", medicacao.getDosagem());
        assertEquals("6h", medicacao.getFrequencia());
    }
}

