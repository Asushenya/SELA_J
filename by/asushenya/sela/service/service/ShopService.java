package by.asushenya.sela.service.service;

import java.util.List;

import by.asushenya.sela.bean.Equipment;
import by.asushenya.sela.bean.Ower;
import by.asushenya.sela.service.exception.ServiceException;

public interface ShopService {
	List<Ower> getOwerReport() 					 throws ServiceException;
	void addNewEquipment(Equipment newEquipment) throws ServiceException;
}
