import { betterAuth } from "better-auth";
import { prismaAdapter } from "better-auth/adapters/prisma";
import { prisma } from "./prisma";

const authSecret =
  process.env.AUTH_SECRET ?? process.env.BETTER_AUTH_SECRET ?? "";
const authUrl = process.env.AUTH_URL ?? process.env.BETTER_AUTH_URL ?? "";

if (!authSecret) {
  throw new Error("AUTH_SECRET (or BETTER_AUTH_SECRET) must be set.");
}

const googleClientId = process.env.GOOGLE_CLIENT_ID;
const googleClientSecret = process.env.GOOGLE_CLIENT_SECRET;

export const auth = betterAuth({
  secret: authSecret,
  baseURL: authUrl || undefined,
  database: prismaAdapter(prisma, { provider: "postgresql" }),
  socialProviders:
    googleClientId && googleClientSecret
      ? {
          google: {
            clientId: googleClientId,
            clientSecret: googleClientSecret,
          },
        }
      : undefined,
});
