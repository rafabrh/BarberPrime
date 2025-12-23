# DOMAIN_MAP

## Entidades principais
- **User**: `id (UUID)`, `email`, `name`, `created_at`.
- **Barbershop**: `id`, `name`, `address`, `description`, `image_url`, `created_at`, `services`.
- **BarbershopService**: `id`, `name`, `description`, `image_url`, `price_in_cents`, `barbershop_id`.
- **Booking**: `id`, `barbershop_id`, `service_id`, `user_id`, `date (timestamptz)`, `cancelled`, `cancelled_at`, `stripe_charge_id`, `created_at`.

## Regras de negócio
- Agendamento só é permitido para slots futuros (`@Future`).
- Prevenção de double-booking: lock pessimista + `UNIQUE(barbershop_id, date, cancelled=false)`.
- Cancelamento marca `cancelled=true` e preserva histórico.
- Serviços pertencem a uma barbearia; exclusão em cascata preservada via FK.

## Futuras extensões
- **Payments**: persistência de CheckoutSession/PaymentIntent com idempotência.
- **Auth**: tokens JWT/OAuth2 associados a `User` existente.
- **Chat/AI**: comandos para buscar barbearias, slots e criar bookings com as mesmas validações.
