/**
 * 
 */
package M13SpringRestApi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import M13SpringRestApi.entity.Botiga;
import M13SpringRestApi.repository.BotigaRepository;

/**
 * Clase Serivicio para la entidad Botiga
 * @author Rubén Rodríguez Fernández
 *
 */
@Service
public class BotigaServices implements IBotigaServices {

	/**
	 * Inyectamos el repositorio de Botiga.
	 */
	@Autowired
	BotigaRepository botigaRep;
	
	/**
	 * Método que guarda una botiga
	 */
	@Override
	public void guardarBotiga(Botiga botiga) {
		botigaRep.save(botiga);
	}

	/**
	 * Método que retorna una botiga con id igual al recibido por parámetro
	 */
	@Override
	public Botiga datosBotiga(Long id) {
		return botigaRep.findById(id).get();
	}

	/**
	 * Método que actualiza los datos de una botiga.
	 */
	@Override
	public Botiga updateBotiga(Botiga botiga, Long id) {
		// TODO Auto-generated method stub
		//Botiga botiganew = botiga;
		return botigaRep.save(botiga);
	}

	/**
	 * Método que elimina una botiga de la BBDD
	 */
	@Override
	public void eliminarbotiga(Long id) {
		botigaRep.deleteById(id);
	}

	/**
	 * Método que devuelve una lista con todas las botigas.
	 */
	@Override
	public List<Botiga> listadoBotigas() {
		
		return botigaRep.findAll();
	}

	/**
	 * Método que devuelve un booleano en función de si el id de botiga existe.
	 */
	@Override
	public boolean existeTienda(Long id) {
		
		return botigaRep.existsById(id);
	}

}
