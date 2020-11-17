package M13SpringRestApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import M13SpringRestApi.entity.Botiga;
import M13SpringRestApi.services.BotigaServices;

/**
 * 
 * Clase controlador para la Botiga
 * 
 * @author Rubén Rodríguez
 *
 */
@RestController
public class BotigaController {

	//inyectamos el servicio de Botiga.
	@Autowired
	BotigaServices servicioBotiga;

	
	/**
	 * Método Create que recoge del body una tienda y llama al servicioBotiga para almacenarlo en la BBDD
	 * @param botiga
	 * @param errors
	 * @return el Body con los datos de la botiga o bien una lista de errores de validación
	 */
	@PostMapping("/shops")
	public ResponseEntity<Object> addBotiga(@Valid @RequestBody Botiga botiga, BindingResult errors) {
		
		
			if (errors.hasErrors())
				return ResponseEntity.ok().body(errors.getFieldError().getDefaultMessage()) ;	
			
			servicioBotiga.guardarBotiga(botiga);
			return ResponseEntity.ok().body(botiga);	
    }
	
	/**
	 * Método que devuelve una lista de botigas al body.
	 * @return
	 */
	@RequestMapping(value = "/shops", method = RequestMethod.GET)
	public List<Botiga> listBotigues() {
		return servicioBotiga.listadoBotigas();
	}	
	
	
	
	/**
	 * Manejo de la excepción HttpMessageNotReadableException para requestBody erróneos.
	 */
	@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "CUSTOM MESSAGE HERE")
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public void handleException() {
		System.out.println("Error envio datos. Datos erróneos. Bien se envía un string para un campo int u otro error de formato.");
	}
}

/**
@InitBinder
public void setAllowedFields(WebDataBinder dataBinder) {
    dataBinder.setDisallowedFields("id");
}
*/