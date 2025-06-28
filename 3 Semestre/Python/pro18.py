#Calcular o IMC

peso=float(input('Digite o seu peso:'))
altura=float(input('Digite sua altura:'))
imc=(peso/(altura**2))

#Exibe o IMC
print(f'Seu IMC é:{imc}')

#Exibe a Classificação

if imc <= 18.5:
    print('É classificado como: Abaixo do peso')
if imc > 18.5 and imc <= 24.9:
    print('É classificado como: Peso Normal')
if imc > 24.9 and imc <= 29.9:
    print('É classificado como: Excesso de Peso')
if imc > 29.9 and imc <= 34.9:
    print('É classificado como: Obesidade I')
if imc > 34.9 and imc <= 39.9:
    print('É classificado como: Obesidade II')
if imc > 39.9:
    print('É classificado como: Obesidade III')
