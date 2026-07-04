package ar.edu.unahur.obj2.energia.notificaciones;

import ar.edu.unahur.obj2.energia.BateriaAlmac;

public interface INotificacion {

    void reaccionar(BateriaAlmac bateria, String tipo, Integer capacidadKWh);

}