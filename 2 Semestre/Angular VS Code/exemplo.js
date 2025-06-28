;
var nome = "Nelson";
var idade = 12;
console.log("Nome: " + nome);
console.log("Idade: " + idade);
var aluno1 = {
    nome: "Guilherme",
    rg: "123.456.789-x",
    idade: 17
};
var texto = "Nome: ".concat(aluno1.nome, "\nRG: ").concat(aluno1.rg, "\nIdade: ").concat(aluno1.idade);
console.log(texto);
