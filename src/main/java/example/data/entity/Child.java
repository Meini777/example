package example.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CHILD")
public class Child
{
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CHILD_ID")
	@SequenceGenerator(name = "CHILD_ID", sequenceName = "CHILD_ID", allocationSize = 1)
	@Column(name = "CHILD_ID")
	private Long id;
	
//  NO VERSION! Parent version should be incremented on change	
//	@Version
//	@Column(name = "VERSION")
//  private int version;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "PARENT_ID", referencedColumnName = "PARENT_ID")
	private Parent parent;
	
	@Column(name = "CHANGEABLE")
	private String changeable;
}
