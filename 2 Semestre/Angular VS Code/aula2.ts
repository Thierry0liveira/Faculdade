//Tipo de Variáveis

var nome:string = "Nelson";
nome = "Camila";

var idade:number = 10;
idade = 10.4;

var ok:boolean = true;
ok = false;

//Concatenação jeito 1
console.log( "Nome: " + nome + " idade " + idade + " OK " + ok );

//Concatenação jeito 2
//console.log( `Nome: ${nome} idade ${idade} OK ${ok}` );

//Lista jeito 1
var lista:Array<string> = ["Alyfy" , "Amanda", "Anderson" , "Daniel" , "Jeziel"];

//Lista jeito 2
//var lista2:string[] = ["Alyfy" , "Amanda", "Anderson" , "Daniel" , "Jeziel"];

//Mostra o Index da lista
for (let item in lista){
    console.log(parseInt(item) + 1);
}

//Mostra o Valor da lista
for (let item of lista){
    console.log(item);
}

