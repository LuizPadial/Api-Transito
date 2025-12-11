### AlgaTransito API

API REST para gerenciamento de veículos e proprietários, construída como parte do estudo do curso Algaworks – Especialista Spring REST.

📌 Sobre o projeto

A AlgaTransito API é uma aplicação desenvolvida com Spring Boot que simula um sistema de controle de veículos, permitindo registrar proprietários, cadastrar veículos, atualizar status e consultar dados.
O objetivo é praticar boas práticas de modelagem, validações, DTOs, mapeamento JPA, migrações Flyway e padrões REST.
🚦 AlgaTransito API

### 🧱 Funcionalidades principais

- Cadastro e consulta de proprietários
- Cadastro e gerenciamento de veículos
- Alteração de status do veículo (REGULAR, IRREGULAR)
- Validação automática dos dados (email, telefone, placa etc.)
- Persistência usando Spring Data JPA
- Migração de banco usando Flyway
- Tratamento centralizado de erros e exceções
- Conversão entre entidades → DTOs → responses

🗃️ Modelo de dados (exemplo)
Proprietário
```
{
  "id": 1,
  "nome": "João da Silva",
  "email": "joaodasilva@exemplo.com",
  "telefone": "11998888-0000"
}
```
Veículo
```
{
  "id": 1,
  "proprietario": {
    "id": 1,
    "nome": "João da Silva",
    "email": "joaodasilva2@algaworks.com",
    "telefone": "1198888-0000"
  },
  "marca": "Honda",
  "modelo": "HR-V",
  "placa": "KRM9988",
  "status": "REGULAR",
  "dataCadastro": "2023-05-18T15:00:00",
  "dataApreensao": null
}
```
### 🛠️ Tecnologias utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Web**
- **Spring Data JPA**
- **Hibernate**
- **Flyway**
- **MySQL**
- **Lombok**
- **ModelMapper / MapStruct** (se usar)
- **Jakarta Bean Validation** (Validation)

