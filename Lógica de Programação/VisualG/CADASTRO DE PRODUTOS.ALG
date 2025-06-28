Algoritmo "Registro de Compra De Produtos"
// Disciplina   :  Lógica de Programação
// Professor   : Wagner Cardoso
// Descrição   : Estrutura de Repetição para a compra de produtos
// Autor(a)    : Lucas Thierry
// Data atual  : 12/10/2023
Var
// Seção de Declarações das variáveis
nome: caractere
cb: caractere
quantidade: inteiro
setor: caractere
preco: real
custo: real
repeticao: caractere


Inicio
// Seção de Comandos, procedimento, funções, operadores, etc...

escreval("BEM VINDO(A) AO PROGRAMA DE COMPRA DE PRODUTOS")
escreval("-----------------------------------------------------")

escreval("Insira o nome do produto:")
leia(nome)
escreval("Insira o código de barras do produto:")
leia(cb)
escreval("Insira a quantidade para a compra:")
leia(quantidade)
escreval("Insira o setor do produto:")
leia(setor)
escreval("Insira o preco do produto:")
leia(preco)
custo <- quantidade*preco
escreval("O produto ",nome, " com o código ",cb, " custou R$ ",custo)
escreval("Deseja inserir mais algum cadastro? s/n")
leia(repeticao)

enquanto repeticao = "s" faca
escreval("Insira o nome do produto:")
leia(nome)
escreval("Insira o código de barras do produto:")
leia(cb)
escreval("Insira a quantidade para a compra:")
leia(quantidade)
escreval("Insira o setor do produto:")
leia(setor)
escreval("Insira o preco do produto:")
leia(preco)
custo <- quantidade*preco
escreval("O produto ",nome, " com o código ",cb, " custou R$ ",custo)
escreval("Deseja inserir mais algum cadastro? s/n")
leia(repeticao)
fimenquanto
escreval("CADASTROS INSERIDOS COM SUCESSO.")
escreval("OBRIGADO POR USAR NOSSO PROGRAMA!!")
fimalgoritmo