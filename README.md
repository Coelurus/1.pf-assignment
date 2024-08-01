# 1.pf-assignment

## FE - 1. část (deprecated - aplikace od té doby poupravena pro komunikaci s BE - pro spuštění standalone FE nutno stáhnout původní commit s FE)
- FE implementován v Reactu s TypeScriptem
- Ponechán původní design pro vygenerovanou demo Vite aplikaci
- Mně známý (pro mě zatím neřešitelný bug) - při refreshi na detailu měny -> 404
    - Předpokládám, že způsobeno tím, že je FE single-page
- Spuštění:
    ```bash
    git clone https://github.com/Coelurus/1.pf-assignment.git
    cd 1.pf-assignment/frontend
    docker build -t 1pf/fr .
    docker run -p 8080:80 1pf/fr
    ```

## BE
- Implementováno s Java Spring Boot + PostgreSQL databáze

## FE - 2. část
- FE poupraven pro komunikaci s BE
- Pro spuštění celého projektu
    ```bash 
    git clone https://github.com/Coelurus/1.pf-assignment.git
    cd 1.pf-assignment
    docker compose up
    ```
- FE pak běží na adrese a portu http://localhost:80/
- BE na adrese a portu http://localhost:8080/
