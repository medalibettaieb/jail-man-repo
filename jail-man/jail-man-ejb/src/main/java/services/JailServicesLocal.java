package services;

import java.util.List;

import javax.ejb.Local;

import entities.Cell;
import entities.Guardian;
import entities.Prisoner;
import entities.User;

@Local
public interface JailServicesLocal {
	void saveOrUpdateUser(User user);

	void saveOrUpdateCell(Cell cell);

	void deleteUser(int userId);

	User findUserById(int userId);

	User login(String login, String password);

	List<Prisoner> findAllPrisoners();

	List<Guardian> findAllGuardians();

	List<Cell> findCellByGuardian(int guardianId);

	List<Prisoner> findPrisonersByCell(int cellId);

	void assignPrisonerToCell(int prisonerId, int cellId);

	Cell findCellById(int cellId);

	void assignGuardianToCell(int guardianId, int cellId);
}
