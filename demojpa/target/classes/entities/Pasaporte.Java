package entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity
@Table (name = "pasaporte")
public class Pasaporte{
    @Id FeneatedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @colum (nullable = false)
    private String numero;
 

    @OneToOne (mappedy = "pasaporte")
    private Pasajero pasajero;
    
}