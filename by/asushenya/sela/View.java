package by.asushenya.sela;

import by.asushenya.sela.controller.Controller;

public class View {

	public static void main(String[] args) {
	
		Controller controller = new Controller();
		System.out.println(controller.executeTask("GET_OWER_REPORT ")); 

	}

}
