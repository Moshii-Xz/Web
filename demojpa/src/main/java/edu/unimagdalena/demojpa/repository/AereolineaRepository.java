package edu.unimagdalena.demojpa.repository;

import edu.unimagdalena.aereopuerto.entities.Aereolinea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AereolineaRepository extends JpaRepository<Aereolinea, Long> {
    
    List<Aereolinea> findAereolineaByNombreStartingWith(String prefix);
    
    Aereolinea findAereolineaByIdAereolinea(Long id);
    
    Aereolinea findAereolineaByNombre(String nombre);
    
    List<Aereolinea> findAereolineaByIdAereolineaIn(List<Long> ids);
    
    List<Aereolinea> findAereolineasByNombreLike(String pattern);
    
    @Query("SELECT a FROM Aereolinea a WHERE SIZE(a.vuelos) > 0")
    List<Aereolinea> getAirlinesWithFlights();
    
    @Query("SELECT DISTINCT a FROM Aereolinea a JOIN a.vuelos v WHERE v.destino = ?1")
    List<Aereolinea> getAirlinesByDestination(String destino);
    
    @Query("SELECT a FROM Aereolinea a WHERE SIZE(a.vuelos) = (SELECT MAX(SIZE(a2.vuelos)) FROM Aereolinea a2)")
    Aereolinea getAirlineWithMoreFlights();
    
    @Query("SELECT a FROM Aereolinea a WHERE SIZE(a.vuelos) = 0")
    List<Aereolinea> getAirlinesWithoutFlights();
    
    @Query("SELECT COUNT(a) FROM Aereolinea a")
    Long countAirlines();
}