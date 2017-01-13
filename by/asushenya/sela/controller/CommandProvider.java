package by.asushenya.sela.controller;

import java.util.HashMap;
import java.util.Map;

import by.asushenya.sela.controller.command.Command;
import by.asushenya.sela.controller.command.impl.CommandName;

import by.asushenya.sela.controller.command.impl.RegisteredNewUser;
import by.asushenya.sela.controller.command.impl.RentEquipment;
import by.asushenya.sela.controller.command.impl.AddNewEquipment;
import by.asushenya.sela.controller.command.impl.GetOwerReport;
import by.asushenya.sela.controller.command.impl.WrongRequest;

public class CommandProvider {
	
	private final Map<CommandName, Command> repository = new HashMap<>();

	CommandProvider(){
		repository.put(CommandName.REGISTERED_NEW_USER, new RegisteredNewUser());
		repository.put(CommandName.RENT_EQUIPMENT,      new RentEquipment());
		repository.put(CommandName.ADD_NEW_EQUIPMENT,   new AddNewEquipment());
		repository.put(CommandName.GET_OWER_REPORT, 	new GetOwerReport());
	    repository.put(CommandName.WRONG_REQUEST,       new WrongRequest());
	}
	
	Command getCommand (String name){
		CommandName commandName = null;
		Command command = null;
		
		try{
			commandName = CommandName.valueOf(name.toUpperCase());
			command = repository.get(commandName);
		} catch(IllegalArgumentException | NullPointerException e){
			
			command = repository.get(CommandName.WRONG_REQUEST);
		}
		return command;
	}
}
