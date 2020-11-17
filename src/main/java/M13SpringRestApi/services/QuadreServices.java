/**
 * 
 */
package M13SpringRestApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import M13SpringRestApi.entity.Quadre;
import M13SpringRestApi.repository.QuadreRepository;

/**
 * Clase Serivicio para la entidad quadre
 * @author Rubén Rodríguez Fernández
 *
 */
@Service
public class QuadreServices implements IQuadreServices {

	/**
	 * Inyectamos el repositorio de Quadre
	 */
	@Autowired
	QuadreRepository repoQuadre;
	
	/**
	 * Guardamos un quadre.
	 */
	@Override
	public Quadre guardaQuadre(Quadre quadre) {
		
		return repoQuadre.save(quadre);

	}
	

	/**
	 * Método que elimina todos los cuadros de una tienda identificado por el id.
	 */
	@Transactional
	@Override
	public void vendidosTodos(Long id) {
		repoQuadre.deleteAllByBotigaId(id);
	}

	/**
	 * Lista los cuadros de una Botiga
	 */
	@Override
	public List<Quadre> listadoQuadresByBotiga(Long id) {

		return repoQuadre.findByBotigaId(id);
	}
	
	/**
	 * Eliminem un cuadre per Id
	 */
	@Override
	public void quadreVenut(Long id) {
		repoQuadre.deleteById(id);
	}

	/**
	 * Método que devuelve una lista de quades per autor. Llamando al repositorio.
	 */
	@Override
	public List<Quadre> listadoPorAutor(String nombre) {
		
		return repoQuadre.findByNombreAutor(nombre);
	}

	/**
	 * Método que devuelve un listado de qudres por botiga y autor. Llama al repositorio. A un método con una
	 * Query personalizada.
	 */
	@Override
	public List<Quadre> listadoPorAutorBotiga(String nombre, Long id) {

		return repoQuadre.findByNombreAutorAndBotigaId(nombre, id);
	}
	
	



		
}


