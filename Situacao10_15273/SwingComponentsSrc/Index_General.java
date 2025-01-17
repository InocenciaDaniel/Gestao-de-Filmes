package SwingComponents;
/**
 *   Title:        GestaoCandidaturaMilitante
 *   Version:
 *   Copyright:    Copyright (c) 2003
 *   Author:       Ruben Paxi Quissanga
 *   Company:      ucan
 *   Description:  Projecto final (Interacao Homem Maquina
 *                 / Fundamentos de Programacao III)
 *
 */
public class Index_General
{
  int posicao;
  
  public Index_General(int pos)
  {
    posicao = pos;
  }
  public String toString()
  {
    return "" + posicao;
  }
  public int get_Posicao()
  { return posicao; }
}
