Algoritmo "semnome"
// Disciplina   :  Lógica de Programação
// Professor   : Wagner Cardoso
// Descrição   : Aqui você descreve o que o programa faz! (função)
// Autor(a)    : Nome do(a) aluno(a)
// Data atual  : 04/03/2024
Var
// Seção de Declarações das variáveis

informacao: caracter
repeticao: caracter

Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...

escreval("O que deseja pesquisar? Opções: 1-Notebook, 2-Desktop ou 3-Celular")
leia (informacao)

escolha informacao

caso "1"
escreval ("É um computador portátil e recomendado para uso comercial.")

caso "2"
escreval("É o tipo mais comum de computador e utilizado geralmente em empresa.")

caso "3"
escreval("É reconhecido atualmente como um computador de bolso.")

fimescolha

escreval("Deseja realizar mais alguma pesquisa? S/N")
leia(repeticao)

enquanto repeticao = "s" faca

escreval("O que deseja pesquisar? Opções: 1-Notebook, 2-Desktop ou 3-Celular")
leia (informacao)

escolha informacao

caso "1"
escreval ("É um computador portátil e recomendado para uso comercial.")

caso "2"
escreval("É o tipo mais comum de computador e utilizado geralmente em empresa.")

caso "3"
escreval("É reconhecido atualmente como um computador de bolso.")

fimescolha

escreval("Deseja realizar mais alguma pesquisa? S/N")
leia(repeticao)

fimenquanto

escreval("Obrigado por usar o programa")

Fimalgoritmo