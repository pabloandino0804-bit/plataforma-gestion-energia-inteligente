package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaException;
import ar.edu.unahur.obj2.energia.excepciones.ValorInvalidoException;

public class MainTest {

    // Parte 1
    @Test
    void dadoUnaBateria_alConsultarSuID_laBateriaDevuelveUnaIDTipoString() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);

        String IDBateria = bateria.getIDBateria();

        assertEquals("Bateria-1", IDBateria);
    }

    @Test
    void dadoUnaBateria_cuandoCarga2000_laBateriaAumentaSuskWhs() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);

        bateria.cargarEnergia(2000); // 2000 + 2400 = 4400

        assertEquals(4400, bateria.getNivelEnergiaActual());
    }

    @Test
    void dadoUnaBateria_cuandoConsume2000_laBateriaReduceSuskWhs() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);

        bateria.consumirEnergia(1350); // 2400 - 1350 = 400

        assertEquals(1050, bateria.getNivelEnergiaActual());
    }

    @Test
    void dadoUnaBateria_siIntentaInstanciarUnaOperacionConUnValorInvalido_lanzaraUnaExcepcion() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);

        assertThrows(ValorInvalidoException.class, () -> bateria.cargarEnergia(0));
        assertThrows(ValorInvalidoException.class, () -> bateria.consumirEnergia(-300));
    }

    @Test
    void dadoUnaBateria_SiSuNivelSuperaElLimiteDeReservaAlConsumir_lanzaraUnaExcepcion() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);

        assertThrows(LimiteReservaException.class, () -> bateria.consumirEnergia(500000));
    }
}
