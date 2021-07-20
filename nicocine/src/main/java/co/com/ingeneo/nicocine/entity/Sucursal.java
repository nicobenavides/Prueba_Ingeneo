package co.com.ingeneo.nicocine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="SUCURSAL")
@Table
public class Sucursal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id_sucursal")
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	// Que columna en la tabla Tuition tiene la FK
    @JoinColumn(name = "id_empleado")
    @OneToOne(fetch = FetchType.LAZY)
	private Empleado administrador;
	@Column(name = "id_ciudad")
	private Long ciudad;
	@Column(name = "direccion")
	private String direccion;

}
