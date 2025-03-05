package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity
@Table (name = "vuelo")
public class Vuelo{
    @Id FeneatedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @colum (nullable = false)
    private void numero__de_vuelo;
    @colum (nullable = false)
    private String origen;
    @colum (nullable = false)
    private String destino;

    @OneToMany (mappedy= "vuelo")
    private List<Reserva> reserva;

   // @ManyToMany
    //@JoinTable(
    //    name = "vuelos_de_aerolinea",
    //    joinColumns = @JoinColumn(name = "aerolinea_id"),
    //    inverseJoinColumns = @JoinColumn(name = "vuelo_id") 
    //)

      //  private List<Aerolinea> aerolineas;
   
}