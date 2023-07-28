package data;
import crud.ClientService;
import crud.PlanetService;
import crud.TicketService;

public class DataBaseTest {
    public static void main(String[] args){
        DatabaseInitServiceFlyway flyway = new DatabaseInitServiceFlyway();
        ClientService clientService = new ClientService();
        PlanetService planetService = new PlanetService();
        TicketService ticketService = new TicketService();

        flyway.initDb();

//        clientService.addClient("Test one");
//        clientService.getClient(5l);
//        clientService.getAll();
//        clientService.modifiedClietn(11l, "Vladimir Motyka");
//        clientService.getAll();
//        clientService.deleteClient(11l);
//        clientService.getAll();
//
//        planetService.addPlanet("SUN", "Sun");
//        planetService.getPlanet("VEN");
//        planetService.getAll();
//        planetService.modifiedPlanet("SUN","Soon");
//        planetService.getAll();
//        planetService.deletePlanet("SUN");
//        planetService.getAll();
//
//        ticketService.addTicket(7l, "MARS","JUP");
//        ticketService.getTicketById(7l);
//        System.out.println("allTicket = " + ticketService.getAll());
//        ticketService.modifiedTicket(6l,"VEN", "EAR");
//        System.out.println("allTicket = " + ticketService.getAll());
//        ticketService.deleteTicket(3l);
//        System.out.println("allTicket = " + ticketService.getAll());

    }
}

