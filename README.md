# FutureSkill Hub API
Maria Julia Araujo Rodrigues
3ESPR – RM 553384
-------------------------------------------------------------
API RESTful desenvolvida em **Spring Boot** com banco de dados **H2**, para gerenciamento de usuários e trilhas de aprendizagem do projeto FutureSkill Hub.

## Tecnologias Utilizadas
- Java 21
- Spring Boot 3
- Spring Data JPA
- H2 Database (em memória)
- Maven

## Estrutura do Projeto
- `Usuario`: representa os usuários cadastrados no sistema.
- `Trilha`: representa as trilhas de aprendizagem disponíveis.
- `UsuarioRepository` e `TrilhaRepository`: interfaces que realizam o acesso ao banco via JPA.
- `UsuarioController` e `TrilhaController`: controladores REST que expõem os endpoints CRUD.

## Endpoints Principais

### Usuários
- **POST** `/api/usuarios` – Cria um novo usuário  
- **GET** `/api/usuarios` – Lista todos os usuários  
- **GET** `/api/usuarios/{id}` – Busca um usuário por ID  
- **PUT** `/api/usuarios/{id}` – Atualiza um usuário existente  
- **DELETE** `/api/usuarios/{id}` – Remove um usuário

### Trilhas
- **POST** `/api/trilhas` – Cria uma nova trilha  
- **GET** `/api/trilhas` – Lista todas as trilhas  
- **GET** `/api/trilhas/{id}` – Busca uma trilha por ID  
- **PUT** `/api/trilhas/{id}` – Atualiza uma trilha existente  
- **DELETE** `/api/trilhas/{id}` – Remove uma trilha

## Banco de Dados
A aplicação utiliza o banco **H2 em memória**, criado automaticamente ao iniciar o projeto.

- **URL:** `http://localhost:8080/h2-console`  
- **Driver:** `org.h2.Driver`  
- **JDBC URL:** `jdbc:h2:mem:futureskillhub`  
- **Usuário:** `sa`  
- **Senha:** *(em branco)*

## Execução do Projeto
1. Clone o repositório:
   ```bash
   git clone https://github.com/majuaraujo/futureskill-hub-api.git
   ```
2. Abra o projeto no IntelliJ IDEA ou VS Code e execute a classe: FutureskillHubApiApplication.java
3. Acesse os endpoints:
   ```bash
   http://localhost:8080/api/usuarios
   http://localhost:8080/api/trilhas
    ```
## Testes de CRUD (via cURL)

# Criar usuário
curl -X POST http://localhost:8080/api/usuarios \
-H "Content-Type: application/json" \
-d "{\"nome\":\"Maria Julia\",\"email\":\"maju@fiap.com\",\"areaAtuacao\":\"Tecnologia e Inovação\",\"nivelCarreira\":\"Em Transição\"}"

# Criar segundo usuário
curl -X POST http://localhost:8080/api/usuarios \
-H "Content-Type: application/json" \
-d "{\"nome\":\"Ana Costa\",\"email\":\"ana.costa@example.com\",\"areaAtuacao\":\"RH\",\"nivelCarreira\":\"Pleno\"}"

# Listar usuários
curl -X GET http://localhost:8080/api/usuarios

# Atualizar usuário (ID 1)
curl -X PUT http://localhost:8080/api/usuarios/1 \
-H "Content-Type: application/json" \
-d "{\"nome\":\"Maria Julia Araujo\",\"email\":\"majuaraujo@fiap.com\",\"areaAtuacao\":\"Gestão de Projetos\",\"nivelCarreira\":\"Analista Júnior\"}"

# Excluir usuário (ID 2)
curl -X DELETE http://localhost:8080/api/usuarios/2

## Status Codes da API
| Código              | Significado                  | Situação         |
| ------------------- | ---------------------------- | ---------------- |
| **200 OK**          | Requisição bem-sucedida      | GET, PUT, DELETE |
| **201 Created**     | Recurso criado com sucesso   | POST             |
| **204 No Content**  | Recurso excluído com sucesso | DELETE           |
| **400 Bad Request** | Erro de validação dos dados  | POST, PUT        |
| **404 Not Found**   | Recurso não encontrado       | GET, PUT, DELETE |
