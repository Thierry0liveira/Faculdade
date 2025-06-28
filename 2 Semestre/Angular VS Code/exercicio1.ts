//Primeiro preciso definir a interface
interface Produto {
    nome:string,
    codigo:number,
    preco:number,
    descricao:string,
    quantidadeEstoque:number
};

//Depois, crio os três produtos usando a interface
var produto1:Produto = { 
    nome: "Lápis",
    codigo: 123,
    preco: 0.75,
    descricao: "Lápis grafite.",
    quantidadeEstoque: 100
};

var produto2:Produto = { 
    nome: "Borracha",
    codigo: 456,
    preco: 2.00,
    descricao: "Borracha branca quadrada.",
    quantidadeEstoque: 50
};

var produto3:Produto = { 
    nome: "Caneta",
    codigo: 789,
    preco: 1.50,
    descricao: "Caneta BIC azul.",
    quantidadeEstoque: 200
};

// Agora, uso a função para cadastrar o produto e mostrar sua informação
function cadastrarProduto(produto: Produto): string {
        var dados = `\nNome: ${produto.nome}
        Codigo: ${produto.codigo}
        Preco: R$ ${produto.preco.toFixed(2)};
        Descricao: ${produto.descricao}
        Quantidade em Estoque: ${produto.quantidadeEstoque} un`
        return dados;
}

//Por último exibo as informações dos produtos cadastrados
console.log(cadastrarProduto(produto1));
console.log(cadastrarProduto(produto2));
console.log(cadastrarProduto(produto3));