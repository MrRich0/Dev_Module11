package hibernate;


import entity.Client;
import entity.Planet;
import entity.Ticket;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUntil {
    private static final HibernateUntil INSTANCE;
    static {
        INSTANCE = new HibernateUntil();
    }
    @Getter
    private SessionFactory sessionFactory;

    private HibernateUntil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Client.class)
                .addAnnotatedClass(Planet.class)
                .addAnnotatedClass(Ticket.class)
                .buildSessionFactory();
    }

    public static HibernateUntil getInstance(){
        return INSTANCE;
    }

    public void close(){
        sessionFactory.close();
    }

}
