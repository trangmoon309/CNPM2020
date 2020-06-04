package CNPM;
	import java.sql.Connection;
	import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

	public class Connect_DB {
		public static Connection getSQLServer() throws SQLException, ClassNotFoundException{
			String hostName = "localhost";
			String sqlInstanceName = "SQLEXPRESS";
			String database = "QuanLiTiemChung";
			String userName = "sa";
			String password = "hpt309";
			return getSQLServer(hostName, sqlInstanceName, database, userName, password);
		}
		private static Connection getSQLServer(String hostName, String sqlInstanceName, String database, String userName, String password)
		throws SQLException, ClassNotFoundException{
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String connectionURL = "jdbc:jtds:sqlserver://" + hostName + ":1433/"+ database + ";instance="+ sqlInstanceName;
			Connection conn = DriverManager.getConnection(connectionURL, userName, password);
			return conn;
			
		}
		public static void main(String args[]) throws SQLException, ClassNotFoundException{
			System.out.println("Connect to QuanLiTiemChung");
			Connection conn = Connect_DB.getSQLServer("localhost", "SQLEXPRESS", "QuanLiTiemChung", "sa", "hpt309");
			System.out.println(conn);
}
	}
