package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.controllers;

import br.com.tiagomonteiro.desafiosegurotarifado.application.usecases.CreateProdutoInteractor;
import br.com.tiagomonteiro.desafiosegurotarifado.domain.entity.Produto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private final CreateProdutoInteractor createProdutoInteractor;
    private final ProdutoDTOMapper produtoDTOMapper;
    
    public ProdutoController(CreateProdutoInteractor createProdutoInteractor, ProdutoDTOMapper produtoDTOMapper) {
        this.createProdutoInteractor = createProdutoInteractor;
        this.produtoDTOMapper = produtoDTOMapper;
    }
    
    @PostMapping
    CreateProdutoResponse create(@RequestBody CreateProdutoRequest request){
        Produto produtoBusinessOBj = produtoDTOMapper.toProduto(request);
        Produto produto = createProdutoInteractor.createProduto(produtoBusinessOBj);
        return produtoDTOMapper.toResponse(produto);
    }
}
