# Resumo

Você foi designado para construir uma API REST capaz de calcular o preço
tarifado de um produto de seguros a partir do preço base informado.

O cálculo deve ocorrer durante a criação ou alteração do produto com base em
sua tributação.

Para isto é necessário considerar as informações abaixo.
Todo produto deve ter os seguintes atributos:
- ID
- Nome
- Categoria
- Preço Base
- Preço Tarifado

Após o cálculo é necessário salvar ou atualizar o produto em uma base de dados
de sua preferência (SQL ou NoSQL, podendo ser inclusive um banco de dados em
memória como H2 ou HSQLDB).

O preço tarifado deve ser calculado pela API e ignorado caso seja enviado
através da requisição, ou seja, caso o corpo da requisição contenha o campo preço
tarifado, o mesmo deve ser ignorado.

Os produtos de seguros podem pertencer as seguintes categorias:
- VIDA
- AUTO
- VIAGEM
- RESIDENCIAL
- PATRIMONIAL

Os impostos devem ser aplicados da seguinte forma:

| Categoria | Imposto sobre Operação Financeira (IOF) | Programa de Integração Social (PIS) | Contribuição para o Financiamento da Seguridade Social (COFINS) |
| --- | --- | --- |-----------------------------------------------------------------|
| VIDA | 1% | 2.2% | Não há                                                          |
| AUTO | 5.5% | 4% | 1%                                                              |
| VIAGEM | 2% | 4% | 1%                                                              |
| RESIDENCIAL | 4% | Não há | 3%                                                              |
| PATRIMONIAL | 5% | 3% | Não há                                                          |

*(obs.: alguns detalhes do documento original foram suprimidos, por não serem relevantes para a definição do desafio para
um leitor externo)*
