package ar.edu.unahur.obj2.energia;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaException;
import ar.edu.unahur.obj2.energia.excepciones.ValorInvalidoException;

public class BateriaAlmac {
    private String IDBateria;
    private Integer kWh;

    public BateriaAlmac(String IDBateria, Integer kWhInicial) {
        this.IDBateria = IDBateria;
        this.kWh = kWhInicial;
    }

    public String getIDBateria() {
        return IDBateria;
    }

    public Integer getNivelEnergiaActual() {
        return kWh;
    }

    public void cargarEnergia(Integer cantkWh) {
        if (cantkWh <= 0) {
            throw new ValorInvalidoException("El valor dado no debe ser menor o igual a 0");
        }
        this.kWh += cantkWh;
    }

    public void consumirEnergia(Integer cantkWh) {
        if (cantkWh <= 0) {
            throw new ValorInvalidoException("El valor dado no debe ser menor o igual a 0");
        }
        if (kWh - cantkWh < -5000) {
            throw new LimiteReservaException("La reserva kWh de la bateria supero el limite");
        }
        this.kWh -= cantkWh;
    }
}
