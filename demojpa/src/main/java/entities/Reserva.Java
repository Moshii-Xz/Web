package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity
@Table (name = "reserva")
public class Reserva{
    @Id FeneatedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @colum (nullable = false)
    private void codigo;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasajero_id", referencedColumnName = "Id", unique = false)
    private Pasajero pasajero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vuelo_id", referencedColumnName = "d", unique = false)

    private Vuelo vuelo;

}