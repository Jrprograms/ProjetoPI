package Tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public abstract class TelaGeralAbs extends JFrame{
    
    //Painel Header,Lateral(Side),Principal(Content)
    protected JPanel pnlHeader;
    protected JPanel pnlSide;
    protected JPanel pnlContent;
    
    //Item pro Cabeçalho
    protected JLabel lblHeader;
    
    //Itens pro painel Lateral
    protected JButton btnGeral;
    protected JButton btnProfessores;
    protected JButton btnAlunos;
    protected JButton btnOpcoes;
    
    //Itens pro painel Principal
    
    
    //Método Principal
    public TelaGeralAbs(){
        this.inicializar();
    }
    
    //Definir configurações da tela
    private void inicializar(){
        //Define o título da tela
        this.setTitle("Sistema de Gestão Escolar");
        //Define a ação de finalizar o programa
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        
        this.getContentPane().add(getPnlHeader(),BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlSide(), BorderLayout.WEST);
        
        this.setMinimumSize(new Dimension(500,500));
        //this.pack();
        this.setResizable(false);
        
    }
    //Modelar paineis
    public JPanel getPnlHeader(){
        if(pnlHeader == null){
            pnlHeader = new JPanel();
            pnlHeader.setBackground(Color.blue);
            
            lblHeader = new JLabel("<html><h1><b>Gestão Escolar<b></h1></html>");
            lblHeader.setForeground(Color.white);
            
            //Adiciona o label no painel
            pnlHeader.add(lblHeader);
        }
        
        return pnlHeader;
    }
    public JPanel getPnlSide(){
        if(pnlSide == null){
            
            pnlSide = new JPanel(new GridLayout(4,1));
            pnlSide.setBackground(Color.BLUE);
            
            btnGeral = new JButton("Geral");
            btnGeral.setBackground(Color.BLUE);
            btnGeral.setForeground(Color.WHITE);
            btnGeral.setFocusPainted(false);
            btnGeral.setBorderPainted(false);
 
            btnProfessores = new JButton("Professores");
            btnProfessores.setBackground(Color.BLUE);
            btnProfessores.setForeground(Color.WHITE);
            btnProfessores.setFocusPainted(false);
            btnProfessores.setBorderPainted(false);
            
            btnAlunos = new JButton("Alunos");
            btnAlunos.setBackground(Color.BLUE);
            btnAlunos.setForeground(Color.WHITE);
            btnAlunos.setFocusPainted(false);
            btnAlunos.setBorderPainted(false);
            
            btnOpcoes = new JButton("Opções");
            btnOpcoes.setBackground(Color.BLUE);
            btnOpcoes.setForeground(Color.WHITE);
            btnOpcoes.setFocusPainted(false);
            btnOpcoes.setBorderPainted(false);
            
            pnlSide.add(btnGeral);
            pnlSide.add(btnProfessores);
            pnlSide.add(btnAlunos);
            pnlSide.add(btnOpcoes);
        }
        
        return pnlSide;
        
    }
}
