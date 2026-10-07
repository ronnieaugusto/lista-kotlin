fun calcularDesconto(valor: Double, cupom: String?): Double {
    return when (cupom) {
        "PROMO10" -> valor - 10
        "PROMO20" -> valor - 20
        else -> valor
    }
}

fun executarQuestao1() {
    println("Com PROMO10: ${calcularDesconto(100.0, "PROMO10")}")
    println("Com PROMO20: ${calcularDesconto(100.0, "PROMO20")}")
    println("Sem cupom (nulo): ${calcularDesconto(100.0, null)}")
    println("Cupom inválido: ${calcularDesconto(100.0, "ABC")}")
}

fun auditarEntregas(enderecos: List<String?>) {
    for (endereco in enderecos) {
        val enderecoFinal = endereco ?: "Endereço Desconhecido"

        if (enderecoFinal == "Endereço Desconhecido") {
            println("Entrega Pendente: Falta de dados")
        } else {
            println("Rota traçada para: $enderecoFinal")
        }
    }
}

fun executarQuestao2() {
    auditarEntregas(listOf("Rua das Flores, 10", null, "Av. Brasil, 200", null))
}
fun validarBioInfantil(bio: String?) {
    val tamanho = bio?.length ?: 0

    if (tamanho <= 50) {
        println("Bio aceita")
    } else {
        println("Bio muito longa")
    }
}

fun executarQuestao3() {
    validarBioInfantil("Adoro desenhos e jogos")
    validarBioInfantil(null)
    validarBioInfantil("Esta biografia é longa demais, passa dos cinquenta caracteres com certeza")
}

fun executarQuestao4() {
    val transferencias: List<Double?> = listOf(50.0, null, 120.5, null, 10.0)
    var total = 0.0

    for (valor in transferencias) {
        if (valor != null) {
            total += valor
        } else {
            println("Transação ignorada")
        }
    }

    println("Total processado: $total")
}

fun avaliarMotorista(nota: Int?) {
    when (nota ?: 0) {
        5 -> println("Excelente corrida!")
        4 -> println("Boa corrida.")
        1, 2, 3 -> println("Precisamos melhorar.")
        0 -> println("Nenhuma avaliação fornecida.")
        else -> println("Nota inválida")
    }
}

fun executarQuestao5() {
    avaliarMotorista(5)
    avaliarMotorista(4)
    avaliarMotorista(2)
    avaliarMotorista(null)
}

val calcularGorjeta: (Double?) -> Double = {
    if (it == null || it < 0) 0.0 else it
}

fun executarQuestao6() {
    println("Gorjeta nula: ${calcularGorjeta(null)}")
    println("Gorjeta negativa: ${calcularGorjeta(-5.0)}")
    println("Gorjeta válida: ${calcularGorjeta(12.5)}")
}

fun limparEmails(emails: List<String?>) {
    var invalidas = 0

    for (email in emails) {
        if ((email?.length ?: 0) == 0) {
            invalidas++
            println("Conta inválida: marcada para deleção")
        } else {
            println("Conta válida: $email")
        }
    }

    println("Contas que precisam ser apagadas: $invalidas")
}

fun executarQuestao7() {
    limparEmails(listOf("ana@email.com", null, "", "joao@email.com", null))
}

fun main() {
    println("--- Questão 1 ---"); executarQuestao1()
    println("--- Questão 2 ---"); executarQuestao2()
    println("--- Questão 3 ---"); executarQuestao3()
    println("--- Questão 4 ---"); executarQuestao4()
    println("--- Questão 5 ---"); executarQuestao5()
    println("--- Questão 6 ---"); executarQuestao6()
    println("--- Questão 7 ---"); executarQuestao7()
}