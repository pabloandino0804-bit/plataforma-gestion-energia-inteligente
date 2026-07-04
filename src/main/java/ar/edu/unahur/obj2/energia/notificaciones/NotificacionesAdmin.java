package ar.edu.unahur.obj2.energia.notificaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmac;

public class NotificacionesAdmin implements INotificacion {

    @Override
    public void reaccionar(BateriaAlmac bateria, String tipo, Integer capacidadKWh) {
        if (tipo == "Carga") {
            System.out.print(
                    "[ADMIN] Se ha cargado " + capacidadKWh + "kWh en su bateria " + bateria.getIDBateria() + ".");
        }
        if (tipo == "Consumo") {
            System.out.print(
                    "[ADMIN] Se ha consumido " + capacidadKWh + "kWh en su bateria " + bateria.getIDBateria() + ".");
        }
    }

}
