package ar.edu.unahur.obj2.energia.notificaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmac;

public class RegistroCentral implements INotificacion {
    @Override
    public void reaccionar(BateriaAlmac bateria, String tipo, Integer capacidadKWh) {
        if (tipo != "Alerta") {
            System.out.print(
                    "[AUDITORIA] Registro: " + tipo + " " + capacidadKWh + " kWh " + "en bateria"
                            + bateria.getIDBateria());
        }
    }
}
