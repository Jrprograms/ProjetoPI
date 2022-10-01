package Tela;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TelaGeral extends TelaGeralAbs{
    
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
    
}
