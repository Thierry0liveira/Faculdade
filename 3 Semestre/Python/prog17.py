n1=float(input('Digite o primeiro número:'))
n2=float(input('Digite o segundo número:'))
n3=float(input('Digite o terceiro número:'))

#Verificar o Maior Número
if n1==n2==n3:
    print('Os números são iguais!')
else:
    if n1 >= n2 and n1 >= n3:
        maior_numero = n1
    else:
#pode ser feito usando a função max 
#       maior_numero = max(n1,n2,n3)
#       print('O maior número é', maior_numero)
        if n2 >= n1 and n2 >= n3:
            maior_numero = n2
        else:
            maior_numero = n3

#Exibir o Maior Número

    print('O maior número é:', maior_numero)
