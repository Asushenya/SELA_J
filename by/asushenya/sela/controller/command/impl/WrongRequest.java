package by.asushenya.sela.controller.command.impl;

import by.asushenya.sela.controller.command.Command;

public class WrongRequest implements Command {

	@Override 
	public String execute (String request){
		
		return "Bad Command";
	}
}
