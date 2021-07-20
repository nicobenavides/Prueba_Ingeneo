package co.com.ingeneo.nicocine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Entity(name="ROL")
@Table
public class Rol {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column (name = "id_rol")
	private Long id;
	@Column(name = "tipo")
	private String tipo;

}
