package org.example.factory;

public class ProdutoFactory {
    public static Produto getInstance(TipoProduto tipoProduto){
        switch (tipoProduto){
            case FISICO:
                ProdutoFisico produtoFisico = new ProdutoFisico();
                produtoFisico.setPossuiDimensoesFisicas(true);
                return produtoFisico;

            case DIGITAL:
                ProdutoDigital produtoDigital = new ProdutoDigital();
                produtoDigital.setPossuiDimensoesFisicas(false);
                return produtoDigital;

            default:
               throw new IllegalArgumentException("Tipo de produto não disponivel");
        }

    }
}
