package entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String codigo; 

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasajero_id", referencedColumnName = "id")
    private Pasajero pasajero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vuelo_id", referencedColumnName = "id")
    private Vuelo vuelo;
}
