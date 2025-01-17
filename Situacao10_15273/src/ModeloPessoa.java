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

public class ModeloPessoa {
	
    private	String nome, dataNasc, tipo, sexo, pais;
    private int codPessoa;
    
	public ModeloPessoa()  
	{
	}
	
	public ModeloPessoa(P_ModeloPessoa  modelo) 
	{
	 	this.codPessoa = modelo.getCodigoPessoa();
	 	this.nome = modelo.getNome();
	 	this.dataNasc = modelo.getDataNasc();
	 	  
	    Contentor_Tabela2 ct2_1 = Contentor_Tabela2.createStream(Defs.fileSexo);
	    this.sexo = ct2_1.get_Designacao(modelo.getSexo());	
		
		Contentor_Tabela2 ct2_2 = Contentor_Tabela2.createStream(Defs.filePais);
	    this.pais = ct2_2.get_Designacao(modelo.getPais());
	    
	    Contentor_Tabela2 ct2_3 = Contentor_Tabela2.createStream(Defs.fileTipo);
	    this.tipo = ct2_3.get_Designacao(modelo.getTipo());    
	}
	
	public static Vector comboPessoas(int tipoId )
	{   	
		ModeloPessoa modelo ;
        Vector nomes = new Vector();
        
        try
        {
		  	RandomAccessFile  ficheiro = new RandomAccessFile(Defs.filePessoa,"r");
	        long tamanhoRG = ficheiro.length();
	        int cod = 0 ;
	       
	        for(int i = 0 ; i < tamanhoRG ; i += P_ModeloPessoa.SizeOf())
	        {
	        	
	             cod = ficheiro.readInt();
	             byte [] bytNome ;
	             if (cod > 0 )
	             {
	             	modelo = new ModeloPessoa();
					modelo.setCodPessoa(cod);		
					ficheiro.read(bytNome = new byte[100],0,100 );
				    modelo.setNome(new String(bytNome).trim());
				    
					ficheiro.skipBytes(23);
					
					int tip = ficheiro.readInt();
					if( tip == tipoId)
					  nomes.add(modelo);
					
					ficheiro.skipBytes(0);
	             }
	             else 
	               ficheiro.skipBytes(P_ModeloPessoa.SizeOf()-4);	
	        }
	        ficheiro.close();
        }
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        return nomes;   
	}
	
	public void setNome(String nome) {
		this.nome = nome; 
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc; 
	}

	public void setTipo(String tipo) {
		this.tipo = tipo; 
	}

	public void setSexo(String sexo) {
		this.sexo = sexo; 
	}

	public void setPais(String pais) {
		this.pais = pais; 
	}

	public void setCodPessoa(int codPessoa) {
		this.codPessoa = codPessoa; 
	}

	public String getNome() {
		return (this.nome); 
	}

	public String getDataNasc() {
		return (this.dataNasc); 
	}

	public String getTipo() {
		return (this.tipo); 
	}

	public String getSexo() {
		return (this.sexo); 
	}

	public String getPais() {
		return (this.pais); 
	}

	public int getCodPessoa() {
		return (this.codPessoa); 
	}

	public String toString2() {

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
		buffer.append("sexo = ");
		buffer.append(sexo);
		buffer.append(sep);
		buffer.append("pais = ");
		buffer.append(pais);
		buffer.append(sep);
		buffer.append("codPessoa = ");
		buffer.append(codPessoa);
		buffer.append(sep);
		
		return buffer.toString();
	}
	
	public String toString() {
		
		return getNome();
	}		
}
