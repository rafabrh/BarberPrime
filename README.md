<div align="center">
  <h1>💈 BarberPrime</h1>
  <p><strong>Sistema Moderno de Agendamento para Barbearias</strong></p>
  <p>Aplicação full-stack rápida, organizada e preparada para escalar.</p>
</div>

<hr/>

<h2>🚀 Tecnologias Utilizadas</h2>

<ul>
  <li><strong>Next.js</strong> (App Router)</li>
  <li><strong>React</strong></li>
  <li><strong>Tailwind CSS</strong></li>
  <li><strong>Shadcn UI</strong></li>
  <li><strong>Prisma ORM</strong></li>
  <li><strong>PostgreSQL</strong></li>
  <li><strong>TypeScript</strong></li>
  <li>Deploy via <strong>Vercel</strong></li>
</ul>

<hr/>

<h2>✂️ Funcionalidades</h2>

<ul>
  <li>Agendamento rápido e responsivo</li>
  <li>Painel para clientes e profissionais</li>
  <li>Horários disponíveis em tempo real</li>
  <li>Gerenciamento de serviços</li>
  <li>Cadastro e autenticação de usuários</li>
  <li>Interface moderna e profissional</li>
  <li>Integração futura com WhatsApp e pagamentos</li>
</ul>

<hr/>

<h2>🗂️ Estrutura do Projeto</h2>

<pre>
/app
  /api
  /components
  /hooks
  /lib
  /services
/prisma
  schema.prisma
/public
/styles
</pre>

<hr/>

<h2>🧩 Como Rodar Localmente</h2>

<ol>
  <li>Instale as dependências:
    <pre>pnpm install</pre>
  </li>
  <li>Configure o arquivo <code>.env</code>:
    <pre>DATABASE_URL="postgres://..."</pre>
  </li>
  <li>Execute as migrations:
    <pre>npx prisma migrate dev</pre>
  </li>
  <li>Inicie o servidor:
    <pre>pnpm dev</pre>
  </li>
</ol>

<p>Acesse em: <strong>http://localhost:3000</strong></p>

<hr/>

<h2>🧱 Banco de Dados</h2>

<p>Estrutura gerenciada pelo Prisma, com as principais entidades:</p>

<ul>
  <li><code>User</code></li>
  <li><code>Service</code></li>
  <li><code>Appointment</code></li>
  <li><code>Professional</code></li>
  <li><code>Barbershop</code></li>
</ul>

<hr/>

<h2>📦 Deploy</h2>

<ul>
  <li>Frontend hospedado na <strong>Vercel</strong></li>
  <li>Banco de dados em <strong>Neon / Supabase / Render</strong></li>
</ul>

<p><strong>Variáveis necessárias:</strong></p>

<pre>
DATABASE_URL=
NEXTAUTH_SECRET=
NEXTAUTH_URL=
</pre>

<hr/>

<h2>🛠️ Scripts Úteis</h2>

<pre>
pnpm dev
pnpm build
pnpm lint
npx prisma studio
</pre>

<hr/>

<h2>🛣️ Roadmap</h2>

<ul>
  <li>[ ] Dashboard completo para profissionais</li>
  <li>[ ] Tema customizável para barbearias</li>
  <li>[ ] Integração com WhatsApp (Twilio / Z-API)</li>
  <li>[ ] Sistemas de pagamento (Pix + Cartão)</li>
  <li>[ ] Multi-tenant (múltiplas unidades)</li>
  <li>[ ] Plano Premium</li>
</ul>

<hr/>

<h2>🤝 Contribuição</h2>

<p>Fluxo Git do projeto:</p>
<pre>
main → produção
dev  → desenvolvimento
</pre>

<ol>
  <li>Crie sua branch:
    <pre>git checkout -b feature/minha-feature</pre>
  </li>
  <li>Commit:
    <pre>git commit -m "feat: minha feature"</pre>
  </li>
  <li>Push:
    <pre>git push origin feature/minha-feature</pre>
  </li>
  <li>Abra um Pull Request</li>
</ol>

<hr/>

<h2>👤 Autor</h2>

<p><strong>Rafael (RaFa)</strong><br/>
Criador e mantenedor do BarberPrime.</p>

<hr/>

<div align="center">
  <p><strong>💈 BarberPrime — agendamento profissional, rápido e elegante.</strong></p>
</div>
