/*********************************************************************************************/
/* Ficheiro: Apresentacao
/* Autor: Inocencia Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : classe responsavel pela apresentação do programa.
/*********************************************************************************************/

import SwingComponents.*;
import javax.swing.JFrame;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.*;
import javax.swing.*; 
import javax.swing.event.*;

public class Apresentacao extends JFrame{
	
	private JLabel texto;
	private JButton concordo,discordo;
	private JPanel  painel1,painel2, painel3;
	private ImageIcon Inoc;
		
	public Apresentacao() 
	{
		 concordo = new JButton ("Sim");
		 discordo = new JButton("Não");
		 Inoc = new ImageIcon("filmes.jpg");
		 texto = new JLabel (Inoc);
	
		 painel1 = new JPanel();
		 painel2 = new JPanel();
		 painel3 = new JPanel();
		 painel1.setLayout(new GridLayout(2,1));
		 painel2.setLayout(new FlowLayout());
		 painel3.setLayout(new FlowLayout());		
		 
	 	 concordo.addActionListener(
	  	 	new ActionListener() 
		    {
					public void actionPerformed( ActionEvent event )
					{
					   Vector_Tabelas.inic();
					   dispose();
					   new MenuPrincipal();
					  
					}				
		    }
	   );
	   
	   discordo.addActionListener(
		  	new ActionListener() 
		    {
					public void actionPerformed( ActionEvent event )
					{
						 JOptionPane.showMessageDialog(null,"A Aplicação sera Fechada!!");
						 System.exit(0);
					  
					}
		    }
	   );
	   
		 painel3.add(texto);
		 painel2.add(concordo);
		 painel2.add(discordo);
		 painel1.add(painel3);					 	 			 	 	
		 
		 getContentPane().add(painel1, BorderLayout.CENTER);
		 getContentPane().add(painel2, BorderLayout.SOUTH);
		 getContentPane().add(painel3 , BorderLayout.CENTER);
		 
		 setSize(770,460);
		 setLocationRelativeTo(null);
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 setVisible(true);
	}
}
