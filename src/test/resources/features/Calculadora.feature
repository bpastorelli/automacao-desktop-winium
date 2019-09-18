@winium
Feature: Testando automacao Desktop com Winium

  @calculadora
  Scenario: Testar calculos de adicao
  	Given Que eu quero testar "Calculos de adicao"
    And Que eu digito o numero 1
    And Que eu digito o numero 3
    And Que eu digito o sinal de Mais
    And Que eu digito o numero 1
    And Que eu digito o numero 0
    And Que eu digito o numero 0
    And Que eu digito o sinal de Igual a
    Then Recebo o resultado de 113 da operacao Mais
    
  @calculadora_examples
  Scenario Outline: Testar calculos da Calculadora
  	Given Que eu quero testar "Calculos de <operacao>"
   	And Que eu digito o numero <numero1>
   	And Que eu digito o sinal de <operacao>
   	And Que eu digito o numero <numero2>
   	When Que eu digito o sinal de Igual a
   	Then Recebo o resultado de <resultado> da operacao <operacao>
   		
   	Examples:
   		| operacao        | numero1  | numero2 | resultado | 
   		| Mais            | 132      | 100     | 232       |
    	| Menos           | 132      | 10      | 122       |
    	| Dividir por     | 100      | 10      | 10        |
    	| Multiplicar por | 100      | 2       | 200       |
