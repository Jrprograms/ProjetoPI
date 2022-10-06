
package Tela;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaOpcoes extends TelaGeralAbs{

    
    public void TelaOpcoes(){
        
    }
    
    @Override
    protected void mudarTelaGeral(ActionEvent ev){
        this.dispose();
        TelaMain.mostrarTela("principal");
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
        
    }
    @Override
    public JPanel getTitulo(){
        if(lblTitulo == null){
            pnlTitulo = new JPanel();
            lblTitulo = new JLabel("<html><style>h1{font:30pt Arial;}</style><h1>Opções</h1></html>");
            
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }
    @Override
    public JPanel getContent(){
        try{
            if(subPnlContent == null){
                    subPnlContent = new JPanel(new GridBagLayout());
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.fill = GridBagConstraints.BOTH;
                    
            }

            
        }catch(Exception e){
            e.printStackTrace();
        }
        return subPnlContent;
    }

    
    
    
    
}
