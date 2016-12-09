package entities;

import entities.User;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Prisoner
 *
 */
@Entity

public class Prisoner extends User implements Serializable {

	
	private int yearsOfConviction;
	private static final long serialVersionUID = 1L;

	public Prisoner() {
		super();
	}
	
	public Prisoner(String name, String login, String password, int yearsOfConviction) {
		super(name, login, password);
		this.yearsOfConviction = yearsOfConviction;
	}

	public int getYearsOfConviction() {
		return this.yearsOfConviction;
	}

	public void setYearsOfConviction(int yearsOfConviction) {
		this.yearsOfConviction = yearsOfConviction;
	}
   
}
