package M13SpringRestApi.entity;

import java.util.Calendar;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;




/**
 * Clase DAO Quadre.
 * Indicamos con la anotación JPA @Entity a Spring que se trata de una entidad y la agrega al contenedor.
 *  
 * @author Rubén Rodríguez
 * 
 *
 */

@Entity   
public class Quadre extends EntidadBase {
	
	
	private static final long serialVersionUID = 1L;
	
	
	// Utilizaremos diferentes anotaciones, como práctica mientras cumpla los requisitos del problema a solucionar.
	
	@Column(name = "nomAutor")
    @Size(min = 4, max = 50)
	@NotBlank
	private String nombreAutor;
	
	@Positive
	private double preuQuadre;
	
	@CreationTimestamp
	@Temporal(TemporalType.DATE)
	@Column(name = "dataRegistre")
	//@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy", timezone="CET+1")	
	private Calendar dataEntrada;
	
	/*
	 * Aquí es donde establecemos la relación entre las tablas. en este caso de muchos a uno, ya que una botiga puede tener muchos cuadros.
	 * 
	 */
    //@JsonManagedReference
	@ManyToOne(targetEntity = Botiga.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH })
	@JoinColumn(name="id_botiga")
	private Botiga botiga;
	
	
	//Getters y Setters
	
	
	public String getNombreAutor() {
		return nombreAutor;
	}


	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}


	public double getPreuQuadre() {
		return preuQuadre;
	}


	public void setPreuQuadre(double preuQuadre) {
		this.preuQuadre = preuQuadre;
	}


	public Calendar getDataEntrada() {
		return dataEntrada;
	}


	public void setDataEntrada(Calendar dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	/**
	 * Método que devuelve el nombre de la tienda en lugar de todo el objeto. Si devulviera todo el objeto etnraría en
	 * un bucle infinito debido a la llamada recursiva de un objeto a otro. Aunque se podría solventar ese bucle 
	 * con alguna anotación, com queremos tener el nombre de la tienda en el tostring, devolvemos una cadena.
	 * @return
	 */
	public String getBotiga() {
		return botiga.getNombreTienda();
	}


	public void setBotiga(Botiga botiga) {
		this.botiga = botiga;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Quadre [nombreAutor=" + nombreAutor + ", preuQuadre=" + preuQuadre + ", dataEntrada=" + dataEntrada
				+ ", Botiga=" +botiga+"]";
	}
	
	
	
}
