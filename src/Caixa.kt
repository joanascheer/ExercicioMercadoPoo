import kotlin.system.exitProcess

class Caixa {

    val listaProdutos: ArrayList<Produto> = ArrayList()

    init {
        while (true) {
            println("***************************\n" +
                    "         C A I X A         \n")

            println("1 - Cadastrar Produtos")
            println("2 - Ver produtos cadastrados")
            println("3 - Limpar carrinho")
            println("4 - Calcular valor total dos produtos do carrinho")
            println("5 - Sair do sistema\n")

            println("Digite a opção desejada: ")

            when (readln()) {

                "1" -> {
                    criaProduto()
                }
                "2" -> {
                    exibeListaProdutos()
                }
                "3" -> {
                    limparLista()
                }
                "4" -> {
                    calculaValorTotal(listaProdutos)
                }
                "5" -> {
                    println("Obrigado(a), até a próxima compra!")
                    exitProcess(0)
                }
            }
        }
    }


        fun criaProduto() {
            println("Quantos produtos deseja cadastrar?")
            val qtdeProdutosACadastrar = readln().toInt()

            for (i in 1..qtdeProdutosACadastrar) {
                val produtoCriado = criaObjProduto()

                println("Digite o nome do produto:")
                produtoCriado.nomeProduto = readln()

                println("Digite o valor do produto:")
                produtoCriado.valorProduto = readln().toDouble()

                println("Digite a quantidade de produtos:")
                produtoCriado.quantidadeProduto = readln().toInt()

                listaProdutos.add(produtoCriado)

            }

            mensagemSucesso()

        }


        fun exibeListaProdutos() {

            if (listaProdutos.isEmpty()) {
                println("Sua cesta está vazia!")
            } else {
                println("Sua cesta de produtos:\n")

                listaProdutos.forEach {
                    println("Produto: ${it.nomeProduto}\n" +
                            "Valor: R$${it.valorProduto}\n" +
                            "Quantidade: ${it.quantidadeProduto}\n" +
                            "Valor total parcial: R$${calcula(it.valorProduto,it.quantidadeProduto)}\n" +
                            "*************\n")
                }
            }

        }


    fun limparLista() {

        listaProdutos.clear()

        mensagemSucesso()

    }

    fun calcula(valorProduto: Double, quantidadeProduto: Int): Double {
        return valorProduto * quantidadeProduto
    }

    fun calculaValorTotal(listaProdutos: ArrayList <Produto>) {
        var totalFinal = 0.0
        for (i in listaProdutos.indices) {
            totalFinal += calcula(listaProdutos[i].valorProduto, listaProdutos[i].quantidadeProduto)
        }

        println("Valor total do carrinho: R$$totalFinal")
    }

    companion object {

        fun criaObjProduto() : Produto {
            Produto()

            return Produto()
        }

        fun mensagemSucesso() {
            println("Operação realizada com sucesso!")
        }

    }

}