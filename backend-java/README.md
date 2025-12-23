# BarberPrime Backend (Spring Boot 3)

Backend Java 21 / Spring Boot 3 para o BarberPrime, mantendo o domínio de barbearias, serviços e agendamentos.

## Como rodar local
1. Configure variáveis de ambiente (opcional, valores padrão em `application.yml`):
   - `DATABASE_URL=jdbc:postgresql://localhost:5432/barberprime`
   - `DATABASE_USER=barberprime`
   - `DATABASE_PASSWORD=barberprime`
2. Suba o Postgres (ver `docker-compose.yml`).
3. Execute migrations automaticamente no start via Flyway.
4. Rode a aplicação:
   ```bash
   mvn spring-boot:run
   ```
5. Acesse o Swagger em `http://localhost:8080/swagger-ui.html`.

## Endpoints principais
- `GET /api/barbershops`: lista barbearias e serviços.
- `POST /api/bookings`: cria agendamento (valida conflito).
- `GET /api/bookings/barbershop/{id}?start=...&end=...`: lista agendamentos por intervalo.
- `GET /actuator/health`: healthcheck.

## Stripe e OAuth
Esta versão inicial mantém apenas estrutura; integração Stripe/OAuth será adicionada nas próximas fases. Configure as chaves via variáveis de ambiente quando implementadas.

## Migrations
- Flyway executa arquivos em `src/main/resources/db/migration`.
- Para aplicar manualmente: `mvn -Dflyway.user=$DATABASE_USER -Dflyway.password=$DATABASE_PASSWORD -Dflyway.url=$DATABASE_URL flyway:migrate`.

## Estrutura
- `domain`: entidades JPA
- `repository`: repositórios Spring Data JPA
- `service`: regras de negócio (ex.: prevenção de double-booking)
- `web`: controllers, DTOs, mappers e tratadores de erro

## Próximos passos
- Adicionar módulos de Auth (JWT + Google OAuth) e Stripe (checkout + webhook com idempotência).
- Recriar endpoints de chat/AI seguindo a lógica do projeto Next.js.
- Expandir testes de integração com Testcontainers.
