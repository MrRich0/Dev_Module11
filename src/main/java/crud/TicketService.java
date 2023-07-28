package crud;
import entity.Client;
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
    private static final Session SESSION;
    private static Transaction TRANSACTION;

    static {
        SESSION = HibernateUtils.getInstance().getSessionFactory().openSession();
        TRANSACTION = SESSION.beginTransaction();
    }

    public void addTicket(Client id, Planet fromPlanet, Planet toPlanet) {
        Ticket newTicket = new Ticket();
        newTicket.setIdClient(id);
        newTicket.setFromPlanet(fromPlanet);
        newTicket.setToPlanet(toPlanet);
        SESSION.persist(newTicket);
        TRANSACTION.commit();
    }

    public void modifiedTicket(long ticketID, Planet fromPlanet, Planet toPlanet){
        List<Planet> planets = SESSION.createQuery("from Planet ", Planet.class).list();
        List<String> ids = planets.stream()
                .map(Planet::getId)
                .collect(Collectors.toList());

        if(ticketID > getAll().size()){
            System.out.println("Білета з номером " + ticketID + " не існує!");
            return;
        }

        if(!ids.contains(fromPlanet.getId()) ) {
            System.out.println("Планети " + fromPlanet.getId() + " немає.Планети які є " + ids);
            return;
        }

        if(!ids.contains(toPlanet.getId()) ) {
            System.out.println("Планети " + toPlanet.getId() + " немає.Планети які є " + ids);
            return;
        }

        if(fromPlanet.getId().equals(toPlanet.getId())){
            System.out.println("Неможе бути fromPlanet та toPlanet одного значення!");
            return;
        }

        Ticket ticket = SESSION.get(Ticket.class, ticketID);
        ticket.setFromPlanet(fromPlanet);
        ticket.setToPlanet(toPlanet);
        SESSION.persist(ticket);
        TRANSACTION.commit();
    }

    public void getTicketById(Client clientId){
        Query query = SESSION.createQuery("from Ticket where idClient = :clientId");
        query.setParameter("clientId", clientId);
        System.out.println("getTicketById "+ clientId + " = " + query.list());
        SESSION.close();

    }

    public List<Ticket> getAll() {
        return SESSION.createQuery("from Ticket ", Ticket.class).list();
    }

    public void deleteTicket(long ticketId){
        if(ticketId > getAll().size()){
            System.out.println("Білета з номером " + ticketId + " не існує!");
            return;
        }

        Ticket ticket = SESSION.get(Ticket.class,ticketId);
        SESSION.remove(ticket);
        TRANSACTION.commit();
    }
}

