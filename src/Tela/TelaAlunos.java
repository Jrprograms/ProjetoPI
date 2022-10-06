package Tela;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaAlunos extends TelaGeralAbs{
    
    //Lista de Materias e Turmas
    protected JComboBox<String> cmbxMat;
    protected JComboBox<String> cmbxTurma;
    
    //Botoes
    protected JPanel pnlBtns;
    protected JButton btnAvancar;
    protected JButton btnVoltar;
    
    //Tabela pra mostrar Alunos/Nota
    protected JPanel pnlTabela;
    protected int maxBusca;
    
    protected ArrayList<JTextField> Alunos;
    protected JTextField Aluno1;
    protected JTextField Aluno2;
    protected JTextField Aluno3;
    protected JTextField Aluno4;
    protected JTextField Aluno5;
    
    protected ArrayList<JTextField> Notas;
    protected JTextField Nota1;
    protected JTextField Nota2;
    protected JTextField Nota3;
    protected JTextField Nota4;
    protected JTextField Nota5;
    
    //Eventos dos botoes
    protected void avancarTableAlunos(ActionEvent ev){
        Aluno1.setText("oi");
    }
    protected void voltarTableAlunos(ActionEvent ev){
        Aluno1.setText("teste");
    }
    

    @Override
    protected void mudarTelaGeral(ActionEvent ev){
        this.dispose();
        TelaMain.mostrarTela("principal");
    }
    @Override
    protected void mudarTelaAlunos(ActionEvent ev){
       
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
    @Override
    public void eventos(){
        btnProfessores.addActionListener(this::mudarTelaProf);
        btnAlunos.addActionListener(this::mudarTelaAlunos);
        btnGeral.addActionListener(this::mudarTelaGeral);
        btnOpcoes.addActionListener(this::mudarTelaOpcoes);
        btnAvancar.addActionListener(this::avancarTableAlunos);
        btnVoltar.addActionListener(this::voltarTableAlunos);
    }
    
    @Override
    public JPanel getTitulo(){
        if(lblTitulo == null){
            pnlTitulo = new JPanel();
            lblTitulo = new JLabel("<html><style>h1{font:30pt Arial;}</style><h1>Alunos</h1></html>");
            
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
    }
    @Override
    public JPanel getContent(){
        if(subPnlContent == null){
                subPnlContent = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.BOTH;
                
                cmbxMat= new JComboBox<>();
                cmbxMat.addItem("Matéria");
                
                cmbxTurma= new JComboBox<>();
                cmbxTurma.addItem("Turma");
                
                gbc.gridx = 0;
                gbc.gridy = 0;
                subPnlContent.add(cmbxTurma,gbc);
                gbc.gridy = 1;
                subPnlContent.add(cmbxMat,gbc);
                gbc.gridy = 2;
                subPnlContent.add(getTableAlunos(),gbc);
                gbc.gridy = 3;
                subPnlContent.add(getBtnsTable(),gbc);
        }
        
        return subPnlContent;
    }
    @Override
    public JPanel getBtnAtualizar(){
        
        if(btnAtualizar == null){
            pnlBtnAtualizar = new JPanel();
            btnAtualizar = new JButton("Pesquisar");
            btnAtualizar.setBackground(Color.BLUE);
            btnAtualizar.setForeground(Color.WHITE);
            btnAtualizar.setFocusPainted(false);
            
            pnlBtnAtualizar.add(btnAtualizar);
        }
        return pnlBtnAtualizar;
    }
    //Tabela de Alunos 
    private JPanel getTableAlunos(){
        
        pnlTabela = new JPanel(new GridLayout(5, 2));
        pnlTabela.setMinimumSize(new Dimension(100,50));
        
        maxBusca = 5;
        Alunos = new ArrayList<>();
        
        Aluno1 = new JTextField();
        Aluno2 = new JTextField();
        Aluno3 = new JTextField();
        Aluno4 = new JTextField();
        Aluno5 = new JTextField();

        Nota1 = new JTextField();
        Nota2 = new JTextField();
        Nota3 = new JTextField();
        Nota4 = new JTextField();
        Nota5 = new JTextField();
        
        Notas = new ArrayList<>();
        Notas.add(Nota1);
        Notas.add(Nota2);
        Notas.add(Nota3);
        Notas.add(Nota4);
        Notas.add(Nota5);
        
        //Organizando os JTXTS
        Aluno1.setColumns(5);
        Aluno1.setText("Teste");
        Aluno1.setEditable(false);
        Aluno2.setColumns(5);
        Aluno2.setText("Teste");
        Aluno2.setEditable(false);
        Aluno3.setColumns(5);
        Aluno3.setText("Teste");
        Aluno3.setEditable(false);
        Aluno4.setColumns(5);
        Aluno4.setText("Teste");
        Aluno4.setEditable(false);
        Aluno5.setColumns(5);
        Aluno5.setText("Teste");
        Aluno5.setEditable(false);
        
        Nota1.setColumns(5);
        Nota1.setText("Teste");
        Nota1.setEditable(false);
        Nota2.setColumns(5);
        Nota2.setText("Teste");
        Nota2.setEditable(false);
        Nota3.setColumns(5);
        Nota3.setText("Teste");
        Nota3.setEditable(false);
        Nota4.setColumns(5);
        Nota4.setText("Teste");
        Nota4.setEditable(false);
        Nota5.setColumns(5);
        Nota5.setText("Teste");
        Nota5.setEditable(false);
        
        Alunos.add(Aluno1);
        Alunos.add(Aluno2);
        Alunos.add(Aluno3);
        Alunos.add(Aluno4);
        Alunos.add(Aluno5);
        

        for(int i = 0; i < maxBusca; i++){
            pnlTabela.add(Alunos.get(i));
            pnlTabela.add(Notas.get(i));
        }
  
       return pnlTabela;
    }
    //Botoes da tabela
    private JPanel getBtnsTable(){
        
        if(btnAvancar == null){   
            pnlBtns = new JPanel(new GridLayout(1, 2));
            
            btnAvancar = new JButton("Próximo>");
            pnlBtns.add(btnAvancar);
            
            btnVoltar = new JButton("<Voltar");
            pnlBtns.add(btnVoltar);
            
        }
        return pnlBtns;
    }

}
