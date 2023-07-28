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

        /*ticketService.modifiedTicket(9,
                planetService.getPlanet("EAR"),
                planetService.getPlanet("JUP"));*/

        /*ticketService.addTicket(clientService.getClient(1l),
                planetService.getPlanet("EAR"),
                planetService.getPlanet("MARS"));*/

        /*ticketService.getTicketById(clientService.getClient(1l));*/

        /*ticketService.deleteTicket(9);*/

         System.out.println("ticketService.getAll() = " + ticketService.getAll());



    }
}

