# ijuda-api

Projeto de Estágio II - Desenvolvimento de aplicação web em conjunto utilizando metodologia ágil.

| :placard: Vitrine.Dev |     |
| -------------  | --- |
| :sparkles: Nome        | **Ijuda-api**
| :label: Tecnologias | java, springboot, spring security, react, PostgresSql, JPA.
| :rocket: URL (front)   | https://react-ijuda-prod.herokuapp.com/
| 👨🏾‍💻 Back-end Developer | [@adamorhenner](https://www.linkedin.com/in/adamorhenner/) 
| 🖥️ Front-end Developer | [@mateus-cesar](https://www.linkedin.com/in/mateus-cesar/) 


![ijuda](https://user-images.githubusercontent.com/53570263/222828835-240a98dd-3716-46bc-aafb-07fc8fccafff.jpg?text=logo#vitrinedev)

## Detalhes do projeto

O projeto Ijuda-API é uma aplicação backend que foi desenvolvida com o objetivo de oferecer informações em formato JSON para serem consumidas pelo frontend de uma aplicação. A aplicação foi projetada com regras de negócios pensadas e desenvolvidas do zero e tem como principal funcionalidade a persistência de dados no banco de dados PostgreSQL.

Para manter o controle da versão do banco de dados, o Flyway foi utilizado e configurado para realizar as migrações necessárias. A fim de garantir a segurança do projeto, foi implementado o Spring Security, que exige um token de acesso para acessar os endpoints da aplicação.

A proposta do projeto é funcionar como uma plataforma que conecta prestadores de serviços, como pedreiros, pintores e assistências técnicas, com clientes que necessitam de seus serviços. Os prestadores de serviços podem se cadastrar na plataforma e oferecer seus serviços, enquanto os clientes podem buscar por prestadores de serviços de acordo com suas necessidades.
 
 ## Tela de Login
 ![login](https://user-images.githubusercontent.com/53570263/222841955-35d729eb-c6f6-4016-8bd4-df8305a3647f.png)

A tela de login usa OAuth para se autenticar e logar no sistema.

 ## Tela de Cadastro
![cadastro](https://user-images.githubusercontent.com/53570263/222842288-b308eb89-df68-4d97-a567-4ab33c6b5117.png)

A tela de cadastro persiste dados no banco de dados, as informações como senha é salva com criptografia.

## Tela de Busca
![busca](https://user-images.githubusercontent.com/53570263/222842491-d71535c4-5543-4ba6-93f8-79fc097e2a96.png)

A busca é feita atraves de um endpoint que filtra prestadores de serviço de acordo com o filtro de categoria passado.

