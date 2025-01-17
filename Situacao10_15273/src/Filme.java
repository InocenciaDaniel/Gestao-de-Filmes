/*********************************************************************************************/
/* Ficheiro: Apresentação
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : classe responsavel por apresentar o formulario
/*********************************************************************************************/
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.util.Vector;
import SwingComponents.*;
import Calendario.*;

public class Filme extends JFrame {
	
	private JButton gravarJB, limparJB, cancelarJB;
	private JTextField tituloJF, duracaoJF, anoRealizacao;
	private JComboBox generoJC, paisJC, realizadorJC, actorJC;
	private JTextFieldData anoR;
    private JPanel P1,P2,p1,p2;    
    private ModeloFilme modeloFilme;
    private P_ModeloFilme p_filme;
    private boolean teste = true;
    private int idFilme = 0;
 	private Vector nomesR = ModeloPessoa.comboPessoas(1);
    private Vector nomesA = ModeloPessoa.comboPessoas(2);
    
    public Filme()
    {    
    	super("Formulario do Filme");
    	inic();
    	
    	limparJB.addActionListener(
    		new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    				limparForm();
    			}    		});
    	
       gravarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		   salvar();
	    		   limparForm();
	    		} 	    	});
	   
	   cancelarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		  dispose();
	    		}	    	});
    	
    	
    	getContentPane().add(P1,BorderLayout.CENTER);
    	getContentPane().add(P2,BorderLayout.SOUTH);
    	
    	setSize(400,300);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    public Filme(ModeloFilme mfilme)
    {
    	
    
    	super("Formulario do Filme");
    	inic(mfilme,false);
    	cancelarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		  dispose();
	    		}	    	});
    	
    	getContentPane().add(P1,BorderLayout.CENTER);
    	getContentPane().add(P2,BorderLayout.SOUTH);
    	
    	setSize(400,300);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    public Filme(ModeloFilme mfilme , int valor)
    {
    	
    
    	super("Formulario");
    	inic(mfilme,true);
    	this.idFilme = mfilme.getCodFilme()-1;
    	
       gravarJB.setText("Alterar");
       gravarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		   Editar(idFilme);
	    		   dispose();
	    		   try{
					 	new EditarFilme();
					 } catch(Exception f)
					 {					 }		}	});
					 
    	cancelarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		  dispose();
	    		}	    	});
    	getContentPane().add(P1,BorderLayout.CENTER);
    	getContentPane().add(P2,BorderLayout.SOUTH);
    	
    	setSize(400,300);
    	setLocationRelativeTo(null);
    	setVisible(true);	
    }
    public Filme(ModeloFilme mfilme , boolean teste)
    {
    	super("Formulario do Filme");
    	inic(mfilme,true);
    	this.idFilme = mfilme.getCodFilme()-1;
    	
       gravarJB.setText("Apagar");
       gravarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		   Apagar(idFilme);
	    		   dispose();
	    		   try {
					 	new ApagarFilme();	
					 }catch(Exception f){
					 } 		}   	});
					 
		cancelarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		  dispose();
	    		}	    	});
    	getContentPane().add(P1,BorderLayout.CENTER);
    	getContentPane().add(P2,BorderLayout.SOUTH);
    	
    	setSize(400,300);
    	setLocationRelativeTo(null);
    	setVisible(true);
    	
    }
    
    public void inic()
    {
     	tituloJF = new JTextField();
     	duracaoJF = new JTextField();
     	
     	realizadorJC = new JComboBox(nomesR);
     	actorJC = new JComboBox(nomesA);
     	
     	anoR = new JTextFieldData("");
	    gravarJB = new JButton("Gravar");
	    limparJB = new JButton("Limpar");
	    cancelarJB = new JButton("Cancelar");
	    generoJC = UInterfaceBox.createJComboBoxsTabela2(Defs.fileGenero);
	    paisJC = UInterfaceBox.createJComboBoxsTabela2(Defs.filePais);
	    anoRealizacao = anoR.getDTestField();
	    
       p1 = new JPanel();
       p1.setLayout(new GridLayout(1,2));
       
       P1 = new JPanel();
       P1.setLayout(new GridLayout(8,2));
       P2 = new JPanel();
       P2.setLayout(new FlowLayout());
       
       p1.add(anoR.getDTestField());
       p1.add(anoR.getDButton());
       
       P1.add(new JLabel("Formulario Filmes"));
       P1.add(new JLabel(""));
       P1.add(new JLabel("Titulo"));
       P1.add(tituloJF);
       P1.add(new JLabel("Genero"));
       P1.add(generoJC);
       P1.add(new JLabel("Pais"));
       P1.add(paisJC);
       P1.add(new JLabel("Ano de Realização"));
       P1.add(p1);
       P1.add(new JLabel("Realizador"));
       P1.add(realizadorJC);
       P1.add(new JLabel("Actor"));
       P1.add(actorJC);
       P1.add(new JLabel("Duração"));
       P1.add(duracaoJF);
       
       P2.add(gravarJB);
       P2.add(limparJB);
       P2.add(cancelarJB);
    }
    
    public void inic(ModeloFilme filme , boolean bt)
    {
    	tituloJF = new JTextField();
    	tituloJF.setText(filme.getTitulo());
    	
    	realizadorJC = new JComboBox(nomesR);
    	realizadorJC.setSelectedIndex(buscaIndex(filme.getRealizador(),nomesR));
    	
    	actorJC = new JComboBox(nomesA);
    	actorJC.setSelectedIndex(buscaIndex(filme.getActor(),nomesA));
    	
     	duracaoJF = new JTextField();
     	duracaoJF.setText(filme.getDuracao());
     	
     	anoR = new JTextFieldData("");
     	anoRealizacao = anoR.getDTestField();
     	anoR.getDTestField().setText(filme.getAnoRealizacao());
     	
	    gravarJB = new JButton("Gravar");
	    limparJB = new JButton("Limpar");
	    cancelarJB = new JButton("Cancelar");
	    
	    generoJC = UInterfaceBox.createJComboBoxsTabela2(Defs.fileGenero);
	    generoJC.setSelectedItem(filme.getGenero());
	    
	    paisJC = UInterfaceBox.createJComboBoxsTabela2(Defs.filePais);
	    paisJC.setSelectedItem(filme.getPais());
	    
       p1 = new JPanel();
       p2 = new JPanel();
       p1.setLayout(new GridLayout(1,2));
       p2.setLayout(new GridLayout(1,2));
       
       P1 = new JPanel();
       P1.setLayout(new GridLayout(8,2));
       P2 = new JPanel();
       P2.setLayout(new FlowLayout());
       
       p1.add(anoR.getDTestField());
       p1.add(anoR.getDButton());
       
       P1.add(new JLabel("Formulario Filmes"));
       P1.add(new JLabel(""));
       P1.add(new JLabel("Titulo"));
       P1.add(tituloJF);
       P1.add(new JLabel("Genero"));
       P1.add(generoJC);
       P1.add(new JLabel("Pais"));
       P1.add(paisJC);
       P1.add(new JLabel("Ano de Realização"));
       P1.add(p1);
       P1.add(new JLabel("Realizador"));
       P1.add(realizadorJC);
       P1.add(new JLabel("Actor"));
       P1.add(actorJC);
       P1.add(new JLabel("Duração"));
       P1.add(duracaoJF);
       if(bt)
         P2.add(gravarJB);
      
       P2.add(cancelarJB);
    }
 
    public void Editar(int cod)
    {
    	 modeloFilme = new ModeloFilme();
    	 modeloFilme.setCodFilme(cod);
    	 teste = true; 
    	 	
    	 modeloFilme.setTitulo(tituloJF.getText());
    	 
    	 modeloFilme.setRealizador(((ModeloPessoa)nomesR.get(realizadorJC.getSelectedIndex())).getCodPessoa());
    	 modeloFilme.setActor(((ModeloPessoa)nomesA.get(actorJC.getSelectedIndex())).getCodPessoa());
  
    	      if (tituloJF.getText().equals(""))
    	      { 
    	      	teste = false;
    	 	    JOptionPane.showMessageDialog(null,"Titulo nulo");
    	      }
    	      else if (anoRealizacao.getText().equals(""))
    	      { 
    	      	teste = false;
    	 	    JOptionPane.showMessageDialog(null,"Ano de realização nulo");
    	      }
    	      else if (duracaoJF.getText().equals(""))
    	      { 
    	      	teste = false;
    	 	    JOptionPane.showMessageDialog(null,"Duração nulo");
    	      }
    	 modeloFilme.setAnoRealizacao(anoRealizacao.getText());
    	 modeloFilme.setGenero(generoJC.getSelectedItem().toString());
    	 modeloFilme.setPais(paisJC.getSelectedItem().toString());
    	 modeloFilme.setDuracao(duracaoJF.getText());
    	 
    	 if(teste)
    	 {    	 	
    	 	p_filme = new  P_ModeloFilme(modeloFilme);
            try
            {	
            	p_filme.Salvar_Filme(p_filme,'E',(cod*P_ModeloFilme.SizeOf()));
            	
            }catch(Exception e)
            {
            	e.printStackTrace();
            }  	 }	      	
}
    
    public void limparForm()
    {
		tituloJF.setText(""); 
		duracaoJF.setText("");
		anoRealizacao.setText("");		
    }
    public void salvar()
    {
    	modeloFilme = new ModeloFilme();
    	teste = true; 
    	 
    	 modeloFilme.setTitulo(tituloJF.getText());
    	 modeloFilme.setRealizador(((ModeloPessoa)nomesR.get(realizadorJC.getSelectedIndex())).getCodPessoa());
    	 modeloFilme.setActor(((ModeloPessoa)nomesA.get(actorJC.getSelectedIndex())).getCodPessoa());
    	 
    	      if (tituloJF.getText().equals(""))
    	      { 
    	      	teste = false;
    	 	    JOptionPane.showMessageDialog(null,"Titulo nulo");
    	      }
    	      else if (anoRealizacao.getText().equals(""))
    	      { 
    	      	teste = false;
    	 	    JOptionPane.showMessageDialog(null,"Ano de realização nulo");
    	      }
    	      else if (duracaoJF.getText().equals(""))
    	      { 
    	      	teste = false;
    	 	    JOptionPane.showMessageDialog(null,"Duração nulo");
    	      }
    	 modeloFilme.setAnoRealizacao(anoRealizacao.getText());
    	 modeloFilme.setGenero(generoJC.getSelectedItem().toString());
    	 modeloFilme.setPais(paisJC.getSelectedItem().toString());
    	 modeloFilme.setDuracao(duracaoJF.getText());
    	 if(teste)
    	 {
    	 	
    	 	p_filme = new  P_ModeloFilme(modeloFilme);
            try
            {
            	p_filme.Salvar_Filme(p_filme,'S',0);	
            }catch(Exception e)
            {
            	e.printStackTrace();
            }  	 }    }
    
    public void Apagar(int cod)
    {
         p_filme = new  P_ModeloFilme();
         p_filme.setCodigoFilme(cod);
            try
            {
            	p_filme.Salvar_Filme(p_filme,'R',(cod*P_ModeloFilme.SizeOf()));
            }catch(Exception e)
            {
            	e.printStackTrace();
            }  	 }	
    	  
 public int buscaIndex(int id , Vector nomesVt)
 {
 	ModeloPessoa copia;
 	for(int i = 0 ;i<nomesVt.size() ;i++)
 	{
 		copia = (ModeloPessoa)nomesVt.get(i);
 		
 		if(copia.getCodPessoa() == id)
 			return i;   
 	}
 	return 0 ;
 	}
}