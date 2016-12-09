package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.Cell;
import entities.Guardian;
import entities.Prisoner;
import entities.User;

/**
 * Session Bean implementation class JailServices
 */
@Stateless
public class JailServices implements JailServicesRemote, JailServicesLocal {
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public JailServices() {
	}

	@Override
	public User findUserById(int userId) {
		return entityManager.find(User.class, userId);
	}

	@Override
	public void saveOrUpdateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void saveOrUpdateCell(Cell cell) {
		entityManager.merge(cell);
	}

	@Override
	public void deleteUser(int userId) {
		entityManager.remove(findUserById(userId));
	}

	@Override
	public User login(String login, String password) {
		User user = null;
		Query query = entityManager.createQuery("select u from User u where u.login=:param1 and u.password=:param2");
		query.setParameter("param1", login);
		query.setParameter("param2", password);
		try {
			user = (User) query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
		}
		return user;
	}

	@Override
	public List<Prisoner> findAllPrisoners() {
		return (List<Prisoner>) entityManager.createQuery("select p from Prisoner p ", Prisoner.class).getResultList();
	}

	@Override
	public List<Guardian> findAllGuardians() {
		return (List<Guardian>) entityManager.createQuery("select p from Guardian p ", Guardian.class).getResultList();
	}

	@Override
	public List<Cell> findCellByGuardian(int guardianId) {
		Guardian guardian = (Guardian) findUserById(guardianId);
		return entityManager.createQuery("select c from Cell c where :param member of c.guardians  ", Cell.class)
				.setParameter("param", guardian).getResultList();
	}

	@Override
	public List<Prisoner> findPrisonersByCell(int cellId) {
		return (List<Prisoner>) entityManager
				.createQuery("select p from Prisoner p where p.cell.id=:param", Prisoner.class)
				.setParameter("param", cellId).getResultList();
	}

	@Override
	public void assignPrisonerToCell(int prisonerId, int cellId) {
		Prisoner prisoner = (Prisoner) findUserById(prisonerId);
		Cell cell = findCellById(cellId);

		prisoner.setCell(cell);

		saveOrUpdateUser(prisoner);

	}

	@Override
	public Cell findCellById(int cellId) {
		return entityManager.find(Cell.class, cellId);
	}

	@Override
	public void assignGuardianToCell(int guardianId, int cellId) {
		Guardian guardian = (Guardian) findUserById(guardianId);
		Cell cell = findCellById(cellId);

		guardian.getGardedCells().add(cell);

		saveOrUpdateUser(guardian);

	}

}
