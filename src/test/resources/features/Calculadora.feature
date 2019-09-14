@winium
Feature: Testando automacao Desktop com Winium

  @calculadora
  Scenario: Testar calculos de adicao e subtracao
    Given Que eu digito o numero 1
    And Que eu digito o numero 3
    And Que eu digito o sinal de Adicionar
    And Que eu digito o numero 1
    And Que eu digito o numero 0
    And Que eu digito o numero 0
    And Que eu digito o sinal de Igual a
    Then Recebo o resultado de 113
    
  @calculadora_examples
  Scenario Outline: Testar calculos de adicao
   	Given Que eu digito o numero <numero1>
   	And Que eu digito o sinal de <operacao>
   	And Que eu digito o numero <numero2>
   	And Que eu digito o sinal de Igual a
   	Then Recebo o resultado de <resultado>
   		
   	Examples:
   		| operacao    | numero1  | numero2 | resultado | 
   		| Adicionar   | 132      | 100     | 232       |
    	| Subtrair    | 132      | 10      | 122       |
    	| Dividir     | 100      | 10      | 10        |
    	| Multiplicar | 100      | 2       | 200       |
