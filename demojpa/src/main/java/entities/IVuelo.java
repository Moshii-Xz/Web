package entities;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IVuelo extends JpaRepository<Vuelo, Long> {
    
    Vuelo findByDestino(String destino);
    Vuelo findByAerolineaNombre(String nombre);
    Vuelo findByReservasPasajeroNombre(String nombre);
    Vuelo findByReservasPasajeroNid(String nid);
    Vuelo findByReservasCodigo(String codigo);
	
}
