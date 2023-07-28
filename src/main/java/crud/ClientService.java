package crud;


import entity.Client;
import hibernate.HibernateUntil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;


public class ClientService {
    private static HibernateUntil HibernateUtils;
    private static final Session SESSION;
    private static Transaction TRANSACTION;
    static {
        SESSION = HibernateUtils.getInstance().getSessionFactory().openSession();
        TRANSACTION = SESSION.beginTransaction();
    }


    public void addClient(String name){
        Client newClient = new Client();
        newClient.setName(name);
        SESSION.persist(newClient);
        TRANSACTION.commit();
    }

    public void getClient(long id){
        Client client = SESSION.get(Client.class,id);
        System.out.println("getClient = " + client);
        SESSION.close();
    }

    public void getAll(){
        List<Client> clients = SESSION.createQuery("from Client", Client.class).list();
        System.out.println("allClients = " + clients);
        SESSION.close();

    }

    public void modifiedClietn(long id, String name){
        Client client = SESSION.get(Client.class,id);
        client.setName(name);
        SESSION.persist(client);
        TRANSACTION.commit();
    }

    public void deleteClient(long id){
        Client client = SESSION.get(Client.class,id);
        SESSION.remove(client);
        TRANSACTION.commit();
    }
}

