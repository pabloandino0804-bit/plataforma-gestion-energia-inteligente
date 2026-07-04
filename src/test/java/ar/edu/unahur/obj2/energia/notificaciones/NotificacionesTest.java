package ar.edu.unahur.obj2.energia.notificaciones;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.energia.operaciones.OpCarga;
import ar.edu.unahur.obj2.energia.operaciones.OpConsumo;
import ar.edu.unahur.obj2.energia.BateriaAlmac;

public class NotificacionesTest {
    private BateriaAlmac bateria = new BateriaAlmac("Bateria-AA", 3500);
    private RegistroCentral registroAuditoria = new RegistroCentral();
    private AlertaSobrecarga alerta = new AlertaSobrecarga();
    private NotificacionesAdmin notificacion = new NotificacionesAdmin();

    @BeforeEach
    void setUp() {
        bateria.eliminarInteresado(registroAuditoria);
        bateria.eliminarInteresado(alerta);
        bateria.eliminarInteresado(notificacion);
    }

    @Test
    void dadoRegistroAuditoria_registraTodasLasAlteracionesExitosasRealizadasSobreLaBateria() {
        bateria.registrarInteresado(registroAuditoria);
        bateria.registrarInteresado(alerta);
        OpCarga carga = new OpCarga(bateria, 2000);
        carga.ejecutar();

        carga.deshacer();

        assertEquals(3500, bateria.getNivelEnergiaActual());
    }

    @Test
    void dado_NotificacionesAdmin_informaAlResponsableCadaVezQueOcurreUnaVariacionDeEnergiaEnSuBateria() {
        bateria.registrarInteresado(notificacion);
        bateria.registrarInteresado(alerta);
        OpCarga carga = new OpCarga(bateria, 2000);
        carga.ejecutar();

        carga.deshacer();

        assertEquals(3500, bateria.getNivelEnergiaActual());
    }

    @Test
    void dadoAlertadeReservaCritica_DetectaCuandoQuedaDebajoDeSuNivelDeToleranciaLuegoDeUnaOperacionYAdvierteSobreElUsoDelLimite() {
        bateria.registrarInteresado(registroAuditoria);
        bateria.registrarInteresado(alerta);
        OpConsumo consumo = new OpConsumo(bateria, 3510);
        consumo.ejecutar();

        consumo.deshacer();

        assertEquals(3500, bateria.getNivelEnergiaActual());
    }

}
