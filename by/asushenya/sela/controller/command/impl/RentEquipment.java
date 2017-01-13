package by.asushenya.sela.controller.command.impl;

import by.asushenya.sela.controller.command.Command;

import by.asushenya.sela.service.factory.ServiceFactory;
import by.asushenya.sela.service.service.ClientService;

import by.asushenya.sela.bean.User;
import by.asushenya.sela.bean.Good;

import by.asushenya.sela.service.exception.ServiceException;


public class RentEquipment implements Command {
	
	@Override
	public String execute(String request){
		
		int user_id;
		int equipment_id;
		float equipment_price;
		int equipment_amount;
		
		String response = null;
		
		String [] initParams = request.split(" ");
		
		user_id          = Integer.parseInt(initParams[1]);
		equipment_id     = Integer.parseInt(initParams[2]);
		equipment_price  = Float.parseFloat(initParams[3]);
		equipment_amount = Integer.parseInt(initParams[4]);
		
		ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
		ClientService clientService = serviceFactoryObject.getClientService();
		
		User user = new User();
		user.setId(user_id);
		
		Good good = new Good();
		good.setId(equipment_id);
		good.setPrice(equipment_price);
		good.setAmount(equipment_amount);
		
		try{
			clientService.rentEquipment(user, good);
			response = "Equipment is successfylly rented";
		} catch(ServiceException e){
			response = "Error duiring Rent Equipment procedure "+e.getMessage();
		}
		return response;
	}

}
