package br.com.escola.aluno;


public class Aluno {
    private int id;
    private String nome;
    private String turma;
    
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setTurma(String turma){
        this.turma = turma;
    }
    public String getTurma(){
        return this.turma;
    }
}
