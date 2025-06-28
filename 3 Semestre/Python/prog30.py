#funcção de calcular media

def calcular_media(exer,port,prova):
    media=exer*0.20+port*0.30+prova*0.5
    return media
    
#função de mensagens aprovado ou reprovado
    
def mensagem_aprovado(aluno, nota_media):
    print(f'Voce {aluno} esta aprovado com a media {nota_media}')

def mensagem_reprovado(aluno, nota_media):
    print(f'Voce {aluno} esta reprovado com a media {nota_media}')

#Validação de entrada

def Val_entrada(nota):
    while (nota < 0 or nota > 10):
        nota = float(input('Nota inválida!! Digite a nota entre 0 e 10:'))
    return nota

#Validação da opçao

def Val_opcao(escolha):
    while (escolha != 's' or escolha != 'n'):
        escolha = input('Escolha inválida!! Escolha s para continuar ou n para sair:')
    return escolha

#programa principal

continua=True
while (continua):

    #entrada de dados

    aluno=input('Digite seu nome:')
    
    exer=Val_entrada(float(input('Digite a nota do exercicio:')))
    port=Val_entrada(float(input('Digite a nota do portifolio:')))
    prova=Val_entrada(float(input('Digite a nota da prova:')))

    #chamar a função
    
    nota_media = calcular_media(exer,port,prova)

    if nota_media >= 6:
        mensagem_aprovado(aluno, nota_media)
    else:
        mensagem_reprovado(aluno, nota_media)

    opcao=Val_opcao(input('Digite s para continuar ou n para sair:'))

    if opcao.upper() == 'S':
        continua=True
    else:
        continua=False
