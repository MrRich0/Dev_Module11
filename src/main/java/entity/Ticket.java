package entity;

import jakarta.persistence.*;
import lombok.Data;
@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private long id;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client idClient;
    @ManyToOne
    @JoinColumn(name = "from_planet_id")
    private Planet fromPlanet;
    @ManyToOne
    @JoinColumn(name = "to_planet_id")
    private Planet toPlanet;


    public Ticket(long id, Client idClient, Planet fromPlanet, Planet toPlanet) {
        this.id = id;
        this.idClient = idClient;
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
    }

    public Ticket() {

    }
}
