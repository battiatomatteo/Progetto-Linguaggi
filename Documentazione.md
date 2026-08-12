# Valyrix



## Indice

1. [Introduzione](#1-introduzione)
2. [Guida Rapida](#2-guida-rapida)
3. [Sintassi](#3-sintassi)
4. [Semantica](#4-semantica)
5. [Implementazione](#5-implementazione)
6. [Programmi di Test](#6-programmi-di-test)

## 1. Introduzione

**Valyrix è un linguaggio di programmazione .

### Caratteristiche principali

- **Tipizzazione statica** con tipi di dominio dedicati alla cucina (`Gram`, `Ml`, `Temp`).
- **Due sezioni distinte**: una sezione per dichiarare gli ingredienti, ed una sezione per il codice eseguibile.
- **Espressioni aritmetico-logiche** complete con precedenza degli operatori.
- **Costrutti iterativi e condizionali**: `while`, `for`, `if`-`else`.
- **Arrays** come struttura dati di base.
- **Zucchero sintattico**: assegnamenti composti (`+=`, `-=`, `*=`, `/=`), incremento e decremento unitatio (`++`, `--`), operatore ternario (`_ ? _ : _`), e interpolazione di espressioni nelle stringhe (`i"...${expr}..."`).
- **Gestione degli errori**: divisione per zero, accesso fuori dai limiti di un array, variabile non dichiarata, errori di tipo (tutti gestiti con messaggi esplicativi).


### Contesto applicativo

CookLang nasce dall'idea di offrire agli appassionati di cucina (e a sviluppatori di applicazioni gastronomiche) un linguaggio espressivo e leggibile per codificare ricette in modo eseguibile. Un programma CookLang non è solo documentazione: è un programma che può calcolare quantità ridimensionate, simulare fasi di cottura, e stampare istruzioni personalizzate.

---

## 2. Guida Rapida

### Requisiti

- **Java 11** o superiore, necessario per ANTLR
- **ANTLR 4** (versione 4.11 o superiore) 
- **Python 3** (versione 3.9 o superiore), necessario per eseguire l'interprete
  - Runtime ANTLR per Python, installabile tramite: `pip install antlr4-python3-runtime`

### Generare il parser

```bash
# dalla directory radice del progetto:
antlr4 -Dlanguage=Python3 -visitor -no-listener CookLang.g4 -o source
```

Questo genera i file `CookLangLexer.py`, `CookLangParser.py`, e `CookLangVisitor.py` nella cartella `source`.

### Eseguire un programma

```bash
python3 source/main.py programs/hello.cook
```

Questo eseguire l'interprete del linguaggio sul programma `hello.cook` contenuto nella cartella `programs`.

### Hello World

Un semplice programma in CookLang.
```
procedure: {
    String nome = "Pasta al Pomodoro";
    print i"Benvenuto in CookLang! Ricetta: ${nome}";
}
```
> **Output** <br>
> Benvenuto in CookLang! Ricetta: Pasta al Pomodoro

Un esempio di programma in CookLang che utilizza tipi di dominio.
```
ingredients:
    Gram farina = 500;
    Ml acqua = 300;
    Temp forno = 180;

procedure: {
    Int porzioni = 4;
    Gram farinaPerPorzione = farina / porzioni;
    print i"Farina per porzione: ${farinaPerPorzione}g";
    print i"Temperatura forno: ${forno}°C";
}
```
> **Output**                 <br>
> Farina per porzione: 125g  <br>
> Temperatura forno: 180°C

## 3. Sintassi

### 3.1 Struttura di un programma

Un programma CookLang è composto da due sezioni:

```
program : ingredientSection? procedureSection
```

- **`ingredientSection`**: sezione opzionale dichiarativa per gli ingredienti. Le variabili qui dichiarate sono visibili nell'intera sezione `procedureSection`.
- **`procedureSection`**: sezione eseguibile. Contiene il corpo del programma racchiuso in un blocco `{ ... }`.

### 3.2 Tipi di dato

| Tipo     | Descrizione                                  | Esempio di valore |
|----------|----------------------------------------------|-------------------|
| `Int`    | Intero con segno                             | `42`, `-3`        |
| `Float`  | Numero in virgola mobile                     | `3.14`, `-0.5`    |
| `Bool`   | Valore booleano                              | `true`, `false`   |
| `String` | Stringa di testo                             | `"ciao"`          |
| `Gram`   | Peso in grammi (sottotipo di `Int`)          | `250`             |
| `Ml`     | Volume in millilitri (sottotipo di `Int`)    | `100`             |
| `Temp`   | Temperatura in °C (sottotipo di `Float`)     | `180.0`, `24.5`   |
| `T[]`    | Array di elementi di tipo `T`                | `[1, 2, 3]`       |

I tipi `Gram` e `Ml` sono tipi di dominio che estendono `Int`, mentre `Temp` è un tipo di dominio che estende `Float`. I tipi `Gram` e `Ml` sono compatibili nelle espressioni aritmetiche con `Int` e tra loro (con conversione implicita a `Int`). Il tipo `Temp` è compatibile nelle espressioni aritmetiche con `Float` (con conversione implicita a `Float`).

### 3.3 Dichiarazione di variabili

```
Int x = 10;
Float y;          // inizializzata al valore di default 0.0
String s = "ok";
Int[] arr = [1, 2, 3];
```

Le variabili dichiarate nella sezione `ingredientSection` sono visibili nell'intero programma. Le variabili dichiarate all'interno di un blocco `{ ... }` sono visibili solo all'interno di quel blocco (**scoping lessicale con shadowing**).

### 3.4 Assegnamenti

```
x = 42;
x += 5;    // equivalente a x = x + 5
x -= 2;    // equivalente a x = x - 2
x *= 3;    // equivalente a x = x * 3
x /= 4;    // equivalente a x = x / 4
++x;       // pre-incremento, incremento unitario prima della valutazione
x++;       // post-incremento, incremento unitario dopo la valutazione
--x;       // pre-decremento, decremento unitario prima della valutazione
x--;       // post-decremento, decremento unitario dopo la valutazione
```

Come statement isolati, pre/post incremento/decremento hanno lo stesso effetto di un assegnamento. La distinzione è rilevante solo quando usati come sotto-espressioni.

### 3.5 Espressioni

Le espressioni supportano la **precedenza standard** degli operatori (dal più basso al più alto):

| Livello | Operatori                                           |
|---------|-----------------------------------------------------|
| 1       | `_ ? _ : _` (ternario)                              |
| 2       | `\|\|`, `&&` (or, and logici)                       |
| 3       | `==`, `!=`, `<`, `>`, `<=`, `>=` (comparatori)      |
| 4       | `+`, `-` (somma, sottrazione)                       |
| 5       | `*`, `/`, `%` (moltiplicazione, divisione, modulo)  |
| 6       | `!` (negazione logica), `-` (negazione numerica)    |
| 7       | Accesso array `arr[i]`                              |

**Operatore ternario:**
```
String msg = (porzioni > 1) ? "porzioni" : "porzione";
```
La variabile `msg` viene assegnata con la stringa *"porzioni"* se la variabile `porzioni` è maggiore di 1. VIene assegnato con la stringa *"porzione"* altrimenti.

### 3.6 Costrutti di controllo

**Condizionale:**
```
if (temperatura > 200) {
    print "Alta temperatura!";
} else {
    print "Temperatura normale.";
}
```

**Ciclo while:**
```
Int i = 0;
while (i < 5) {
    print i"Passo ${i}";
    i++;
}
```

**Ciclo for:**
```
for i from 1 to 10 {
    print i"Ingrediente numero ${i}";
}
```
Il ciclo `for i from a to b` itera `i` da `a` a `b` inclusi, `a` e `b` possono essere solo numeri interi non negativi.

### 3.7 Stampa e interpolazione nelle stringhe

```
print "Testo semplice";
print i"Risultato: ${x + y} unità";
print i"Il doppio di ${n} è ${n * 2}";
```

Le stringhe interpolate iniziano con `i"` e terminano con `"`. Le espressioni sono racchiuse in `${...}`.

### 3.8 Array

```
Int[] ingredienti = [10, 20, 30];
Int primo = ingredienti[0];
ingredienti[1] = 99;

Int[] vuoto = new Int[5];   // array di 5 interi inizializzati a 0
```

### 3.9 Uscita dal programma

```
exit;   // termina immediatamente l'esecuzione del programma
```

### 3.10 Commenti

```cooklang
// Commento su una riga
/* Commento
   su più righe */
```

### 3.11 Regole lessicali principali

- Gli identificatori iniziano con una lettera o `_`, seguiti da lettere, cifre, o `_`.
- Le keyword sono case-sensitive e riservate (ad esempio, `if`, `while`, `for`, `true`, `false`, i nomi dei tipi).
- I blocchi sono delimitati da `{` e `}`.
- Ogni statement termina con `;`.
- Gli spazi bianchi e le tabulazioni sono ignorati.

## 4. Semantica

### 4.1 Tipizzazione

CookLang adotta **tipizzazione statica**: ogni variabile deve essere dichiarata con un tipo esplicito, e il tipo non cambia durante l'esecuzione. Le verifiche di tipo avvengono prima di eseguire un programma tramite un **type system**, il quale riporta errori segnalati con messaggi descrittivi. Gli errori gestiti staticamente includono:

| Errore                        | Messaggio                                                  |
|-------------------------------|------------------------------------------------------------|
| Variabile non dichiarata      | *"Errore di tipo: variabile 'x' usata ma non dichiarata"*  |
| Tipo incompatibile            | *"Errore di tipo: operazione non valida tra Int e Bool"*   |
| Assegnamento di tipo errato   | *"Errore di tipo: atteso Gram, trovato String"*            |

### 4.2 Visibilità e scoping

CookLang adotta lo **scoping lessicale** con **shadowing**. Ogni blocco `{ ... }` introduce un nuovo ambiente. Una variabile dichiarata in un blocco interno può avere lo stesso nome di una variabile esterna (la variabile interna la nasconde all'interno del blocco). All'uscita dal blocco, la variabile esterna ritorna visibile.

Gli ingredienti dichiarati nella sezione `ingredientSection` risiedono nella memoria globale del programma e sono visibili da qualsiasi punto del programma.

### 4.3 Valutazione delle espressioni

Le espressioni sono valutate in modo standard: tutti gli operandi vengono valutati prima dell'applicazione dell'operatore. Gli operatori logici `&&` e `||` **non** adottano la semantica short-circuit.

### 4.4 Gerarchia dei tipi

```
Bool
String
Float
├── Int
|   ├── Gram
|   └── Ml
└── Temp
```
I tipi di dominio `Gram` e `Ml` sono sottotipo di `Int`: un valore di tipo `Gram` può essere usato dove è atteso un `Int`. A sua volta, `Int` è sottotipo di `Float`. Il tipo di dominio `Temp` è sottotipo di `Float`, ma non di `Int`. Le conversioni numeriche seguono le catene:

$$
    \text{Gram} \subsetneq \text{Int} \subsetneq \text{Float} \\
    \text{Ml} \subsetneq \text{Int} \subsetneq \text{Float} \\
    \text{Temp} \subsetneq \text{Float}
$$

Sono previste le seguenti **conversioni implicite**, applicate *solo in espressioni miste*:
- `Int` → `Float` 
- `Gram` / `Ml` → `Int`
- `Temp` → `Float`

Il linguaggio nella versione attuale non prevede **conversioni esplicite**. Si può forzare una conversione tramite espressioni aritmetiche negli assegnamenti (ad esempio, `Float x = intVal + 0.0`).

### 4.5 Gestione degli errori a runtime

Gli errori a tempo d'esecuzione vengono intercettati dall'interprete e riportati con messaggi esplicativi, **senza terminare** bruscamente il programma. Gli errori gestiti includono:

| Errore                        | Messaggio                                                  |
|-------------------------------|------------------------------------------------------------|
| Divisione per zero            | *"Errore a runtime: divisione per zero"*                   |
| Indice array fuori limite     | *"Errore a runtime: indice 7 fuori dai limiti (size=5)"*   |

### 4.6 Semantica operazionale

Di seguito alcune regole di transizione della semantica operazionale di CookLang. Lo stato è una coppia $(\overline{\sigma}, c)$ dove $\overline{\sigma} = \sigma_1 \cdot \sigma_2 \cdot \ldots \cdot \sigma_n$ è una pila di memorie (una memoria $\sigma$ è una mappa da identificatori a valori) e $c$ è il comando (o l'espressione) da valutare. La pila, con ultimo elemento inserito a sinistra, è necessaria per gestire lo scoping delle variabili all'interno di blocchi di codice.

**Blocco**

$$
    \text{Block} ~ \frac{
        -
    }{
        (\overline{\sigma},\ \{ c \}) \rightarrow (\sigma \cdot \overline{\sigma},\ \mathtt{block}(c))
    }
    ~ \sigma = \varnothing
    \quad \quad
    \text{BlockP} ~ \frac{
        (\overline{\sigma},\ c) \rightarrow (\overline{\sigma}',\ c')
    }{
        (\overline{\sigma},\ \mathtt{block}(c)) \rightarrow (\overline{\sigma}',\ \mathtt{block}(c'))
    }
    \quad \quad
    \text{BlockE} ~ \frac{
        -
    }{
        (\sigma \cdot \overline{\sigma},\ \mathtt{block}(\epsilon)) \rightarrow (\overline{\sigma}',\ \epsilon)
    }
$$

dove $\sigma = \varnothing$ indica che la memoria $\sigma$ è vuota, mentre $\sigma \cdot \overline{\sigma}$ indica una pila con ultimo elemento inserito $\sigma$ e continuazione $\overline{\sigma}$.

**Ciclo while**

$$
    \text{While} ~ \frac{
        -
    }{
        (\overline{\sigma},\ \mathtt{while} \, (e) \, \{ c \}) \rightarrow (\overline{\sigma},\ \mathtt{if} \, (e) \, \{ c \,;\, \mathtt{while} \, (e) \, \{ c \} \})
    }
    \quad\quad
$$

**Sequenza**

$$
    \text{SeqP} ~ \frac{
        (\overline{\sigma},\ c_1) \rightarrow (\overline{\sigma}',\ c_1')
    }{
        (\overline{\sigma},\ c_1 \,;\, c_2) \rightarrow (\overline{\sigma}',\ c_1' \,;\, c_2)
    }
    \quad\quad
    \text{SeqE} ~ \frac{
        -
    }{
        (\overline{\sigma},\ \epsilon \,;\, c) \rightarrow (\overline{\sigma},\ c)
    }
$$



## 5. Implementazione

### 5.1 Struttura del progetto

```
CookLang/
├── CookLang.g4          # Grammatica ANTLR4
├── source/
│   ├── main.py          # Entry point
│   ├── interpreter.py   # Visitor principale (interprete)
|   ├── ts.py            # Visitor secondario (type system)
│   ├── memory.py        # Gestione delle memorie/scope
│   ├── types.py         # Gerarchia dei tipi e controllo
│   └── errors.py        # Classi di errore custom
├── programs/            # Programmi d'esempio
│   ├── hello.cook
│   ├── pasta.cook
│   ├── biscotti.cook
│   ├── fibonacci.cook
│   └── errori.cook
└── doc.md               # Documentazione
```

### 5.2 L'interprete

L'interprete è implementato come un **visitor** generato da ANTLR4 (`CookLangVisitor`) in Python. La classe principale `CookLangInterpreter` estende `CookLangVisitor` e sovrascrive il metodo `visit*` per ogni produzione della grammatica.

Il metodo `visitProgram` inizializza la memoria globale con gli ingredienti e poi avvia la visita della sezione `procedureSection`. Lo stato è mantenuto attraverso una pila di memorie (`Environment`), uno per ogni blocco annidato.

### 5.3 Gestione dello scope

La classe `Environment` implementa una pila di memorie. Ogni inserimento (*push*) crea un nuovo frame locale, mentre ogni estrazione (*pop*) lo rimuove. La ricerca di una variabile avviene risalendo la pila. Le scritture avvengono nel frame più in alto che dichiara la variabile (o nel frame corrente per le nuove dichiarazioni).

### 5.4 Zucchero sintattico

Gli operatori composti e gli operatori di incremento/decremento unitario sono gestiti direttamente nel visitor: vengono tradotti nella corrispondente operazione semplice più un aggiornamento della memoria.

L'interpolazione delle stringhe (`i"...${expr}..."`) è gestita con una sezione lessicale separata nel lexer ANTLR. L'interprete per questo sotto-linguaggio costruisce la stringa finale valutando ogni parte testuale e ogni espressione embedded, convertendo il risultato a stringa, e concatenando tutte le componenti.

### 5.5 Difficoltà tecniche

- **Interpolazione nelle stringhe**: la gestione dei token nel lexer di ANTLR ha richiesto attenzione per evitare conflitti tra i simboli `{` e `}` (usati sia per delimitare blocchi di codice, sia per delimitare espressioni nelle stringhe). La soluzione adottata è stata quella di utilizzare i medesimi token in entrambi i casi, affidandosi alla priorità delle sezioni lessicali per disambiguare.

- **Tipizzazione statica**: poiché ANTLR non permette di specificare delle regole ti tipaggio, il controllo dei tipi avviene durante una prima visita con un interprete specifico  (type system), mentre l'esecuzione del programma avviene durante una seconda visita (interprete).

- **Scoping con shadowing**: la propagazione delle modifiche alle variabili esterne (ma non la creazione di nuove variabili locali nell'ambiente esterno) ha richiesto una logica di ricerca nella pila delle memorie distinta dalla logica di dichiarazione.

## 6. Programmi di Test

### `hello.cook` – Hello world

```
procedure: {
    String nome = "Pasta al Pomodoro";
    print i"Benvenuto in CookLang! Ricetta: ${nome}";
}
```
> **Output atteso** <br>
> Benvenuto in CookLang! Ricetta: Pasta al Pomodoro

### `pasta.cook` – Cottura con ciclo e operatore ternario

```
// Simulazione cottura pasta con controllo temperatura
ingredients:
    Temp temperaturaAcqua = 20;
    Int  minutiCottura    = 0;
    Int  tempoRichiesto   = 10;

procedure: {
    // Portare l'acqua a ebollizione
    print "Riscaldamento acqua...";
    while (temperaturaAcqua < 100) {
        temperaturaAcqua += 10;
    }
    print i"Acqua in ebollizione: ${temperaturaAcqua}°C";

    // Cuocere la pasta
    print "Cottura pasta in corso...";
    for minutiCottura from 1 to tempoRichiesto {
        String stato = (minutiCottura < tempoRichiesto) ? "in cottura" : "pronta!";
        print i"Minuto ${minutiCottura}: pasta ${stato}";
    }

    print "Buon appetito!";
}
```
> **Output atteso**             <br>
> Riscaldamento acqua...        <br>
> Acqua in ebollizione: 100°C   <br>
> Cottura pasta in corso...     <br>
> Minuto 1: pasta in cottura    <br>
> Minuto 2: pasta in cottura    <br>
> ...                           <br>
> Minuto 10: pasta pronta!      <br>
> Buon appetito!

### `biscotti.cook` – Ridimensionamento ricetta con operatori composti

```
// Ricetta biscotti al burro – ridimensionamento automatico
ingredients:
    Gram farina   = 300;
    Gram burro    = 150;
    Gram zucchero = 120;
    Int  uova     = 2;
    Int  porzioni = 12;

procedure: {
    Int nuovePorzioni = 24;
    Float fattore = nuovePorzioni / porzioni;

    farina   *= fattore;
    burro    *= fattore;
    zucchero *= fattore;
    uova     *= fattore;

    print i"-- Ricetta per ${nuovePorzioni} biscotti";
    print i"Farina:   ${farina}g";
    print i"Burro:    ${burro}g";
    print i"Zucchero: ${zucchero}g";
    print i"Uova:     ${uova}";
}
```
> **Output atteso**           <br>
> -- Ricetta per 24 biscotti  <br>
> Farina:   600g              <br>
> Burro:    300g              <br>
> Zucchero: 240g              <br>
> Uova:     4

### `fibonacci.cook` – Algoritmo con array e scoping

```
// Calcolo dei primi N numeri di Fibonacci con array
procedure: {
    Int N = 10;

    Int[] fib = new Int[N];
    fib[0] = 0;
    fib[1] = 1;

    Int i = 2;
    while (i < N) {
        fib[i] = fib[i - 1] + fib[i - 2];
        i++;
    }

    print i"Primi ${N} numeri di Fibonacci:";
    for j from 0 to N - 1 {
        print i"fib[${j}] = ${fib[j]}";
    }

    // Scoping: questa variabile locale non è visibile fuori dal blocco
    {
        Int somma = 0;
        for k from 0 to N - 1 {
            somma += fib[k];
        }
        print i"Somma: ${somma}";
    }
    // Qui 'somma' non è più accessibile
}
```
> **Output atteso**              <br>
> Primi 10 numeri di Fibonacci:  <br>
> fib[0] = 0                     <br>
> fib[1] = 1                     <br>
> fib[2] = 1                     <br>
> fib[3] = 2                     <br>
> fib[4] = 3                     <br>
> fib[5] = 5                     <br>
> fib[6] = 8                     <br>
> fib[7] = 13                    <br>
> fib[8] = 21                    <br>
> fib[9] = 34                    <br>
> Somma: 88

### `errori.cook` – Gestione errori a runtime

```
// Test della gestione degli errori
procedure: {
    Int x = 10;
    Int y = 0;

    // Test divisione per zero
    // L'interprete segnala l'errore e continua
    Int z = x / y;      // Errore runtime: divisione per zero

    /*
    Variabile non dichiarata
    Il type system segnala l'errore ed il programma non esegue
    print w;            // Errore di tipo: variabile 'w' usata ma non dichiarata
    */
    
    // Test accesso illegale array
    // L'interprete segnala l'errore e continua
    Int[] arr = [1, 2, 3];
    print arr[0];   
    print arr[5];       // Errore runtime: indice 5 fuori dai limiti (size=3)

    // Uscita anticipata
    print "Fine programma";
    exit;
    print "Questa riga non viene stampata";
}
```
> **Output atteso**                                                <br>
> Errore runtime: divisione per zero alla riga 8                   <br>
> 1                                                                <br>
> Errore runtime: indice 5 fuori dai limiti (size=3) alla riga 20  <br>
> Fine programma
