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

public class Pessoa extends JFrame {
	
	private JButton gravarJB, limparJB, cancelarJB;
	private JTextField nomeJF, dataNacimento;
	private JComboBox sexoJC, paisJC, tipoJC;
	private JTextFieldData dataN;
    private JPanel P1,P2,p1,p2;
    private ModeloPessoa modeloPessoa;
    private P_ModeloPessoa p_pessoa;
    private boolean teste = true;
    private int idPessoa = 0; 

     
    public Pessoa()
    {    
    	super("Formulario Nova Pessoa");
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
    
    public Pessoa(ModeloPessoa mpessoa)
    {
    	super("Formulario Pessoa");
    	inic(mpessoa,false);
    	
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
    public Pessoa(ModeloPessoa mpessoa , int valor)
    {
    	super("Formulario");
    	inic(mpessoa,true);
    	this.idPessoa = mpessoa.getCodPessoa()-1;
    	
       gravarJB.setText("Editar");
       
       gravarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		   Editar(idPessoa);
	    		   dispose();
	    		   try{
					 	new EditarPessoa();
					 	
					 }catch(Exception f)
					 {
					 }	}	});
	   
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
    public Pessoa(ModeloPessoa mpessoa , boolean teste)
    {
    	super("Formulario");
    	inic(mpessoa,true);
    	this.idPessoa = mpessoa.getCodPessoa()-1;
    	
       gravarJB.setText("Eliminar");
       gravarJB.addActionListener(
	    	new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		   Apagar(idPessoa);
	    		   dispose();
	    		   try{
					 	new ApagarPessoa();	
					 }catch(Exception f)
					 {
					 }	}	});
	   
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
     	nomeJF = new JTextField();
     	dataN = new JTextFieldData("");
	    gravarJB = new JButton("Gravar");
	    limparJB = new JButton("Limpar");
	    cancelarJB = new JButton("Cancelar");
	    sexoJC = UInterfaceBox.createJComboBoxsTabela2(Defs.fileSexo);
	    paisJC = UInterfaceBox.createJComboBoxsTabela2(Defs.filePais);
	    tipoJC = UInterfaceBox.createJComboBoxsTabela2(Defs.fileTipo);
	    dataNacimento = dataN.getDTestField();
	    
       p1 = new JPanel();
       p2 = new JPanel();
       p1.setLayout(new GridLayout(1,2));
       p2.setLayout(new GridLayout(1,2));
       
       p1.add(dataN.getDTestField());
       p1.add(dataN.getDButton());
       
       P1 = new JPanel();
       P1.setLayout(new GridLayout(9,2));
       P2 = new JPanel();
       P2.setLayout(new FlowLayout());
       
       
       P1.add(new JLabel("Formulario Pessoa"));
       P1.add(new JLabel(""));
       P1.add(new JLabel(""));
       P1.add(new JLabel(""));
       P1.add(new JLabel("Nome"));
       P1.add(nomeJF);
       P1.add(new JLabel("Sexo"));
       P1.add(sexoJC);
       P1.add(new JLabel("Pais"));
       P1.add(paisJC);
       P1.add(new JLabel("Data de nascimento"));
       P1.add(p1);
       P1.add(new JLabel("Tipo de pessoa"));
       P1.add(tipoJC);
       
       P2.add(gravarJB);
       P2.add(limparJB);
       P2.add(cancelarJB);
    }
    
    public void inic(ModeloPessoa pessoa , boolean bt)
    {
    	nomeJF = new JTextField();
    	nomeJF.setText(pessoa.getNome());
    	
     	dataN = new JTextFieldData("");
     	dataNacimento = dataN.getDTestField();
     	dataN.getDTestField().setText(pessoa.getDataNasc());
     	
	    gravarJB = new JButton("Gravar");
	    limparJB = new JButton("Limpar");
	    cancelarJB = new JButton("Cancelar");
	    
	    sexoJC = UInterfaceBox.createJComboBoxsTabela2(Defs.fileSexo);
	    sexoJC.setSelectedItem(pessoa.getSexo());
	    
	    paisJC = UInterfaceBox.createJComboBoxsTabela2(Defs.filePais);
	    paisJC.setSelectedItem(pessoa.getPais());
	    
	    tipoJC = UInterfaceBox.createJComboBoxsTabela2(Defs.fileTipo);
	    tipoJC.setSelectedItem(pessoa.getTipo());
	    
       p1 = new JPanel();
       p2 = new JPanel();
       p1.setLayout(new GridLayout(1,2));
       p2.setLayout(new GridLayout(1,2));
       
       p1.add(dataN.getDTestField());
       p1.add(dataN.getDButton());
       
       P1 = new JPanel();
       P1.setLayout(new GridLayout(9,2));
       P2 = new JPanel();
       P2.setLayout(new FlowLayout());
       
       
       P1.add(new JLabel("Formulario Pessoa"));
       P1.add(new JLabel(""));
       P1.add(new JLabel(""));
       P1.add(new JLabel(""));
       P1.add(new JLabel("Nome"));
       P1.add(nomeJF);
       P1.add(new JLabel("Sexo"));
       P1.add(sexoJC);
       P1.add(new JLabel("Pais"));
       P1.add(paisJC);
       P1.add(new JLabel("Data de nascimento"));
       P1.add(p1);
       P1.add(new JLabel("Tipo de pessoa"));
       P1.add(tipoJC);
       
       if(bt)
         P2.add(gravarJB);
              
       P2.add(cancelarJB);
    }
    
    public void limparForm()
    {
		nomeJF.setText("");
		dataNacimento.setText(""); 
    }
    
    public void salvar()
    {
    	 modeloPessoa = new ModeloPessoa();
    	 teste = true;
    	 
    	 modeloPessoa.setNome(nomeJF.getText());
    	 	if (nomeJF.getText().equals(""))
    	      { 
    	      	teste = false;
    	 	    JOptionPane.showMessageDialog(null,"Nome nulo");
    	      }  
    	      else if (dataNacimento.getText().equals(""))
    	      { 
    	      	teste = false;
    	 	    JOptionPane.showMessageDialog(null,"Data Nascimento nulo");
    	      }
    	 modeloPessoa.setSexo(sexoJC.getSelectedItem().toString());
    	 modeloPessoa.setPais(paisJC.getSelectedItem().toString());
    	 modeloPessoa.setDataNasc(dataNacimento.getText());
    	 modeloPessoa.setTipo(tipoJC.getSelectedItem().toString());
    	 if(teste)
    	 {
    	 	p_pessoa = new  P_ModeloPessoa(modeloPessoa);
            try
            {
            	p_pessoa.Salvar_Pessao(p_pessoa,'S',0);
            	
            }catch(Exception e)
            {
            	e.printStackTrace();
            }  	 }	   }
    
    public void Editar(int cod)
    {
    	 
    	 modeloPessoa = new ModeloPessoa();
    	 modeloPessoa.setCodPessoa(cod);
    	 teste = true; 
    	 	
	 	modeloPessoa.setNome(nomeJF.getText());
	 	if (nomeJF.getText().equals(""))
	      { 
	      	teste = false;
	 	    JOptionPane.showMessageDialog(null,"Nome nulo");
	      }  
	      else if (dataNacimento.getText().equals(""))
	      { 
	      	teste = false;
	 	    JOptionPane.showMessageDialog(null,"Data Nascimento nulo");
	      }
    	 modeloPessoa.setSexo(sexoJC.getSelectedItem().toString());
    	 modeloPessoa.setPais(paisJC.getSelectedItem().toString());
    	 modeloPessoa.setDataNasc(dataNacimento.getText());
    	 modeloPessoa.setTipo(tipoJC.getSelectedItem().toString());
    	 
    	 if(teste)
    	 {
    	 	p_pessoa = new  P_ModeloPessoa(modeloPessoa);
            try{
            	p_pessoa.Salvar_Pessao(p_pessoa,'E',(cod*P_ModeloPessoa.SizeOf()));	
            }catch(Exception e){
            	e.printStackTrace();
            }
    	 }	      	
    }
    
    public void Apagar(int cod)
    {
         p_pessoa = new  P_ModeloPessoa();
         p_pessoa.setCodigoPessoa(cod);
            try{
            	p_pessoa.Salvar_Pessao(p_pessoa,'R',(cod*P_ModeloPessoa.SizeOf()));
            }catch(Exception e){
            	e.printStackTrace();
            }
    	 }	
    	  
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