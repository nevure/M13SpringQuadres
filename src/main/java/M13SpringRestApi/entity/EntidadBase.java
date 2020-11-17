/**
 * 
 */
package M13SpringRestApi.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 
 * Esta clase es la superclase de las entidades de nuestra aplicación.
 * Bueno, no es del todo necesaria pero la creamos como algo didáctico.
 * 
 * Aquí solo tenemos el id, ya que tanto la entidad quadre como botiga tienen un id autoincremental y clave.
 * @author Rubén rodríguez Fernández
 * 
 * 
 *
 */

/*
 * Se mapeará como cualquier otra clase, pero  se aplicará a las  subclases, 
 * puesto que esta entidad no tiene una tabla asociada.
 */
@MappedSuperclass
public class EntidadBase  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	
}
