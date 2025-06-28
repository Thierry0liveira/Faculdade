nome=input('Digite seu nome:')
idade= int(input('Digite sua Idade:'))
sexo=input('Digite f - Feminino m - Masculino:')
if (idade>=18):
    if(sexo=='f'):
        print('Você é uma mocinha maior de idade')
    else:
        print('Você é um mocinho maior de idade')
else:
    if(sexo=='f'):
        print('Você é uma mocinha menor de idade')
    else:
        print('Você é um mocinho menor de idade')    
print('fim do programa!!')
