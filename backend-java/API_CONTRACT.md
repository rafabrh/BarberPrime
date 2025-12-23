# API_CONTRACT

## Barbershops
### GET /api/barbershops
- **Resposta 200**
```json
[
  {
    "id": "uuid",
    "name": "Barbearia Central",
    "address": "Rua A, 123",
    "description": "Espaço premium",
    "imageUrl": "https://...",
    "services": [
      {
        "id": "uuid",
        "name": "Corte",
        "description": "Corte masculino",
        "imageUrl": "https://...",
        "priceInCents": 5000
      }
    ]
  }
]
```

## Bookings
### POST /api/bookings
- **Body**
```json
{
  "barbershopId": "uuid",
  "serviceId": "uuid",
  "userId": "uuid",
  "date": "2025-01-01T13:00:00Z"
}
```
- **Resposta 200**
```json
{
  "id": "uuid",
  "barbershopId": "uuid",
  "serviceId": "uuid",
  "userId": "uuid",
  "date": "2025-01-01T13:00:00Z",
  "cancelled": false,
  "cancelledAt": null,
  "stripeChargeId": null
}
```
- **Erros**
  - `409 CONFLICT` se slot já estiver reservado.
  - `404 NOT_FOUND` para IDs inexistentes.

### GET /api/bookings/barbershop/{id}?start=ISO&end=ISO
- Lista agendamentos no intervalo informado (uso para cálculo de slots).

## Próximas rotas (a implementar)
- `/api/auth/**` para JWT/OAuth.
- `/api/stripe/checkout` e `/api/stripe/webhook`.
- `/api/chat` replicando fluxo Shark.
