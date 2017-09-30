package br.com.acme.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.acme.model.Departamento;
import br.com.acme.model.Funcionario;
import br.com.acme.repository.DepartamentoDAO;
import br.com.acme.repository.FuncionarioDAO;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Funcionario f = new Funcionario();
		FuncionarioDAO fdao = new FuncionarioDAO();
		
		f.setId(4);
		f.setNome("Drougras");
		f.setMatricula("004");
		
		//fdao.create(f);
		//fdao.update(f);
		
		//fdao.delete(20, null, null);
		
		List<Funcionario> funcionarios = new ArrayList<>();
		funcionarios = fdao.read();
		
		System.out.println(":D ------------ FUNCIONARIOS ------------\n");
		
		for(Funcionario fun : funcionarios){
			System.out.println("ID >>>>>>>>>>> " +fun.getId());
			System.out.println("NOME >>>>>>>>> " +fun.getNome());
			System.out.println("MATRICULA >>>> " +fun.getMatricula());
		}
		
		//-----------------------------------------------------------
		
		Departamento d = new Departamento();
		DepartamentoDAO dao = new DepartamentoDAO();
		
		d.setId(3);
		d.setNome("Recursos Humanos");
		d.setChefe("Dougras");
		
		//dao.create(d);
		//dao.update(d);
		
		//dao.delete(20, null, null);
		
		List<Departamento> departamentos = new ArrayList<>();
		departamentos = dao.read();
		
		System.out.println("\n:B ------------ DEPARTAMENTOS ------------\n");
		
		for(Departamento depa : departamentos){
			System.out.println("ID >>>>>>>>>>> " +depa.getId());
			System.out.println("NOME >>>>>>>>> " +depa.getNome());
			System.out.println("CHEFE >>>>>>>> " +depa.getChefe());
		}
	}
}
