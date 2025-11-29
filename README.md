<div align="center">
  <h1>💈 <strong>BarberPrime</strong></h1>
  <p><strong>Plataforma Premium de Agendamento para Barbearias</strong></p>
  <p>Experiência profissional. Pagamentos integrados. IA embarcada. Login social.</p>
</div>

<hr/>

<h2>✨ Visão Geral</h2>

<p>
  O <strong>BarberPrime</strong> é uma aplicação completa de gerenciamento e agendamento para barbearias,
  construída com arquitetura moderna, UI de alto nível e funcionalidades premium como:
</p>

<ul>
  <li><strong>Chat com IA</strong> integrado para atendimento imediato ao cliente</li>
  <li><strong>Stripe Checkout</strong> para pagamentos online</li>
  <li><strong>Login com conta Google</strong> via OAuth</li>
  <li><strong>Agenda inteligente</strong> com horários disponíveis em tempo real</li>
  <li><strong>Painel de agendamentos</strong> para clientes e profissionais</li>
  <li><strong>Gerenciamento completo de barbearias e serviços</strong></li>
  <li>Frontend com <strong>Next.js App Router</strong> e UI profissional com <strong>Shadcn + Tailwind</strong></li>
  <li>Back-end sólido com <strong>Prisma ORM + PostgreSQL</strong></li>
</ul>

<hr/>

<h2>🚀 Tecnologias</h2>

<ul>
  <li><strong>Next.js 14</strong> (App Router, React Server Components)</li>
  <li><strong>TypeScript</strong></li>
  <li><strong>Tailwind CSS + Shadcn UI</strong></li>
  <li><strong>Prisma ORM</strong></li>
  <li><strong>PostgreSQL</strong> (Neon/Supabase/RenderDB)</li>
  <li><strong>Stripe</strong> (Checkout + Webhooks)</li>
  <li><strong>NextAuth (Auth.js)</strong> com Google OAuth</li>
  <li><strong>Vercel</strong> para deploy</li>
</ul>

<hr/>

<h2>🔥 Funcionalidades Premium</h2>

<h3>💬 Chat com IA integrado</h3>
<p>
  O sistema possui um módulo completo de <strong>chat com IA</strong>, incluindo rota dedicada:
</p>

<pre><code>/app/api/chat/route.ts</code></pre>

<p>
  A IA responde dúvidas, indica serviços, confere horários e auxilia o usuário durante a navegação.
</p>

<h3>💳 Pagamentos Online via Stripe</h3>
<p>
  Checkout seguro e profissional via <strong>Stripe</strong>, incluindo:
</p>

<ul>
  <li>Criação de sessões de pagamento</li>
  <li>Validação de retorno</li>
  <li>Webhooks configurados em <code>/app/api/stripe/webhook</code></li>
</ul>

<h3>🔐 Login com Conta Google</h3>
<p>
  Autenticação via Google OAuth integrada ao sistema em:
</p>

<pre><code>/app/api/auth/[...all]/route.ts</code></pre>

<p>
  Usuário acessa o sistema em segundos sem precisar criar senha.
</p>

<h3>📅 Agenda Inteligente</h3>

<p>
  O BarberPrime possui uma engine avançada de disponibilidade:
</p>

<ul>
  <li>Checagem de horários disponíveis</li>
  <li>Criação de agendamentos</li>
  <li>Cancelamento de agendamentos</li>
  <li>Slots dinâmicos configuráveis por barbearia</li>
</ul>

<p>Principais actions:</p>

<pre><code>
/app/_actions/create-booking.ts
/app/_actions/cancel-booking.ts
/app/_actions/get-date-available-time-slots.ts
/app/_actions/create-booking-checkout-session.ts
</code></pre>

<hr/>

<h2>🧱 Estrutura Real do Projeto</h2>

<p>Baseada nos diretórios listados do seu repositório:</p>

<pre>
app/
  _actions/
  _components/
  _providers/
  api/
    auth/[...all]
    chat/
    stripe/webhook/
  barbershops/
  bookings/
  chat/
  layout.tsx
  page.tsx

prisma/
public/
prompts/
generated/
lib/
node_modules/
.next/

Configuração:
  next.config.ts
  eslint.config.mjs
  postcss.config.mjs
  prisma.config.ts
  tsconfig.json
  vercel.json
  .env / .env.example
</pre>

<hr/>

<h2>🧩 Como Rodar Localmente</h2>

<h3>1. Instalar dependências</h3>
<pre><code>pnpm install</code></pre>

<h3>2. Configurar .env</h3>
<pre><code>
DATABASE_URL="postgres://..."
NEXTAUTH_SECRET="..."
GOOGLE_CLIENT_ID="..."
GOOGLE_CLIENT_SECRET="..."
STRIPE_SECRET_KEY="..."
STRIPE_WEBHOOK_SECRET="..."
</code></pre>

<h3>3. Rodar migrações</h3>
<pre><code>npx prisma migrate dev</code></pre>

<h3>4. Rodar o projeto</h3>
<pre><code>pnpm dev</code></pre>

<p>Acesse: <strong>http://localhost:3000</strong></p>

<hr/>

<h2>🏗️ Banco de Dados</h2>
<p>Modelo escalável e organizado via Prisma:</p>

<ul>
  <li><code>User</code></li>
  <li><code>Service</code></li>
  <li><code>Barbershop</code></li>
  <li><code>Professional</code></li>
  <li><code>Appointment</code></li>
</ul>

<p>
  A pasta <strong>/prisma</strong> contém o schema completo:
</p>

<pre><code>/prisma/schema.prisma</code></pre>

<hr/>

<h2>📦 Deploy</h2>

<h3>Backend + Frontend</h3>
<p>
  Deploy automático pela <strong>Vercel</strong> via push na branch <code>main</code>.
</p>

<h3>Variáveis na Vercel</h3>
<pre><code>
DATABASE_URL=
NEXTAUTH_SECRET=
NEXTAUTH_URL=
GOOGLE_CLIENT_ID=
GOOGLE_CLIENT_SECRET=
STRIPE_SECRET_KEY=
STRIPE_WEBHOOK_SECRET=
</code></pre>

<hr/>

<h2>🛠️ Scripts Úteis</h2>

<pre>
pnpm dev       # ambiente local
pnpm build     # build de produção
pnpm lint      # correções e análise
pnpm format    # prettier
npx prisma studio  # visualizar banco
</pre>

<hr/>

<h2>🛣️ Roadmap</h2>

<ul>
  <li>[ ] App mobile com Expo</li>
  <li>[ ] Painel administrativo avançado</li>
  <li>[ ] Multitenant (várias barbearias independentes)</li>
  <li>[ ] Temas customizáveis</li>
  <li>[ ] Notificações push via Firebase</li>
  <li>[ ] Reagendamento inteligente</li>
  <li>[ ] Automatização via WhatsApp</li>
</ul>

<hr/>

<h2>👤 Autor</h2>

<p>
  <strong>Rafael (RaFa)</strong><br/>
  Engenheiro de Software e criador do BarberPrime.
</p>

<div align="center">
  <p><strong>💈 BarberPrime — A plataforma moderna para barbearias de alto nível.</strong></p>
</div>
