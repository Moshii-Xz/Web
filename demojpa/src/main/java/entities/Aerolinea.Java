
package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity

public class Aerolinea{
    @Id FeneatedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @colum (nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "aerolinea")
    private List<Vuelo> vuelos;
}