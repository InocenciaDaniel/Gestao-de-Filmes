package Calendario;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Calendario extends JFrame 
{
	private Painel2 painel;
	public Calendario()
	{
		super("Calendario 2004");
		
		try 
    {
	     UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} 
		
		catch (Exception exc) 
		{
	    	System.err.println("Error loading L&F: " + exc);
		}
		
		painel = new Painel2();
		//painel.setBackground(Color.blue);
		getContentPane().add(painel,BorderLayout.CENTER);
		
		setResizable(false);
		setLocationRelativeTo(null);
		setSize(800,633);
		show();
		
	}
	
	
}

class Painel2 extends JPanel
{		
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Icon paisagen = new ImageIcon("Ascende.jpg");
		
		paisagen.paintIcon(this,g,0,0);
		g.setFont(new Font("Commercial Script", Font.BOLD, 40));		
		g.drawString( "C A L E N D A R I O   2 0 0 4", 80, 50 );
		
		g.setFont(new Font("Commercial Script", Font.BOLD, 16));
		g.drawString("Janeiro                                  Fevereiro                             Marco                                Abril",50,80);
		g.drawString("Maio                                       Junho                                    Julho                                   Agosto",50,260);
		g.drawString("Setembro                             Outubro                               Novembro                             Dezembro",50,440);
		
		
			g.setFont(new Font("Commercial Script", Font.BOLD, 10));
			g.drawString("Seg Ter Qua Qui Sex Sab Dom      Seg Ter Qua Qui Sex Sab Dom     Seg Ter Qua Qui Sex Sab Dom     Seg Ter Qua Qui Sex Sab Dom",30, 110);
			g.drawString("Seg Ter Qua Qui Sex Sab Dom      Seg Ter Qua Qui Sex Sab Dom     Seg Ter Qua Qui Sex Sab Dom     Seg Ter Qua Qui Sex Sab Dom",30, 290);
			g.drawString("Seg Ter Qua Qui Sex Sab Dom      Seg Ter Qua Qui Sex Sab Dom     Seg Ter Qua Qui Sex Sab Dom     Seg Ter Qua Qui Sex Sab Dom",30, 460);
		
		g.setFont(new Font("Commercial Script",Font.BOLD,10));
		g.drawString("  1       2      3       4                                                           1           1      2      3      4      5      6      7                                1      2      3      4",100,140); 
		g.drawString("5      6      7     8       9     10   11           2      3      4      5      6      7    8           8      9      10    11   12    13   14        5     6     7      8      9   10    11",35,155);
		g.drawString("12   13   14   15     16     17   18           9    10    11    12   13   14  15          15   16     17    18   19    20    21      12  13   14    15   16   17    18 ",30,170);
		g.drawString("19   20   21   22     23    24    25         16    17    18    19   20   21  22          22   23    24     25   26    27    28      19  20   21   22    23   24    25",30,185);
		g.drawString("26   27   28   29     30    31                  23   24     25    26   27   28  29         29    30   31                                          26  27  28   29    30",30,200);
		
		g.drawString("1      2                    1      2      3      4      5      6                                    1      2      3      4                                                          1",155,320);
		g.drawString("3      4      5     6      7     8      9             7     8      9    10    11   12    13          5      6      7       8      9    10   11           2     3     4     5      6      7      8  ",35,335);
		g.drawString("10   11    12  13  14   15    16            14   15   16   17    18   19    20         12  13   14      15    16   17   18           9   10    11   12   13    14    15   ",35,350);
		g.drawString("17   18    19  20  21   22    23            21   22    23   24   25   26    27         19  20   21      22    23   24   25          16  17    18   19   20    21    22   ",35,365);
		g.drawString("24   25    26  27  28   29    30            28   29    30                                         26  27   28      29    30   31                 23   24    25   26  27    28    29",35,380);
		g.drawString("31                                                                                                                                                                                       30   31",35,395);
	
		
		g.drawString(" 1      2      3      4      5                                            1      2      3           1      2      3      4      5      6      7                        1      2      3      4       5",80,490);
		g.drawString(" 6     7     8      9     10   11   12           4      5      6      7      8      9    10           8      9     10    11    12   13   14         6      7    8      9     10     11   12",35,505);
		g.drawString("13   14   15   16    17   18   19          11   12   13   14    15    16    17          15   16    17    18    19   20   21        13    14  15   16    17     18   19",35,520);
		g.drawString("20   21   22   23    24   25   26          18   19   20   21    22    23   24           22   23    24    25    26   27   28        20     21  22   23    24    25   26",35,535);
		g.drawString("27   28   29   30                                  25   26   27   28    29    30   31           29   30                                                  27    28  29   30    31",35,550);

		// feriados
		
		g.drawString("1-Ano Novo                                     4-Dia do Inicio da luta armada      8-Dia Internacional da Mulher     4-Paz e reconciliacoo Nacional",35,220);
		g.drawString("4-Herois da Baixa de Cassanje  24- Carnaval                                                                                                    9-Sexta-Feira Santa",35,230);
		g.drawString("11- Pascoa", 580, 240);
	}
}