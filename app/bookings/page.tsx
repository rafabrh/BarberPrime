import Header from "../_components/header";
import Footer from "../_components/footer";
import BookingItem from "../_components/booking-item";
import {
  PageContainer,
  PageSection,
  PageSectionTitle,
} from "../_components/ui/page";
import { auth } from "@/lib/auth";
import { prisma } from "@/lib/prisma";
import { headers } from "next/headers";
import { Button } from "../_components/ui/button";
import Link from "next/link";
import { Booking, BarbershopService, Barbershop } from "@prisma/client";

const BookingsPage = async () => {
  const session = await auth.api.getSession({
    headers: await headers(),
  });

  if (!session?.user) {
    return (
      <main>
        <Header />
        <PageContainer>
          <PageSection>
            <PageSectionTitle>Agendamentos</PageSectionTitle>
            <p className="text-muted-foreground text-sm">
              Faça login para visualizar seus agendamentos confirmados.
            </p>
            <Button asChild className="rounded-full">
              <Link href="/">Ir para a página inicial</Link>
            </Button>
          </PageSection>
        </PageContainer>
        <Footer />
      </main>
    );
  }

  const bookings = await prisma.booking.findMany({
    where: {
      userId: session.user.id,
    },
    orderBy: {
      date: "desc",
    },
  });

  const bookingsWithDetails = (
    await Promise.all(
      bookings.map(async (booking) => {
        const service = await prisma.barbershopService.findUnique({
          where: {
            id: booking.serviceId,
          },
          include: {
            barbershop: true,
          },
        });

        if (!service) {
          return null;
        }

        return {
          booking,
          service,
        };
      })
    )
  ).filter((item): item is { booking: Booking; service: BarbershopService & { barbershop: Barbershop } } => item !== null);

  return (
    <main>
      <Header />
      <PageContainer>
        <PageSection>
          <PageSectionTitle>Agendamentos</PageSectionTitle>
          {bookingsWithDetails.length > 0 ? (
            <div className="space-y-3">
              {bookingsWithDetails.map(({ booking, service }) => (
                <BookingItem
                  key={booking.id}
                  serviceName={service.name}
                  barbershopName={service.barbershop.name}
                  barbershopImageUrl={service.barbershop.imageUrl}
                  date={booking.date}
                />
              ))}
            </div>
          ) : (
            <p className="text-muted-foreground text-sm">
              Você ainda não possui agendamentos cadastrados.
            </p>
          )}
        </PageSection>
      </PageContainer>
      <Footer />
    </main>
  );
};

export default BookingsPage;
