# Microsserviço de Perfis de Triagem (ms-triage-profile)

![Java](https://img.shields.io/badge/Java-17-blue) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-15-blue) ![Docker](https://img.shields.io/badge/Docker-Active-blue) ![Status](https://img.shields.io/badge/status-conclu%C3%ADdo-brightgreen)

## 📝 Descrição

Este projeto é um microsserviço back-end, parte do ecossistema de logística **"Orion Triage System"**. Sua principal responsabilidade é gerenciar os "Perfis de Triagem" de produtos, servindo como uma fonte da verdade para o processo de devolução e reestoque em um e-commerce.

Diferente de um catálogo de produtos genérico, este serviço armazena informações detalhadas e específicas para a triagem, como:
- Checklist de componentes essenciais.
- Pontos críticos de análise para cada produto.
- Instruções de reembalagem.

## 🚀 Tecnologias Utilizadas

- **Java 17:** Versão da linguagem.
- **Spring Boot:** Framework principal para criação da API RESTful.
- **Spring Data JPA & Hibernate:** Camada de persistência e mapeamento objeto-relacional.
- **PostgreSQL:** Banco de dados relacional de produção.
- **Docker & Docker Compose:** Utilizado para conteinerizar e gerenciar o ambiente do banco de dados localmente.
- **Flyway:** Ferramenta para versionamento de schema do banco de dados (Database Migrations).
- **Maven:** Gerenciador de dependências e build do projeto.
- **Lombok:** Biblioteca para reduzir código boilerplate.

## 💿 Como Executar o Projeto

**Pré-requisitos:**
- Java JDK 17 ou superior.
- Maven 3.6 ou superior.
- Docker Desktop instalado e em execução.

```bash
# 1. Clone o repositório
$ git clone https://github.com/DevCarlosMoura/Orion-ms-triage-profile.git

# 2. Navegue até o diretório do projeto
$ cd java-ms-triage-profile

# 3. Inicie o banco de dados PostgreSQL com Docker Compose
# (Este comando irá rodar em background)
$ docker-compose up -d

# 4. Execute a aplicação Spring Boot com o Maven
$ ./mvnw spring-boot:run
```

Após a execução, a API estará disponível em `http://localhost:8080`.

## Endpoints da API

A API expõe operações CRUD completas para os perfis de triagem em `/api/v1/triage-profiles`.

| Método HTTP | Rota                            | Descrição                                 | Exemplo de Body (JSON)                                                                                             |
|-------------|---------------------------------|-------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| `POST`      | `/api/v1/triage-profiles`       | Cadastra um novo perfil de triagem.       | `{ "productSku": "MLB123", "componentChecklist": ["Item A", "Item B"] ... }`                                   |
| `GET`       | `/api/v1/triage-profiles`       | Lista todos os perfis cadastrados.        | N/A                                                                                                                |
| `GET`       | `/api/v1/triage-profiles/{id}`  | Busca um perfil específico pelo seu UUID. | N/A                                                                                                                |
| `PUT`       | `/api/v1/triage-profiles/{id}`  | Atualiza um perfil existente.             | `{ "productSku": "MLB456", "componentChecklist": ["Item C"] ... }`                                                 |
| `DELETE`    | `/api/v1/triage-profiles/{id}`  | Deleta um perfil pelo seu UUID.           | N/A                                                                                                                |

---
_Desenvolvido por [Carlos Moura](https://www.linkedin.com/in/carlos-eduardo-moura-pinheiro-60a1ba169)_