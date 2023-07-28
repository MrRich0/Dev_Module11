package crud;
import entity.Planet;
import entity.Ticket;
import hibernate.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.stream.Collectors;

public class TicketService {
    private static HibernateUntil HibernateUtils;
    private PlanetService planetService;

    private static final Session SESSION;
    private static Transaction TRANSACTION;

    static {
        SESSION = HibernateUtils.getInstance().getSessionFactory().openSession();
        TRANSACTION = SESSION.beginTransaction();
    }

    public void addTicket(Long id, String fromPlanet, String toPlanet) {
        Ticket newTicket = new Ticket();
        newTicket.setIdClient(id);
        newTicket.setFromPlanet(fromPlanet);
        newTicket.setToPlanet(toPlanet);
        SESSION.persist(newTicket);
        TRANSACTION.commit();
    }

    public void getTicketById(long clientId){
        Query query = SESSION.createQuery("from Ticket where idClient = :clientId");
        query.setParameter("clientId", clientId);
        System.out.println("getTicketById "+ clientId + " = " + query.list());
        SESSION.close();
    }

    public List<Ticket> getAll() {
        return SESSION.createQuery("from Ticket ", Ticket.class).list();
    }

    public void modifiedTicket(long id, String fromPlanet, String toPlanet)   {
        List<Planet> planets = SESSION.createQuery("from Planet ", Planet.class).list();
        List<String> ids = planets.stream()
                .map(Planet::getId)
                .collect(Collectors.toList());

        if(id > getAll().size()){
            System.out.println("Білета з номером " + id + " не існує!");
            return;
        }

        if(!ids.contains(fromPlanet) ) {
            System.out.println("Планети " + fromPlanet + " немає.Планети які є " + ids);
            return;
        }

        if(!ids.contains(toPlanet) ) {
            System.out.println("Планети " + toPlanet + " немає.Планети які є " + ids);
            return;
        }

        if(fromPlanet.equals(toPlanet)){
            System.out.println("Неможе бути fromPlanet та toPlanet одного значення!");
            return;
        }

        Ticket ticket = SESSION.get(Ticket.class, id);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);
        SESSION.persist(ticket);
        TRANSACTION.commit();
    }

    public void deleteTicket(Long id){
        if(id > getAll().size()){
            System.out.println("Білета з номером " + id + " не існує!");
            return;
        }
        Ticket ticket = SESSION.get(Ticket.class,id);
        SESSION.remove(ticket);
        TRANSACTION.commit();
    }
}
