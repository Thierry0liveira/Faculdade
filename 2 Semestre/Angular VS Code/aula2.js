//Tipo de Variáveis
var nome = "Nelson";
nome = "Camila";
var idade = 10;
idade = 10.4;
var ok = true;
ok = false;
//Concatenação jeito 1
console.log("Nome: " + nome + " idade " + idade + " OK " + ok);
//Concatenação jeito 2
//console.log( `Nome: ${nome} idade ${idade} OK ${ok}` );
//Lista jeito 1
var lista = ["Alyfy", "Amanda", "Anderson", "Daniel", "Jeziel"];
//Lista jeito 2
//var lista2:string[] = ["Alyfy" , "Amanda", "Anderson" , "Daniel" , "Jeziel"];
//Mostra o Index da lista
for (var item in lista) {
    console.log(parseInt(item) + 1);
}
//Mostra o Valor da lista
for (var _i = 0, lista_1 = lista; _i < lista_1.length; _i++) {
    var item = lista_1[_i];
    console.log(item);
}
