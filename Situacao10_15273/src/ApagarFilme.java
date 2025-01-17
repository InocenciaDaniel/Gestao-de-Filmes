/*********************************************************************************************/
/* Ficheiro: Apresentação
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : classe responsavel por apagar fichas no ficheiro filme.dat
/*********************************************************************************************/
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.List;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.util.StringTokenizer;
import SwingComponents.*;

public class ApagarFilme extends JFrame{
	private JPanel painel = new JPanel();
    private List Lista = new List(10,false);
    private String nome ;
    private long  tamanhoRG = 0;
	public ApagarFilme() throws Exception
	{
		RandomAccessFile  ficheiro = new RandomAccessFile(Defs.fileFilme,"r");
        tamanhoRG = ficheiro.length();
        int cod = 0 ;
       
        for(int i = 0 ; i < tamanhoRG ; i += P_ModeloFilme.SizeOf())
        {
             cod = ficheiro.readInt();
             byte [] bytNome ;
             if (cod > 0 )
             {
				nome = Integer.toString(cod) +" - ";
				
				ficheiro.read(bytNome =new byte[100],0,100 );
				nome += new String(bytNome).trim();
				
				Lista.add(nome);
				ficheiro.skipBytes(46);
             }
             else 
               ficheiro.skipBytes(P_ModeloFilme.SizeOf()-4);
        }
        ficheiro.close();
        
        Lista.addActionListener(	  	   
		  	new ActionListener(){
					public void actionPerformed( ActionEvent event ){
						  try{
						  		StringTokenizer st = new StringTokenizer(Lista.getSelectedItem().toString(), "-");
						   		mostrar((Integer.parseInt(st.nextElement().toString().trim())-1));
						  }catch(Exception e){
						  	e.printStackTrace();
						  }		}	});
						  
	   painel.setLayout(new BorderLayout());
	   painel.add(Lista,BorderLayout.CENTER);
	   
	   getContentPane().setLayout(new BorderLayout());
	   getContentPane().add(painel, BorderLayout.CENTER);
	   setSize(300,400);
	   setLocationRelativeTo(null);
	   setVisible(true);	
	}

  private void mostrar(int codReg) throws Exception	  	
  {
  		P_ModeloFilme mfilme = new P_ModeloFilme();
	  	ModeloFilme filme;
	  	byte [] titulo, anoRealizacao, duracao, realizador, actor;
	
	    RandomAccessFile  ficheiro = new RandomAccessFile(Defs.fileFilme,"r");
	  
	     ficheiro.seek(codReg*P_ModeloFilme.SizeOf());
	    
	    mfilme.setCodigoFilme(ficheiro.readInt());
	    
		ficheiro.read(titulo = new byte[100],0,100 );
		mfilme.setTitulo(new String(titulo).trim());
		
		ficheiro.read(duracao = new byte[15],0,15 );
		mfilme.setDuracao(new String(duracao).trim());
		
		ficheiro.read(anoRealizacao = new byte[15],0,15 );
		mfilme.setAnoRealizacao(new String(anoRealizacao).trim());
		
		mfilme.setRealizador(ficheiro.readInt());
		mfilme.setActor(ficheiro.readInt());		
	    mfilme.setGenero(ficheiro.readInt());
	    mfilme.setPais(ficheiro.readInt());
	    
	    filme = new ModeloFilme(mfilme);
	    
	    //JOptionPane.showMessageDialog(null,mfilme.toString());
	    //JOptionPane.showMessageDialog(null,filme.toString());
        
	     new SalvarFilme(filme,true);
	     
	     }
}