# DesafioCC
Desafio dado pela Cross Commerce em criar um aplicativo que realize um processo de ETL(Extract, transform and Load), onde eu preciso extrair um conjunto de números da base de dados ate quando não existir mais números a serem extraídos.

Eu utilizei o Postman para realizar os testes e quando enviar um request GET no localhost:8080/numero/iniciar, assim o request for enviado o aplicativo começará a extrair o JSON do banco de dados. 

No banco de dados consiste em várias paginas e em cada página consiste em um array de números envolvendo 100 números decimais dentro deles. Quando o aplicativo terminar de extrair todas as paginas, ele ira juntar todas as paginas em um array e então começara a ordenar eles em ordem crescente.

Após os números estiverem em ordenados, será possível ver os números retornados no postman
