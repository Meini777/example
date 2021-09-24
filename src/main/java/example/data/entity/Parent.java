package example.data.entity;

import java.util.Collection;
import java.util.LinkedHashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name = "PARENT")
public class Parent
{
	@JsonCreator
	public Parent(@JsonProperty("changeable") String changeable)
	{
		this.changeable = changeable;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARENT_ID")
	@SequenceGenerator(name = "PARENT_ID", sequenceName = "PARENT_ID", allocationSize = 1)
	@Column(name = "PARENT_ID")
	private Long id;
	
	@Version
	@Column(name = "VERSION")
    private int version;
	
	@OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<Child> children = new LinkedHashSet<>();
	
	@Column(name = "CHANGEABLE")
	private String changeable;
}
