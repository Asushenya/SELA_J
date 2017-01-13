package by.asushenya.sela.controller.command.impl;

import by.asushenya.sela.controller.command.Command;
import by.asushenya.sela.service.exception.ServiceException;
import by.asushenya.sela.service.factory.ServiceFactory;
import by.asushenya.sela.service.service.ShopService;
import by.asushenya.sela.bean.Equipment;
import by.asushenya.sela.bean.Ower;

import java.util.List;

public class GetOwerReport implements Command {
	
	@Override
	public String execute (String request){
		String response;
		
		ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
		ShopService shopService = serviceFactoryObject.getShopService();
		
		try{
			List<Ower> owerList = shopService.getOwerReport();
			
			for(Ower ower : owerList){
				System.out.print (ower.getUser().getLogin());
				
					for(Equipment item: ower.getEquipments()){
						
						System.out.print(" "+item.getName());
						System.out.print(" "+item.getQuantity());
					}
					System.out.println();
			}
			response = Integer.toString(owerList.size());
			return response;
			
		} catch(ServiceException e){
			response = e.getMessage();
		}
		
		return null;
		}

}
