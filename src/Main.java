import repository.InMemorySolicitudRepository;
import repository.SolicitudRepository;
import service.SolicitudService;
import UI.MenuConsola;

public class Main {

    public static void main(String[] args) {

        SolicitudRepository repository =
                new InMemorySolicitudRepository();

        SolicitudService servicio =
                new SolicitudService(repository);

        MenuConsola menu = new MenuConsola(servicio);

        menu.iniciar();
    }
}