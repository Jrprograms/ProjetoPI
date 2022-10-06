package Tela;

import br.com.escola.dao.DadosDAO;
import br.com.escola.dao.ProfessorDAO;
import br.com.escola.professor.Professor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class TelaProfessores extends TelaGeralAbs{
    
    //Elementos únicos da tela
    protected JLabel lblProfessor;
    protected JComboBox<String> cmbxProf;
    protected JLabel lblMateria;
    protected JComboBox<String> cmbxMat;
    protected JLabel lblTurma;
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
    
    
    //Eventos dos botoes
    protected void avancarTableAlunos(ActionEvent ev){
        Aluno1.setText("");
        Aluno2.setText("");
        Aluno3.setText("");
        Aluno4.setText("");
        Aluno5.setText("");
        
        DadosDAO BDAlunos = new DadosDAO();
        String turma = String.valueOf(cmbxTurma.getSelectedItem());
        String[] alunos = BDAlunos.getAlunos(turma);
        if(Aluno1.getText() != null){
            Aluno1.setText(alunos[0].substring(0, 15));
        }
        if(Aluno2.getText() != null){
            Aluno2.setText(alunos[1].substring(0, 15));
        }
        if(Aluno3.getText() != null){
            Aluno3.setText(alunos[2].substring(0, 15));
        }
    }
    /*protected void voltarTableAlunos(ActionEvent ev){
    }*/
    
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
        
    }
    @Override
    protected void mudarTelaOpcoes(ActionEvent ev) {
        this.dispose();
        TelaMain.mostrarTela("opcoes");
    }
    @Override
    public void inicializar(){
        //Define o título da tela
        this.setTitle("Sistema de Gestão Escolar");
        //Define a ação de finalizar o programa
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        
        this.getContentPane().add(getPnlHeader(),BorderLayout.PAGE_START);
        this.getContentPane().add(getPnlSide(), BorderLayout.WEST);
        this.getContentPane().add(getPnlContent(), BorderLayout.CENTER);
        this.getContentPane().add(getTableAlunos(),BorderLayout.SOUTH);
        
        this.setLocation(200, 100);
        this.setMinimumSize(new Dimension(700,500));
        //this.pack();
        this.setResizable(false);
        
    }
    @Override
    public void eventos(){
        btnProfessores.addActionListener(this::mudarTelaProf);
        btnAlunos.addActionListener(this::mudarTelaAlunos);
        btnGeral.addActionListener(this::mudarTelaGeral);
        btnOpcoes.addActionListener(this::mudarTelaOpcoes);
        btnAtualizar.addActionListener(this::avancarTableAlunos);
        /*btnAvancar.addActionListener(this::avancarTableAlunos);
        btnVoltar.addActionListener(this::voltarTableAlunos);*/
    }
    @Override
    public JPanel getContent(){
        if(subPnlContent == null){
                subPnlContent = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.fill = GridBagConstraints.BOTH;
                
                //Lista de Professores
                /* Adionar método de busca */ 
                lblProfessor = new JLabel("<html><style>p{margin-right:5px;}</style><p>Professor: </p></html>");
                cmbxProf = new JComboBox<>();
               
                
                //Lista de Matérias do Professor
                lblMateria = new JLabel("<html><style>p{margin-right:5px;}</style><p>Matéria: </p></html>");
                cmbxMat= new JComboBox<>();
                
                
                //Lista de Turmas do Professor
                lblTurma = new JLabel("<html><style>p{margin-right:5px;}</style><p>Turma(s): </p></html>");
                cmbxTurma = new JComboBox<>();
                
                addItemsCmbx("professor");
                
                gbc.gridx = 0;
                gbc.gridy = 0;
                subPnlContent.add(lblProfessor,gbc);
                gbc.gridx = 1;
                gbc.gridy = 0;
                subPnlContent.add(cmbxProf,gbc);
                gbc.gridx = 0;
                gbc.gridy = 1;
                subPnlContent.add(lblMateria,gbc);
                gbc.gridx = 1;
                gbc.gridy = 1;
                subPnlContent.add(cmbxMat,gbc);
                gbc.gridx = 0;
                gbc.gridy = 2;
                subPnlContent.add(lblTurma,gbc);
                gbc.gridx = 1;
                gbc.gridy = 2;
                subPnlContent.add(cmbxTurma,gbc);
                gbc.gridx = 0;
                gbc.gridy = 3;
                /*subPnlContent.add(getBtnsTable(),gbc);*/
        }
        
        return subPnlContent;
    }
    
    @Override
    public JPanel getTitulo(){
        if(lblTitulo == null){
            pnlTitulo = new JPanel();
            lblTitulo = new JLabel("<html><style>h1{font:30pt Arial;}</style><h1>Professores</h1></html>");
            
            pnlTitulo.add(lblTitulo);
        }
        return pnlTitulo;
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
        
        int COLUNAS = 5;
        
        pnlTabela = new JPanel(new GridLayout(3, 2));
        pnlTabela.setMinimumSize(new Dimension(100,50));
        
        maxBusca = 5;
        Alunos = new ArrayList<>();
        
        Aluno1 = new JTextField();
        Aluno2 = new JTextField();
        Aluno3 = new JTextField();
        Aluno4 = new JTextField();
        Aluno5 = new JTextField();

        
        //Organizando os JTXTS
        Aluno1.setColumns(COLUNAS);
        Aluno1.setText("");
        Aluno1.setEditable(false);
        Aluno2.setColumns(COLUNAS);
        Aluno2.setText("");
        Aluno2.setEditable(false);
        Aluno3.setColumns(COLUNAS);
        Aluno3.setText("");
        Aluno3.setEditable(false);
        Aluno4.setColumns(COLUNAS);
        Aluno4.setText("");
        Aluno4.setEditable(false);
        Aluno5.setColumns(COLUNAS);
        Aluno5.setText("");
        Aluno5.setEditable(false);
        
        
        Alunos.add(Aluno1);
        Alunos.add(Aluno2);
        Alunos.add(Aluno3);
        Alunos.add(Aluno4);
        Alunos.add(Aluno5);
        

        for(int i = 0; i < maxBusca; i++){
            pnlTabela.add(Alunos.get(i));
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

    private void addItemsCmbx(String nome) {
        if(nome.equals("professor")){

            ProfessorDAO prof = new ProfessorDAO();
            String[] nomes;
            
        for(Professor professor : prof.getProfessores()){
           
            cmbxMat.addItem(professor.getMateria());
            cmbxProf.addItem(professor.getNome());
            
            for(String t : professor.getTurmas()){
                if(!"".equals(t)){
                    cmbxTurma.addItem(t);
                }
            }
        }
        
        }else if(nome.equals("materia")){
        
        }
    }

}
