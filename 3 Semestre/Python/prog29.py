#funcção de calcular media

def calcular_media(exer,port,prova):
    media=exer*0.20+port*0.30+prova*0.5
    return media
    
#função de mensagens aprovado ou reprovado
    
def mensagem_aprovado(aluno, nota_media):
    print(f'Voce {aluno} esta aprovado com a media {nota_media}')

def mensagem_reprovado(aluno, nota_media):
    print(f'Voce {aluno} esta reprovado com a media {nota_media}')

#programa principal

continua=True
while (continua):

    #entrada de dados

    aluno=input('Digite seu nome:')
    exer=float(input('Digite a nota do exercicio:'))
    port=float(input('Digite a nota do portifolio:'))
    prova=float(input('Digite a nota da prova:'))

    #chamar a função
    
    nota_media = calcular_media(exer,port,prova)

    if nota_media >= 6:
        mensagem_aprovado(aluno, nota_media)
    else:
        mensagem_reprovado(aluno, nota_media)

    continua=False
