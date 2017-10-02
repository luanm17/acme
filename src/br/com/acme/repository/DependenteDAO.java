package br.com.acme.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acme.connection.ConnectionFactory;
import br.com.acme.model.Dependente;

public class DependenteDAO {

	private Connection conexao;

	public DependenteDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
//CREATE (Funcionando) -------------------------------------------------------
	
	public void create(Dependente d) throws SQLException{
		
		String sql = "INSERT INTO dependente (id, nome, matricula, funcionario) VALUES (?,?,?,?)";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setInt(1, d.getId());
		stmt.setString(2, d.getNome());
		stmt.setString(3, d.getMatricula());
		stmt.setString(4, d.getFuncionario());
		
		stmt.executeUpdate();
		stmt.close();
		this.conexao.close();
	}

//READ (Funcionando) ---------------------------------------------------------

	public List<Dependente> read() throws SQLException{
		
		List<Dependente> listDependentes = new ArrayList<>();
		
		String sql = "SELECT * FROM dependente";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rset = stmt.executeQuery(sql);
		
		while (rset.next()) {
			Dependente d = new Dependente();
			
            d.setId(rset.getInt("id"));
            d.setNome(rset.getString("nome"));
            d.setMatricula(rset.getString("matricula"));
            d.setFuncionario(rset.getString("funcionario"));
            
            listDependentes.add(d);
        }
		
		rset.close();
		stmt.close();
		this.conexao.close();
		
		return listDependentes;
	}

//UPDATE (Funcionando) ------------------------------------------------------------
	
	public void update(Dependente d) throws SQLException{
		
		String sql = "UPDATE dependente SET nome=?, matricula=?, funcionario=? WHERE id=?";
		
		this.conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, d.getNome());
		stmt.setString(2, d.getMatricula());
		stmt.setString(3, d.getFuncionario());
		stmt.setInt(4, d.getId());
		
		stmt.executeUpdate();
        stmt.close();
        this.conexao.close();     
    }
	
//DELETE (Funcionando) -------------------------------------------------------------------

	public void delete(int id) throws SQLException{
		
		String sql = "DELETE FROM dependente WHERE id=?";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		stmt.close();
		this.conexao.close();
	}
	
}
