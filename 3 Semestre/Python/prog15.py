n1=float(input('Digite o primeiro número:'))
n2=float(input('Digite o segundo número:'))
print('Escolha a opção')
print('1 - Adição')
print('2 - Subtracao')
print('3 - Multiplicacao')
print('4 - Divisao')
opcao=int(input('Opção:'))
if opcao < 1 or opcao > 4:
    print('Opção Inválida')
if opcao ==1:
    s=n1+n2
    print(f'O resultado da Adição é:{s}')
if opcao ==2:
    s=n1-n2
    print(f'O resultado da Subtração é:{s}')
if opcao ==3:
    s=n1*n2
    print(f'O resultado da Multiplicação é:{s}')
if opcao==4:
    s=n1/n2
    print(f'O resultado da Divisão é:{s}')



