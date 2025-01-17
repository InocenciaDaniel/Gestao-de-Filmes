package SwingComponents;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;


public class Tabela3_3 extends Tabela3_2
{

  public Tabela3_3()
  {
 
  }

  public Tabela3_3(int CodProv, String Designacao)
  {
  		super(CodProv, Designacao);
  }
  
  public static void editarNovosItems(String filePai, String fileFilho, String fileNeto, 
  					String labelPai, String labelFilho, String labelNeto, 
  														String NovaDesignacao)
  {
	new Editar_Tabela3_3(filePai, fileFilho, fileNeto, labelPai, labelFilho, labelNeto, 
														NovaDesignacao);	
  }
  
  
  private static class Editar_Tabela3_3 extends JFrame
  {
  private JLabel label;
  private JTextField field;
  private JPanel painelEsquerdo, painelCentro, painelDireito;
  private JButton BtTasks[];
  private static final String btNames[] = {"Salvar", "Cancelar", "Ok"};
  private static final int SAVE = 0, CANCELAR = 1, OK = 2;
  private ObjectOutputStream output;
  protected String filePai, fileFilho, fileNeto;
  protected JComboBoxTabela3_Tabela3 cb;
  //private Contentor_Tabela3_2 contentor;

  public Editar_Tabela3_3(String filePai, String fileFilho, String fileNeto, 
  					String labelPai, String labelFilho, String labelNeto, 
  														String NovaDesignacao)
   {
    super("Editar " + NovaDesignacao);
               
    this.filePai = filePai;
  	this.fileFilho = fileFilho;
  	this.fileNeto = fileNeto;
  	
    Container container = getContentPane();
	container.setLayout(new GridLayout(1,3)); 
	
	// construcao do Painel esquerdo
	//painelEsquerdo = new JPanel();
	//painelEsquerdo.setLayout(new FlowLayout());
	Box box = Box.createVerticalBox();
	box.add(new JLabel(labelPai));
	cb = new JComboBoxTabela3_Tabela3(filePai, fileFilho, fileNeto);
	//cb.setEventManipulators();
	box.add(cb.getComboBoxPai());
	
	box.add(new JLabel(labelFilho));
	box.add(cb.getComboBoxFilho());
	
	box.add(new JLabel(labelNeto));
	box.add(cb.getComboBoxNeto());
		
	container.add(box);
	
	// construcao do Painel central
	painelCentro = new JPanel();
	painelCentro.setLayout(new FlowLayout());
	//box = Box.createVerticalBox();
	label = new JLabel(NovaDesignacao);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    painelCentro.add(label);
    field = new JTextField(15);
	painelCentro.add(field);
	container.add(painelCentro);
	
 	// construcao do Painel direito
	painelDireito = new JPanel();
	painelDireito.setLayout(new GridLayout(3,1));
	BtTasks = UInterfaceBox.createJButtons(btNames);
	//Box box = Box.createVerticalBox();
	for (int i = 0; i < BtTasks.length; i++)
		painelDireito.add(BtTasks[i]);
	container.add(painelDireito);
	

    BtTasks[SAVE].addActionListener(
          new ActionListener()
          {
            public void actionPerformed( ActionEvent e )
            {

              Save_Data();

            }
          }
        );

    BtTasks[CANCELAR].addActionListener(
          new ActionListener()
          {
            public void actionPerformed( ActionEvent e )
            {
              Clear_Field();
            }
          }
        );

    BtTasks[OK].addActionListener(
          new ActionListener()
          {
            public void actionPerformed( ActionEvent e )
            {
              dispose();
            }
          }
        );

     addWindowListener(
         new WindowAdapter()
         {
            public void windowClosing( WindowEvent e )
            {
               if ( output != null )
               {
                  dispose();
               }
               else
                 dispose();
            }
         }
         );

        setSize(900,150);
        this.setResizable(false);
        show();
     }

     public void Save_Data()
      {
         Tabela3_3 record;
         String designacao = get_Field_Value();
         Contentor_Tabela3_3 contentor =  Contentor_Tabela3_3.createStream3_3(fileNeto);
         //Se o campo provincia n�o for nulo e a provincia nao existir ainda
        if ( !designacao.equals("") && contentor.Search(designacao) < 0 )
          {
            record = (Tabela3_3)contentor.createNewTabela3_3(cb.getCodigoFilhoSeleccionado(), designacao);
            contentor.add(record);
            contentor.Gerar_Proximo_Codigo();
            contentor.Actualizar_Ficheiro();
            Clear_Field();
            cb.getComboBoxNeto().insert(record.get_Designacao());
          }
        else
           JOptionPane.showMessageDialog(null,
            "Edite o nome da objecto ou \n" +
            "Verifique se o nome do objecto" +
            " ja existe", "Error", JOptionPane.ERROR_MESSAGE);
  	   }

  	public String get_Field_Value()
  	 {   return field.getText();  }

  	public void Clear_Field()
  	 {   field.setText("");  }
  }


}
