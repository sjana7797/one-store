import app from "./app";

const PORT = process.env.PORT ?? 3001;

console.log(`App running on http://localhost:${PORT}`);

Bun.serve({
  fetch: app.fetch,
  port: PORT,
});
