package example.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "SIMPLE")
public class Simple
{
	@JsonCreator
	public Simple(@JsonProperty("changeable") String changeable)
	{
		this.changeable = changeable;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID")
	@SequenceGenerator(name = "ID", sequenceName = "ID", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Version
	@Column(name = "VERSION")
    private int version;
	
	@Column(name = "CHANGEABLE")
	private String changeable;
}
