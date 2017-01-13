package by.asushenya.sela.controller;

import by.asushenya.sela.controller.command.Command;

public class Controller {
	private final CommandProvider provider = new CommandProvider();
	
	private final char paramDelimeter = ' ';
	
	public String executeTask(String request){
		String commandName = null;
		Command executionCommand = null;
		
		String response;
		
		try{
			commandName = request.substring(0,request.indexOf(paramDelimeter));
			
		} catch(IndexOutOfBoundsException e){
			response = "incorrect request (controller)";
			return response+ ": " +e.getMessage();
		}
				
		executionCommand = provider.getCommand(commandName);
		
		try{
			response = executionCommand.execute(request);
			
		} catch(NullPointerException e){
			
			response = "NullPointer excecution command (controller)";
		}	
		
		return response;
	}
}
