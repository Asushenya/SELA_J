package by.asushenya.sela.service.impl;

import by.asushenya.sela.bean.Good;
import by.asushenya.sela.bean.User;
import by.asushenya.sela.service.service.ClientService;
import by.asushenya.sela.dao.factory.DAOFactory;
import by.asushenya.sela.dao.UserDAO;
import by.asushenya.sela.dao.exception.DAOException;

import by.asushenya.sela.service.exception.ServiceException;
public class ClientServiceImpl implements ClientService {
	
	@Override 
	public void registration(User user) throws ServiceException {
		
		if( user.getLogin()    == null ||
		    user.getPassword() == null)
		throw new ServiceException("Incorrect user");
		 
	try{
		
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		UserDAO userDAO = daoFactoryObject.getUserDAO();
		userDAO.registeredNewUser(user);
		
	} catch(DAOException e){
			throw new ServiceException(e);
		}
	}
	
	@Override 
	public void rentEquipment(User user, Good good) throws ServiceException {
		
		if(user.getId() == 0 )
		throw new ServiceException("Incorrect user");	
		
		if(good.getId()     == 0    ||
		   good.getAmount() == 0)
		throw new ServiceException("Incorrect good");		
		
	try{
		
		DAOFactory daoFactoryObject = DAOFactory.getInstance();
		UserDAO userDAO = daoFactoryObject.getUserDAO();
		userDAO.rentEquipment(user, good);
		
	} catch(DAOException e){
			throw new ServiceException(e);
		}
	}
}
