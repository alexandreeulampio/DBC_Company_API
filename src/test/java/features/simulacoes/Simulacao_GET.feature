#Author: alexandreeulampio@gmail.com

Feature: Consultar simulacoes existentes
  Eu quero executar o comando GET
  Para consultar todas as simulacoes cadastradas

  Scenario Outline: Consultar simulacoes
    Given Eu acesso a operacao GET do endpoint simulacoes
    When Eu executo a operacao GET
    Then Eu vejo todas as simulacoes cadastradas "<StatusCode>","<id>","<nome>","<cpf>","<email>","<valor>","<parcelas>","<seguro>"

    Examples:
      | StatusCode | id | nome          | cpf         | email              | valor    | parcelas | seguro |
      | 204        |    |               |             |                    |          |          |        |
      | 200        | 11 | Fulano        | 66414919004 | fulano@gmail.com   | 11000.00 | 3        | true   |
      | 200        | 12 | Deltrano      | 17822386034 | deltrano@gmail.com | 20000.00 | 5        | false  |
      | 200        | 13 | Fulano de Tal | 97093236014 | email@email.com    | 1200.00  | 3        | false  |
      | 200        | 38 | Fulano de Tal |             | email@email.com    | 1200.00  | 3        | true   |
      | 200        | 50 | Fulano de Tal | 1           | email@email.com    | 1200.00  | 3        | true   |
      | 200        | 51 | Fulano        | 21222222222 | fulano@gmail.com   | 11000.00 | 3        | true   |

