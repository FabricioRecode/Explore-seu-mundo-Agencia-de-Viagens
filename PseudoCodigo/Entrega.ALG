Algoritmo "semnome"
// Disciplina   : [Linguagem e L�gica de Programa��o]
// Professor   : Antonio Carlos Nicolodi 
// Descri��o   : Aqui voc� descreve o que o programa faz! (fun��o)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 04/07/2022
Var
// Se��o de Declara��es das vari�veis 
 nome,destino,leAssento: vetor[1..10] de  caracter
 cpf,assento: vetor[1..10] de inteiro
  i,n:inteiro
Inicio
// Se��o de Comandos, procedimento, fun��es, operadores, etc... 
 escreva("Quantas Pessoas Quer Cadastrar no Maximo 10 Pessoas: ")
 leia(n)
 
 para i   de 1 ate n faca
 escreva( "Coloque o nome: " )
 leia(nome[i])
   fimpara
   
   para i   de 1 ate n faca
  escreva( "Digite o CPF: " )
  leia(cpf[i])
   fimpara
   
   para i   de 1 ate n faca
 escreva( "Escolha o Assento de 01 ate 40: " )
 leia(assento[i])
   fimpara
   
   para i   de 1 ate n faca
 escreva( "Escolha a letra do Assento pode ser A, B, C e D : " )
 leia(leAssento[i])
   fimpara
   
 para i   de 1 ate n faca
 escreva( "Coloque o destino: " )
 leia(destino[i])
     
 fimpara
     
     limpatela
     
 para i   de 1 ate n faca

 escreval ("ID: " ,i)
 escreval ("Nome: ", nome[i])
 escreval ("CPF: ", cpf[i])
 escreval ("Seu Assento �: ", assento[i], leAssento[i] )
 escreval ("Destino ", destino[i])
 escreval ("---------------------------")
      
 fimpara

Fimalgoritmo