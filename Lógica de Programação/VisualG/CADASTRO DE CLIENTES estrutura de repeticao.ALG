Algoritmo "Cadastro de Clientes"
// Disciplina   :  Lógica de Programação
// Professor   : Wagner Cardoso 
// Descrição   : Estrutura de Repetição para cadastro de clientes
// Autor(a)    : Lucas Thierry
// Data atual  : 12/10/2023
Var
// Seção de Declarações das variáveis 
nome: caractere
repeticao: caractere
renda: real
profissao: caracter
idade: inteiro

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc... 

escreval("BEM VINDO(A) AO PROGRAMA DE CADASTROS TECTREINAMENTOS")
escreval("-----------------------------------------------------")

escreval("Insira o nome do cliente:")
leia(nome)
escreval("Insira a Renda do cliente:")
leia(renda)
escreval("Insira a Profissao do cliente:")
leia(profissao)
escreval("Insira a Idade do cliente:")
leia(idade)
escreval("Deseja inserir mais algum cadastro? s/n")
leia(repeticao)

enquanto repeticao = "s" faca
escreval("Insira o nome do cliente:")
leia(nome)
escreval("Insira a Renda do cliente:")
leia(renda)
escreval("Insira a Profissao do cliente:")
leia(profissao)
escreval("Insira a Idade do cliente:")
leia(idade)
escreval("Deseja inserir mais algum cadastro? s/n")
leia(repeticao)
leia(repeticao)
fimenquanto
escreval("CADASTROS INSERIDOS COM SUCESSO")
escreval("OBRIGADO! Por utilizar o programa.")
Fimalgoritmo