package by.asushenya.sela.dao;

import by.asushenya.sela.bean.Good;
import by.asushenya.sela.bean.User;
import by.asushenya.sela.dao.exception.DAOException;

public interface UserDAO {
	void registeredNewUser(User user)		     throws DAOException;
	void rentEquipment    (User user, Good good) throws DAOException;
}
