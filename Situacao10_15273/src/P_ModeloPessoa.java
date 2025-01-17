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

public class P_ModeloPessoa {
	
	private	String nome, dataNasc;
    private int codigoPessoa, sexo, pais, tipo;

	public P_ModeloPessoa() 
	{
	}
	
	public P_ModeloPessoa(ModeloPessoa  modelo) 
	{
		this.nome = modelo.getNome();
		this.dataNasc = modelo.getDataNasc();
	    
	    Contentor_Tabela2 ct2_1 = Contentor_Tabela2.createStream(Defs.fileSexo);
	    this.sexo = ct2_1.get_Codigo(modelo.getSexo().trim());	
		
		Contentor_Tabela2 ct2_2 = Contentor_Tabela2.createStream(Defs.filePais);
	    this.pais = ct2_2.get_Codigo(modelo.getPais().trim());
	    
	    Contentor_Tabela2 ct2_3 = Contentor_Tabela2.createStream(Defs.fileTipo);
	    this.tipo = ct2_3.get_Codigo(modelo.getTipo().trim());
	 }
     
    public void Salvar_Pessao(P_ModeloPessoa p_pessoa ,char modo , int offSet )	throws IOException	
    {
           SalvarFicheiroPessoa.SalvarFPessoa(modo,offSet,p_pessoa);
    }	
     
    public static int SizeOf()
    {
    	return 131;
    }

	public void setNome(String nome) {
		this.nome = nome; 
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc; 
	}

	public void setTipo(int tipo) {
		this.tipo = tipo; 
	}

	public void setCodigoPessoa(int codigoPessoa) {
		this.codigoPessoa = codigoPessoa; 
	}

	public void setSexo(int sexo) {
		this.sexo = sexo; 
	}

	public void setPais(int pais) {
		this.pais = pais; 
	}

	public String getNome() {
		return (this.nome); 
	}

	public String getDataNasc() {
		return (this.dataNasc); 
	}

	public int getTipo() {
		return (this.tipo); 
	}

	public int getCodigoPessoa() {
		return (this.codigoPessoa); 
	}

	public int getSexo() {
		return (this.sexo); 
	}

	public int getPais() {
		return (this.pais); 
	}

	public String toString() {

		String sep = System.getProperty("line.separator");

		StringBuffer buffer = new StringBuffer();
		buffer.append(sep);
		buffer.append("nome = ");
		buffer.append(nome);
		buffer.append(sep);
		buffer.append("dataNasc = ");
		buffer.append(dataNasc);
		buffer.append(sep);
		buffer.append("tipo = ");
		buffer.append(tipo);
		buffer.append(sep);
		buffer.append("codigoPessoa = ");
		buffer.append(codigoPessoa);
		buffer.append(sep);
		buffer.append("sexo = ");
		buffer.append(sexo);
		buffer.append(sep);
		buffer.append("pais = ");
		buffer.append(pais);
		buffer.append(sep);
		
		return buffer.toString();
	}
    
}
