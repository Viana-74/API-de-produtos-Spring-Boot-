# API-de-produtos-Spring-Boot-
Este repositório é um **projeto de estudo** desenvolvido a partir do conteúdo da disciplina **Back-end Frameworks** (UNG).

## O que foi melhorado em relação ao conteúdo da aula

A aula original construiu uma API com apenas duas operações (cadastrar e listar produtos). Neste projeto, o CRUD foi expandido e completado, adicionando:

- Consulta de produtos por nome
- Atualização (PUT) de um produto existente
- Exclusão (DELETE) de um produto
- Campo adicional `descricao` no model `Produto`

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA (Hibernate como ORM)
- MySQL (via XAMPP)
- Postman Local (para testes manuais das requisições)

## Pré-requisitos para rodar o projeto

1. **XAMPP** instalado e em execução (módulos **Apache** e **MySQL** ligados).
2. Criar, via phpMyAdmin (`http://localhost/phpmyadmin`), um banco de dados chamado **`xammp`**.
   - Não é necessário criar as tabelas manualmente: o Hibernate cria e atualiza a estrutura automaticamente (`spring.jpa.hibernate.ddl-auto=update`).
3. Ajustar, se necessário, o arquivo `application.properties` com as credenciais do seu MySQL local:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/xammp
spring.datasource.username=root
spring.datasource.password=
```

4. Executar a aplicação (`Aula4Application.java` → Run As → Spring Boot App).
5. A API ficará disponível em `http://localhost:8080/produtos`.


## Testando com o Postman

Este projeto **não possui front-end**: toda a validação do back-end é feita simulando requisições HTTP via **Postman**. Abaixo estão os endpoints disponíveis:

| Operação | Verbo | URL | Body (JSON) |
|---|---|---|---|
| Listar todos | GET | `/produtos` | — |
| Buscar por nome | GET | `/produtos/buscar?nome=exemplo` | — |
| Cadastrar | POST | `/produtos` | `{"nome": "pizza", "preco": 25.00, "descricao": "pizza grande"}` |
| Atualizar | PUT | `/produtos/{id}` | `{"nome": "pizza", "preco": 30.00, "descricao": "pizza grande"}` |
| Excluir | DELETE | `/produtos/{id}` | — |

> **Observação:** no PUT, é necessário enviar todos os campos editáveis (`nome`, `preco`, `descricao`), pois a implementação atual sobrescreve o registro por completo (comportamento semântico do PUT no padrão REST).


## Estrutura do projeto

```
src/main/java/br/com/xammp
├── controller   → recebe as requisições HTTP e devolve as respostas
├── service      → implementa as regras de negócio
├── model        → representa os dados da aplicação (entidade Produto)
└── repository   → realiza o acesso aos dados persistidos (JPA)
```

README GERADO PELO CLAUDE.IA
E REVISADO POR VIANA-74
