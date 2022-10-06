package br.com.escola.professor;


public class Professor {
	
	private int id;
	private String nome;
	private int email;
        private String materia;
	private int senha;
	private int telefone;
        private String[] turmas = new String[5];
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getEmail() {
		return email;
	}
	public void setEmail(int email) {
		this.email = email;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public int getTelefone() {
		return telefone;
	}
	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}
	public String getMateria(){
            return this.materia;
        }
        public void setMateria(String materia){
            this.materia = materia;
        }
        public String[] getTurmas() {
            return turmas;
	}
	public void setTurmas(String[] turmas) {
            int i = 0;
            for(String turma : turmas){
                this.turmas[i] = turma;
                i++;
            }
	}
        
}
