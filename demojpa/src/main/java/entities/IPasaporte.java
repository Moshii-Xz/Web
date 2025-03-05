package entities;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPasaporte extends JpaRepository<Pasaporte, Long> {
    
    List<Pasaporte> findByNumero(String numero);
    List<Pasaporte> findByPasajeroNombre(String nombre);
    List<Pasaporte> findByPasajeroNid(String nid);
    List<Pasaporte> findByPasajeroReservaVueloNumeroDeVuelo(String numeroDeVuelo);
    List<Pasaporte> findByPasajeroReservaVueloOrigen(String origen);
}
