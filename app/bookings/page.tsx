import Header from "@/app/_components/header";
import Footer from "@/app/_components/footer";
import {
  PageContainer,
  PageSection,
  PageSectionTitle,
} from "@/app/_components/ui/page";
import BookingItem from "@/app/_components/booking-item";

const BookingsPage = () => {
  return (
    <main>
      <Header />
      <PageContainer>
        <PageSection>
          <PageSectionTitle>Seus agendamentos</PageSectionTitle>
          <p className="text-muted-foreground text-sm">
            Acesse com sua conta para visualizar e gerenciar seus próximos
            horários.
          </p>
        </PageSection>
        <PageSection>
          <PageSectionTitle>Como funciona</PageSectionTitle>
          <div className="space-y-2 text-sm text-foreground">
            <p>
              1. Escolha uma barbearia e abra um serviço para iniciar uma
              reserva.
            </p>
            <p>
              2. Confirme a data e horário disponíveis para concluir o
              agendamento.
            </p>
            <p>
              3. Volte a esta página para acompanhar ou cancelar quando
              necessário.
            </p>
          </div>
        </PageSection>
        <PageSection>
          <PageSectionTitle>Exemplo de agendamento</PageSectionTitle>
          <BookingItem
            serviceName="Corte exemplar"
            barbershopName="Barbearia Demo"
            barbershopImageUrl="https://utfs.io/f/c97a2dc9-cf62-468b-a851-bfd2bdde775f-16p.png"
            date={new Date()}
          />
        </PageSection>
      </PageContainer>
      <Footer />
    </main>
  );
};

export default BookingsPage;
