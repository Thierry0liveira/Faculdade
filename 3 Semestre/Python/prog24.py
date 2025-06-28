# Exercício Tabuada e todas as Opereções

numero=int(input('Digite o número:'))

for i in range(10):
    i=i+1
    soma=numero+i
    sub=numero-i
    div=numero*i
    mult=numero/i
    print(f'{numero} + {i} = {soma:.1f}\t', end='')
    print(f'{numero} - {i} = {sub:.1f}\t', end='')
    print(f'{numero} X {i} = {div:.1f}\t', end='')
    print(f'{numero} / {i} = {mult:.1f}')
