package Tela;

import br.com.escola.dao.AlunoDAO;
import br.com.escola.dao.ProfessorDAO;
import java.awt.event.ActionEvent;


public class TelaGeral extends TelaGeralAbs{
   
    
    @Override
    public void eventos(){
        btnProfessores.addActionListener(this::mudarTelaProf);
        btnAlunos.addActionListener(this::mudarTelaAlunos);
        btnGeral.addActionListener(this::mudarTelaGeral);
        btnOpcoes.addActionListener(this::mudarTelaOpcoes);
        btnAtualizar.addActionListener(this::calcQntdProf_Aluno);
        calcQntdProf_Aluno(null);
    }
    @Override
    protected void mudarTelaGeral(ActionEvent ev){
        
    }
    @Override
    protected void mudarTelaAlunos(ActionEvent ev){
       this.dispose();
       TelaMain.mostrarTela("alunos");
    }
    @Override
    protected void mudarTelaProf(ActionEvent ev){
        this.dispose();
        TelaMain.mostrarTela("professores");
    }
    @Override
    protected void mudarTelaOpcoes(ActionEvent ev) {
        this.dispose();
        TelaMain.mostrarTela("opcoes");
    }

    protected void calcQntdProf_Aluno(ActionEvent ev) {
        ProfessorDAO prof = new ProfessorDAO();
        AlunoDAO al = new AlunoDAO();
        int quantidadeProf = prof.quantidadeProfessor();
        int quantidadeAl = al.quantidadeAluno();
        txtQntdProf.setText(Integer.toString(quantidadeProf));
        txtQntdAlunos.setText(Integer.toString(quantidadeAl));
    }
    
}
