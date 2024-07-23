# Biblioteca Inteligente

## Descrição

A **Biblioteca Inteligente** é uma aplicação web que permite gerenciar uma coleção de livros. Com ela, você pode adicionar novos livros, visualizar um catálogo de livros existentes e gerenciar suas leituras. O sistema também oferece funcionalidades de busca para encontrar livros por título, autor ou categoria.

## Funcionalidades

- **Catálogo de Livros**: Visualize todos os livros cadastrados.
- **Adicionar Livro**: Adicione novos livros ao catálogo com informações como título, autor, preço e categoria.
- **Buscar Livros**: Realize buscas por título, autor ou categoria.
- **Login**: Acesse sua conta para gerenciar a coleção de livros.

## Tecnologias Usadas

- **Frontend**: HTML, CSS
- **Backend**: Java, Spring Boot
- **Banco de Dados**: [H2 Database](https://www.h2database.com/html/main.html) (ou qualquer outro banco de dados relacional)
- **ORM**: Hibernate / JPA
- **Dependências**: Spring Data JPA, Thymeleaf


Estrutura do Projeto
src/main/java: Contém o código-fonte Java do projeto.
domain: Contém as classes de entidades (por exemplo, Livro, Categoria).
dao: Contém as interfaces de acesso a dados e suas implementações.
service: Contém a lógica de negócios e os serviços.
controller: Contém os controladores REST e MVC.
src/main/resources: Contém arquivos de configuração e templates.
application.properties: Configurações da aplicação.
templates: Contém arquivos Thymeleaf para a interface do usuário.
static: Contém arquivos estáticos como CSS e JavaScript.
