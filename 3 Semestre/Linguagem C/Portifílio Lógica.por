programa {
  funcao inicio() {
    //VARIAVEIS
    inteiro opcao, qtd_animais_especie
    real comida, preco, qtd_comida_dia, qtd_comida_mes, preco_mes

    //ENTRADA DE DADOS
    escreva ("Animais do ZOO:")
    escreva ("\n1 - Leao")
    escreva ("\n2 - Zebra")
    escreva ("\n3 - Urso")
    escreva ("\n4 - Jacare")
    escreva ("\n5 - Elefante")
    escreva ("\nEscolha uma OPCAO: ")
    leia(opcao)
    escreva ("Digite a quantidade de Animais da Especie Selecionada: ")
    leia(qtd_animais_especie)

    //PROCESSAMENTO
    se (opcao == 1){
      comida = 5.0
      preco = 30.0
    }
    se (opcao == 2){
      comida = 1.0
      preco = 1.0
    }
    se (opcao == 3){
      comida = 4.0
      preco = 25.0
    }
    se (opcao == 4){
      comida = 0.5
      preco = 5.0
    }
    se (opcao == 5){
      comida = 5.0
      preco = 15.0
    }

    //CALCULOS
    qtd_comida_dia = comida * qtd_animais_especie
    qtd_comida_mes = qtd_comida_dia * 30
    preco_mes = qtd_comida_mes * preco

    //SAIDA DE DADOS
    escreva("\n\nRESULTADOS")
    escreva("\nQuantidade comida ao dia: "+ qtd_comida_dia)
    escreva("\nQuantidade comida ao mes: "+ qtd_comida_mes)
    escreva("\nCusto mesnal: "+ preco_mes)

  }
}
