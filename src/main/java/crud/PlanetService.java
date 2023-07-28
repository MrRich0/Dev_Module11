package crud;
import entity.Planet;
import hibernate.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlanetService {
    private static HibernateUntil HibernateUtils;
    private static final Session SESSION;
    private static Transaction TRANSACTION;
    static {
        SESSION = HibernateUtils.getInstance().getSessionFactory().openSession();
        TRANSACTION = SESSION.beginTransaction();
    }

    public void addPlanet(String id,String name){
        Planet newPlanet = new Planet();
        newPlanet.setId(id);
        newPlanet.setName(name);
        SESSION.persist(newPlanet);
        TRANSACTION.commit();
    }

    public void getPlanet(String id) {
        Planet getPlanet = SESSION.get(Planet.class, id);
        System.out.println("getPlanet = " + getPlanet);
    }

    public void getAll(){
        List<Planet> planets = SESSION.createQuery("from Planet ", Planet.class).list();
        System.out.println("allPlanets = " + planets);
        SESSION.close();

    }

    public void modifiedPlanet(String id, String name){
        Planet planet = SESSION.get(Planet.class,id);
        planet.setName(name);
        SESSION.persist(planet);
        TRANSACTION.commit();
    }

    public void deletePlanet(String id){
        Planet planet = SESSION.get(Planet.class,id);
        SESSION.remove(planet);
        TRANSACTION.commit();
    }
}
