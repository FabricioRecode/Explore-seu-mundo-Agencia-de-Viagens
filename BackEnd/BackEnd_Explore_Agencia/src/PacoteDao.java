import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PacoteDao {
	private Connection conn = null;
	private PreparedStatement pstm = null;

	public void insert(Pacote pacote) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO pacote(preco,diaria,id_cidade,cafe_manha)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);

			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setDouble(1, pacote.getPreco());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setInt(2, pacote.getDiaria());

			pstm.setInt(3, pacote.getId_cidade());
			
			pstm.setBoolean(4, pacote.isCafe_manha());

			// Executa a sql para inserção dos dados
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public List<Pacote> getById(int id) {

		String sql = "SELECT * FROM pacote WHERE id_cidade = ?";
		ResultSet rset = null;
		List<Pacote> pacotes = new ArrayList<>();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(rset.getInt("id"));
				pacote.setPreco(rset.getDouble("preco"));
				pacote.setDiaria(rset.getInt("diaria"));
				pacote.setCafe_manha(rset.getBoolean("cafe_manha"));
				pacote.setId_cidade(id);
				pacotes.add(pacote);
			} 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return pacotes;
	}
	
	public List<Pacote> select() {

		String sql = "SELECT * FROM pacote";
		ResultSet rset = null;
		List<Pacote> pacotes = new ArrayList<>();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Pacote pacote = new Pacote();
				pacote.setId(rset.getInt("id"));
				pacote.setPreco(rset.getDouble("preco"));
				pacote.setDiaria(rset.getInt("Diaria"));
				pacote.setCafe_manha(rset.getBoolean("cafe_manha"));
				
				pacotes.add(pacote);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (rset != null) {
					rset.close();
				}

				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		return pacotes;
	}
	
	public boolean deleteById(int id) {

		String sql = "DELETE FROM pacote WHERE id = ?";
		boolean result = false;
		try {

			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.execute();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void updateById(Pacote pacote) {

		String sql = "UPDATE pacote SET preco = ? , diaria = ?,cafe_manha = ? WHERE id = ?";
		try {

			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setDouble(1, pacote.getPreco());
			pstm.setInt(2, pacote.getDiaria());
			pstm.setBoolean(3, pacote.isCafe_manha());
			
			pstm.setInt(4, pacote.getId());

			// Executa a sql para inserção dos dados
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}

	}
	
	

}
