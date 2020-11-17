package M13SpringRestApi.services;

import java.util.List;

import M13SpringRestApi.entity.Botiga;

/**
 * Interfaz de los servicios de Botiga
 * @author Rubén Rodríguez
 *
 */
public interface IBotigaServices {
	
	public void guardarBotiga(Botiga botiga);
	public Botiga datosBotiga(Long id);
	public Botiga updateBotiga(Botiga botiga, Long id);
	public void eliminarbotiga(Long id);
	public List<Botiga> listadoBotigas();
	public boolean existeTienda(Long id);
	
}
