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
                        pstm.setInt(4,professor.getSenha());

                        
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
        public List<Professor> selectProfessor(){
            String query = "SELECT * FROM escola";
            
            List<Professor> professor = new ArrayList<>();
            
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
                    Professor professor1 = new Professor();
                    
                    professor1.setNome(rset.getString("nome"));
                    professor1.add(professor1);
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
            
            return selectProfessor();
        }
        
        //Método para atualizar os dados do BD
        public void update(Professor professor) {
            
            String query = "UPDATE contato SET nome = ?, telefone= ?, senha = ?, email = ?" + "WHERE id_professor = ?";
            
            Connection con = null;
            PreparedStatement pstm = null;
            
            try{
                // Criar conexão com bd
                con = ConnectionFactory.createConnectionToMySQL();
		//Preparando Query para ser Executada
		pstm = con.prepareStatement(query);
                pstm.setString(1,professor.getNome());
                pstm.setInt(2,professor.getTelefone());
                pstm.setInt(3,professor.getSenha());
                pstm.setInt(4,professor.getEmail());
                pstm.setInt(5, professor.getId());
                
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
