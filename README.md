Desafio Android
Regras Gerais
● O candidato tem até 3 dias para entregar a implementação do desafio.
● Nenhuma alteração no projeto será permitida após a entrega, caso contrário o candidato será desclassificado.
● O projeto deve ser desenvolvido em Android navito (Kotlin).
● O projeto deve ser disponibilizado em um repositório git (Github, Bitbucket ou Gitlab) público.
● O projeto deve conter as instruções necessárias para realizar a execução do mesmo.
● O candidato pode utilizar bibliotecas open-source de terceiros.




O Desafio
O desafio consiste na implementação de uma aplicação Android que deverá consumir a API pública do Github, que disponibiliza informações sobre os usuários e seus repositórios, onde o aplicativo deverá permitir a listagem de usuários, busca de usuário por nome de usuário e visualização das informações de um usuário específico, bem como a listagem de seus repositórios.
Descrição
A aplicação deverá consumir um serviço para realizar tais operações. Segue a URL da API:
https://api.github.com
● Para listar os usuários, a aplicação deverá consumir o seguinte endereço:
https://api.github.com/users
Este endereço lista apenas alguns usuários. Isto pode servir como uma massa de dados para a tela de listagem dos usuários da aplicação.

● Para obter informações específicas de um usuário, basta acessar o seguinte endereço:
https://api.github.com/users/torvalds
● Para listar os repositórios de um usuário específico, a aplicação deverá acessar o seguinte endereço:
https://api.github.com/users/torvalds/repos
● Para obter mais informações sobre a API:


https://developer.github.com/v3/

Dicas
• É sempre bom avisar ao usuário quando uma operação está em andamento.
• A API pode retornar erros, por isso pense em como apresentar isso ao usuário.
•
Faça testes automatizados


- acesse https://github.com/settings/personal-access-tokens/new
- crie um token para acesso simples e copie o mesmo
- substitua o token no arquivo gradle.properties
- rode o projeto
- 
Thema
Splash
gradleDSL

UI - telas

navigation


presentation [event, upstate, viewmodel]


services
retrofit

use cases
viewmodels

DI

testes http
testes telas

mappers
remote data

domain


Dialog Erro

Material3
Splashscreen
Compose
Retrofit
Koin


