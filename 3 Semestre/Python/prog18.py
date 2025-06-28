# Aplicativo para calcular a média ponderada dos alunos

# se a média for >= 6 o aluno está aprovado
# se a média for <6 o aluno está reprovado

#limpar a tela quando executado no prompt de comando

continua=True
while(continua):
    import os
    os.system('cls')

    aluno=input('Digite o nome do Aluno(a):')
    disciplina=input('Digite a Disciplina:')
    ex=float(input('Digite a nota dos Exercícios:'))
    pt=float(input('Digite a nota do Portifólio:'))
    pr=float(input('Digite a nota da Prova:'))
    mf=((ex*20+pt*30+pr*50)/100)
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
