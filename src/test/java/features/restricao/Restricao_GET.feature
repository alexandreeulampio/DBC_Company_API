#Author: alexandreeulampio@gmail.com

Feature: Consultar restricoes
  Eu quero informar um CPF
  Para consultar se o mesmo possui restricao

  Scenario Outline: Consultar CPF
    Given Eu executo a opeacao GET do endpoint restricao
    When Eu informo o numero do CPF "<CPF>"
    Then Eu vejo o resultado da consulta de restricao "<StatusCode>" "<Mensagem>"

    Examples:
      | CPF         | StatusCode | Mensagem                           |
      | 97093236014 | 200        | O CPF 97093236014 possui restrição |
      | 60094146012 | 200        | O CPF 60094146012 possui restrição |
      | 84809766080 | 200        | O CPF 84809766080 possui restrição |
      | 62648716050 | 200        | O CPF 62648716050 possui restrição |
      | 26276298085 | 200        | O CPF 26276298085 possui restrição |
      | 01317496094 | 200        | O CPF 01317496094 possui restrição |
      | 55856777050 | 200        | O CPF 55856777050 possui restrição |
      | 19626829001 | 200        | O CPF 19626829001 possui restrição |
      | 24094592008 | 200        | O CPF 24094592008 possui restrição |
      | 58063164083 | 200        | O CPF 58063164083 possui restrição |
      | asdf        | 204        | Não possui restrição               |
      | 12345667756 | 204        | Não possui restrição               |
      | */-+.       | 204        | Não possui restrição               |