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

   // @ManyToOne
    @Column(name = "client_id")
    private long idClient;
   // @ManyToOne
    @Column(name = "from_planet_id")
    private String fromPlanet;
  //  @ManyToOne
    @Column(name = "to_planet_id")
    private String toPlanet;
}
