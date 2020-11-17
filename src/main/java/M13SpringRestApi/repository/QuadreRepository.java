package M13SpringRestApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import M13SpringRestApi.entity.Quadre;
/**
 * 
 * Interfaz que utiliza la clase QuadreService. Extiende al repositorio JPA. Agregamos dos métodos más.
 * 
 * @author Rubén Rodríguez Fernández
 * 
 *
 */
@Repository
public interface QuadreRepository extends JpaRepository<Quadre, Long> {
	
	/**
	 * Método que genera una lsita de cuadros a partir de un nombre de autor faciitado.
	 * @param nombreAutor
	 * @return
	 */
	List<Quadre> findByNombreAutor(String nombreAutor);
	
	/**
	 * Método que genera una lista de cuadros de una botiga en concreto.
	 * @param id
	 * @return
	 */
	List<Quadre> findByBotigaId(Long id);
	
	/**
	 * Método que elimina todos los cuadros de una botiga. 
	 * @param id identificador de la botiga.
	 */
	void deleteAllByBotigaId(Long id);

	/**
	 * Creamos un método para encontrar cuadros por nombre de autor y botiga. A través
	 * de una Query personalizada en HQL
	 * @param nombreAutor
	 * @param id
	 * @return lista de Cuadros pertenecientes a un Autor y Botiga.
	 */
	@Query("SELECT q FROM Quadre q INNER JOIN q.botiga b WHERE q.nombreAutor = ?1 AND b.id = ?2") 
	List<Quadre> findByNombreAutorAndBotigaId(String nombreAutor,  Long id);
	
}

