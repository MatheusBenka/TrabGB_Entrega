#Compilador JAVACC para LPD

Nosso trabalho foi feito utilizando a abordagem da ferramenta JavaCC, foi feita a tabela de símbolos, análise sintática, análise semântica e o tratamento de erros. Os principais arquivos são analisa_LPD.jj, tabela_simb.java e codigo.txt.

O código teste utilizado em codigo.txt está com erros propositais para testar a funcionalidade dos analisadores sintático e semântico, já o arquivo codigo_c.txt está sem nenhum erro.

O analisador foi compilado e testado utilizando o cmd. 

##Para executa-lo:

é preciso abrir o cmd no local dos arquivos principais e executar o comando: 

```
java -cp ./javacc.jar javacc analisa_LPD.jj
javac *.java
java analisa_LPD.java < codigo.txt
```

Substituindo o conteudo do "codigo.txt" para o teste de sua preferência.