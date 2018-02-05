package dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UserData {
	
	static UserData usD = new UserData();
	
	String imie;
	String haslo;
	
	public String getImie() {
		return imie;}
	public void setImie(String imie) {
		this.imie = imie;}
	public String getHaslo() {
		return haslo;}
	public void setHaslo(String haslo) {
		this.haslo = haslo;}
	

	
	public String getImie2() {
		String imie2;
		imie2 = usD.getImie();
		return imie2;
	}
	public String getHaslo2(){
		String haslo2;
		haslo2=usD.getHaslo();
		return haslo2;
	}
	
	public static Connection polacz() {
		Connection polaczenie = null;
		try {
			Class.forName("org.sqlite.JDBC");
			polaczenie = DriverManager.getConnection("jdbc:sqlite:user.db");
			System.out.println("Polaczylem sie z baza danych");
			}catch(Exception e) {
				System.out.println("Blad polaczenia");
				return null;
			}
		return polaczenie;
		
	}
	
	public static void crateTable(Connection polaczenie) {
		Statement stat=null;
		try {
			stat=polaczenie.createStatement();
			String tabelaSQL = "CREATE TABLE IF NOT EXISTS  user"					
					+ "(Nazwa 			 CHAR(50)   NOT NULL, "
					+ "Password      	 CHAR(50)  	NOT NULL)";
			stat.executeUpdate(tabelaSQL);
			stat.close();
			polaczenie.close();	
		}catch(SQLException  e) {
			System.out.println("Nie mogê stworzyæ tabeli" + e.getMessage());
		}
		
	}
	
	public static void addNazwa(Uzytkownik user) {
		Connection polaczenie = null;
        Statement stat = null;
        	try {
        		Class.forName("org.sqlite.JDBC");
    			polaczenie = DriverManager.getConnection("jdbc:sqlite:user.db");
        		stat=polaczenie.createStatement();
        		String DodajSQL = "INSERT INTO user (Nazwa, Password) VALUES ("
        				+"'"+user.getNazwa()+"',"
        				+"'"+user.getPassword()+"')";
        		stat.executeUpdate(DodajSQL);
        		stat.close();
        		polaczenie.close();
        		System.out.println("Dodanie zakonczone");
        	}catch(Exception e) {
        			System.out.println("Nie udalo sie dodac usera! "+ e.getMessage());
        	}
		
	}
	
	public static void ShowUser(String pole, String wartosc) {
		Connection polaczenie = null;
		Statement stat = null;
			try {
				Class.forName("org.sqlite.JDBC");
				polaczenie=DriverManager.getConnection("jdbc:sqlite:user.db");
				stat = polaczenie.createStatement();
				String SzukajSQL = "SELECT * FROM user"+
	                     " WHERE " + pole + "=='" + wartosc + "';";
				ResultSet wynik = stat.executeQuery(SzukajSQL);
				
				usD.setImie(wynik.getString("Nazwa"));
				usD.setHaslo(wynik.getString("Password"));
				
				wynik.close();
	            stat.close();
	            polaczenie.close();
				
			}catch(Exception e) {
				System.out.println("Nie moge wyszukac danych" + e.getMessage());
			}
		
	}

}
