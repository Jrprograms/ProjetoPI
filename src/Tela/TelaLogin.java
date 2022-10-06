package Tela;

import br.com.escola.dao.DadosDAO;
import br.com.escola.dao.ProfessorDAO;
import java.awt.event.ActionEvent;


public class TelaLogin extends TelaLoginAbs{
    
    @Override
    protected void login(ActionEvent ev){
        
        ProfessorDAO prof = new ProfessorDAO();
        DadosDAO dir = new DadosDAO();
        
        String BDSenha = null;
        
        String User = txtUsername.getText();
        String Pass = txtPassword.getText();
        System.out.println(Pass);
        
        try{        
            BDSenha = prof.selectProfessor(User);
            System.out.println(BDSenha);
        }catch(Exception e){
            e.printStackTrace();
        }

        if(BDSenha == null){    
            if(Pass.equals(dir.selectDiretor())){
                this.setVisible(false);
                this.dispose();
                TelaMain.mostrarTela("principal");
            }else{
                msgError();
            }
        }else{
            if(Pass.equals(BDSenha)){
                this.setVisible(false);
                this.dispose();
                TelaMain.mostrarTela("principal");
            }else{
                msgError();
            }
        }
    }
    private void msgError(){
        System.out.println("Erro!");
    }
}
