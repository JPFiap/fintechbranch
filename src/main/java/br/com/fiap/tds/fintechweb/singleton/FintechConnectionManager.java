package br.com.fiap.tds.fintechweb.singleton;


import java.sql.Connection;
import java.sql.DriverManager;

public class FintechConnectionManager {
	
    private static FintechConnectionManager instance;
    
    private FintechConnectionManager() {}
    
    
    public static FintechConnectionManager getInstance() {
    	if(instance == null) {
    		instance = new FintechConnectionManager();
    	}
    	
    	return instance;
    }


	public Connection getConnection() {
		Connection conexao = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			conexao = DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "RM96551",
					"060398");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conexao;
	}

}
