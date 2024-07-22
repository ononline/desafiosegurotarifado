package br.com.tiagomonteiro.desafiosegurotarifado.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "PRODUTO")
public class ProdutoEntity{
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        private String nome;
        private String categoria;
        private Double preco_base;
        private Double preco_tarifado;
        
        public ProdutoEntity() {
        }
        
        public UUID getId() {
                return id;
        }
        
        public void setId(UUID id) {
                this.id = id;
        }
        
        public String getNome() {
                return nome;
        }
        
        public void setNome(String nome) {
                this.nome = nome;
        }
        
        public String getCategoria() {
                return categoria;
        }
        
        public void setCategoria(String categoria) {
                this.categoria = categoria;
        }
        
        public Double getPreco_base() {
                return preco_base;
        }
        
        public void setPreco_base(Double preco_base) {
                this.preco_base = preco_base;
        }
        
        public Double getPreco_tarifado() {
                return preco_tarifado;
        }
        
        public void setPreco_tarifado(Double preco_tarifado) {
                this.preco_tarifado = preco_tarifado;
        }
        
        public ProdutoEntity(UUID id, String nome, String categoria, Double preco_base, Double preco_tarifado) {
                this.id = id;
                this.nome = nome;
                this.categoria = categoria;
                this.preco_base = preco_base;
                this.preco_tarifado = preco_tarifado;
        }
}
