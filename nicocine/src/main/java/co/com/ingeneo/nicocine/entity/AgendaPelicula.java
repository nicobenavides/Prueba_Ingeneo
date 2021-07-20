package co.com.ingeneo.nicocine.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="AGENDA_PELICULA")
@Table
public class AgendaPelicula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id")
	private Long id;	
	
    @JoinColumn(name = "empleado_id")
    @OneToOne(fetch = FetchType.LAZY)
	private Empleado administrador;
    
    @JoinColumn(name = "sala_id")
    @OneToOne(fetch = FetchType.LAZY)
	private Sala sala;
    
	
}
