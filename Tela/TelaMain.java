package Tela;

import javax.swing.SwingUtilities;


public class TelaMain {
    
    public static void main(String[] args){
        SwingUtilities.invokeLater(() -> {
        TelaLoginAbs telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        });
    }
       
    public static void mostrarTela() {
        SwingUtilities.invokeLater(() -> {
        TelaGeralAbs telaGeral = new TelaGeral() ;
        telaGeral.setVisible(true);
        });
                
        }    
}

