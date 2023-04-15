<h1 align="center"> API de gerenciamento de pessoas </h1>

<p align="center">🚀 Esta API permite gerenciar informações de pessoas, incluindo nome, data de nascimento e endereços.</p>
<p align="center"> Teste Técnico Desenvolvedor Back-end Attornatus</p>


### ✔️ Técnicas e tecnologias utilizadas

- ``Java 17``
- ``InteliJ IDEA``
- ``H2 Database``
- ``Lombok``
- ``Maven``

## Como executar a aplicação

### 1. Clone este repositório
```bash
$ git clone <https://github.com/aeciog/api-gerenciamento-pessoas.git>
```

### 2. Acesse o diretório do projeto:
```bash
$ cd api-gerenciamento-pessoas
```

### 3. Compile o projeto:
```bash
$ mvn clean install
```

### 4. Rode o projeto:
```bash
$ mvn spring-boot:run
```

### 5. Acesse a API:
```bash
http://localhost:8080
```
# Funcionalidades do projeto

- `Funcionalidade 1`: Criar uma pessoa
- `Funcionalidade 2`: Editar Pessoa
- `Funcionalidade 3`: Consultar uma pessoa
- `Funcionalidade 4`: Listar pessoas
- `Funcionalidade 5`: Criar endereço para pessoa
- `Funcionalidade 6`: Listar endereços da pessoa
- `Funcionalidade 7`: Poder informar qual endereço é o principal da pessoa



## Endpoints

| Método | Endpoint                                | Descrição                                   |
|--------|-----------------------------------------|---------------------------------------------|
| POST   | api/pessoas                             | Cria uma pessoa                             |
| PUT    | api/pessoas/{id}                        | Edita uma pessoa                            |
| GET    | api/pessoas/{id}                        | Consulta uma pessoa                         |
| GET    | api/pessoas                             | Lista todas as pessoas                      |
| POST   | api/pessoas/{id}/enderecos              | Cria um endereço para a pessoa              |
| GET    | api/pessoas/{id}/enderecos              | Lista todos os endereços da pessoa          |
| PATCH  | api/pessoas/{id}/enderecos/{idEndereco} | Define um endereço como principal da pessoa |

#### Cadastrar uma pessoa
- POST /api/pessoas
```bash
{
    "nome": "Usuario 1",
    "dataNascimento": "2023-01-01",
    "enderecos": [
        {
            "logradouro": "Rua A",
            "cep": "12345-678",
            "numero": "100",
            "cidade": "São Luís"
        }
    ]
}
```

### Editar Pessoa
- PUT api/pessoas/{id}
```bash

{
    "nome": "Aecio Barros",
    "dataNascimento": "1995-11-06",
    "enderecoPrincipal": {
        "logradouro": "Rua 2",
        "cep": "12345-678",
        "numero": 20,
        "cidade": "São Luis"
    }
}
```

### Consultar pessoa
- GET api/pessoas/{id}

### Listar pessoas
- GET api/pessoas


### Criar endereço para pessoa
- POST api/pessoas/{id}/enderecos
```bash

{
    "logradouro": "Rua 3",
    "cep": "12345-678",
    "numero": 30,
    "cidade": "São Paulo"
}
```
### Listar endereços da pessoa
- GET api/pessoas/{id}/enderecos

### Informar qual endereço é o principal da pessoa
- PUT api/pessoas/{idPessoa}/enderecos/{idEndereco}/principal



# Autor
```Aécio Guterres``
