# 🚀 Cadastro de Usuários - Spring Boot

Este projeto é uma **API RESTful** construída com **Spring Boot**, que gerencia o cadastro de usuários. A aplicação oferece funcionalidades para **criar**, **listar**, **atualizar** e **excluir** usuários. É uma boa base para compreender a construção de endpoints REST utilizando Spring Boot e como integrá-los com os serviços e controladores.

---

## 🌟 Funcionalidades

A API oferece as seguintes funcionalidades:

- **Criar um novo usuário**: Cria um novo usuário com base nas informações enviadas.
- **Listar todos os usuários**: Retorna uma lista de todos os usuários cadastrados.
- **Atualizar um usuário existente**: Atualiza as informações de um usuário baseado no ID fornecido.
- **Excluir um usuário**: Exclui um usuário baseado no ID fornecido.

---

## 🛠 Endpoints

### 1. **Criar um novo usuário**

- **Método**: `POST`
- **URL**: `/api/usuarios/novo`
- **Descrição**: Cria um novo usuário a partir das informações fornecidas no corpo da requisição.

#### Corpo da Requisição (JSON):

```json
{
    "nome": "Nome do Usuário",
    "email": "usuario@exemplo.com",
    "senha": "senha123"
}
```

#### Resposta:
- **Código 201**: Usuário criado com sucesso.

Exemplo de resposta:

```json
{
    "id": 1,
    "nome": "Nome do Usuário",
    "email": "usuario@exemplo.com",
    "senha": "senha123"
}
```

---

### 2. **Listar todos os usuários**

- **Método**: `GET`
- **URL**: `/api/usuarios/`
- **Descrição**: Retorna todos os usuários cadastrados.

#### Resposta:
- **Código 200**: Lista de usuários cadastrados.

Exemplo de resposta:

```json
[
    {
        "id": 1,
        "nome": "Nome do Usuário",
        "email": "usuario@exemplo.com",
        "senha": "senha123"
    },
    {
        "id": 2,
        "nome": "Outro Usuário",
        "email": "outro@exemplo.com",
        "senha": "senha456"
    }
]
```

---

### 3. **Atualizar informações de um usuário**

- **Método**: `PUT`
- **URL**: `/api/usuarios/{id}`
- **Descrição**: Atualiza as informações de um usuário com base no ID fornecido.

#### Corpo da Requisição (JSON):

```json
{
    "nome": "Novo Nome",
    "email": "novoemail@exemplo.com",
    "senha": "novasenha123"
}
```

#### Resposta:
- **Código 200**: Usuário atualizado com sucesso.
- **Código 404**: Usuário não encontrado para o ID fornecido.

---

### 4. **Excluir um usuário**

- **Método**: `DELETE`
- **URL**: `/api/usuarios/{id}`
- **Descrição**: Exclui um usuário com base no ID fornecido.

#### Resposta:
- **Código 204**: Usuário excluído com sucesso.
- **Código 404**: Usuário não encontrado para o ID fornecido.

---

## ⚙ Tecnologias Utilizadas

- **Spring Boot**: Framework principal para a criação de APIs REST.
- **Spring Web**: Para criar os controladores REST.
- **JPA/Hibernate**: Para a interação com o banco de dados.
- **Jakarta Validation**: Para validação das entradas no corpo das requisições.
- **H2 Database**: Banco de dados em memória para testes e desenvolvimento rápido.

---

## 💻 Como Rodar o Projeto

### Requisitos

- Java 11 ou superior
- Maven para gerenciamento de dependências

### Passos

1. Clone o repositório:

```bash
git clone https://github.com/DevBF1907/Project-CadUsuarios.git
cd Project-CadUsuarios
```

2. Compile e execute o projeto com Maven:

```bash
mvn spring-boot:run
```

3. Acesse a API no navegador ou utilizando uma ferramenta como Postman:

- **URL Base**: `http://localhost:8080/api/usuarios`

---

## 📑 Exemplos de Uso

### Criar um novo usuário

- **Método**: `POST`
- **URL**: `/api/usuarios/novo`

#### Exemplo de corpo da requisição:

```json
{
    "nome": "John Doe",
    "email": "john.doe@example.com",
    "senha": "john1234"
}
```

### Listar todos os usuários

- **Método**: `GET`
- **URL**: `/api/usuarios/`

#### Resposta:

```json
[
    {
        "id": 1,
        "nome": "John Doe",
        "email": "john.doe@example.com",
        "senha": "john1234"
    }
]
```

### Atualizar um usuário

- **Método**: `PUT`
- **URL**: `/api/usuarios/{id}`

#### Exemplo de corpo da requisição:

```json
{
    "nome": "John Updated",
    "email": "john.updated@example.com",
    "senha": "newpassword123"
}
```

### Excluir um usuário

- **Método**: `DELETE`
- **URL**: `/api/usuarios/{id}`

