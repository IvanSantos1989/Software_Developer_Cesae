package parteA.gestaoBancaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    private ContaBancaria conta;
    private ContaBancaria conta2;

    @BeforeEach
    void setUp() {
        conta = new ContaBancaria("João Silva", 1000.0, 2020, "Portugal", "PT50000201231234567890154");
        conta2 = new ContaBancaria("Maria Santos", 2000.0, 2021, "Portugal", "PT50000201231234567890155");
    }

    @Test
    void depositar() {
        conta.depositar(500);
        assertEquals(500.0, conta.consultarSaldo());
    }

    @Test
    void levantar() {
        conta.levantar(100);
        assertEquals(1000.0, conta.consultarSaldo());
    }

    @Test
    void transferir() {
        conta2.transferir(conta, 300.0);
        assertEquals(1700.0, conta2.consultarSaldo());
    }

    @Test
    void aplicarRendimentoMensal() {
        conta.aplicarRendimentoMensal(0.01); // 1% de rendimento
        assertEquals(1010.0, conta.consultarSaldo(), 0.001);
    }

    @Test
    void consultarSaldo() {
        conta2.consultarSaldo();
        assertEquals(2000, conta2.consultarSaldo(), 0.001);
    }

    @Test
    void gerarResumoConta() {
        String resumo = conta.gerarResumoConta();
        assertEquals(resumo, conta.gerarResumoConta());
    }
}