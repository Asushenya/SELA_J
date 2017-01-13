package by.asushenya.sela.dao;

import java.util.List;

import by.asushenya.sela.bean.Equipment;
import by.asushenya.sela.bean.Ower;
import by.asushenya.sela.dao.exception.DAOException;

public interface EquipmentsDAO {
	void addEquipment(Equipment newEquipment) throws DAOException;
	List<Ower> getOwerReport() 				  throws DAOException;
}
