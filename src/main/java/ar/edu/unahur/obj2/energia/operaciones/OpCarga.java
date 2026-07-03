package ar.edu.unahur.obj2.energia.operaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmac;

public class OpCarga implements IOperacionTransfer {
    private final BateriaAlmac bateria;
    private Integer cantkWhDada;

    public OpCarga(BateriaAlmac bateria, Integer kWhs) {
        this.bateria = bateria;
        this.cantkWhDada = kWhs;
    }

    @Override
    public void ejecutar() {
        bateria.cargarEnergia(cantkWhDada);
    }

    @Override
    public void deshacer() {
        bateria.consumirEnergia(cantkWhDada);
    }
}
