package entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPasaporte extends JpaRepository<Pasaporte, Long> {
    
    List<Pasaporte> findByNumero(String numero);
    List<Pasaporte> findByPasajeroNombre(String nombre);
    List<Pasaporte> findByPasajeroNid(String nid);
    List<Pasaporte> findByPasajeroReservaVueloNumeroDeVuelo(String numeroDeVuelo);
    List<Pasaporte> findByPasajeroReservaVueloOrigen(String origen);

    @Query("SELECT p FROM Pasaporte p WHERE p.pasajero.nombre = ?1")
        Pasaporte findByPasajeroNombre(String nombre);
    @Query("SELECT p FROM Pasaporte p WHERE p.pasajero.nid = ?1")
        Pasaporte findByPasajeroNid(String nid);
    @Query("SELECT p FROM Pasaporte p WHERE p.pasajero.reserva.vuelo.numeroDeVuelo = ?1")
        Pasaporte findByPasajeroReservaVueloNumeroDeVuelo(String numeroDeVuelo);
    @Query("SELECT p FROM Pasaporte p WHERE p.pasajero.reserva.vuelo.origen = ?1")
        Pasaporte findByPasajeroReservaVueloOrigen(String origen);
    @Query("SELECT p FROM Pasaporte p WHERE p.numero = ?1")
        Pasaporte findByNumero(String numero);
}
