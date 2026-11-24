
# Valyrix

Valyrix è un linguaggio di programmazione imperativo e tipizzato, sviluppato in Java come progetto universitario per il corso di Linguaggi.

Il progetto comprende la definizione della grammatica tramite ANTLR4 e la realizzazione di un interprete in grado di analizzare ed eseguire programmi scritti nel linguaggio.

## Caratteristiche principali

- **Grammatica context-free:** definita con ANTLR4.
- **Interprete:** realizzato in Java utilizzando il Visitor Pattern.
- **Tipizzazione statica:** controlli sui tipi prima dell'esecuzione.
- **Strutture dati:** array monodimensionali.
- **Controllo del flusso:** condizioni, cicli `for` e `while`, `break` e `switch`.
- **Non determinismo:** esecuzione casuale di un comando tra più alternative.
- **Zucchero sintattico:** operatori composti, incremento/decremento, operatore ternario e interpolazione di stringhe.
- **Casting:** conversione esplicita tra tipi supportati.
- **Gestione degli errori:** controlli semantici ed errori a runtime con messaggi dedicati.

## Tecnologie utilizzate

- Java 24
- Maven
- ANTLR 4.13.2
- Jackson Databind
- Apache Commons Text

## Struttura del progetto

```text
Progetto-Linguaggi/
├── programs/                  # Programmi di esempio Valyrix
├── src/
│   ├── main/
│   │   ├── antlr4/            # Grammatica ANTLR
│   │   ├── java/              # Interprete e sistema di tipi
│   │   └── resources/
│   └── test/
│       └── java/              # Test e menu interattivo
├── Documentazione.md
├── Documentazione.pdf
├── pom.xml
└── README.md
```

## Requisiti

- JDK 24
- Apache Maven

## Installazione e compilazione

Clonare il repository:

```bash
git clone <URL_DEL_REPOSITORY>
cd Progetto-Linguaggi
```

Compilare e creare il pacchetto:

```bash
mvn clean package
```

## Esecuzione

Per eseguire un programma Valyrix utilizzando l'interprete:

```bash
java -jar target/Progetto_linguaggi-1.0-SNAPSHOT-jar-with-dependencies.jar programs/helloWorld.vlrx
```

È possibile sostituire `helloWorld.vlrx` con un altro programma presente nella cartella `programs/`.

## Documentazione

Per approfondire il linguaggio, la sua sintassi, la semantica e i dettagli dell'implementazione:

- [Documentazione completa (Markdown)](Documentazione.md)
- [Documentazione completa (PDF)](Documentazione.pdf)
