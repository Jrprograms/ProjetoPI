package Tela;

import java.awt.event.ActionEvent;


public class TelaLogin extends TelaLoginAbs{
    
    @Override
    protected void login(ActionEvent ev){
        String User = txtUsername.getText();
        String Pass = txtPassword.getText();
        System.out.println(User + Pass);
        this.setVisible(false);
        this.dispose();
        TelaMain.mostrarTela();
    }
}
