package edu.unimagdalena.demojpa.repository;

import edu.unimagdalena.aereopuerto.entities.Pasaporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasaporteRepository extends JpaRepository<Pasaporte, Long> {
    
    Pasaporte findPasaporteByNumero(String numero);
    
    Pasaporte findPasaporteById(Long id);
    
    List<Pasaporte> findPasaportesByNumeroContaining(String parte);
    
    List<Pasaporte> findPasaportesByIdIn(List<Long> ids);
    
    List<Pasaporte> findPasaportesByNumeroStartingWith(String prefix);
    
    @Query("SELECT p FROM Pasaporte p ORDER BY LENGTH(p.numero) DESC")
    Pasaporte findPassportWithLongestNumber();
    
    @Query("SELECT p FROM Pasaporte p WHERE p.id BETWEEN ?1 AND ?2")
    List<Pasaporte> getPassportsInIdRange(Long minId, Long maxId);
    
    @Query(value = "SELECT * FROM pasaporte ORDER BY id DESC LIMIT 1", nativeQuery = true)
    Pasaporte getLastRegisteredPassport();
    
    @Query("SELECT COUNT(p) FROM Pasaporte p")
    Long countPassports();
}
