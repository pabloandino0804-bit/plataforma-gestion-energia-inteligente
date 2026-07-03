package ar.edu.unahur.obj2.energia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ar.edu.unahur.obj2.energia.excepciones.LimiteReservaException;
import ar.edu.unahur.obj2.energia.excepciones.ValorInvalidoException;
import ar.edu.unahur.obj2.energia.operaciones.IOperacionTransfer;

public class ControladorTranfer {
    private List<IOperacionTransfer> listOps = new ArrayList<>();

    public void ejecutarOperacion(IOperacionTransfer unaOperacion) {
        if (listOps.contains(unaOperacion)) {
            unaOperacion.ejecutar();
            listOps.remove(unaOperacion);
        }
    }

    public void registrarOperaciones(IOperacionTransfer... operaciones) {
        List<IOperacionTransfer> operatiosnList = Arrays.asList(operaciones);
        operatiosnList.stream().forEach(operacion -> listOps.add(operacion));
    }

    public void ejecutarEnRutina() {
        for (IOperacionTransfer operacion : listOps) {
            try {
                operacion.ejecutar();
            } catch (ValorInvalidoException e) {
                System.out.print("Operacion fallida en lote" + e.getMessage());
            } catch (LimiteReservaException e) {
                System.out.print("Operacion fallida en lote" + e.getMessage());
            }
        }
        vaciarListOperaciones();
    }

    private void vaciarListOperaciones() {
        listOps.clear();
    }
}
