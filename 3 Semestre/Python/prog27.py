a=0
soma=0
for ano in range (2000,2020):
    if ano % 4 ==0:
        print (f'Esse ano {ano} é um Ano Bissexto')
    else:
        print(f'Esse ano {ano} não é um Ano Bissexto')
    soma=soma+1 #acumulador

print(f'Totais de anos {soma}')
