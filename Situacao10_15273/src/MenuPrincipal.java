/*********************************************************************************************/
/* Ficheiro: Apresentação
/* Autor: Inocência Daniel
/* Numero : 15273                              
/* Professor: Felisberto                              
/* Descrição : classe responsavel por apresentar o menu
/*********************************************************************************************/
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import SwingComponents.*;
import javax.swing.JOptionPane;
import java.io.IOException;
import java.awt.Desktop;
import java.net.URISyntaxException;

public class MenuPrincipal extends JFrame{	
	
	private JMenu home, filmeJM, consultaJM, tabela, ajuda, sairJM, pessoaJM, defesaJM;
	private JMenuItem homeRealizador, homeActor, novoFilme, editarFilme, listarFilme, eliminarFilme, sobre, sairJI;
	private JMenuItem novaPessoa, editaPessoa, listarPessoa, eliminarPessoa, pDefesaJMI;
	private JMenu filmeCJM, pessoaCJM;
	private JMenuItem filmeTituloC, filmeGeneroC, filmePaisC;
	private JMenuItem pessoaNome;
	private JMenuItem generoTabela, sexoTabela, paisTabela, tipoTabela;
    private JMenuBar barraMenu;
    private JPanel painel;
    private ImageIcon Inoc = new ImageIcon ("imagem.jpg");
    private JLabel imagem = new JLabel(Inoc);
    public MenuPrincipal(){
    	
    	super("MENU PRINCIPAL");
    	inic();
    	 
    	homeRealizador.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				}	    });
    	
    	sairJI.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				JOptionPane.showMessageDialog(null, "Obrigada pela sua visita. \n\n *** Volte sempre ***");
    				System.exit(0);
    			}   		});
    				
    	sobre.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				new Ajuda();
    			}    		});
    			
    	generoTabela.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				Tabela2.editarNovosItems(Defs.fileGenero,"Novo Genero");
    			}    		});
    			
    	/*sexoTabela.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				Tabela2.editarNovosItems(Defs.fileSexo,"Sexo");
    			}    		});
    			
    	tipoTabela.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				Tabela2.editarNovosItems(Defs.fileTipo,"Tipo Pessoa");
    			}    		});*/
    						
    	paisTabela.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				Tabela2.editarNovosItems(Defs.filePais,"Novo Pais");
    			}    		});
    			
    	novoFilme.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				new SalvarFilme();
    			}    		});
    			
    	listarFilme.addActionListener(	  	   
		  	new ActionListener(){
					public void actionPerformed( ActionEvent event )
					{
						try{
						  	 new ListarFilme();
						  }catch(Exception e){
						  	e.printStackTrace();
						  }		}    });
						  
		editarFilme.addActionListener(	  	   
		  	new ActionListener(){
					public void actionPerformed( ActionEvent event )
					{
						try{
						  	 new EditarFilme();
						  }catch(Exception e){
						  	e.printStackTrace();
						  }		}    });
						  
		eliminarFilme.addActionListener(	  	   
		  	new ActionListener(){
		  		public void actionPerformed( ActionEvent event )
					{				
						try
						  {
						  	 new ApagarFilme();
						  }catch(Exception e){
						  	e.printStackTrace();
						  } }   });
    					
    	novaPessoa.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				new SalvarPessoa();
    			}    		});
    			
    	listarPessoa.addActionListener(	  	   
		  	new ActionListener(){
					public void actionPerformed( ActionEvent event )
					{
						try{
						  	 new ListarPessoa();
						  }catch(Exception e){
						  	e.printStackTrace();
						  }		}    });
						  
		editaPessoa.addActionListener(	  	   
		  	new ActionListener(){
					public void actionPerformed( ActionEvent event )
					{
						try{
						  	 new EditarPessoa();
						  }catch(Exception e){
						  	e.printStackTrace();
						  }		}    });
						  
		eliminarPessoa.addActionListener(	  	   
		  	new ActionListener(){
		  		public void actionPerformed( ActionEvent event )
					{				
						try
						  {
						  	 new ApagarPessoa();
						  }catch(Exception e){
						  	e.printStackTrace();
						  } }   });
						  
		homeRealizador.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				JOptionPane.showMessageDialog(null,"ESTA SERIA A PAGINA DO REALIZADOR");
    			}    		});
    			
    	homeActor.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				JOptionPane.showMessageDialog(null,"ESTA SERIA A PAGINA DO ACTOR");
    			}    		});
						  
		pessoaNome.addActionListener(
			new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		    String realizador = JOptionPane.showInputDialog("Digite o nome do relizador");
	    		    	try{
	    		    		new ConsutarPessoa(realizador);
	    		    	}
	    		    	catch(Exception r){
	    		    		r.printStackTrace();
	    		    	}   	}	    });
	    		    	
	    filmeTituloC.addActionListener(
			new ActionListener(){
	    		public void actionPerformed(ActionEvent e){
	    		    String titulo = JOptionPane.showInputDialog("Digite o titulo do filme");
	    		    	try{
	    		    		new ConsultarFilme(titulo);
	    		    	}
	    		    	catch(Exception r){
	    		    		r.printStackTrace();
	    		    	}   	}	    });
	    		    	
	    pDefesaJMI.addActionListener(
    		new ActionListener(){
    			public void actionPerformed( ActionEvent event ){
    				new P_Defesa();
    			}    		});
    	
	    setSize(760,580);
	  	setLocationRelativeTo(null);
	  	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  	setVisible(true);
    }
    
    public void inic(){
    	
    	painel = new JPanel();
    	
    	home = new JMenu ("Home");
    	filmeJM = new JMenu ("Filme");
    	pessoaJM = new JMenu ("Pessoa");
    	consultaJM = new JMenu ("Pesquisa");
    	tabela = new JMenu ("Tabelas");
    	ajuda = new JMenu ("Ajuda");
    	sairJM = new JMenu ("Sair");
    	filmeCJM = new JMenu ("Filme");
    	pessoaCJM = new JMenu ("Pessoa");
    	
    	defesaJM = new JMenu ("Defesa");
    	pDefesaJMI = new JMenuItem ("Pesquisa Defesa");
    	defesaJM.add(pDefesaJMI);
    	   	
    	homeRealizador = new JMenuItem ("Home Realizador");
    	homeActor = new JMenuItem ("Home Actor");
    	novoFilme = new JMenuItem ("Novo");
    	editarFilme = new JMenuItem ("Editar");
    	listarFilme = new JMenuItem ("Listar");
    	eliminarFilme = new JMenuItem ("Eliminar");
    	sobre = new JMenuItem ("Sobre");
    	sairJI = new JMenuItem ("Sair");
    	novaPessoa = new JMenuItem ("Novo");
    	editaPessoa = new JMenuItem ("Editar");
    	listarPessoa = new JMenuItem ("Listar");
    	eliminarPessoa = new JMenuItem ("Eliminar");
    	
		filmeTituloC = new JMenuItem ("Titulo");
		filmeGeneroC = new JMenuItem ("Genero");
		filmePaisC = new JMenuItem("Pais");
		pessoaNome = new JMenuItem ("Nome");
		generoTabela = new JMenuItem ("Genero");
		paisTabela = new JMenuItem ("Pais");
		//sexoTabela = new JMenuItem ("Sexo");
		//tipoTabela = new JMenuItem("Tipo Pessoa");
		barraMenu = new JMenuBar();
		
		home.add(homeRealizador);
		home.add(homeActor);
		sairJM.add(sairJI);
		ajuda.add(sobre);
		filmeJM.add(novoFilme);
		filmeJM.add(editarFilme);
		filmeJM.add(listarFilme);
		filmeJM.add(eliminarFilme);
		pessoaJM.add(novaPessoa);
		pessoaJM.add(editaPessoa);
		pessoaJM.add(listarPessoa);
		pessoaJM.add(eliminarPessoa);
		filmeCJM.add(filmeTituloC);
		filmeCJM.add(filmeGeneroC);
		filmeCJM.add(filmePaisC);
		
		pessoaCJM.add(pessoaNome);
		consultaJM.add(filmeCJM);
		consultaJM.add(pessoaCJM);
		tabela.add(generoTabela);
		tabela.add(paisTabela);
		//tabela.add(sexoTabela);
		//tabela.add(tipoTabela);
		
		barraMenu.add(home);
       	barraMenu.add(filmeJM);
       	barraMenu.add(pessoaJM);
       	barraMenu.add(consultaJM);
       	barraMenu.add(tabela);
       	barraMenu.add(defesaJM);
       	barraMenu.add(ajuda);
       	barraMenu.add(sairJM);
       	
       	painel.add(imagem);
	
        painel.setLayout(new FlowLayout());
        getContentPane().add(painel,BorderLayout.CENTER);
		
		setJMenuBar(barraMenu);
    } 
}
