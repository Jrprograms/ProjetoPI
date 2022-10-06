package br.com.escola.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.escola.factory.ConnectionFactory;

public class DadosDAO {
    public String selectDiretor(){
            String query = "SELECT * FROM Diretor";

            Connection con = null;
            PreparedStatement pstm = null;
            
            //Objeto para receber os resultados
            ResultSet rset = null;
            String diretor = null;
            
            try{
                // Criar conexão com bd
                con = ConnectionFactory.createConnectionToMySQL();
		//Preparando Query para ser Executada
		pstm = con.prepareStatement(query);
                //Receber array do BD
                rset = pstm.executeQuery();
                       
                while(rset.next()){
                    diretor = rset.getString("senha");       
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
            
            return diretor;
        }
    //Pegar turmas do banco de dados
    public String[] turmasBD(){
            
            String[] turmas = new String[3];
            int i = 0;
            
            String query = "SELECT nome FROM turma";
            
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
    public String[] getAlunos(String turma){
        String[] alunos = new String[20];
            int i = 0;
            String query = "SELECT nome FROM aluno where turma like '" + turma + "'";
            
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
                    String aluno = rset.getString("nome");
                    System.out.println(aluno);
                    alunos[i] = aluno;
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
            
            return alunos;
    }
}
