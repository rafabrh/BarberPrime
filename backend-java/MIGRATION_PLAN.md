# MIGRATION_PLAN

## Estratégia
- **Strangler Fig**: backend Java evolui em paralelo ao Next.js/Prisma, ativando rotas por módulo.
- Preserve schema Postgres; usar Flyway para versionar mudanças.

## Fases
1. **Base**: projeto Spring Boot, Flyway, Actuator, OpenAPI, pipeline CI (build/test).
2. **Domínio Core**: Barbershop/Service/Booking com validação de conflito e DTOs; endpoints REST compatíveis.
3. **Auth**: JWT + refresh + OAuth2 Google; mapear usuários BetterAuth.
4. **Pagamentos**: Stripe Checkout + Webhook com idempotência (tabela de eventos) e refunds.
5. **Chat/AI**: reimplementar fluxo `/api/chat` com ferramentas (slots/booking) via OpenAI Java SDK.
6. **Observabilidade/Hardening**: logs estruturados, métricas Prometheus, rate limiting básico, CORS.

## Critérios de aceite por fase
- Base: `mvn test` verde; `GET /actuator/health` ok; Swagger publicado.
- Domínio Core: agendamento via API evita double-booking; listagem e slots respondem em <500ms em dev.
- Auth: login Google funcionando; rotas protegidas exigem token; refresh rotation.
- Pagamentos: webhook idempotente; cancelamento gera refund quando houver charge.
- Chat/AI: conversa agenda com as mesmas regras do frontend atual; limites e audit log.
- Observabilidade: dashboards básicos; alertas de erro e latência; checklist de segurança validado.

## Riscos/mitigações
- **Double-booking**: unique constraint + lock pessimista.
- **Webhook duplicado**: idempotency key persistida; assinatura Stripe validada.
- **Timezone**: usar `OffsetDateTime`/`TIMESTAMPTZ` e normalizar para UTC.
- **Compatibilidade de contrato**: documentar no `API_CONTRACT.md` e alinhar com frontend.
- **Custos**: hospedar em Render/Fly/Railway; DB pequeno gerenciado.
