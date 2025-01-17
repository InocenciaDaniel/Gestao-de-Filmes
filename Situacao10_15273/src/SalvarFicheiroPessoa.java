/*********************************************************************************************/
/* Ficheiro: Apresentação
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto
/* Descrição : classe responsavel por salvar o formulario
/*********************************************************************************************/
import java.io.*;
import javax.swing.*;
import SwingComponents.*;

public class SalvarFicheiroPessoa {

	public SalvarFicheiroPessoa() {
		// TODO: Add your code here
	}
	
 private static String ColetarDados(String dados , int size )
  {
  	int tamanho = dados.length();
  	
  	if (tamanho > size)
  		dados = dados.substring(0,size);
    else
	    {
	    	for( int i = tamanho ; i < size ; i++)
  		        dados += ' ';
	    }
  	    
  	return dados;
  } 
	                            // modo = Que tipo de Opracao( Salvar ,alterar,eliminar)
	                            //offSet = saltar bytes(reg)
	public static void SalvarFPessoa(char modo , int offset , P_ModeloPessoa pessoa ) throws IOException	
	{
		RandomAccessFile Ficheiro;
	    int numero = 0 ;
	    
	    Ficheiro = new RandomAccessFile(Defs.filePessoa, "rw");
	    
	    if (modo == 'S')
	    {
	    	RandomAccessFile FichaNumero;
		    FichaNumero = new RandomAccessFile("Numero da Ultima Pessoa.dat", "rw");
		    
		    if (FichaNumero.length() != 0)
		    {
		    	numero = FichaNumero.readInt() + 1;
		    	FichaNumero.seek(0);
		    }
		    else
		    	numero = 1;
		    	
		 	FichaNumero.writeInt(numero);
		 	Ficheiro.seek(Ficheiro.length());
		 	Ficheiro.writeInt(numero);
		 	
			Ficheiro.writeBytes(ColetarDados(pessoa.getNome(),100));
			//104 
			Ficheiro.writeBytes(ColetarDados(pessoa.getDataNasc(),15));
		    Ficheiro.writeInt(pessoa.getSexo());
		    Ficheiro.writeInt(pessoa.getPais());
		    Ficheiro.writeInt(pessoa.getTipo());
		    	  	
		    FichaNumero.close();	    
		    Ficheiro.close();
		    JOptionPane.showMessageDialog(null,"Ficha Número: " + numero  + " Guardada com Exito"
		    								, "Numero da Ficha", JOptionPane.PLAIN_MESSAGE);
		} 
		   
		if (modo == 'E')
	    {   
	    	//tamanho registo + 4 (pula o id do registo a ser alterado)
		    Ficheiro.seek(offset + 4);
		     
		 	Ficheiro.writeBytes(ColetarDados(pessoa.getNome(),100));
			//104 
			Ficheiro.writeBytes(ColetarDados(pessoa.getDataNasc(),15));
		    Ficheiro.writeInt(pessoa.getSexo());
		    Ficheiro.writeInt(pessoa.getPais());
		    Ficheiro.writeInt(pessoa.getTipo());	  	
		    
		    Ficheiro.close();
		    
		    JOptionPane.showMessageDialog(null,"Ficha Modificada com Exito"
		    								, "Resultado", JOptionPane.PLAIN_MESSAGE);

		}
		
		if (modo == 'R')
	    {   
		    Ficheiro.seek(offset); 
             
            int valor = (pessoa.getCodigoPessoa() *(-1));
              	
		    Ficheiro.writeInt(valor); 
			
		    Ficheiro.close();
		    
		    JOptionPane.showMessageDialog(null,"Ficha Nº "+(pessoa.getCodigoPessoa()+1) +"  Eliminada com Exito"
		    								, "Resultado", JOptionPane.PLAIN_MESSAGE);
		}
	}
}