package entities;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface IVuelo extends JpaRepository<Vuelo, Long> {
    
    Vuelo findByDestino(String destino);
    Vuelo findByAerolineaNombre(String nombre);
    Vuelo findByReservasPasajeroNombre(String nombre);
    Vuelo findByReservasPasajeroNid(String nid);
    Vuelo findByReservasCodigo(String codigo);
	

    @Query("SELECT v FROM Vuelo v WHERE v.aerolinea.nombre = ?1")
        Vuelo findByAerolineaNombre(String nombre);
    @Query("SELECT v FROM Vuelo v WHERE v.reservas.pasajero.nombre = ?1")
        Vuelo findByReservasPasajeroNombre(String nombre);
    @Query("SELECT v FROM Vuelo v WHERE v.reservas.pasajero.nid = ?1")
        Vuelo findByReservasPasajeroNid(String nid);
    @Query("SELECT v FROM Vuelo v WHERE v.reservas.codigo = ?1")
        Vuelo findByReservasCodigo(String codigo);
    @Query("SELECT v FROM Vuelo v WHERE v.destino = ?1")
        Vuelo findByDestino(String destino);
}
