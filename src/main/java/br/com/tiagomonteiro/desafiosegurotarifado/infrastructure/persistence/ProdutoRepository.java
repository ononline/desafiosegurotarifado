package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {
}
