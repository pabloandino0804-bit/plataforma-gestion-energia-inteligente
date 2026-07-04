package ar.edu.unahur.obj2.energia.notificaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmac;

public class AlertaSobrecarga implements INotificacion {
    private Integer limiteReserva = -5000;

    @Override
    public void reaccionar(BateriaAlmac bateria, String tipo, Integer capacidadKWh) {
        if (tipo == "Alerta")
            System.out.println(
                    "[ALERTA] la bateria " + bateria.getIDBateria() + " esta en Reserva critica " + " Que no llege a "
                            + limiteReserva);
    }

}
