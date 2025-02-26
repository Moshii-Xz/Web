
package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity

public class Pasajero{
    @Id FeneatedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @colum (nullable = false)
    private String nombre;
    @colum (nullable = false)
    private String NID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasaporte_id", referencedColumnName = "id", unique = true)
    private Pasaporte pasaporte;

    @OneToMany(mappedy="pasajero")
    private List<Reserva> reserva;
}