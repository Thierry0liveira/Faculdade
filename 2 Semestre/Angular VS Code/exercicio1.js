;
//Depois, crio os três produtos usando a interface
var produto1 = {
    nome: "Lápis",
    codigo: 123,
    preco: 0.75,
    descricao: "Lápis grafite.",
    quantidadeEstoque: 100
};
var produto2 = {
    nome: "Borracha",
    codigo: 456,
    preco: 2.00,
    descricao: "Borracha branca quadrada.",
    quantidadeEstoque: 50
};
var produto3 = {
    nome: "Caneta",
    codigo: 789,
    preco: 1.50,
    descricao: "Caneta BIC azul.",
    quantidadeEstoque: 200
};
// Agora, uso a função para cadastrar o produto e mostrar sua informação
function cadastrarProduto(produto) {
    var dados = "\nNome: ".concat(produto.nome, "\n        Codigo: ").concat(produto.codigo, "\n        Preco: R$ ").concat(produto.preco.toFixed(2), ";\n        Descricao: ").concat(produto.descricao, "\n        Quantidade em Estoque: ").concat(produto.quantidadeEstoque, " un");
    return dados;
}
//Por último exibo as informações dos produtos cadastrados
console.log(cadastrarProduto(produto1));
console.log(cadastrarProduto(produto2));
console.log(cadastrarProduto(produto3));
