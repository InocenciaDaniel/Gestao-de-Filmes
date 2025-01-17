/*********************************************************************************************/
/* Ficheiro: Apresentação
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : classe responsavel por receber os dados na forma string
/*********************************************************************************************/
import java.io.RandomAccessFile;
import SwingComponents.*;
import java.util.Vector;

public class ModeloFilme {
	
    private	String titulo, anoRealizacao, duracao, genero, pais;
    private int codFilme, realizador, actor;
    

	public ModeloFilme()  
	{
	}
	
	public ModeloFilme(P_ModeloFilme  modelo) 
	{
		this.codFilme = modelo.getCodigoFilme();
		this.titulo = modelo.getTitulo();
		this.anoRealizacao = modelo.getAnoRealizacao();
		this.duracao = modelo.getDuracao();
		this.realizador = modelo.getRealizador();
		this.actor = modelo.getActor();
	    
	    Contentor_Tabela2 ct2_1 = Contentor_Tabela2.createStream(Defs.fileGenero);
	    this.genero = ct2_1.get_Designacao(modelo.getGenero());	
		
		Contentor_Tabela2 ct2_2 = Contentor_Tabela2.createStream(Defs.filePais);
	    this.pais = ct2_2.get_Designacao(modelo.getPais());
	    
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

	public void setGenero(String genero) {
		this.genero = genero; 
	}

	public void setPais(String pais) {
		this.pais = pais; 
	}
	
	public void setCodFilme(int  codFilme) {
		this.codFilme = codFilme; 
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

	public String getGenero() {
		return (this.genero); 
	}

	public String getPais() {
		return (this.pais); 
	}
	
	public int getCodFilme() {
		return (this.codFilme); 
	}

	public String toString2() {

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
		buffer.append("genero = ");
		buffer.append(genero);
		buffer.append(sep);
		buffer.append("pais = ");
		buffer.append(pais);
		buffer.append(sep);
		buffer.append("codFilme = ");
		buffer.append(codFilme);
		buffer.append(sep);
		
		return buffer.toString();
	}
	public String toString() {
		
		return getTitulo();
	}		
}
