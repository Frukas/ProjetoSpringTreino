# ProjetoSpringTreino


This is a Spring Boot REST API for managing beneficiaries and their documents.

## Endpoints
| Path	                        | Method	| Description |
| :---------------------------- | :-------- |:-------- |
| `/Benificiario`               | GET	    | Get all beneficiaries |
| `/Benificiario`               | POST	    | Add a new beneficiary |
| `/Benificiario/Documento/{id}`|GET	    | Get documents of a specific beneficiary by their ID |
| `/Benificiario`	            | PUT	    | Update a beneficiary and their associated documents |
| `/Benificiario`	            | DELETE	| Delete a beneficiary |

## Usage
### Get all beneficiaries
```http
GET /Benificiario
```

Example response:
```json
JSON
[
  {
    "id": 1,
    "nome": "John Doe",
    "cpf": "12345678900",
    "dataNascimento": "1970-01-01",
    "documentos": [
      {
        "id": 1,
        "tipoDocumento": "RG",
        "numeroDocumento": "1234567890"
      }
    ]
  }
]
```

### Add a new beneficiary
```http
POST /Benificiario
```
Request body:
```json
JSON
{
  "nome": "Jane Doe",
  "cpf": "09876543210",
  "dataNascimento": "1980-02-02",
  "documentos": [
    {
      "tipoDocumento": "Passaporte",
      "numeroDocumento": "ABC123456"
    }
  ]
}
```

Response:

HTTP 200 OK

### Get documents of a specific beneficiary
```http
GET /Benificiario/Documento/{id}
```
Path parameters:

id: The ID of the beneficiary
Response:
```json
JSON
[
  {
    "id": 1,
    "tipoDocumento": "RG",
    "numeroDocumento": "1234567890"
  }
]
```

### Update a beneficiary and their documents
```http
PUT /Benificiario
```
Request body:
```json
JSON
{
  "id": 1,
  "nome": "John Doe (updated)",
  "cpf": "12345678900",
  "dataNascimento": "1970-01-01",
  "documentos": [
    {
      "id": 1,
      "tipoDocumento": "RG",
      "numeroDocumento": "1234567890",
      "nomeDocumento": "New name"
    },
    {
      "id": 2,
      "tipoDocumento": "Passaporte",
      "numeroDocumento": "DEF543210"
    }
  ]
}
```

Response:

HTTP 200 OK

### Delete a beneficiary
```http
DELETE /Benificiario
```
Request body:
```json
JSON
{
  "id": 1
}
```

Response:

HTTP 200 OK
Error codes:

400 Bad Request: Invalid or missing data in the request body.
404 Not Found: The requested resource could not be found.
500 Internal Server Error: An unexpected error occurred.