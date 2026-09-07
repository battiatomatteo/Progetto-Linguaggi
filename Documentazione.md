Valyrix

*Valyrix* è un linguaggio di programmazione general-purpose che utilizza una sintassi simile a java ma non presenta la possibilita' di instanziare classi.

## Indice

1. [Introduzione](#1-introduzione)
2. [Guida Rapida](#2-guida-rapida)
3. [Sintassi](#3-sintassi)
4. [Semantica](#4-semantica)
5. [Implementazione](#5-implementazione)
6. [Programmi di Test](#6-programmi-di-test)

## 1. Introduzione

*Valyrix* è un linguaggio di programmazione imperativo tipizzato general-purpose ma non presenta la possibilità di instanziare classi.
### Caratteristiche principali

- **Tipizzazione statica** con i tipi di dato più comuni (int,dec,bool,string,char)
- **Due sezioni distinte**: una sezione per dichiarare le variabili, ed una sezione per il codice eseguibile.
- **Espressioni aritmetico-logiche** complete con precedenza degli operatori.
- **Costrutti iterativi e condizionali**: `while`, `for`, `if`-`else`.
- **Arrays** come strutture dati statiche monodimensionali .
- **Zucchero sintattico**: assegnamenti composti (`+=`, `-=`, `*=`, `/=`), incremento e decremento unitario (`++`, `--`), operatore ternario (`_ ? _ : _`), e interpolazione di espressioni nelle stringhe (`${expr}`).
- **Gestione degli errori**: divisione per zero, accesso fuori dai limiti di un array, variabile non dichiarata, errori di tipo (tutti gestiti con messaggi esplicativi).
- **Operatore Non Deterministico** presenza di un operatore che esegue una istruzione casuale tra un insieme di comandi
- **Casting esplicito** casting esplicito, permette conversione tra tutti i tipi di dato semplici e tra tutti i tipi di dato array 
- **Flusso di Controllo Condizionato** Supporto per un costrutto iterativo con possibilita' di uscita prematura dall’iterazione tramite un apposito comando. Compatibile con solo con il ciclo for.
### Contesto applicativo

Valyrix punta ad essere un linguaggio semplice con una sintassi simile a C e Java.

---

## 2. Guida Rapida

### Requisiti

- **Java 11** o superiore, necessario per ANTLR
- **ANTLR 4** (versione 4.11 o superiore) 

### Installazione programma

```powershell
mvn clean install
mvn clean compile
```

`mvn clean compile` pulisce i file generati in precedenza e compila il progetto. `mvn clean install`, oltre a pulire e compilare, esegue i test, crea il pacchetto del progetto e lo installa nel repository locale di Maven.

### Eseguire un programma

```bash
mvn exec:java "-Dexec.mainClass=progetto.Main" "-Dexec.args=.\programs\helloWorld.vlrx"
```

Questo esegue l'interprete del linguaggio sul programma `helloWorld.vlrx` contenuto nella cartella `programs`.

> Per effettuare eventuali test :

```bash
mvn test-compile
mvn test-compile exec:java "-Dexec.mainClass=Test" "-Dexec.classpathScope=test"
```

### Hello World

Un programma per iniziare con Valyrix .
```valiryx
string name;
input name;
print "Ciao " :: name 
```
>**Input**
   Mario

**Output** <br>
> Ciao Mario

Un esempio di programma in Valiryx che effettua semplici operazioni aritmiche
```valiryx
int num = 5;
int i;
int end = 10;
print "tabellina del 5";
for i from 0 to end{
	print num :: " X " :: ${i + 1} :: " = " :: ${(i + 1) * num}
}
```
> **Output**                 <br>
	tabellina del 5
	5 X 1 = 5
	5 X 2 = 10
	5 X 3 = 15
	5 X 4 = 20
	5 X 5 = 25
	5 X 6 = 30
	5 X 7 = 35
	5 X 8 = 40
	5 X 9 = 45
	5 X 10 = 50

## 3. Sintassi

### 3.1 Struttura di un programma

Un programma Valyrix è composto da due sezioni:

```valiryx
main : decl com EOF
```

- **`decl`**: sezione opzionale dichiarativa per dichiarare e inizializzare le variabili che verranno usate nel programma.
- **`com`**: sezione eseguibile. Contiene il corpo del programma rappresentato come serie di comandi terminati da ";" , l'ultima istruzione di ogni blocco (anche nei blocchi annidati come nell'esempio precedente) non necessita del terminatore.

### 3.2 Tipi di dato

| Tipo     | Descrizione              | Esempio di valore |
| -------- | ------------------------ | ----------------- |
| `Int`    | Intero con segno         | `42`, `-3`        |
| `dec`    | Numero in virgola mobile | `3.14`, `-0.5`    |
| `Bool`   | Valore booleano          | `true`, `false`   |
| `String` | Stringa di testo         | `"ciao"`          |
| `char`   | Carattere ascii          | 'a' , 'b'         |

### 3.3 Dichiarazione di variabili

```valiryx
int x = 8;
dec z;    // la variabile deve essere valorizzata prima dell'utilizzo
string s = "prova";
int[] array = [1, 2, 3];
```

 Nella fase di dichiarazione l'inizializzazione è opzionale, ma deve essere effettuata nel codice prima dell'utilizzo della variabile, in caso contrario avviene un errore di mancata inizializzazione. Le variabili sono globali e posso essere dichiarate solo all'inizio del programma, non esiste di conseguenza  shadowing delle variabili nel codice.

### 3.4 Assegnamenti

```valiryx
int x = 30;
int y = 5;
x += 5;    // equivalente a x = x + 5
x -= 2;    // equivalente a x = x - 2
x *= 3;    // equivalente a x = x * 3
x /= 4;    // equivalente a x = x / 4
++x;       // pre-incremento, incremento unitario prima della valutazione
x++;       // post-incremento, incremento unitario dopo la valutazione
--x;       // pre-decremento, decremento unitario prima della valutazione
x--;       // post-decremento, decremento unitario dopo la valutazione
y = x++ - 5; // y = 30 - 5 --> y = 25, x = 31 poiche' l'incremento viene effettuato dopo aver terminato l'istruzione
y = x++ - 5; // y = 32 - 5 --> y = 27, x = 32 poiche' in questo caso l'incremento viene effettuato subito 
```

Gli operatori di pre e post incremento / decremento possono essere usati sia da soli che all'interno delle espressioni. 
### 3.5 Espressioni

Le espressioni supportano la **precedenza standard** degli operatori (dal più basso al più alto):

| Livello | Operatori                                          |
| ------- | -------------------------------------------------- |
| 1       | `_ ? _ : _` (ternario)                             |
| 2       | `\|\|`, `&&` (or, and logici)                      |
| 3       | `==`, `!=`, `<`, `>`, `<=`, `>=` (comparatori)     |
| 4       | `+`, `-` (somma, sottrazione)                      |
| 5       | `*`, `/`, `%` (moltiplicazione, divisione, modulo) |
| 6       | `!` (negazione logica)                             |
| 7       | Accesso array `arr[i]`                             |

**Operatore ternario:**
```
int numero = 5;
String msg = (numero % 2 == 0) ? "pari" : "dispari"
```
La variabile `msg` viene assegnata con la stringa *"pari"* se la variabile numero è divisibile per 2 con resto 0, altrimenti viene assegnato con la stringa *"dispari"* .

### 3.6 Costrutti di controllo

**Condizionale:**
```valiryx
if (numero < 0) {
    print "Numero negativo"
} else {
    print "Numero positivo"
}
```

**Ciclo while:**
```valiryx
Int i = 0;
while (i < 5) {
    print "numero " :: ${i};
    i++
}
```

**Ciclo for:**
```valiryx
for i from 1 to 10 {
    print "numero " :: ${i};
    if(i == 5){
    break
    }
}
```
Il ciclo `for i from a to b` itera `i` da `a` incluso a `b` escluso `a` e `b` possono essere solo numeri interi.
I cicli while e for possono terminare anticipatamente con l'utilizzo dell'istruzione "break".

### 3.7 Stampa e interpolazione nelle stringhe

```valiryx
print "Testo semplice";
print i"Risultato: ${x + y} unità";
print i"Il doppio di ${n} è ${n * 2}";
```

Le stringhe interpolate sono comprese tra "${" e "}", e contengono espressioni di qualsiasi tipo e possono essere concatenate con le stringhe semplici 

### 3.8 Array

```valiryx
int[] a = [1, 2, 3];
int n = 2;
print a;  
a[1] = 5 * n;  
print a
```

### 3.9 Uscita dal programma

```valiryx
exit;   // termina immediatamente l'esecuzione del programma
```

### 3.10 Commenti

```valiryx
// Commento su una riga
/* Commento
   su più righe */
```

### 3.11 Regole lessicali principali

- Gli identificatori iniziano con una lettera , seguiti da lettere, cifre.
- Le keyword sono case-sensitive e riservate (ad esempio, `if`, `while`, `for`, `true`, `false`, i nomi dei tipi).
- I blocchi sono delimitati da `{` e `}`.
- Ogni statement termina con `;` tranne l'ultimo di ogni blocco.
- Gli spazi bianchi e le tabulazioni sono ignorati.

## 4. Semantica

### 4.1 Tipizzazione

 Valyrix adotta **tipizzazione statica**: ogni variabile deve essere dichiarata con un tipo esplicito, e il tipo non cambia durante l'esecuzione. Le verifiche di tipo avvengono prima di eseguire un programma tramite un **type system**, il quale riporta errori segnalati con messaggi descrittivi. Gli errori gestiti staticamente includono:

| Errore                      | Messaggio                                                                                    |
| --------------------------- | -------------------------------------------------------------------------------------------- |
| Variabile non dichiarata    | *Variable a assigned but never declared. @1:0*                                               |
| Tipo incompatibile          | Type mismatch: numeric expression expected. @3:10                                            |
| Assegnamento di tipo errato | *assigned value [1,2] of type ArrayType.INT is not compatible with type SimpleType.INT @1:0* |

| Warning         | Messaggio                                   |
| --------------- | ------------------------------------------- |
| Casting critico | Warning: unsafe cast from char to int @20:4 |
questo warning appare quando si fanno dei casting tra valori solitamente non compatibili es: char --> int, bool --> char, int --> bool
### 4.2 Visibilità e scoping

Le variabili in Valyrix sono definite solo all'inizio del programma

### 4.3 Valutazione delle espressioni

Le espressioni sono valutate in modo standard: tutti gli operandi vengono valutati prima dell'applicazione dell'operatore. Gli operatori logici `&&` e `||` **non** adottano la semantica short-circuit.

### 4.4 Gerarchia dei tipi

```
Bool
String
Char
Dec
Int
```

Il linguaggio nella versione attuale prevede **conversioni esplicite** utilizzando la sintassi del tipo: (TIPO) VAR

### 4.5 Gestione degli errori a runtime

Gli errori a tempo d'esecuzione vengono intercettati dall'interprete e riportati con messaggi esplicativi, **senza terminare** bruscamente il programma. Gli errori gestiti includono:

| Errore                        | Messaggio                                                      |
| ----------------------------- | -------------------------------------------------------------- |
| Divisione per zero            | *"Division by zero"*                                           |
| Indice array fuori limite     | *"Index out of bounds 7 array size 2"*                         |
| Esponente negativo con base 0 | *"Exponential base cannot be zero with exponent lower than 0"* |

### 4.6 Semantica operazionale

....

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

...

...

### 5.1 Struttura del progetto

```
documentazione.md
documentazione.pdf
pom.xml
src/
├── main
│   ├──  java/ 
│   │   ├── config/
│   │   │   └── config.json - ProgramConfig.java
│   │   └── progetto/
│   │       ├── exception/ tutti i file exception
│   │       ├── type/ tutti i file con le tipologie
│   │       ├── utils/ tutti i file che contengono metodi ed altro che vengono usati nel progetto
│   │       ├── value/ tutti i file value
│   │       ├── Interprete.java
│   │       ├── Main.java
│   │       ├── Mem.java
│   │       └── TypedImoTS.java
│   ├──  antlr4/ 
│   │   └── progetto/Linguaggio.g4
│   └──   resources /           
│
└── test/
    └── java/
        ├── output/
        ├── TestClasses/ tutte le tipologie di test divise per classi
        ├── TestMenu/ tutti i file menu compreso il main che lo gestisce
        └── Test.java
```

### 5.2 L'interprete

L'interprete è implementato come un **visitor** generato da ANTLR4 (`CookLangVisitor`) in Python. La classe principale `CookLangInterpreter` estende `CookLangVisitor` e sovrascrive il metodo `visit*` per ogni produzione della grammatica.

Il metodo `visitProgram` inizializza la memoria globale con gli ingredienti e poi avvia la visita della sezione `procedureSection`. Lo stato è mantenuto attraverso una pila di memorie (`Environment`), uno per ogni blocco annidato.

### 5.3 Gestione dello scope

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
