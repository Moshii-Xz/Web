package entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String nid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasaporte_id", referencedColumnName = "id", unique = true)
    private Pasaporte pasaporte;

    @OneToMany(mappedBy = "pasajero")
    private List<Reserva> reserva;
}
