package br.com.acme.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acme.connection.ConnectionFactory;
import br.com.acme.model.Departamento;
import br.com.acme.model.Email;
import br.com.acme.model.Funcionario;
import br.com.acme.model.Telefone;

public class FuncionarioDAO {

	private Connection conexao;

	public FuncionarioDAO() {
		this.conexao = ConnectionFactory.getConnection();
	}
	
	Email mail = new Email();
	Telefone tel = new Telefone();
	Departamento dep = new Departamento();
	
//CREATE (Funcionando) -------------------------------------------------------
	
	public void create(Funcionario f) throws SQLException{
		
		String sql = "INSERT INTO funcionario (id, nome, matricula, cargo, telefone, email, salario, departamento) VALUES (?,?,?,?,?,?,?,?)";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setInt(1, f.getId());
		stmt.setString(2, f.getNome());
		stmt.setString(3, f.getMatricula());
		stmt.setString(4, f.getCargo());
		stmt.setString(5, f.getTelefone());
		stmt.setString(6, f.getEmail());
		stmt.setDouble(7, f.getSalario());
		stmt.setString(8, f.getDepartamento());
		
		stmt.executeUpdate();
		stmt.close();
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
            f.setCargo(rset.getString("cargo"));
            f.setTelefone(rset.getString("telefone"));
            f.setEmail(rset.getString("email"));
            f.setSalario(rset.getDouble("salario"));
            f.setDepartamento(rset.getString("departamento"));
             
            listFuncionarios.add(f);
        }
		
		rset.close();
		stmt.close();
		this.conexao.close();
		
		return listFuncionarios;
	}
	
//UPDATE (Funcionando) ------------------------------------------------------------
	
	public void update(Funcionario f) throws SQLException{
		
		String sql = "UPDATE funcionario SET nome=?, matricula=?, cargo=?, telefone=?, email=?, salario=?, departamento=? WHERE id=?";
		
		this.conexao = ConnectionFactory.getConnection();
        PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setString(1, f.getNome());
		stmt.setString(2, f.getMatricula());
		stmt.setString(3, f.getCargo());
		stmt.setString(4, f.getTelefone());
		stmt.setString(5, f.getEmail());
		stmt.setDouble(6, f.getSalario());
		stmt.setString(7, f.getDepartamento());
		stmt.setInt(8, f.getId());
		
		stmt.executeUpdate();
        stmt.close();
        this.conexao.close();     
    }
	
//DELETE (Funcionando) -------------------------------------------------------------------

	public void delete(int id) throws SQLException{
		
		String sql = "DELETE FROM funcionario WHERE id=?";
		
		this.conexao = ConnectionFactory.getConnection();
		PreparedStatement stmt = this.conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		stmt.close();
		this.conexao.close();
	}
	
}
