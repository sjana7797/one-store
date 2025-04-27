import { betterAuth } from "better-auth";
import { drizzleAdapter } from "better-auth/adapters/drizzle";
import { db } from "@one-store/database/db";
import { admin, apiKey, openAPI, organization } from "better-auth/plugins";

export const auth = betterAuth({
  database: drizzleAdapter(db, {
    provider: "pg",
    usePlural: true,
  }),
  plugins: [admin(), apiKey(), organization(), openAPI()],
  emailAndPassword: {
    enabled: true,
  },
});
