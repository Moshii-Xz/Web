package edu.unimagdalena.demojpa.repository;

import edu.unimagdalena.aereopuerto.entities.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long> {
    
    List<Pasajero> findPasajerosAllByOrderByNombreAsc();
    
    Pasajero findPasajeroById(Long id);
    
    Pasajero findPasajeroByNombre(String nombre);
    
    List<Pasajero> findPasajerosByIdIn(List<Long> ids);
    
    List<Pasajero> findPasajerosByNombreLike(String pattern);
    
    @Query("SELECT p FROM Pasajero p WHERE SIZE(p.reservas) = (SELECT MAX(SIZE(p2.reservas)) FROM Pasajero p2)")
    Pasajero getPassengerWithMoreBookings();
    
    @Query("SELECT COUNT(p) FROM Pasajero p")
    Long countPassengers();
    
    @Query(value = "SELECT * FROM pasajero ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<Pasajero> getLast5Passengers();
    
    @Query("SELECT p FROM Pasajero p WHERE SIZE(p.reservas) > 0")
    List<Pasajero> getPassengersWithReservations();
    
    @Query("SELECT p FROM Pasajero p WHERE SIZE(p.reservas) = 0")
    List<Pasajero> findPassengersWithoutReservations();
}