package by.asushenya.sela.service.service;

import by.asushenya.sela.bean.User;
import by.asushenya.sela.bean.Good;
import by.asushenya.sela.service.exception.ServiceException;

public interface ClientService {
	void registration(User user)		    throws ServiceException;
	void rentEquipment(User user,Good good) throws ServiceException;
}
