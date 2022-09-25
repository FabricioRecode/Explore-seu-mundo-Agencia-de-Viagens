package model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CidadeDao {

	private Connection conn = null;
	private PreparedStatement pstm = null;

	public void insert(Cidade cidade ) {

		// Isso é uma sql comum, os ? são os parâmetros que nós vamos adicionar na base
		// de dados

		String sql = "INSERT INTO cidades(nome, pais,continente,estado)" + " VALUES(?,?,?,?)";

		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			// Adiciona o valor do primeiro parâmetro da sql
			pstm.setString(1, cidade.getNome());
			// Adicionar o valor do segundo parâmetro da sql
			pstm.setString(2, cidade.getPais());
			
			pstm.setString(3, cidade.getContinente());
			
			pstm.setString(4, cidade.getEstado());

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

	public void updateById(Cidade cidade) {

		String sql = "UPDATE cidades SET nome = ? , pais = ?,estado = ?,continente = ? WHERE id = ?";
		try {

			conn = Conexao.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, cidade.getNome());
			pstm.setString(2, cidade.getPais());
			pstm.setString(3, cidade.getEstado());
			pstm.setString(4, cidade.getContinente());
			pstm.setInt(5, cidade.getId());

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

	public boolean deleteById(int id) {

		String sql = "DELETE FROM cidades WHERE id = ?";
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

	public List<Cidade> select() {

		String sql = "SELECT * FROM cidades";
		ResultSet rset = null;
		List<Cidade> cidades = new ArrayList<>();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cidade cidade = new Cidade();
				cidade.setId(rset.getInt("id"));
				cidade.setNome(rset.getString("nome"));
				cidade.setPais(rset.getString("pais"));
				cidade.setEstado(rset.getString("estado"));
				cidade.setContinente(rset.getString("continente"));
				cidades.add(cidade);
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

		return cidades;
	}

	public Cidade selectById(int id) {

		String sql = "SELECT * FROM cidades where id = ?";
		ResultSet rset = null;
		Cidade cidade = new Cidade();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rset = pstm.executeQuery();

			if (rset.next()) {
				
				cidade.setId(rset.getInt("id"));
				cidade.setNome(rset.getString("nome"));
				cidade.setPais(rset.getString("pais"));
				cidade.setEstado(rset.getString("estado"));
				cidade.setContinente(rset.getString("continente"));
				
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

		return cidade;
	}

	
	public int selectIdByNome(String nomeCidade) {

		String sql = "SELECT * FROM cidades WHERE nome = ?";
		ResultSet rset = null;
		int idCidade = -1;
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, nomeCidade);
			rset = pstm.executeQuery();
		
				
			if(rset.next()) {
				idCidade = rset.getInt("id");
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if(rset != null) {
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

		return idCidade;
	}
	
	public String selectNomeById(int id_cidade) {

		String sql = "SELECT * FROM cidades WHERE id = ?";
		ResultSet rset = null;
		String nome = null;
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_cidade);
			rset = pstm.executeQuery();
		
				
			if(rset.next()) {
				nome = rset.getString("nome");
			}
		

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Fecha as conexões
			try {
				if(rset != null) {
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

		return nome;
	}
	
	public List<Cidade> getBycontinente(String continente) {

		String sql = "SELECT * FROM cidades WHERE continente = ?";
		ResultSet rset = null;
		List<Cidade> cidades = new ArrayList<>();
		try {
			// Cria uma conexão com o banco
			conn = Conexao.createConnectionToMySQL();

			// Cria um PreparedStatment, classe usada para executar a query
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, continente);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Cidade cidade = new Cidade();
				cidade.setId(rset.getInt("id"));
				cidade.setNome(rset.getString("nome"));
				cidade.setPais(rset.getString("pais"));
				cidade.setEstado(rset.getString("estado"));
				cidade.setContinente(rset.getString("continente"));
				cidades.add(cidade);
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

		return cidades;
	}


	
	
}
