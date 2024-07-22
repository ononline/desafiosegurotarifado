package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {
    
    Optional<ProdutoEntity> findByNome(String nome);
}
