package repository;

import model.Solicitudes;
import java.util.List;

public interface SolicitudRepository {

    void guardar(Solicitudes solicitud);

    Solicitudes buscarPorId(int id);

    List<Solicitudes> obtenerTodas();
}