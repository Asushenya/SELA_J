package by.asushenya.sela.controller.command.impl;

import by.asushenya.sela.controller.command.Command;
import by.asushenya.sela.service.factory.ServiceFactory;
import by.asushenya.sela.service.service.ClientService;
import by.asushenya.sela.bean.User;
import by.asushenya.sela.service.exception.ServiceException;

public class RegisteredNewUser implements Command{
	
	@Override
	public String execute(String request){
		String login = null;
		String password = null;
		
		String response = null;
		
		String [] initParams = request.split(" ");
		login    = initParams[1];
		password = initParams[2];
		
		ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
		ClientService clientService = serviceFactoryObject.getClientService();
		
		try{			
			clientService.registration(new User(login, password));
			response = "New user successfully registered";
			
		} catch(ServiceException e){
			
			response = "Error duiring Registered new user procedure"+e.getMessage();
		}
		
		return response;	
	}
}
