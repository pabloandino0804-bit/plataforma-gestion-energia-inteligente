package ar.edu.unahur.obj2.energia.operaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmac;

public class OpConsumo implements IOperacionTransfer {
    private final BateriaAlmac bateria;
    private Integer cantkWhDada;

    public OpConsumo(BateriaAlmac bateria, Integer kWhs) {
        this.bateria = bateria;
        this.cantkWhDada = kWhs;
    }

    @Override
    public void ejecutar() {
        bateria.consumirEnergia(cantkWhDada);
    }

    @Override
    public void deshacer() {
        bateria.cargarEnergia(cantkWhDada);
    }

}
