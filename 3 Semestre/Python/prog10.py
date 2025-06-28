#Aplicativo para calcular a média ponderada dos alunos
os.system('cls')
aluno=input('Digite o nome do Aluno(a):')
disciplina=input('Digite a Disciplina:')
ex=float(input('Digite a nota dos Exercícios:'))
pt=float(input('Digite a nota do Portifólio:'))
pr=float(input('Digite a nota da Prova:'))
mf=((ex*20+pt*30+pr*50)/100)
print(f'O aluno(a) {aluno} obteve a média: {mf} na disciplina:{disciplina}')
