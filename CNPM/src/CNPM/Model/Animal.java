package CNPM.Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Animal {
	private String idVatnuoi;
	private String tenVatnuoi;
	
	private static List<Animal> anis = new ArrayList<Animal>();
	
	public static List<Animal> getAnimals() throws SQLException{
		Connection conn = null;
		String url = "select * from dbo.Animal";
		Statement st = conn.createStatement();
		ResultSet rs= st.executeQuery(url);
		while(rs.next()) {
			Animal item = new Animal(rs.getString("idVatNuoi"),rs.getString("Vatnuoi_name"));
			anis.add(item);
		}
		return anis;
	}
	
	public String getIdVatnuoi() {
		return idVatnuoi;
	}


	public void setIdVatnuoi(String idVatnuoi) {
		this.idVatnuoi = idVatnuoi;
	}

	public String getTenVatnuoi() {
		return tenVatnuoi;
	}


	public void setTenVatnuoi(String tenVatnuoi) {
		this.tenVatnuoi = tenVatnuoi;
	}


	public Animal(String idVatnuoi, String tenVatnuoi) {
		super();
		this.idVatnuoi = idVatnuoi;
		this.tenVatnuoi = tenVatnuoi;
	}
	@Override
	public String toString() {
	 return String.format("Animal[idVatnuoi = %s, tenVatnuoi = %s]", idVatnuoi, tenVatnuoi);
}
	static Connection conn = null;
	//Edit By Trang
		public Animal() {
			
		}
		public static String getIDByAnimalName(Connection conn, String animalName) {
			String id = "";
				String query = " select idVatNuoi from dbo.Animal where Vatnuoi_name='" + animalName + "'";

				try {
					Statement st = conn.createStatement();
					ResultSet rs;
					rs = st.executeQuery(query);
					while(rs.next()) {
						id = rs.getString("idVatNuoi");
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			return id;
		}
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
