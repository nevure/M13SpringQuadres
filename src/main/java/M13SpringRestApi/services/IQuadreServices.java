package M13SpringRestApi.services;

import java.util.List;

import M13SpringRestApi.entity.Quadre;
/**
 * Interfaz de los servicios de Quadres
 * @author Rubén Rodríguez
 *
 */
public interface IQuadreServices {

	
	public Quadre guardaQuadre(Quadre quadre);
	public void vendidosTodos(Long id);
	public List<Quadre> listadoQuadresByBotiga(Long id);
	public void quadreVenut(Long idQuadre);
	public List<Quadre> listadoPorAutor(String nombre);
	public List<Quadre> listadoPorAutorBotiga(String nombre, Long id);
	
}
