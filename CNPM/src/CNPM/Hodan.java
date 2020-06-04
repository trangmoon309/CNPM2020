package CNPM;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Hodan {
	
	private List<Hodan> hodan = new ArrayList<Hodan>();
	private String idHodan;
	private String idVatnuoi;
	private String Username;
	private String Password;
	private String Fullname;
	private String Dob;
	private String Gender;
	private String Phonenumber;
	private String Address;
	
	
	public List<Hodan>  gethodan(){
		return this.hodan;
	}
	public String getIdHodan() {
		return idHodan;
	}


	public void setIdHodan(String idHodan) {
		this.idHodan = idHodan;
	}


	public String getIdVatnuoi() {
		return idVatnuoi;
	}


	public void setIdVatnuoi(String idVatnuoi) {
		this.idVatnuoi = idVatnuoi;
	}


	public String getUsername() {
		return Username;
	}


	public void setUsername(String username) {
		Username = username;
	}


	public String getPassword() {
		return Password;
	}


	public void setPassword(String password) {
		Password = password;
	}


	public String getFullname() {
		return Fullname;
	}


	public void setFullname(String fullname) {
		Fullname = fullname;
	}


	public String getDob() {
		return Dob;
	}


	public void setDob(String dob) {
		Dob = dob;
	}


	public String getGender() {
		return Gender;
	}


	public void setGender(String gender) {
		Gender = gender;
	}


	public String getPhonenumber() {
		return Phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		Phonenumber = phonenumber;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	
	 

	public Hodan(String idHodan, String idVatnuoi, String username, String password, String fullname, String dob,
			String gender, String phonenumber, String address) {
		super();
		this.idHodan = idHodan;
		this.idVatnuoi = idVatnuoi;
		Username = username;
		Password = password;
		Fullname = fullname;
		Dob = dob;
		Gender = gender;
		Phonenumber = phonenumber;
		Address = address;
		
	}
	public void Add() {
		
	}
	@Override
	public String toString() {
	 return String.format("Hodan[idHodan = %s, idVatnuoi = %s, username = %s, password = %s, fullname = %s, dob = %s, "
	 		+ "gender = %s,  phonenumber = %s, address = %s]", 
	 		idHodan, idVatnuoi	, Username, Password, Fullname, Dob, Gender, Phonenumber);
}
	Connection conn = null;
	public Hodan() {}
	public String getFullName(String userName) {
		String fname ="";
		try {
			conn = Connect_DB.getSQLServer();
			String query = "select Fullname from dbo.HoDan where Username='" + userName + "'";
			Statement st = conn.createStatement();
			ResultSet rs= st.executeQuery(query);
			while(rs.next()) {
				fname = rs.getString("Fullname");
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return fname;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
// đồ họa máy tính
//vẽ hình ngay giữa cửa sổ
/*CREATE TABLE "dbo"."HoDan" (
		"idHoDan" INT NOT NULL,
		"idVatNuoi" INT,
		"username" null,
		"password" null,
		"hoten" null,
		"tuoi" INT,
		"gioitinh" null,
		"sodienthoai" null,
		"diachi" null,
		"sogiayphep" INT,*/
