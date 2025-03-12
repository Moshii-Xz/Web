package edu.unimagdalena.demojpa.repository;

import edu.unimagdalena.aereopuerto.entities.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
    Long countReservasByPasajeroNombre(String nombre);
    
    Reserva findReservaById(Long id);
    
    List<Reserva> findReservasByPasajeroId(Long id);
    
    Reserva findByCodigoReserva(UUID codigoReserva);
    
    List<Reserva> findReservasByVueloId(Long id);
    
    @Query("SELECT r FROM Reserva r WHERE r.vuelo.origen = ?1 AND r.vuelo.destino = ?2")
    List<Reserva> findReservasByOrigenAndDestino(String origen, String destino);
    
    @Query("SELECT r FROM Reserva r WHERE r.vuelo.origen = ?1")
    List<Reserva> findReservasByCiudadOrigen(String origen);
    
    @Query("SELECT r FROM Reserva r WHERE r.vuelo.destino = ?1")
    List<Reserva> findReservationsByFlightDestination(String destino);
    
    @Query("SELECT r FROM Reserva r WHERE r.vuelo.id = ?1")
    List<Reserva> findReservasByCodigoVuelo(Long id);
    
    @Query(value = "SELECT * FROM reserva ORDER BY id DESC", nativeQuery = true)
    List<Reserva> findRecentReservations();
}