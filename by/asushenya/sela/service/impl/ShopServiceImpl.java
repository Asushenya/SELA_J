package by.asushenya.sela.service.impl;

import java.util.List;

import by.asushenya.sela.bean.Ower;
import by.asushenya.sela.bean.Equipment;
import by.asushenya.sela.service.service.ShopService;
import by.asushenya.sela.dao.factory.DAOFactory;
import by.asushenya.sela.dao.EquipmentsDAO;
import by.asushenya.sela.dao.exception.DAOException;
import by.asushenya.sela.service.exception.ServiceException;

public class ShopServiceImpl implements ShopService {

	@Override 
	public List<Ower> getOwerReport() throws ServiceException{
	try{
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		EquipmentsDAO equipmentsDAO = daoObjectFactory.getEquipmentsDAO();
		
		return equipmentsDAO.getOwerReport();
		
		} catch(DAOException e){
			throw new ServiceException(e);
		}
	
	}
	
	@Override
	public void addNewEquipment(Equipment equipment) throws ServiceException{
		
		if(equipment.getName()     == null  ||
		   equipment.getKind()     == null  ||
		   equipment.getQuantity() == 0)
		throw new ServiceException("Equipment is incorrect");
		
		try{
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			EquipmentsDAO equipmentsDAO = daoObjectFactory.getEquipmentsDAO();
			equipmentsDAO.addEquipment(equipment);
			
		} catch(DAOException e){
			throw new ServiceException (e);
		}
	}
}
