package ar.edu.unahur.obj2.energia;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaException;
import ar.edu.unahur.obj2.energia.excepciones.ValorInvalidoException;
import ar.edu.unahur.obj2.energia.notificaciones.INotificacion;

public class BateriaAlmac {
    private String IDBateria;
    private Integer kWh;
    private List<INotificacion> sistemasInteresados = new ArrayList<>();

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
        notificarObservadores("Carga", cantkWh);
        if (this.kWh < 0) {
            notificarObservadores("Alerta", cantkWh);
        }
    }

    public void consumirEnergia(Integer cantkWh) {
        if (cantkWh <= 0) {
            throw new ValorInvalidoException("El valor dado no debe ser menor o igual a 0");
        }
        if (kWh - cantkWh < -5000) {
            throw new LimiteReservaException("La reserva kWh de la bateria supero el limite");
        }
        this.kWh -= cantkWh;
        notificarObservadores("Consumo", cantkWh);
        if (this.kWh < 0) {
            notificarObservadores("Alerta", cantkWh);
        }
    }

    // Mecanismo de Suscripción
    public void registrarInteresado(INotificacion interesado) {
        sistemasInteresados.add(interesado);
    }

    public void eliminarInteresado(INotificacion interesado) {
        sistemasInteresados.remove(interesado);
    }

    private void notificarObservadores(String tipo, Integer kWh) {
        for (INotificacion interesado : sistemasInteresados) {
            interesado.reaccionar(this, tipo, kWh);
        }
    }
}
