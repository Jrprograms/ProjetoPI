package Tela;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public abstract class TelaGeralAbs extends JFrame{
    
    //Painel Header,Lateral(Side),Principal(Content)
    protected JPanel pnlHeader;
    protected JPanel pnlSide;
    protected JPanel pnlTitulo;
    protected JPanel pnlContent;
    protected JPanel subPnlContent;
    protected JPanel pnlBtnAtualizar;
    
    //Item pro Cabeçalho
    protected JLabel lblHeader;
    
    //Itens pro painel Lateral
    protected JButton btnGeral;
    protected JButton btnProfessores;
    protected JButton btnAlunos;
    protected JButton btnOpcoes;
    
    //Itens pro painel Principal
    private String content;// content, professores, alunos
    
    //Labels de título
    protected JLabel lblTitulo;
    /*protected JLabel lblProfessores;
    protected JLabel lblAlunos;*/
    
    //Tela Principal - Geral
    protected JLabel lblQtndAlunos;
    protected JLabel lblQtndProf;
    protected JTextField txtQntdAlunos;
    protected JTextField txtQntdProf;
    protected JButton btnAtualizar;
    
    //Tela Opçoes
    
    //Funções dos botões
    protected abstract void mudarTelaProf(ActionEvent ev);
    protected abstract void mudarTelaAlunos(ActionEvent ev);
    protected abstract void mudarTelaGeral(ActionEvent ev);
    protected abstract void mudarTelaOpcoes(ActionEvent ev);
    
    //Método Principal
    public TelaGeralAbs(){
        this.inicializar();
        this.eventos();
    }
    
    //Definir configurações da tela
    public void inicializar(){
        //Define o título da tela
        this.setTitle("Sistema de Gestão Escolar");
        //Define a ação de finalizar o programa
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        
        this.getContentPane().add(getPnlHeader(),BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlSide(), BorderLayout.WEST);
        this.getContentPane().add(getPnlContent(), BorderLayout.CENTER);
        
        this.setLocation(200, 100);
        this.setMinimumSize(new Dimension(700,500));
        //this.pack();
        this.setResizable(false);
        
    }
    public void eventos(){
        btnProfessores.addActionListener(this::mudarTelaProf);
        btnAlunos.addActionListener(this::mudarTelaAlunos);
        btnGeral.addActionListener(this::mudarTelaGeral);
        btnOpcoes.addActionListener(this::mudarTelaOpcoes);
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
        pnlSide = null;
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
    public JPanel getTitulo(){
        if(lblTitulo == null){
            pnlTitulo = new JPanel();
            lblTitulo = new JLabel("<html><style>h1{font:30pt Arial;}</style><h1>Geral</h1></html>");
            
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }
    public JPanel getBtnAtualizar(){
        
        if(btnAtualizar == null){
            pnlBtnAtualizar = new JPanel();
            btnAtualizar = new JButton("Atualizar");
            btnAtualizar.setBackground(Color.BLUE);
            btnAtualizar.setForeground(Color.WHITE);
            btnAtualizar.setFocusPainted(false);
            
            pnlBtnAtualizar.add(btnAtualizar);
        }
        return pnlBtnAtualizar;
    }
    public JPanel getContent(){
        if(subPnlContent == null){
            subPnlContent = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
                
            lblQtndAlunos = new JLabel("<html><style>h1{font:20pt Arial;margin-right:5px;margin-bottom:5px;}</style><h1>Total de Alunos</h1></html>");
            lblQtndProf = new JLabel("<html><style>h1{font:20pt Arial;margin-right:5px;margin-bottom:5px;}</style><h1>Total de Professores</h1></html>");
            txtQntdAlunos = new JTextField();
            txtQntdAlunos.setText("Buscando...");
            txtQntdAlunos.setColumns(10);
            txtQntdAlunos.setHorizontalAlignment(JTextField.CENTER);
            txtQntdAlunos.setEditable(false);
            txtQntdAlunos.setMinimumSize(new Dimension(30,10));

            txtQntdProf = new JTextField();
            txtQntdProf.setText("Buscando...");
            txtQntdProf.setColumns(10);
            txtQntdProf.setHorizontalAlignment(JTextField.CENTER);
            txtQntdProf.setEditable(false);
            txtQntdProf.setMinimumSize(new Dimension(30,10));

            gbc.gridx = 0;
            gbc.gridy = 0;
            subPnlContent.add(lblQtndAlunos,gbc);
            gbc.gridx = 1;
            subPnlContent.add(txtQntdAlunos,gbc);

            gbc.gridy = 1;
            gbc.gridx = 0;
            subPnlContent.add(lblQtndProf,gbc);
            gbc.gridx = 1;
            subPnlContent.add(txtQntdProf,gbc);
                 
        }
        
        return subPnlContent;
    }
    public JPanel getPnlContent(){
        pnlContent = new JPanel(new BorderLayout());
        
        pnlContent.add(getTitulo(),BorderLayout.NORTH);
        pnlContent.add(getContent(),BorderLayout.CENTER);
        pnlContent.add(getBtnAtualizar(),BorderLayout.SOUTH);
        
        return pnlContent;
    }
    
}
