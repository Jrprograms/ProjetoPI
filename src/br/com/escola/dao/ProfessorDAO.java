package br.com.escola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.escola.factory.ConnectionFactory;
import br.com.escola.professor.Professor;



public class ProfessorDAO {
	
	//CRUD
	
	public void insert(Professor professor) {
		// Variável para registrar a consulta
		String query = "INSERT INTO contato (nome, telefone, senha, email) VALUES (? , ?, ?, ?)";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			// Criar conexão com bd
			con = ConnectionFactory.createConnectionToMySQL();
			//Preparando Query para ser Executada
			pstm = con.prepareStatement(query);
                        pstm.setString(1,professor.getNome());
                        pstm.setInt(2,professor.getTelefone());
                        pstm.setInt(3,professor.getSenha());
                        pstm.setInt(4,professor.getEmail());

                        
                        pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}//Garantindo que a conexão será finalizada
                finally{
                    try{
                        if(pstm != null){
                            pstm.close();
                        }
                        if(con!=null){
                            con.close();
                        }
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                }
		
	}

        //Método para mostrar os dados do BD
        public String selectProfessor(String nome){
            String query = "SELECT senha FROM professor where nome like '" + nome + "'";
            
            String professor = null;
            
            Connection con = null;
            PreparedStatement pstm = null;
            
            //Objeto para receber os resultados
            ResultSet rset = null;
            
            try{
                // Criar conexão com bd
                con = ConnectionFactory.createConnectionToMySQL();
		//Preparando Query para ser Executada
		pstm = con.prepareStatement(query);
                //Receber array do BD
                rset = pstm.executeQuery();
                       
                while(rset.next()){
                   professor = rset.getString("senha");
                   break;
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(rset!=null) {
                        rset.close();
                    }
                    if(pstm != null){
                        pstm.close();
                    }
                    if(con!=null){
                        con.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            
            return professor;
        }
        
        public int quantidadeProfessor(){
            String query = "SELECT nome FROM professor";
            
            int quantidade = 0;
            
            Connection con = null;
            PreparedStatement pstm = null;
            
            //Objeto para receber os resultados
            ResultSet rset = null;
            
            try{
                // Criar conexão com bd
                con = ConnectionFactory.createConnectionToMySQL();
		//Preparando Query para ser Executada
		pstm = con.prepareStatement(query);
                //Receber array do BD
                rset = pstm.executeQuery();
                       
                while(rset.next()){
                   quantidade++;
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(rset!=null) {
                        rset.close();
                    }
                    if(pstm != null){
                        pstm.close();
                    }
                    if(con!=null){
                        con.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            return quantidade;
        }
        public ArrayList<Professor> getProfessores(){
            String query = "SELECT * FROM professor";

            ArrayList<Professor> professores  = new ArrayList<>();
            
            Connection con = null;
            PreparedStatement pstm = null;
            
            //Objeto para receber os resultados
            ResultSet rset = null;
            
            try{
                // Criar conexão com bd
                con = ConnectionFactory.createConnectionToMySQL();
		//Preparando Query para ser Executada
		pstm = con.prepareStatement(query);
                //Receber array do BD
                rset = pstm.executeQuery();
                       
                while(rset.next()){
                    String nome = rset.getString("nome");
                    String materia = rset.getString("materia");
                    Professor prof = new Professor();
                    prof.setNome(nome);
                    prof.setMateria(materia);
                    String turmas[] = turmasProfessor(nome,materia);
                    prof.setTurmas(turmas);
                    professores.add(prof);
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(rset!=null) {
                        rset.close();
                    }
                    if(pstm != null){
                        pstm.close();
                    }
                    if(con!=null){
                        con.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
           
            return professores;
        }
        //Pegar as turmas que o professor da aula
        public String[] turmasProfessor(String prof, String materia){
            
            String[] turmas = new String[3];
            int i = 0;
            
            String query = "SELECT nome FROM turma where professor like '" + prof + "' and materia like '" + materia + "' ;";
            
            Connection con = null;
            PreparedStatement pstm = null;
            
            //Objeto para receber os resultados
            ResultSet rset = null;
            
            try{
                // Criar conexão com bd
                con = ConnectionFactory.createConnectionToMySQL();
		//Preparando Query para ser Executada
		pstm = con.prepareStatement(query);
                //Receber array do BD
                rset = pstm.executeQuery();
                       
                while(rset.next()){
                    String turma = rset.getString("nome");
                    turmas[i] = turma;
                    i++;
                }
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(rset!=null) {
                        rset.close();
                    }
                    if(pstm != null){
                        pstm.close();
                    }
                    if(con!=null){
                        con.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            
            return turmas;
        }
        //Método para apagar dados do DB
        public void delete(int id){
        
            String query = "DELETE FROM contato WHERE id_contato = ?";
            
            Connection con = null;
            PreparedStatement pstm = null;
            
            try{
                // Criar conexão com bd
                con = ConnectionFactory.createConnectionToMySQL();
		//Preparando Query para ser Executada
		pstm = con.prepareStatement(query);
                
                pstm.setInt(1,id);
                
                pstm.execute();
                
                
            }catch(Exception e){
                e.printStackTrace();
            }finally{
                try{
                    if(pstm != null){
                        pstm.close();
                    }
                    if(con!=null){
                        con.close();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
            
        }
}
