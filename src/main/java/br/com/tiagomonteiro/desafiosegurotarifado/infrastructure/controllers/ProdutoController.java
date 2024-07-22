package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers;

import br.com.tiagomonteiro.desafiosegurotarifado.application.usecases.CalculateTarifaInteractor;
import br.com.tiagomonteiro.desafiosegurotarifado.application.usecases.CreateProdutoInteractor;
import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    private final CreateProdutoInteractor createProdutoInteractor;
    private final ProdutoDTOMapper produtoDTOMapper;
    private final CalculateTarifaInteractor calculateTarifaInteractor;
    
    public ProdutoController(CreateProdutoInteractor createProdutoInteractor, ProdutoDTOMapper produtoDTOMapper, CalculateTarifaInteractor calculateTarifaInteractor) {
        this.createProdutoInteractor = createProdutoInteractor;
        this.produtoDTOMapper = produtoDTOMapper;
        this.calculateTarifaInteractor = calculateTarifaInteractor;
    }
    
    @PostMapping("/produtos")
    CreateProdutoResponse create(@RequestBody CreateProdutoRequest request) throws IllegalAccessException {
        calculateTarifaInteractor.setStrategy(request.categoria());
        double precoTarifado = calculateTarifaInteractor.calcularTarifas(request.preco_base());
        Produto produtoBusinessObj = produtoDTOMapper.toProduto(request, precoTarifado);
        Produto produto = createProdutoInteractor.createProduto(produtoBusinessObj);
        return produtoDTOMapper.toResponse(produto);
    }
}
