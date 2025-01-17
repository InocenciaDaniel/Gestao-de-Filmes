package SwingComponents;
/**
 *   Title:        GestaoCandidaturaMilitante
 *   Version:
 *   Copyright:    Copyright (c) 2003
 *   Author:       Ruben Paxi Quissanga
 *   Company:      ucan
 *   Description:  Projecto final (Interacao Homem Maquina
 *                 / Fundamentos de Programacao III)
 */



import java.io.*;

public class MyFile extends File
{
  public MyFile(String f)
  {
    super(f);
  }
  public static boolean existe(String f)
  {
    File Stream = new File(f);
    return ((true == Stream.exists()) && (true == Stream.isFile()));
  }
} 