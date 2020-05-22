#Author: alexandreeulampio@gmail.com

Feature: Altera simulacoes
  Eu quero executar o comando PUT
  Para alterar simulacoes

  Scenario Outline: ALterar simulacoes
    Given Eu acesso a operacao PUT do endpoint simulacoes
    When Eu executo a operacao PUT informando os campos "<CPF_Origem>","<StatusCode>","<nome>","<cpf>","<email>","<valor>","<parcelas>","<seguro>"
    Then Eu visualizo o resultado da alteracao "<StatusCode>" "<Mensagem>"

    Examples:
      | CPF_Origem  | StatusCode | nome          | cpf         | email              | valor | parcelas | seguro | Mensagem                         |
      | 97093236014 | 200        | Fulano        | 97093236014 | fulano@gmail.com   | 11000 | 3        | true   |                                  |
      |             | 405        | Deltrano      | 17822386034 | deltrano@gmail.com | 20000 | 5        | false  | CPF duplicado                    |
      | 97093236014 | 200        | Fulano de Tal | 97093236014 | email@email.com    | 1200  | 3        | true   |                     |
      | 97093236014 | 200        |               | 97093236014 | email@email.com    | 1200  | 3        | true   |                                  |
      | 97093236014 | 400        | Fulano de Tal |             | email@email.com    | 1200  | 3        | true   | CPF duplicado                    |
      | 97093236014 | 400        | Fulano de Tal | 97093236014 |                    | 1200  | 3        | true   | E-mail deve ser um e-mail válido |
      | 97093236014 | 200        | Fulano de Tal | 97093236014 | email@email.com    |       | 3        | true   |                                  |
      | 97093236014 | 200        | Fulano de Tal | 97093236014 | email@email.com    | 1200  |          | true   |                                  |
      | 97093236014 | 200        | Fulano de Tal | 97093236014 | email@email.com    | 1200  | 3        |        |                                  |