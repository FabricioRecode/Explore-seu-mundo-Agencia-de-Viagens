package model;
import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
	// Nome do usuário do mysql

	private static final String USERNAME = "root";

	// Senha do mysql

	private static final String PASSWORD = "F@b052216";

	// Dados de caminho, porta e nome da base de dados que irá ser feita a conexão

	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/explore_agencia";

	// * Cria uma conexão com o banco de dados MySQL utilizando o nome de usuário e
	// senha fornecidos

	// * @param username

	// * @param senha

	// * @return uma conexão com o banco de dados

	// * @throws Exception
	public static Connection createConnectionToMySQL() throws Exception {

		// Faz com que a classe seja carregada pela JVM

		// Cria a conexão com o banco de dados
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
		    throw new RuntimeException(e);
		}
		

		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

		return connection;

	}
}
