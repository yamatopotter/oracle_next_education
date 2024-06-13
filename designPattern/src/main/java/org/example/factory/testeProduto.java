package org.example.factory;

public class testeProduto {
    public static void main(String[] args) {
        ProdutoFisico produtoFisico = new ProdutoFisico();
        produtoFisico.setPossuiDimensoesFisicas(true);

        ProdutoDigital produtoDigital = new ProdutoDigital();
        produtoDigital.setPossuiDimensoesFisicas(false);

        Produto produto1 = ProdutoFactory.getInstance(TipoProduto.DIGITAL);
        Produto produto2 = ProdutoFactory.getInstance(TipoProduto.FISICO);

        System.out.println(produto1);
        System.out.println(produto2);

    }
}
