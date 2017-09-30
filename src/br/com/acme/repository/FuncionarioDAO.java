package br.com.acme.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acme.connection.ConnectionFactory;
import br.com.acme.model.Funcionario;

public class FuncionarioDAO {

	private Connection conexao;

	public FuncionarioDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
//CREATE (Funcionando) -------------------------------------------------------
	
	public void create(Funcionario f) throws SQLException{
		
		String sql = "INSERT INTO funcionario (id, nome, matricula) VALUES (?,?,?)";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setInt(1, f.getId());
		stmt.setString(2, f.getNome());
		stmt.setString(3, f.getMatricula());
		
		stmt.executeUpdate();
		this.conexao.close();
	}

//READ (Funcionando) ---------------------------------------------------------

	public List<Funcionario> read() throws SQLException{
		
		List<Funcionario> listFuncionarios = new ArrayList<>();
		
		String sql = "SELECT * FROM funcionario";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rset = stmt.executeQuery(sql);
		
		while (rset.next()) {
			Funcionario f = new Funcionario();
			
            f.setId(rset.getInt("id"));
            f.setNome(rset.getString("nome"));
            f.setMatricula(rset.getString("matricula"));
             
            listFuncionarios.add(f);
        }
		
		rset.close();
		stmt.close();
		this.conexao.close();
		
		return listFuncionarios;
	}
	
//UPDATE (Funcionando) ------------------------------------------------------------
	
	public void update(Funcionario f) throws SQLException{
		
		String sql = "UPDATE funcionario SET nome=?, matricula=? WHERE id=?";
		
		this.conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, f.getNome());
		stmt.setString(2, f.getMatricula());
		stmt.setInt(3, f.getId());
		
		stmt.executeUpdate();
        stmt.close();
        this.conexao.close();     
    }
	
//DELETE (Funcionando) -------------------------------------------------------------------

	public void delete(int id, String nome, String matricula) throws SQLException{
		
		String sql = "DELETE FROM funcionario WHERE id=?";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		this.conexao.close();
	}
	
}
