package services;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import entities.Cell;
import entities.Guardian;
import entities.Prisoner;

/**
 * Session Bean implementation class Util
 */
@Singleton
@LocalBean
@Startup
public class Util {
	@EJB
	private JailServicesLocal jailServicesLocal;

	/**
	 * Default constructor.
	 */
	public Util() {
	}

	@PostConstruct
	public void initDb() {
		Prisoner prisoner = new Prisoner("slah", "sa", "sa", 20);
		Prisoner prisoner2 = new Prisoner("karim", "ka", "ka", 25);
		Prisoner prisoner3 = new Prisoner("ammar", "am", "am", 12);

		Guardian guardian = new Guardian("med ali", "m", "m", 50);
		Guardian guardian2 = new Guardian("salma", "s", "s", 50);

		Cell cell = new Cell(200);
		Cell cell2 = new Cell(6);
		jailServicesLocal.saveOrUpdateUser(prisoner);
		jailServicesLocal.saveOrUpdateUser(prisoner2);
		jailServicesLocal.saveOrUpdateUser(prisoner3);
		jailServicesLocal.saveOrUpdateUser(guardian);
		jailServicesLocal.saveOrUpdateUser(guardian2);

		jailServicesLocal.saveOrUpdateCell(cell);
		jailServicesLocal.saveOrUpdateCell(cell2);
	}

}
