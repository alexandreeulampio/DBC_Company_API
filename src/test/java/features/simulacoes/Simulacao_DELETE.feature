#Author: alexandreeulampio@gmail.com

Feature: Inserir simulacoes
  Eu quero executar o comando POST
  Para inserir simulacoes

  Scenario Outline: Excluir simulacoes
    Given Eu acesso a operacao DELETE do endpoint simulacoes
    When Eu executo a operacao DELETE informando os campos "<id>"
    Then Eu visualizo o resultado "<StatusCode>"

    Examples:
      | id     | StatusCode |
      | 100    | 200        |
      |        | 405        |
      | abcd   | 400        |
      | 154542 | 404        |
