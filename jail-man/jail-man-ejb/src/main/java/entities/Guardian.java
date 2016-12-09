package entities;

import java.io.Serializable;

import javax.persistence.Entity;

/**
 * Entity implementation class for Entity: Gardian
 *
 */
@Entity

public class Guardian extends User implements Serializable {

	private int experience;
	private static final long serialVersionUID = 1L;

	public Guardian() {
		super();
	}

	public Guardian(String name, String login, String password, int experience) {
		super(name, login, password);
		this.experience = experience;
	}

	public int getExperience() {
		return this.experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

}
