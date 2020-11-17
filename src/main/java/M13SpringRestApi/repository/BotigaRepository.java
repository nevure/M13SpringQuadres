/**
 * 
 */
package M13SpringRestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import M13SpringRestApi.entity.Botiga;

/**
 * 
 * Interfaz que utiliza la clase BotigaService. Extiende al repositorio JPA. 
 * 
 * @author Rubén Rodríguez Fernández
 * 
 *
 */
@Repository
public interface BotigaRepository extends JpaRepository<Botiga, Long> {

}
