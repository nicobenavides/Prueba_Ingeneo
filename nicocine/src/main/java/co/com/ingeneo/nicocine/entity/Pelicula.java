package co.com.ingeneo.nicocine.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="Pelicula")
@Table
public class Pelicula {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre_original")
	private String  nombreOriginal;
	
	@Column(name = "nombre_traducido")
	private String  nombreTraducido;
	
	@Column(name = "fecha_estereno")
	private Date  fechaEstereno;
	
	@Column(name = "fecha_baja")
	private Date  fechaBaja;
	
	@Column(name = "portada")
	private Long  portada;
	
	@Column(name = "generos")
	private String  generos;
	
	@Column(name = "sinopsis")
	private String  sinopsis;
	
	@OneToOne(optional = false, fetch = FetchType.EAGER)
	private Formato  formato;
	
	@Column(name = "sucursales")
	private String  sucursales;
	
	@Column(name = "duracion")
	private String  duracion;
	
	

}
