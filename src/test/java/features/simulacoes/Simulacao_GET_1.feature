#Author: alexandreeulampio@gmail.com

Feature: Consultar restricoes
  Eu quero informar um CPF
  Para consultar se o mesmo possui restricao

  Scenario Outline: Consultar CPF
    Given Eu executo a opeacao GET do endpoint simulacoes
    When Eu informo o numero de CPF "<CPF>"
    Then Eu vejo os dados "<CPF>","<StatusCode>","<id>","<nome>","<email>","<valor>","<parcelas>","<seguro>"

    Examples:
      | CPF         | StatusCode | id | nome     | email              | valor | parcelas | seguro |
      | 17822386034 | 200        | 12 | Deltrano | deltrano@gmail.com | 20000 | 5        | false  |
      | abcd        | 404        |    |          |                    |       |          |        |
