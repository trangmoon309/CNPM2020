package CNPM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Vacxin {
	private String idVaccine;
	private String tenvaccine;
	private int soluong;
	private List<Vacxin> vaccine = new ArrayList<Vacxin>();
	public List<Vacxin> getvaccine(){
		return this.vaccine;
	}
	
	public Vacxin() {
		
	}
	
	public Vacxin(String idVaccine, String tenvaccine, int soluong) {
		super();
		this.idVaccine = idVaccine;
		this.tenvaccine = tenvaccine;
		this.soluong = soluong;
	}


	public String getIdVaccine() {
		return idVaccine;
	}


	public void setIdVaccine(String idVaccine) {
		this.idVaccine = idVaccine;
	}


	public String getTenvaccine() {
		return tenvaccine;
	}


	public void setTenvaccine(String tenvaccine) {
		this.tenvaccine = tenvaccine;
	}


	public int getSoluong() {
		return soluong;
	}


	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	@Override
	public String toString() {
		return  String.format("Vacxin[idVaccine = %s,  tenvaccine= %s,  soluong= %d ]", idVaccine, tenvaccine, soluong);
	}

	Connection conn = null;

	//Edit By Trang
	public String getIDByAnimalName(String animalName) {
		Animal a = new Animal();
		String id = "";
		String idVatNuoi = a.getIDByAnimalName(animalName);
		try {
			conn = Connect_DB.getSQLServer();
			String query = "  select idVaccine from dbo.Vaccine_r where idVatNuoi= '" + idVatNuoi + "'";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				id = rs.getString("idVaccine");
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return id;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * "idVaccine" null NOT NULL,
	"tenVaccine" null,
	"soluong" INT,
 */
