package M13SpringRestApi.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;



/**
 * Clase entidad Botiga.
 * Extendemos de la superclase EntidadÇBase de donde obtenemos el id. por l que aquí no hace falta declarar la propiedad.
 * 
 * @author Rubén Rodríguez Fernández
 *
 */

@Entity
public class Botiga  extends EntidadBase {
	
	
	private static final long serialVersionUID = 1L;

	
	@NotBlank (message= "La tienda debe tener un nombre")
	@Column(name="nomBotiga")
	private String nombreTienda;
	
	//Mapeo con la tabla Quadre donde la propiedad join se llama "botiga". Declaramos también los efectos en cascada que tendrá. 
   // @JsonBackReference
	@OneToMany(mappedBy = "botiga", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	List<Quadre> quadres = new ArrayList<Quadre>();

	
	//GETTERs y SETTERs
	
	
	public String getNombreTienda() {
		return nombreTienda;
	}

	public void setNombreTienda(String nombreTienda) {
		this.nombreTienda = nombreTienda;
	}

	public int getCapacitatMax() {
		return capacitatMax;
	}

	public void setCapacitatMax(int capacitatMax) {
		this.capacitatMax = capacitatMax;
	}

	private int capacitatMax;
	
	

	public List<Quadre> getQuadres() {
		return quadres;
	}

	public void setQuadres(List<Quadre> quadres) {
		this.quadres = quadres;
	}
	
	//Constructores y ToString
	
	
	public Botiga() {
		
	}
	
	
	public Botiga(String nom, int capacitat) {
		this.nombreTienda = nom;
		this.capacitatMax = capacitat;
	}
	@Override
	public String toString() {
		return "Botiga [nombreTienda=" + nombreTienda + ", capacitatMax=" + capacitatMax + ", quadres=" + quadres + "]";
	}

}
