FROM node:21.7.2-slim AS build

WORKDIR /opt/vite

COPY package.json package-lock.json ./
RUN npm ci

COPY . .
RUN npm run build

FROM nginx:1.25.4
COPY --from=build /opt/vite/dist /usr/share/nginx/html

COPY ./nginx/default.conf.template /etc/nginx/templates/

ENV SERVER_URL="https://webapi.developers.erstegroup.com/api/csas/public/sandbox/v2/rates/exchangerates?web-api-key=c52a0682-4806-4903-828f-6cc66508329e"
EXPOSE 80

CMD ["nginx", "-g", "daemon off;"]