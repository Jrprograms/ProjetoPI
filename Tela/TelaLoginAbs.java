/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Carvalhos
 */
public abstract class TelaLoginAbs extends JFrame{
    
    //Painel do cabeçalho, do txt Login, do formulário e do botao
    protected JPanel pnlHeader;
    protected JPanel pnlLblLogin;
    protected JPanel pnlForm;
    protected JPanel pnlBtnLogin;
    
    //Itens pro painel do cabeçalho
    protected JLabel lblHeader;
    
    //Itens pro painel de formulário
    protected JLabel lblLogin;
    protected JLabel lblUsername;
    protected JTextField txtUsername;
    protected JLabel lblPassword;
    protected JTextField txtPassword;
    protected JButton btnLogin;
    
    //Eventos dos botões
    protected abstract void login(ActionEvent ev);    
    //Método principal
    public TelaLoginAbs(){
        this.inicializar();
        this.eventos();
    }
    
    //Definir configurações da tela
    private void inicializar(){
        //Define o Título da tela
        this.setTitle("Sistema de Gestão Escolar");
        //Define a ação de finalizar o programa
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //Define o layout da tela
        this.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        
        //Definindo a posição que vai add
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        this.getContentPane().add(getPnlHeader(),gbc);
        gbc.gridy = 1;
        this.getContentPane().add(getLblLogin(),gbc);
        gbc.gridy = 2;
        this.getContentPane().add(getPnlForm(),gbc);
        gbc.gridy = 3;
        this.getContentPane().add(getBtnLogin(),gbc);
        
        /*this.getContentPane().add(getPnlHeader(),BorderLayout.PAGE_START);
        this.getContentPane().add(getLblLogin(),BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlForm(),BorderLayout.CENTER);*/
        
        
        this.pack();
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
    public JPanel getLblLogin(){
        if(lblLogin == null){
            
            pnlLblLogin = new JPanel();
            
            lblLogin = new JLabel("<html><h1>Login</h1><html>");
            lblLogin.setFont(new Font("Serif",Font.PLAIN,18));
            
            pnlLblLogin.add(lblLogin);
        }
        
        return pnlLblLogin;
    }
    public JPanel getBtnLogin(){
        if(btnLogin == null){
            
            pnlBtnLogin = new JPanel();
            
            btnLogin = new JButton("Entrar");
            btnLogin.setBackground(Color.blue);
            btnLogin.setForeground(Color.white);
            
            pnlBtnLogin.add(btnLogin);
        }
        return pnlBtnLogin;
    }
    public JPanel getPnlForm(){
        if(pnlForm == null){
            pnlForm = new JPanel(new GridLayout(3,2));
            
            
            
            lblUsername = new JLabel("<html><h2>Usuário</h2></html>");
            lblPassword = new JLabel("<html><h2>Senha</h2></html>");
            
            txtUsername = new JTextField(20);
            txtPassword = new JTextField(20);
            
            pnlForm.add(lblUsername);
            pnlForm.add(txtUsername);
            pnlForm.add(lblPassword);
            pnlForm.add(txtPassword);
        }
        
        return pnlForm;
    }
    
    //Eventos dos botões
    private void eventos(){
        btnLogin.addActionListener(this::login);
    }
}
