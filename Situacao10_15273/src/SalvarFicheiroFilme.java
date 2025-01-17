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

public class SalvarFicheiroFilme {
	
	public SalvarFicheiroFilme() {
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
	public static void SalvarFFilme(char modo , int offset , P_ModeloFilme filme ) throws IOException	
	{
		RandomAccessFile Ficheiro;
	    int numero = 0 ;
	   
	    Ficheiro = new RandomAccessFile(Defs.fileFilme, "rw");
	    
	    if (modo == 'S')
	    {
	    	RandomAccessFile FichaNumero;
		    FichaNumero = new RandomAccessFile("Numero do Ultima Filme.dat", "rw");
		    
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
		 		
			Ficheiro.writeBytes(ColetarDados(filme.getTitulo(),100));
			//104 
			Ficheiro.writeBytes(ColetarDados(filme.getDuracao(),15));
			Ficheiro.writeBytes(ColetarDados(filme.getAnoRealizacao(),15));
		    //103
		    Ficheiro.writeInt(filme.getRealizador());
		    Ficheiro.writeInt(filme.getActor());
		    Ficheiro.writeInt(filme.getGenero());
		    Ficheiro.writeInt(filme.getPais());
		     	  	
		    FichaNumero.close();	    
		    Ficheiro.close();
		    
		    JOptionPane.showMessageDialog(null,"Ficha Número: " + numero  + " Guardada com Exito"
		    								, "Numero da Ficha", JOptionPane.PLAIN_MESSAGE);
		}
		   
		if (modo == 'E')
	    {   
	    	//tamanho registo + 4 (pula o id do registo a ser alterado)
		    Ficheiro.seek(offset + 4);
		    
		    Ficheiro.writeBytes(ColetarDados(filme.getTitulo(),100));
			
			Ficheiro.writeBytes(ColetarDados(filme.getDuracao(),15));
			Ficheiro.writeBytes(ColetarDados(filme.getAnoRealizacao(),15));
			Ficheiro.writeInt(filme.getRealizador());
		    Ficheiro.writeInt(filme.getActor());
		    Ficheiro.writeInt(filme.getGenero());
		    Ficheiro.writeInt(filme.getPais());  	
		    
		    Ficheiro.close();
		    
		    JOptionPane.showMessageDialog(null,"Ficha Modificada com Exito"
		    								, "Resultado", JOptionPane.PLAIN_MESSAGE);

		}
		
		if (modo == 'R')
	    {   
		    Ficheiro.seek(offset); 
             	
            int valor = (filme.getCodigoFilme() *(-1));
              	
		    Ficheiro.writeInt(valor); 
		    Ficheiro.close();
		    
		    JOptionPane.showMessageDialog(null,"Ficha Nº "+(filme.getCodigoFilme()+1) +"  Eliminada com Exito"
		    								, "Resultado", JOptionPane.PLAIN_MESSAGE);

		}				
	
	}

}
