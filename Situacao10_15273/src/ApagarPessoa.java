/*********************************************************************************************/
/* Ficheiro: Apresentação
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : classe responsavel por apagar fichas no ficheiro pessoa.dat
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

public class ApagarPessoa extends JFrame{
	private JPanel painel = new JPanel();
    private List Lista = new List(10,false);
    private String nome ;
    private long  tamanhoRG = 0;
    
	public ApagarPessoa() throws Exception
	{
		RandomAccessFile  ficheiro = new RandomAccessFile(Defs.filePessoa,"r");
        tamanhoRG = ficheiro.length();
        int cod = 0 ;
       
        for(int i = 0 ; i < tamanhoRG ; i += P_ModeloPessoa.SizeOf())
        {
             cod = ficheiro.readInt();
             byte [] bytNome ;
             if (cod > 0 )
             {
				nome = Integer.toString(cod) +" - ";
				
				ficheiro.read(bytNome =new byte[100],0,100 );
				nome += new String(bytNome).trim();
				
				Lista.add(nome);
				ficheiro.skipBytes(27);
             }
             else 
               ficheiro.skipBytes(P_ModeloPessoa.SizeOf()-4);	
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
						  }		}		});
						  
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
	  	P_ModeloPessoa mpessoa = new P_ModeloPessoa();
	  	ModeloPessoa pessoa;
	  	byte [] nome, dataNasc, tipo;
	 
	    RandomAccessFile  ficheiro = new RandomAccessFile(Defs.filePessoa,"r");
	   
	     ficheiro.seek(codReg*P_ModeloPessoa.SizeOf());
	     
	    mpessoa.setCodigoPessoa(ficheiro.readInt());	
	    	
		ficheiro.read(nome = new byte[100],0,100 );
		mpessoa.setNome(new String(nome).trim());
		
		ficheiro.read(dataNasc = new byte[15],0,15 );
		mpessoa.setDataNasc(new String(dataNasc).trim());
		
		mpessoa.setSexo(ficheiro.readInt());
		mpessoa.setPais(ficheiro.readInt());
		mpessoa.setTipo(ficheiro.readInt());
		
		pessoa = new ModeloPessoa(mpessoa);
	    
	    //JOptionPane.showMessageDialog(null,mpessoa.toString());
	    //JOptionPane.showMessageDialog(null,pessoa.toString());
        
	     new SalvarPessoa(pessoa,true);			
	}
}