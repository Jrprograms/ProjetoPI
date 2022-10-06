package br.com.escola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.escola.factory.ConnectionFactory;
import br.com.escola.aluno.Aluno;



public class AlunoDAO {
	
	
	
	public void insert(Aluno  aluno) {
		
		String query = "INSERT INTO aluno (nome, turma) VALUES (?, ?)";
		
		Connection con = null;
		PreparedStatement pstm = null;
		
		try {
			
			con = ConnectionFactory.createConnectionToMySQL();
			
			pstm = con.prepareStatement(query);
                        pstm.setString(1,aluno.getNome());
                        pstm.setString(2,aluno.getTurma());
                        
                        pstm.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
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

        
        public ArrayList<Aluno> selectAluno(String nome){
            String query = "SELECT * FROM aluno where nome like '" + nome +"'";
            ArrayList<Aluno> alunos = new ArrayList<>();
            
            Connection con = null;
            PreparedStatement pstm = null;
            
           
            ResultSet rset = null;
            
            try{
               
                con = ConnectionFactory.createConnectionToMySQL();
		
		pstm = con.prepareStatement(query);
                
                rset = pstm.executeQuery();
                       
                while(rset.next()){
                    Aluno aluno = new Aluno();
                    aluno.setNome(rset.getString("nome"));
                    aluno.setTurma(rset.getString("turma"));
                    alunos.add(aluno);
                    
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
            
            return alunos;
        }
        public int quantidadeAluno(){
            String query = "SELECT * FROM aluno";
            
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
        
}