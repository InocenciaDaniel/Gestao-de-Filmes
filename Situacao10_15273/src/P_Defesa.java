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
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.RandomAccessFile;
import SwingComponents.*;
import Calendario.JTextFieldData;

public class P_Defesa extends JFrame {
	
	private JButton pesquisaJB;
	private JComboBox realizadorJC, actor;
    private JPanel P1,P2,p1;    
    private ModeloFilme modeloFilme;
    private P_ModeloFilme p_filme;
    private boolean teste = true;
    private int idFilme = 0;
 	private Vector nomesR = ModeloPessoa.comboPessoas(1);
 	private Vector nomesA = ModeloPessoa.comboPessoas(2);
 	
	private JPanel painel = new JPanel();
    private List Lista = new List(10,false);
    private String nome ;
    private long  tamanhoRG = 0;
    
    public P_Defesa()
    {    
    	super("Pesquisa");
    	inic();
    	
    	pesquisaJB.addActionListener(
    		new ActionListener(){
    			public void actionPerformed(ActionEvent e){
    			try{
	    		    		new ConsutarPessoa(actor.toString());
	    		    	}
	    		    	catch(Exception r){
	    		    		r.printStackTrace();
	    		    	}   	}	    });
    	
    	getContentPane().add(P1,BorderLayout.CENTER);
    	getContentPane().add(P2,BorderLayout.SOUTH);
    	
    	setSize(300,200);
    	setLocationRelativeTo(null);
    	setVisible(true);
    }
    
    public void inic()
    {
     	
     	realizadorJC = new JComboBox(nomesR);
     	actor = new JComboBox(nomesA);
	    pesquisaJB = new JButton("Pesquisa");
	    
       p1 = new JPanel();
       p1.setLayout(new GridLayout(1,2));
       
       P1 = new JPanel();
       P1.setLayout(new GridLayout(3,2));
       P2 = new JPanel();
       P2.setLayout(new FlowLayout());
       
       P1.add(new JLabel("Formulario Filmes"));
       P1.add(new JLabel(""));
       P1.add(new JLabel("Realizador"));
       P1.add(realizadorJC);
       P1.add(new JLabel("Actor"));
       P1.add(actor);
       
       P2.add(pesquisaJB);
    }
}