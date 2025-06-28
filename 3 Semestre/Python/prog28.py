# Aplicativo para calcular a média ponderada dos alunos entre 0 e 10

#   Função -- Estruturação do programa

#   Criar função

def calcula_media():

    continua=True
    while(continua):
        import os
        os.system('cls')

        aluno=input('Digite o nome do Aluno(a):')
        disciplina=input('Digite a Disciplina:')
        ex=float(input('Digite a nota dos Exercícios entre 0 e 10:'))
        while(ex < 0 or ex > 10):
            ex=float(input('\n Nota Inválida!! \n Digite a nota entre 0 e 10:'))
        pt=float(input('Digite a nota do Portifólio entre 0 e 10:'))
        while(pt < 0 or pt > 10):
            pt=float(input('\n Nota Inválida!! \n Digite a nota entre 0 e 10:'))             
        pr=float(input('Digite a nota da Prova entre 0 e 10:'))
        while(pr < 0 or pr > 10):
            pr=float(input('\n Nota Inválida!! \n Digite a nota entre 0 e 10:'))

    # Calculando a média
        
        mf=((ex*20+pt*30+pr*50)/100)

    # Exibiindo o resultado

        print(f'O aluno(a) {aluno} na disciplina {disciplina} obteve a média {mf}\n')
        if mf >= 6:
            print('O aluno está aprovado!\n\n')
        else:
            print('O aluno está reprovado!\n\n')

        opcao=input('Deseja continuar (S ou N): ')
        while(opcao.upper() != 'S' and opcao.upper() != 'N'):
            opcao=input('\nOpção inválida!!\n\n Digite (S ou N)')
        if opcao.upper()== 'S':
            continua=True
        else:
            continua=False
    print('Fim do Programa!!')

#Chamar a função

calcula_media()
