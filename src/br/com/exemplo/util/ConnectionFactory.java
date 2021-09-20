package br.com.exemplo.util;
import java.sql.Connection;
import java.sql.DriverManager;
public class ConnectionFactory {
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		try {
			//qual é o banco e o driver
			Class.forName("com.mysql.jdbc.Driver"); //Qual é o banco
			//String login = "uniciddb";
			//String senha = "Alfa#01";		
			//String url = "jdbc:mysql://uniciddb.mysql.dbaas.com.br:3306/uniciddb";
			String login = "root";
			String senha = "";
			String url = "jdbc:mysql://localhost:3306/javabanco";
			conn = DriverManager.getConnection(url,login,senha); //Método que pega a conexão
		} catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		return conn;
	}
}