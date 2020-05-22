#Author: alexandreeulampio@gmail.com

Feature: Inserir simulacoes
  Eu quero executar o comando POST
  Para inserir simulacoes

  Scenario Outline: Inserir simulacoes
    Given Eu acesso a operacao POST do endpoint simulacoes
    When Eu executo a operacao POST informando os campos "<StatusCode>","<nome>","<cpf>","<email>","<valor>","<parcelas>","<seguro>"
    Then Eu visualizo o resultado do cadastro "<StatusCode>" "<Mensagem>"

    Examples:
      | StatusCode | nome          | cpf         | email              | valor | parcelas | seguro | Mensagem                         |
      | 201        | Fulano        | 21222222221 | fulano@gmail.com   | 11000 | 3        | true   |                                  |
      | 400        | Deltrano      | 17822386034 | deltrano@gmail.com | 20000 | 5        | false  | CPF duplicado                    |
      | 400        | Fulano de Tal | 97093236014 | email@email.com    | 1200  | 3        | true   | CPF duplicado                    |
      | 400        |               | 97093236014 | email@email.com    | 1200  | 3        | true   |                                  |
      | 400        | Fulano de Tal |             | email@email.com    | 1200  | 3        | true   | CPF duplicado                    |
      | 400        | Fulano de Tal | 97093236014 |                    | 1200  | 3        | true   | E-mail deve ser um e-mail válido |
      | 400        | Fulano de Tal | 97093236014 | email@email.com    |       | 3        | true   |                                  |
      | 400        | Fulano de Tal | 97093236014 | email@email.com    | 1200  |          | true   |                                  |
      | 400        | Fulano de Tal | 97093236014 | email@email.com    | 1200  | 3        |        |                                  |