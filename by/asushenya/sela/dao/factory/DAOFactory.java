package by.asushenya.sela.dao.factory;


import by.asushenya.sela.dao.EquipmentsDAO;
import by.asushenya.sela.dao.UserDAO;
import by.asushenya.sela.dao.impl.EquipmentDAOImpl;
import by.asushenya.sela.dao.impl.UserDAOImpl;

public class DAOFactory {
	private static final DAOFactory daoFactory = new DAOFactory();
	
	private DAOFactory(){
	}
	
	private EquipmentsDAO equipmentsDAO = new EquipmentDAOImpl();
	private UserDAO userDAO = new UserDAOImpl();
	
	public EquipmentsDAO getEquipmentsDAO(){
		return equipmentsDAO;
	}
	
	public UserDAO getUserDAO(){
		return userDAO;
	}
	
	public static DAOFactory getInstance(){
		return daoFactory;
	}
}
