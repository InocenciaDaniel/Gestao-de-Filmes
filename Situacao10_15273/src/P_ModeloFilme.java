/*********************************************************************************************/
/* Ficheiro: Apresentação
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : classe responsavel por converter os dados
/*********************************************************************************************/
import SwingComponents.*;
import javax.swing.JOptionPane;
import java.io.RandomAccessFile;
import java.io.IOException;

public class P_ModeloFilme {
	
    private	String titulo, anoRealizacao, duracao;
    private int codigoFilme, genero, pais, realizador, actor;

	public P_ModeloFilme() 
	{	
	}
	
	public P_ModeloFilme(ModeloFilme  modelo) 
	{
	 	this.titulo = modelo.getTitulo();
	 	this.anoRealizacao = modelo.getAnoRealizacao();
	 	this.duracao = modelo.getDuracao();
	 	this.realizador = modelo.getRealizador();
	 	this.actor = modelo.getActor();
	 	   
	    Contentor_Tabela2 ct2_1 = Contentor_Tabela2.createStream(Defs.fileGenero);
	    this.genero = ct2_1.get_Codigo(modelo.getGenero().trim());	
		
		Contentor_Tabela2 ct2_2 = Contentor_Tabela2.createStream(Defs.filePais);
	    this.pais = ct2_2.get_Codigo(modelo.getPais().trim());
	}
     
    public void Salvar_Filme(P_ModeloFilme p_filme ,char modo , int offSet )	throws IOException	
    {
    	
           SalvarFicheiroFilme.SalvarFFilme(modo,offSet,p_filme);	
    }	
     
    public static int SizeOf()
    {
    	return 150;
    }

	public void setTitulo(String titulo) {
		this.titulo = titulo; 
	}

	public void setAnoRealizacao(String anoRealizacao) {
		this.anoRealizacao = anoRealizacao; 
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao; 
	}

	public void setRealizador(int realizador) {
		this.realizador = realizador; 
	}

	public void setActor(int actor) {
		this.actor = actor; 
	}

	public void setCodigoFilme(int codigoFilme) {
		this.codigoFilme = codigoFilme; 
	}
	public void setGenero(int genero) {
		this.genero = genero; 
	}

	public void setPais(int pais) {
		this.pais = pais; 
	}

	public String getTitulo() {
		return (this.titulo); 
	}

	public String getAnoRealizacao() {
		return (this.anoRealizacao); 
	}

	public String getDuracao() {
		return (this.duracao); 
	}

	public int getRealizador() {
		return (this.realizador); 
	}

	public int getActor() {
		return (this.actor); 
	}
	
	public int getCodigoFilme() {
		return (this.codigoFilme); 
	}

	public int getGenero() {
		return (this.genero); 
	}

	public int getPais() {
		return (this.pais); 
	}

	public String toString() {

		String sep = System.getProperty("line.separator");

		StringBuffer buffer = new StringBuffer();
		buffer.append(sep);
		buffer.append("titulo = ");
		buffer.append(titulo);
		buffer.append(sep);
		buffer.append("anoRealizacao = ");
		buffer.append(anoRealizacao);
		buffer.append(sep);
		buffer.append("duracao = ");
		buffer.append(duracao);
		buffer.append(sep);
		buffer.append("realizador = ");
		buffer.append(realizador);
		buffer.append(sep);
		buffer.append("actor = ");
		buffer.append(actor);
		buffer.append(sep);
		buffer.append("codigoFilme = ");
		buffer.append(codigoFilme);
		buffer.append(sep);
		buffer.append("genero = ");
		buffer.append(genero);
		buffer.append(sep);
		buffer.append("pais = ");
		buffer.append(pais);
		buffer.append(sep);
		
		return buffer.toString();
	}
    
}