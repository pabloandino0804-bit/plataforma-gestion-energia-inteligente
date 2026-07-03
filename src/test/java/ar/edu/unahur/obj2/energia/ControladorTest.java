package ar.edu.unahur.obj2.energia;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.operaciones.OpCarga;
import ar.edu.unahur.obj2.energia.operaciones.OpConsumo;

public class ControladorTest {

    @Test
    void testEjecutarEnRutina() {
        ControladorTranfer controlador = new ControladorTranfer();
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 1000);
        OpCarga carga = new OpCarga(bateria, 2000);
        OpConsumo consumo = new OpConsumo(bateria, 500);
        OpConsumo consumo2 = new OpConsumo(bateria, -1500);
        OpCarga carga2 = new OpCarga(bateria, 1500);
        OpConsumo consumo3 = new OpConsumo(bateria, 500000);
        controlador.registrarOperaciones(carga, carga2, consumo, consumo2, consumo3);

        controlador.ejecutarEnRutina();

        assertEquals(4000, bateria.getNivelEnergiaActual());
    }

    @Test
    void testEjecutarOperacion() {
        ControladorTranfer controlador = new ControladorTranfer();
        BateriaAlmac bateria = new BateriaAlmac("Bateria-1", 1000);
        OpCarga carga = new OpCarga(bateria, 2000);
        OpConsumo consumo = new OpConsumo(bateria, 500);
        controlador.registrarOperaciones(carga, consumo);

        controlador.ejecutarOperacion(consumo);
        controlador.ejecutarOperacion(carga);

        assertEquals(3500, bateria.getNivelEnergiaActual());
    }

}
