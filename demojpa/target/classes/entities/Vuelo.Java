package entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String numeroDeVuelo;  // Corregido el tipo de dato y el nombre

    @Column(nullable = false)
    private String origen;

    @Column(nullable = false)
    private String destino;

    @OneToMany(mappedBy = "vuelo")
    private List<Reserva> reserva;

    @ManyToMany
    @JoinTable(
        name = "vuelos_de_aerolinea",
        joinColumns = @JoinColumn(name = "vuelo_id"),  // Ahora correcto
        inverseJoinColumns = @JoinColumn(name = "aerolinea_id") 
    )
    private List<Aerolinea> aerolineas;
}
