package Tela;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public class TelaMain {
    
    
    public static void main(String[] args){
        /*SwingUtilities.invokeLater(() -> {
        TelaLoginAbs telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        });*/
        SwingUtilities.invokeLater(() -> {
        TelaLoginAbs telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        });
    }
       
    public static void mostrarTela(String c) {
        if(c == "principal"){    
            SwingUtilities.invokeLater(() -> {  
            TelaGeralAbs telaGeral = new TelaGeral();
            telaGeral.setVisible(true);
            });
        }else if(c == "professores"){
            SwingUtilities.invokeLater(() -> {  
            TelaGeralAbs telaProfessores = new TelaProfessores();
            telaProfessores.setVisible(true);
            });
        }else if(c == "alunos"){
            SwingUtilities.invokeLater(() -> {  
            TelaGeralAbs telaAlunos = new TelaAlunos();
            telaAlunos.setVisible(true);
            });
        }else if(c == "opcoes"){
            SwingUtilities.invokeLater(() -> {  
            TelaGeralAbs telaopcoes = new TelaOpcoes();
            telaopcoes.setVisible(true);
            });
        }
        
    }
}

