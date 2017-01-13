package by.asushenya.sela.dao.impl;

import by.asushenya.sela.dao.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.asushenya.sela.bean.Good;
import by.asushenya.sela.bean.User;
import by.asushenya.sela.dao.exception.DAOException;

public class UserDAOImpl implements UserDAO {

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
	public void registeredNewUser(User user) throws DAOException{
		try{
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/equipments","root","1111");
			String sql = "insert into user ( login, password) values(?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
		
			ps.executeUpdate();
		} catch (SQLException e){		
	
			throw new DAOException ("DAOException registeredNewUser: "+e.getMessage());
			
			} finally{
				try{
					if(rs != null){rs.close();}
					if(st != null){st.close();}
					if(con != null){con.close();}
			}catch (SQLException e){
				throw new DAOException ("DAOException registeredNewUser: "+e.getMessage());
			}
		}	
	}
	

	@Override
	public void rentEquipment(User user, Good good) throws DAOException {
		try{
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/equipments","root","1111");
			String sql = "insert rent ( user_id, equipment_id, equipment_amount, rent_cost, date_from, is_rented) values(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			ps.setInt(2, good.getId());
			ps.setInt(3, good.getAmount());
			ps.setFloat(4, good.getAmount() * good.getPrice());
			ps.setTimestamp(5, new java.sql.Timestamp(new java.util.Date().getTime()));
			ps.setBoolean(6, true);
		
			ps.executeUpdate();
		} catch (SQLException e){
			throw new DAOException ("DAOException rentEquipment: "+e.getMessage());
			
			} finally{
				try{
					if(rs != null){rs.close();}
					if(st != null){st.close();}
					if(con != null){con.close();}
			}catch (SQLException e){
				throw new DAOException ("DAOException rentEquipment: "+e.getMessage());
				
			}
		}	
		
	}
}
