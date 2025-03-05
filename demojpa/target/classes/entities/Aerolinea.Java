package entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Aerolinea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "aerolineas") 
    private List<Vuelo> vuelos;
}
