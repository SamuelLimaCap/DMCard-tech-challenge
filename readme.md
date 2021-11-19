# Tech Challenge da DMCard

---

#Para que serve

O programa é um algoritmo que lê as linhas passadas através de um arquivo e verifica, em cada linha, se os parentêses estão abertos e fechados corretamente. Feito para verificar o uso dos parenteses em expressões matemáticas

---
#Requisitos
- JRE 8+
- Arquivo de leitura no formato txt

---

# Como funciona

O arquivo é um programa que é executado através da linguagem JAVA. Você pode rodar esa aplicação de 3 maneiras:
	---

## 1- Passando o caminho do arquivo depois de executar a aplicação
Utilize o comando via prompt de comando:

	java QuantidadeParenteses.java
	
Após isso, a aplicação pedirá que digite o caminho absoluto de onde está o arquivo para leitura (caso esteja no mesmo lugar que o programa, informe apenas o nome do arquivo de leitura).

## 2- Passando o caminho do arquivo como parâmetro
Para isso, adicione o parâmetro 'path', e, em seguida, passe o caminho absoluto do arquivo entre aspas duplas, como no exemplo a seguir:

	java QuantidadeParenteses.java path "C:\Users\TESTE\Desktop\parentesesGerados.txt"
	
## 3- Passando o caminho do arquivo como parâmetro e o parâmetro para ver o tempo de execução da leitura e escrita.

Para isso, realize o procedimento do método 2 e, em seguida, adicione o parametro 'showTimeSpent' como no exemplo abaixo:

	java QuantidadeParenteses.java path "C:\Users\TESTE\Desktop\parentesesGerados.txt" showTimeSpent	
	
Após a execução completa, a aplicação mostrará no console o tempo gasto em milisegundos

---

Após a passagem do caminho do arquivo, será criado, na mesma pasta da aplicação, um arquivo com a indicação de cada linha. Caso os parênteses expressão da primeira linha esteja correta, o arquivo colocará 'correct' na primeira linha de saida, caso não esteja, colocará 'incorreta'. Assim proseguirá esta regra com as outras linhas até a ultima linha.

---
# Observações
- Linhas em branco serão contadas como parâmetros
- Caso o caminho do arquivo esteja errado, o programa irá soltar uma exception informando que não foi encontrado o arquivo 

