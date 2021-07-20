package co.com.ingeneo.nicocine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name="Fila")
@Table
public class Fila {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
	@Column(name = "id")
	private Long id;
	@Column(name = "nombre")
	private char nombre;
	@ManyToOne()
    @JoinColumn(name = "sala_id")
	private Sala sala;
	@Column(name = "sillas")
	private Long sillas;
}
