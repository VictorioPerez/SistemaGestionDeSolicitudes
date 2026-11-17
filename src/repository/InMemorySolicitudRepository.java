package repository;

import model.Solicitudes;
import java.util.ArrayList;
import java.util.List;

public class InMemorySolicitudRepository
        implements SolicitudRepository {

    private final List<Solicitudes> solicitudes = new ArrayList<>();

    @Override
    public void guardar(Solicitudes solicitud) {
        solicitudes.add(solicitud);
    }

    @Override
    public Solicitudes buscarPorId(int id) {
        for (Solicitudes solicitud : solicitudes) {
            if (solicitud.getId() == id) {
                return solicitud;
            }
        }
        return null;
    }

    @Override
    public List<Solicitudes> obtenerTodas() {
        return new ArrayList<>(solicitudes);
    }
}