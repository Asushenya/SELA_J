package by.asushenya.sela.dao.impl;

import by.asushenya.sela.dao.EquipmentsDAO;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import by.asushenya.sela.bean.Equipment;
import by.asushenya.sela.bean.User;
import by.asushenya.sela.bean.Ower;
import by.asushenya.sela.dao.exception.DAOException;
import java.util.List;

import com.mysql.jdbc.util.ResultSetUtil;

import java.util.ArrayList;

public class EquipmentDAOImpl implements  EquipmentsDAO{
	
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	
	static {
		try{
			Class.forName("org.gjt.mm.mysql.Driver");
		} catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void addEquipment(Equipment equipment) throws DAOException{	
		
		try{
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/equipments","root","1111");
			String sql = "insert into equipment ( name, kind, cost, quantity) values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, equipment.getName());
			ps.setString(2, equipment.getKind());
			ps.setFloat(3, equipment.getCost());
			ps.setInt(4, equipment.getQuantity());
		
			ps.executeUpdate();
		} catch (SQLException e){
			
			throw new DAOException ("DAOException addEquipment: "+e.getMessage());
			
			} finally{
				try{
					if(rs != null){rs.close();}
					if(st != null){st.close();}
					if(con != null){con.close();}
			}catch (SQLException e){
				throw new DAOException("DAOException addEquipment: "+e.getMessage());
				
			}
		}	
	}
	
	@Override 
	public List<Ower> getOwerReport() throws DAOException{
		List<Ower> owerList = new ArrayList<Ower>();
		try{
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/equipments","root","1111");
			
			st = con.createStatement();
			rs = st.executeQuery("select user_id from rent where is_rented = true group by user_id;");
			
			while(rs.next()){
				Statement getUserByIdStatement = con.createStatement();
				ResultSet userResultSet = getUserByIdStatement.executeQuery("select * from user where id = "+rs.getInt(1));
				
				userResultSet.next();
				User user = new User(userResultSet.getInt(1),
									 userResultSet.getString(2),
									 userResultSet.getString(3));
				
				Statement getOwerEquipment = con.createStatement();
				ResultSet owerEquipmentResultSet = getOwerEquipment.executeQuery("select equipment_id,equipment.name, equipment.kind,  equipment.cost , equipment_amount  from rent join equipment on equipment.id = rent.equipment_id where user_id = "+user.getId()+" and is_rented = true;");
			
				owerEquipmentResultSet.last();
				int i= owerEquipmentResultSet.getRow();				
				Equipment[] owerEquipmentArray = new Equipment[i];
				
				owerEquipmentResultSet.beforeFirst();
				
				int equipmentCounter = 0;
				while(owerEquipmentResultSet.next()){
					owerEquipmentArray[equipmentCounter++] = new Equipment(owerEquipmentResultSet.getInt(1),
																		   owerEquipmentResultSet.getString(2),
																		   owerEquipmentResultSet.getString(3),
																		   owerEquipmentResultSet.getFloat(4),
																		   owerEquipmentResultSet.getInt(5));
				}
				
				Ower ower = new Ower();
				ower.setUser(user);
				ower.setEquipments(owerEquipmentArray);
				
				owerList.add(ower);
			}
			
			return owerList;
		} catch (SQLException e){
			
			throw new DAOException("DAOException getOwerReport: "+e.getMessage());
			
			} finally{
				try{
					if(rs != null){rs.close();}
					if(st != null){st.close();}
					if(con != null){con.close();}
			       }catch (SQLException e){
			    	   throw new DAOException("DAOException getOwerReport: "+e.getMessage());			
			}
		}
	}
	
}
