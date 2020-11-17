package M13SpringRestApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import M13SpringRestApi.entity.Quadre;

import M13SpringRestApi.services.BotigaServices;
import M13SpringRestApi.services.QuadreServices;

import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 
 * Clase controlador para los cuadros
 * 
 * @author Rubén Rodríguez
 *
 */
@RestController
public class QuadreController {
	
	
	//Inyectamos los servicios de Quadre y Botiga.
	@Autowired
	QuadreServices serviceQuadre;
	
	@Autowired
	BotigaServices serviceBotiga;
	
	
	/**
	 * método para crear un cuadro en una botiga en concreto.
	 * @param id  identificador de la botiga
	 * @param quadre el cuadro a guardar
	 * @param errors 
	 * @return El cuadro si se ha creado correctamente. o una lista de errores .
	 * 
	 */
	@RequestMapping(value = "/shops/{id}/pictures", method = RequestMethod.POST)
	public ResponseEntity<Object> addQuadre(@PathVariable Long id, @Valid @RequestBody Quadre quadre, BindingResult errors) {

		//Verificamos si existe la tienda
		if(serviceBotiga.existeTienda(id)) {
			//la tienda existe, pero verificamos ahora si los datos recibidos no tienen errores.
			if (errors.hasErrors())
				return ResponseEntity.ok().body(errors.getFieldError().getDefaultMessage()) ;	
		
			//Verificamos el límite de stock de la tienda.
			if ( serviceBotiga.datosBotiga(id).getCapacitatMax() > serviceQuadre.listadoQuadresByBotiga(id).size() ) {
				//Guardamos en el objeto quadre la tienda a la que pertenece y luego guardamos el quadre devolviendo los datos del mismo.
				quadre.setBotiga(serviceBotiga.datosBotiga(id));
				return ResponseEntity.ok().body(serviceQuadre.guardaQuadre(quadre));
			}
			return ResponseEntity.ok().body("La tienda ha alcanzado su límite de stock");
			
			
			//this.quadre = quadre;
			//	serviceBotiga.datosBotiga(id).map(botiga -> {
			//	System.out.println("en mapeo botiga es :"+botiga.toString());
							
		//	}).orElseThrow();
					
		}
		return ResponseEntity.ok().body("La tienda con ese id  no existe");			
	}
	/**
	 * Método que devuelve un body con el listado de cuadros de la tienda con id recibido por la url
	 * @param id
	 * @return
	 */
	@GetMapping("/shops/{id}/pictures")
	//public List<Quadre> listQuadres(@PathVariable Long id) {
	public ResponseEntity<Object> listQuadres(@PathVariable Long id) {
		
		if(serviceBotiga.existeTienda(id)) {
		    return ResponseEntity.ok().body(serviceQuadre.listadoQuadresByBotiga(id));	
		}			

	    return ResponseEntity.ok().body("La tienda no existe");		
	}
	/**
	 * Método que "Vende" todos los cuadros en caso de emergencia.
	 * @param id
	 * @return
	 */
	@RequestMapping( value = "/shops/{id}/pictures", method = RequestMethod.DELETE)
	public String quadresVendidos(@PathVariable Long id) {
		serviceQuadre.vendidosTodos(id);
		return "Quadres venuts tots";
	}
	
	/**
	 * Métod que devuelve un listado de cuadros por autor de toda la cadena de botigues.
	 * @param autor
	 * @return
	 */
	@GetMapping(value="/shops/{autor}")
	public List<Quadre> listPorAutor(@PathVariable String autor){
		
		return serviceQuadre.listadoPorAutor(autor);
	}
	
	/**
	 * Método que devuelve un listado de quadres para una tienda y un autor en concreto.
	 * @param id identificador de la tienda
	 * @param nombre del autor del cuadro.
	 * @return
	 */
	@GetMapping("/shops/{id}/pictures/{nombre}")
	public List<Quadre> listaPorAutorYBotiga(@PathVariable Long id, @PathVariable String nombre) {
		System.out.println(" daots pasados:  "+id+ "nombre "+nombre);
		return serviceQuadre.listadoPorAutorBotiga(nombre, id);
		
	}
	
	
}


/*

return postRepository.findById(postId).map(post -> {
            comment.setPost(post);
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }
*/
