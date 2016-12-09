package entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: Cell
 *
 */
@Entity

public class Cell implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int capacity;
	private static final long serialVersionUID = 1L;
	@ManyToMany(mappedBy = "guardedCells")
	private List<User> guardians;
	@OneToMany(mappedBy = "cell")
	private List<User> prisoners;

	public Cell() {
		super();
	}

	public Cell(int capacity) {
		super();
		this.capacity = capacity;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public List<User> getGuardians() {
		return guardians;
	}

	public void setGuardians(List<User> guardians) {
		this.guardians = guardians;
	}

	public List<User> getPrisoners() {
		return prisoners;
	}

	public void setPrisoners(List<User> prisoners) {
		this.prisoners = prisoners;
	}

}
