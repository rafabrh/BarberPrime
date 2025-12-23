CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    email TEXT NOT NULL UNIQUE,
    name TEXT,
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE IF NOT EXISTS barbershops (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    address TEXT NOT NULL,
    description TEXT,
    image_url TEXT,
    created_at TIMESTAMPTZ DEFAULT now()
);

CREATE TABLE IF NOT EXISTS barbershop_services (
    id UUID PRIMARY KEY,
    name TEXT NOT NULL,
    description TEXT,
    image_url TEXT,
    price_in_cents INTEGER NOT NULL,
    barbershop_id UUID NOT NULL REFERENCES barbershops(id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS bookings (
    id UUID PRIMARY KEY,
    barbershop_id UUID NOT NULL REFERENCES barbershops(id) ON DELETE CASCADE,
    service_id UUID NOT NULL REFERENCES barbershop_services(id) ON DELETE CASCADE,
    user_id UUID NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    date TIMESTAMPTZ NOT NULL,
    cancelled BOOLEAN DEFAULT FALSE,
    cancelled_at TIMESTAMPTZ,
    stripe_charge_id TEXT,
    created_at TIMESTAMPTZ DEFAULT now(),
    CONSTRAINT uq_booking_slot UNIQUE (barbershop_id, date, cancelled)
);

CREATE INDEX IF NOT EXISTS idx_bookings_user ON bookings(user_id);
