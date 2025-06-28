interface Pessoa {
    nome:string,
    rg:string,
    idade:number
};

var nome:string = "Nelson";
var idade:number = 12;

console.log("Nome: " + nome);
console.log("Idade: " + idade);

var aluno1:Pessoa = {
    nome: "Guilherme",
    rg:  "123.456.789-x",
    idade: 17
};

var texto = `Nome: ${aluno1.nome}
RG: ${aluno1.rg}
Idade: ${aluno1.idade}`;

console.log(texto);