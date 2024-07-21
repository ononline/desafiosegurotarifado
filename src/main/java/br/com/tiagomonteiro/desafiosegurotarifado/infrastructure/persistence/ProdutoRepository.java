package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, String> {
}
