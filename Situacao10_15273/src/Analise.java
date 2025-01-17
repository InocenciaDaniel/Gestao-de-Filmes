/*------------------------------------
Autor: Inocência da Conceição Gonçalves Daneil
File: Analise.java
Data: /11/2016
Tutor: Engº Felisberto P. Delgado
Objectivo: Descricao do projecto
--------------------------------------*/

/*
 1.	Tema: Gestao de uma colecção de filmes
	Objectivo: Armazenamento e consulta de filmes

 2. Entidades Principais
 	- Filme
 	- Pessoa

 3. Entidades Auxiliares 
	- Realizador
	- Actor
	
 4. Atributos das Entidades
	- Filme
		- int id
		- string título
		- int genero
		- int pais
		- string ano
		- int realizador
		- int actor
		- string duração

   		
   	- Pessoa
   		- int: id
   		- string nome
   		- int sexo
   		- string data de nascimento
   		- int pais
   		- int tipo

5. GUI - Graphic User Interface
	Apresentacao
	MenuPrincipal
	
	Menu
		- Home
			- Home Actor
			- Home Realizador
		- Filme
			- Inserir
			- Listar
			- Editat
			- Eliminar
			
		- Pessoa
			- Inserir
			- Listar
			- Editat
			- Eliminar
			
		- Consulta
			- Filme
			- Realizador
			- Actor
			
		- Tabelas
		- Ajuda
		- Sair
		

6. Entidades persistentes
	- Filme.dat
		- int id [4]
		- string título [100]
		- int genero [4]
		- int pais [4]
		- string ano [15]
		- int realizador [4]
		- int actor [4]
		- string duração [15]
		.......
                                    SizeOf(filme) = 150
		
	- pessoa.dat
		- int: id [4]
   		- string nome [100]
   		- int sexo [4]
   		- string data de nascimento [15]
   		- int pais [4]
   		- int tipo [4]
   		.......
                                    SizeOf(realizador) = 131
	
          
   
	genero.tab
    sexo.tab
	pais.tab
	tipo.tab
	
6.	Implementacao
	Linguagem de Programacao: Java
*/