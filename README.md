# Desafio Software Engineer - "Seguro Tarifado"

## Introdução
Este projeto é a solução desenvolvida por Tiago Petreanu Monteiro para o desafio 
do processo seletivo para Software Engineer, conforme proposto no anexo [Desafio](DESAFIO.md).

O projeto foi iniciado em 20/07/2024, para entrega no dia 23/07/2024

## Tecnologias utilizadas

- Spring Initializr
- Gradle
- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2
- JUnit
- Mockito
- Micrometer
- Prometheus
- Grafana

## Como executar o projeto

Para executar o projeto deve-se utilizar o gradle.

Primeiro, se executa `$ gradle build` para baixar as dependências e construir o projeto.

Depois, para executar o projeto, deve-se executar `$ gradle bootRun`.

Caso esteja utilizando a IDE IntelliJ, é só utilizar o menu do Gradle.

Com o projeto executando, há apenas um endpoint que pode ser acessado pelo endereço http://localhost:8080/produtos

O endpoint aceita como body um JSON com formato:

```json
{
  "nome": "vida",
  "categoria" : "VIDA",
  "preco_base" : 100.00
}
```


- O campo `"nome"` é uma `String` livre, sem validação, mas utilizada como identificador do produto, conforme especificação,
  para manter a base de dados
- O campo `"categoria"` é uma `String` que aceita os valores `VIDA`, `AUTO`, `VIAGEM`, `RESIDENCIAL` e `PATRIMONIAL`.
  - Qualquer valor além desses irá retornar um erro
- O campo `"preco_base"` é um `double` que indica o valor a se aplicar os impostos

E retorna outro JSON, com o formato:

```json
{
  "id": "c7b4a6d9-4f9e-4fd2-bc77-6edc5c5fdc40",
  "nome": "vida",
  "categoria": "VIDA",
  "preco_base": 100.0,
  "preco_tarifado": 103.2
}
```
- O campo `"id"` indica o UUID gerado para o registro no banco de dados
- Os campos `"nome"`, `"categoria"` e `"preco_base"` são os mesmos valores enviados na requisição
- O campo `"preco_tarifado"` é refente ao preço base enviado na requisição, somado aos valores dos impostos parametrizados
  para cada categoria

## Detalhamento da solução

### Arquitetura

A arquitetura escolhida para o projeto foi baseada na Clean Architecture, pois foi mencionado no desafio que será um 
ponto de avaliação.

Em um projeto real que teria o mesmo objetivo que este desafio (i.e.: calcular tarifas sobre um produto), uma arquitetura
mais simplista seria suficiente. A Clean Architecture é fundamental em projetos complexos para haver uma separação entre
as regras de negócio e os mecanismos de funcionamento do serviço, deixando as regras livres de dependências.

Esse desacoplamento é importante, porém neste caso me parece exagerado. Algumas classes do projeto servem simplesmente como
separadores, não tendo função real. Uma arquitetura Model-Service-Controller conseguiria manter a separação de responsabilidades
mantendo um código mais legível e manutenível.

### Design Patterns

Foram escolhidas duas Design Patterns para facilitar a independência dos cálculos de tarifas: Strategy, Factory e Singleton.

A pattern Strategy permite que os cálculos das tarifas sejam independentes uns dos outros, permitindo que, caso eventualmente
tenha uma categoria cujo cálculo seja completamente diferente dos outros, não há impacto nos cálculos existentes, nem
na execução do serviço. Só é necessário criar uma nova implementação da CategoriaStrategy, e alterar a Factory para considerar
a nova categoria.

Já a pattern Factory acaba se mesclando um pouco com Singleton, para permitir que a escolha e o instanciamento da Strategy 
apropriada sejam centralizados, tornando o restante do código independente da categoria, e sem a criação de novas instâncias 
a cada chamada.

Inicialmente a solução imaginada havia sido o uso de um Enum com os valores dos impostos fixados, o que faria o código ser
mais simples, porém todos os cálculos de tarifas seriam obrigados a utilizar a mesma fórmula, atendendo no momento, mas pode
causar problemas futuramente, além de delegar ao Spring Web a responsabilidade sobre a tratativa de erros.

## Testes

Os testes foram realizados de forma unitária sobre as classes referentes ao cálculo de tarifas (as Strategies), e de forma 
integrada cobrindo o restante do serviço, totalizando:
- 98% das classes (17 de 18, não foi testada a classe Application, que só possui o método main da aplicação)
- 87% dos métodos (36/41, faltam alguns getters e setters que não são utilizados no código)
- 95% das linhas (100/105, mesmo que acima)

O relatório de cobertura de testes pode ser encontrado [aqui](htmlReport/index.html)

## Observabilidade

Para acompanhamento da saúde do serviço, foi incluído o Micrometer, parte do Spring Actuator, que colhe todos os dados necessários
do serviço, o Prometheus que fica lendo os dados colhidos pelo Micrometer e o Grafana para criar dashboards com os dados do 
Prometheus.

Para verificar os dados, deve-se executar o `docker-compose.yml`, que irá criar imagens do Prometheus e do Grafana, que podem
ser acessados pelas urls http://localhost:9090 e http://localhost:3000 respectivamente.