/*********************************************************************************************/
/* Ficheiro: Ajuda
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : Classe Responsável por apresentar informações sobre o projecto e a autora do mesmo.
/*********************************************************************************************/
import java.awt.event.*;
import java.awt.*;
import javax.swing.*; 

public class Ajuda extends JFrame{
	
	private JLabel texto;
	private JPanel  painel1, painel3;
	private ImageIcon Inoc;
		
	public Ajuda() 
	{
		 Inoc = new ImageIcon("ajuda.jpg");
		 texto = new JLabel (Inoc);
	
		 painel1 = new JPanel();
		 painel3 = new JPanel();
		 painel1.setLayout(new GridLayout(2,1));
		 painel3.setLayout(new FlowLayout());		
	   
		 painel3.add(texto);
		 painel1.add(painel3);					 	 			 	 	
		 
		 getContentPane().add(painel1, BorderLayout.CENTER);
		 getContentPane().add(painel3 , BorderLayout.CENTER);
		 
		 setSize(470,385);
		 setLocationRelativeTo(null);
		 setVisible(true);
	}
}

