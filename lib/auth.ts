import { betterAuth } from "better-auth";
import { prismaAdapter } from "better-auth/adapters/prisma";
import { prisma } from "./prisma";

const authSecret =
  process.env.AUTH_SECRET ?? process.env.BETTER_AUTH_SECRET ?? undefined;
const authBaseURL =
  process.env.AUTH_URL ?? process.env.BETTER_AUTH_URL ?? undefined;
const googleClientId = process.env.GOOGLE_CLIENT_ID;
const googleClientSecret = process.env.GOOGLE_CLIENT_SECRET;

export const auth = betterAuth({
  ...(authSecret ? { secret: authSecret } : {}),
  ...(authBaseURL ? { baseURL: authBaseURL } : {}),
  database: prismaAdapter(prisma, { provider: "postgresql" }),
  ...(googleClientId && googleClientSecret
    ? {
        socialProviders: {
          google: {
            clientId: googleClientId,
            clientSecret: googleClientSecret,
          },
        },
      }
    : {}),
});
