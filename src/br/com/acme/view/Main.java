package br.com.acme.view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.acme.model.Funcionario;
import br.com.acme.model.Departamento;
import br.com.acme.model.Dependente;
import br.com.acme.repository.FuncionarioDAO;
import br.com.acme.repository.DepartamentoDAO;
import br.com.acme.repository.DependenteDAO;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		Funcionario f = new Funcionario();
		Departamento depa = new Departamento();
		Dependente depe = new Dependente();
		
		FuncionarioDAO fdao = new FuncionarioDAO();
		DepartamentoDAO depadao = new DepartamentoDAO();
		DependenteDAO depedao = new DependenteDAO();
		
		Scanner scan = new Scanner(System.in);
		
		int option;
		
		do{
			System.out.println(">>>>>>>> Menu <<<<<<<<\n");
			
            System.out.println("1 - Inserir Funcionário");
			System.out.println("2 - Editar Funcionário");
			System.out.println("3 - Excluir Funcionário");
			System.out.println("4 - Listar Todos os Funcionários\n");
			
			System.out.println("5 - Inserir Departamento");
			System.out.println("6 - Editar Departamento");
			System.out.println("7 - Excluir Departamento");
			System.out.println("8 - Listar Todos os Departamentos\n");
			
			System.out.println("9 - Inserir Dependente");
			System.out.println("10 - Editar Dependente");
			System.out.println("11 - Excluir Dependente");
			System.out.println("12 - Listar Todos os Dependentes");
			
			System.out.println("\n0 - Sair");
			
			System.out.println("\nDigite o número da opção:");

            option = scan.nextInt();

            switch(option){
            case 0:
            	System.out.println("\n------------------- Até mais! -------------------");
            	
            	break;
            	
            case 1:
            	
                System.out.println("\n-------------- Inserir Funcionário --------------");

                System.out.println("\nDigite o Id: ");
                f.setId(scan.nextInt());
                System.out.println("Digite o Nome: ");
				f.setNome(scan.next());
				System.out.println("Digite a Matricula: ");
				f.setMatricula(scan.next());
				System.out.println("Digite o Cargo: ");
				f.setCargo(scan.next());
				System.out.println("Digite o Telefone: ");
				f.setTelefone(scan.next());
				System.out.println("Digite o Email: ");
				f.setEmail(scan.next());
				System.out.println("Digite o Salário: ");
				f.setSalario(scan.nextDouble());
				System.out.println("Digite o Departamento : ");
				f.setDepartamento(scan.next());

				fdao.create(f);

				System.out.println("\n--------- Inserção realizada com sucesso! ---------\n");

				scan.nextLine();

                break;
                
            case 2:
            	
				System.out.println("\n-------------- Editar Funcionário --------------");

				System.out.println("\nDigite o Id: ");
                f.setId(scan.nextInt());
                System.out.println("Digite o Nome: ");
				f.setNome(scan.next());
				System.out.println("Digite a Matricula: ");
				f.setMatricula(scan.next());
				System.out.println("Digite o Cargo: ");
				f.setCargo(scan.next());
				System.out.println("Digite o Telefone: ");
				f.setTelefone(scan.next());
				System.out.println("Digite o Email: ");
				f.setEmail(scan.next());
				System.out.println("Digite o Salário: ");
				f.setSalario(scan.nextDouble());
				System.out.println("Digite o Departamento : ");
				f.setDepartamento(scan.next());

				fdao.update(f);

				System.out.println("\n-------- Dados atualizados com sucesso! --------\n");

				scan.nextLine();

                break;
                
            case 3:
            	
                System.out.println("\n-------------- Excluir Funcionário --------------");
                
                System.out.println("\nDigite o Id:");
                f.setId(scan.nextInt());

                fdao.delete(f.getId());

                System.out.println("\n-------- Exclusão realizada com sucesso! --------\n");

                scan.nextLine();
                
                break;
                
            case 4:
            	
                List<Funcionario> funcionarios = new ArrayList<>();
				funcionarios = fdao.read();
		        	
		        if(funcionarios.isEmpty())
		        	System.out.println("\n--------- Nenhum funcionário cadastrado! ---------\n");
		        else{
		        	System.out.println("------------ Funcionários Cadastrados ------------");
		        	
				    for(Funcionario fun : funcionarios){
						System.out.println("\nId >>>>>>>>>>> " +fun.getId());
						System.out.println("Nome >>>>>>>>> " +fun.getNome());
						System.out.println("Matricula >>>> " +fun.getMatricula());
						System.out.println("Cargo >>>>>>>> " +fun.getCargo());
						System.out.println("Telefone >>>>> " +fun.getTelefone());
						System.out.println("Email >>>>>>>> " +fun.getEmail());
						System.out.println("Salário >>>>>> " +fun.getSalario());
						System.out.println("Departamento > " +fun.getDepartamento());
					}
				    System.out.println("\n--------------------------------------------------\n");
		        }
		        
                break;
                
            case 5:
            	
                System.out.println("\n-------------- Inserir Departamento --------------");

                System.out.println("\nDigite o Id: ");
                depa.setId(scan.nextInt());
                System.out.println("Digite o Nome: ");
                depa.setNome(scan.next());
                System.out.println("Digite o Funcionário: ");
                depa.setFuncionario(scan.next());
				System.out.println("Digite o Chefe: ");
				depa.setChefe(scan.next());
				
				depadao.create(depa);

				System.out.println("\n--------- Inserção realizada com sucesso! ---------\n");

				scan.nextLine();

                break;
                
            case 6:
            	
				System.out.println("\n-------------- Editar Departamento --------------");

				System.out.println("\nDigite o Id: ");
                depa.setId(scan.nextInt());
                System.out.println("Digite o Nome: ");
                depa.setNome(scan.next());
                System.out.println("Digite o Funcionário: ");
                depa.setFuncionario(scan.next());
				System.out.println("Digite o Chefe: ");
				depa.setChefe(scan.next());
				
				depadao.update(depa);

				System.out.println("\n-------- Dados atualizados com sucesso! --------\n");

				scan.nextLine();

                break;
                
            case 7:
            	
                System.out.println("\n-------------- Excluir Departamento --------------");
                
                System.out.println("\nDigite o Id:");
                depa.setId(scan.nextInt());

                depadao.delete(depa.getId());

                System.out.println("\n-------- Exclusão realizada com sucesso! --------\n");

                scan.nextLine();
                
                break;
                
            case 8:
            	
                List<Departamento> departamentos = new ArrayList<>();
                departamentos = depadao.read();
		        	
		        if(departamentos.isEmpty())
		        	System.out.println("\n--------- Nenhum departamento cadastrado! ---------\n");
		        else{
		        	System.out.println("------------ Departamentos Cadastrados -----------");
		        	
				    for(Departamento d : departamentos){
						System.out.println("\nId >>>>>>>>>>> " +d.getId());
						System.out.println("Nome >>>>>>>>> " +d.getNome());
						System.out.println("Funcionário >> " +d.getFuncionario());
						System.out.println("Chefe >>>>>>>> " +d.getChefe());
					}
				    System.out.println("\n--------------------------------------------------\n");
		        }
		        
                break;
                
            case 9:
            	
                System.out.println("\n--------------- Inserir Dependente ---------------");

                System.out.println("\nDigite o Id: ");
                depe.setId(scan.nextInt());
                System.out.println("Digite o Nome: ");
                depe.setNome(scan.next());
                System.out.println("Digite a Matricula: ");
                depe.setMatricula(scan.next());
				System.out.println("Digite o Funcionário: ");
				depe.setFuncionario(scan.next());
				
				depedao.create(depe);

				System.out.println("\n-------- Inserção realizada com sucesso! --------\n");

				scan.nextLine();

                break;
                
            case 10:
            	
				System.out.println("\n-------------- Editar Dependente --------------");

				System.out.println("\nDigite o Id: ");
                depe.setId(scan.nextInt());
                System.out.println("Digite o Nome: ");
                depe.setNome(scan.next());
                System.out.println("Digite a Matricula: ");
                depe.setMatricula(scan.next());
				System.out.println("Digite o Funcionário: ");
				depe.setFuncionario(scan.next());
				
				depedao.update(depe);

				System.out.println("\n-------- Dados atualizados com sucesso! --------\n");

				scan.nextLine();

                break;
                
            case 11:
            	
                System.out.println("\n-------------- Excluir Dependente --------------");
                
                System.out.println("\nDigite o Id:");
                depe.setId(scan.nextInt());

                depedao.delete(depe.getId());

                System.out.println("\n-------- Exclusão realizada com sucesso! --------\n");

                scan.nextLine();
                
                break;
                
            case 12:
            	
                List<Dependente> dependentes = new ArrayList<>();
                dependentes = depedao.read();
		        	
		        if(dependentes.isEmpty())
		        	System.out.println("\n--------- Nenhum dependente cadastrado! ---------\n");
		        else{
		        	System.out.println("------------- Dependentes Cadastrados ------------");
		        	
				    for(Dependente d : dependentes){
						System.out.println("\nId >>>>>>>>>>> " +d.getId());
						System.out.println("Nome >>>>>>>>> " +d.getNome());
						System.out.println("Matricula >>>> " +d.getMatricula());
						System.out.println("Funcionário >>>>>>>> " +d.getFuncionario());
					}
				    System.out.println("\n--------------------------------------------------\n");
		        }
		        
                break;
            
            default:
            	
                System.out.println("\n----------------- Opção inválida! -----------------\n");
                
                break;
            }
		}while(option != 0);{
			scan.close();
		}
	}
}