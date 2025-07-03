package parteA.gestaoProduto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    // 1. Declarar o campo Produto
   Produto camisa;
   Produto bermuda;

    // 2. Inicializar o campo Produto no método setUp()
    @BeforeEach
    void setUp() {
        camisa = new Produto("Camisa Polo", 50.00, 100, "Vestuário", "Adidas");
        bermuda = new Produto("Bermuda Jeans", 40.00, 50, "Vestuário", "Puma");
    }

    // 3. Implementar os testes para cada método da classe Produto
    @Test
    void testactualizarPrecoBase() {
        camisa.actualizarPrecoBase(45.00);
        assertEquals(45.00, camisa.getPrecoBase());
    }

    @Test
    void TestaplicarDesconto() {
        bermuda.aplicarDesconto(0.10); // Aplicar 10% de desconto
        assertEquals(44.0, bermuda.getPrecoBase()); // o preço aumenta ao invés de diminuir
        //assertThrows(IllegalArgumentException.class, () -> manteiga.precoComDesconto(11));
    }

    @Test
    void testcalcularPrecoFinal() {
        camisa.aplicarDesconto(0.20); // Aplicar 20% de desconto
        assertEquals(40.00, camisa.calcularPrecoFinal());
    }

    @Test
    void testadicionarStock() {
        camisa.adicionarStock(2);
        assertEquals(102, camisa.getStock());

        bermuda.adicionarStock(3);
        assertEquals(53, bermuda.getStock());
    }

    @Test
    void testremoverStock() {
        camisa.removerStock(10);
        assertEquals(90, camisa.getStock());

        bermuda.removerStock(10);
        assertEquals(40, bermuda.getStock());
    }

    @Test
    void testgerarDescricaoProduto() {
        String descricaoCamisa = camisa.gerarDescricaoProduto();
        assertEquals("Produto: Camisa Polo, Marca: Adidas, Categoria: Vestuário, PreçoBase: 50.0, Stock: 100", descricaoCamisa);

        String descricaoBermuda = bermuda.gerarDescricaoProduto();
        assertEquals("Produto: Bermuda Jeans, Marca: Puma, Categoria: Vestuário, PreçoBase: 40.0, Stock: 50", descricaoBermuda);
    }
}