package by.asushenya.sela.controller.command.impl;

import by.asushenya.sela.controller.command.Command;

import by.asushenya.sela.service.factory.ServiceFactory;
import by.asushenya.sela.service.service.ShopService;

import by.asushenya.sela.bean.Equipment;

import by.asushenya.sela.service.exception.ServiceException;

public class AddNewEquipment implements Command {
	
	@Override
	public String execute (String request){
		
		String title;
		String kind;
		float  price;
		int    quantity;
		
		String responce;
		
		String [] initParams = request.split(" ");
		title = initParams[1];
		kind = initParams[2];
		price = Float.parseFloat(initParams[3]);
		quantity = Integer.parseInt(initParams[4]);
		
		ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
		ShopService    shopService = serviceFactoryObject.getShopService();
		
		try{
			shopService.addNewEquipment(new Equipment(title, kind, price, quantity));
			responce = "New Equipment is successfylly added";
			
		} catch(ServiceException e){
			responce = "Error duiring Add New Equipment procedure "+e.getMessage();
		}
		
		return responce;
	}

}
