package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.operaciones.OpCarga;
import ar.edu.unahur.obj2.energia.operaciones.OpConsumo;

public class operacionesTest {
    @Test
    void dadoOpCarga_cuandoSeEjecutaLaAccion_entoncesCargaEnergiaDeLaBateria() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);
        OpCarga carga = new OpCarga(bateria, 2000);

        carga.ejecutar(); // 2000 + 2400 = 4400

        assertEquals(4400, bateria.getNivelEnergiaActual());
    }

    @Test
    void dadoOpCarga_cuandoSeDeshace_vuelveASusEstadoNormal() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);
        OpCarga carga = new OpCarga(bateria, 2000);
        carga.ejecutar(); // 2000 + 2400 = 4400

        carga.deshacer();

        assertEquals(2400, bateria.getNivelEnergiaActual());

    }

    @Test
    void dadoOpConsumo_cuandoSeEjecutaLaAccion_entoncesConsumeEnergiaDeLaBateria() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);
        OpConsumo consumo = new OpConsumo(bateria, 2000);

        consumo.ejecutar(); // 2000 - 2400 = 400

        assertEquals(400, bateria.getNivelEnergiaActual());
    }

    @Test
    void dadoOpConsumo_cuandoSeDeshace_vuelve() {
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 2400);
        OpConsumo consumo = new OpConsumo(bateria, 2000);
        consumo.ejecutar();

        consumo.deshacer();

        assertEquals(2400, bateria.getNivelEnergiaActual());

    }
}
