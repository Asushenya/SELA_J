package by.asushenya.sela.service.factory;

import by.asushenya.sela.service.impl.ClientServiceImpl;
import by.asushenya.sela.service.impl.ShopServiceImpl;
import by.asushenya.sela.service.service.ShopService;
import by.asushenya.sela.service.service.ClientService;

public class ServiceFactory {

	private static final ServiceFactory instance = new ServiceFactory();
	
	private ShopService shopService = new ShopServiceImpl();
	private ClientService clientService = new ClientServiceImpl();
	
	private ServiceFactory(){
		
	}
	
	public ShopService getShopService(){
		return shopService;
	}
	
	public ClientService getClientService(){
		return clientService;
	}
	
	public static ServiceFactory getInstance(){
		return instance;
	}
}
