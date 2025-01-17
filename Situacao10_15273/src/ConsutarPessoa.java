/*********************************************************************************************/
/* Ficheiro: Apresentação
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : classe que permite fazer consulta sobre informações relacionadas a pessoa
/*********************************************************************************************/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.RandomAccessFile;
import SwingComponents.*;

public class ConsutarPessoa extends JFrame{
	private JPanel painel = new JPanel();
    private List Lista = new List(10,false);
    private String nome ;
    private long  tamanhoRG = 0;
	
		public ConsutarPessoa(String nomePessoa) throws Exception
		{
		
			RandomAccessFile  ficheiro = new RandomAccessFile(Defs.filePessoa,"r");
        	tamanhoRG = ficheiro.length();
        	int cod = 0 ;
        	for(int i = 0 ; i < tamanhoRG ; i += P_ModeloPessoa.SizeOf()){
        	
	        	cod = ficheiro.readInt();
	             byte [] bytNome ;
	             if (cod > 0 ){
	       			nome = Integer.toString(cod) +" - ";
					
					ficheiro.read(bytNome = new byte[100],0,100 );
			
					nome += new String(bytNome).trim();
					
					ficheiro.skipBytes(27);
					if(new String(bytNome).toLowerCase().contains(nomePessoa.toLowerCase()))									
						Lista.add(nome);
             		}
             
         	    else 
              	 ficheiro.skipBytes(127);
         	}
        	
         ficheiro.close();
         
         Lista.addActionListener(	  	   
		  	new ActionListener(){
					public void actionPerformed( ActionEvent event ){
						  try{
						  		mostrar((Integer.parseInt(String.valueOf(Lista.getSelectedItem().substring(0,2).trim()))-1));
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
	     new SalvarPessoa(pessoa);		
	}
}