package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity

public class Reserva{
    @Id FeneatedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @colum (nullable = false)
    private void codigo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pasajero_id", referencedColumnName = "id", unique = false)
    private Pasajero pasajero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vuelo_id", referencedColumnName = "id", unique = false)

    private Vuelo vuelo;

}