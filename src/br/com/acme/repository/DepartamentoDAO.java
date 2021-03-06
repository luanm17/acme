package br.com.acme.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acme.connection.ConnectionFactory;
import br.com.acme.model.Departamento;

public class DepartamentoDAO {

	private Connection conexao;

	public DepartamentoDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
//CREATE (Funcionando) -------------------------------------------------------
	
	public void create(Departamento d) throws SQLException{
		
		String sql = "INSERT INTO departamento (id, nome, funcionario, chefe) VALUES (?,?,?,?)";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setInt(1, d.getId());
		stmt.setString(2, d.getNome());
		stmt.setString(3, d.getFuncionario());
		stmt.setString(4, d.getChefe());
		
		stmt.executeUpdate();
		stmt.close();
		this.conexao.close();
	}

//READ (Funcionando) ---------------------------------------------------------

	public List<Departamento> read() throws SQLException{
		
		List<Departamento> listDepartamentos = new ArrayList<>();
		
		String sql = "SELECT * FROM departamento";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		ResultSet rset = stmt.executeQuery(sql);
		
		while (rset.next()) {
			Departamento d = new Departamento();
			
            d.setId(rset.getInt("id"));
            d.setNome(rset.getString("nome"));
            d.setFuncionario(rset.getString("funcionario"));
            d.setChefe(rset.getString("chefe"));
            
            listDepartamentos.add(d);
        }
		
		rset.close();
		stmt.close();
		this.conexao.close();
		
		return listDepartamentos;
	}

//UPDATE (Funcionando) ------------------------------------------------------------
	
	public void update(Departamento d) throws SQLException{
		
		String sql = "UPDATE departamento SET nome=?, funcionario=?, chefe=? WHERE id=?";
		
		this.conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, d.getNome());
		stmt.setString(2, d.getFuncionario());
		stmt.setString(3, d.getChefe());
		stmt.setInt(4, d.getId());
		
		stmt.executeUpdate();
        stmt.close();
        this.conexao.close();     
    }
	
//DELETE (Funcionando) -------------------------------------------------------------------

	public void delete(int id) throws SQLException{
		
		String sql = "DELETE FROM departamento WHERE id=?";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		stmt.close();
		this.conexao.close();
	}
	
}
