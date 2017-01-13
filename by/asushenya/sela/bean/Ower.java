package by.asushenya.sela.bean;

import java.util.List;

public class Ower {
	User user;
	Equipment[] equipments;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Equipment getEquipments(int index) {
		return equipments[index];
	}
	public Equipment[] getEquipments(){
		return equipments;
	}
	public void setEquipments(Equipment[] equipments) {
		this.equipments = equipments;
	}

	
}
