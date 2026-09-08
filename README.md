# Progetto Lab Linguaggi

Nome del linguaggio : *Valyrix* .

Progetto di laboratorio per la materia *Linguaggi* del terzo anno dell'università , il suo scopo è quello di sviluppare un linguaggio di programmazione che soddisfi dei requisiti strutturali e funzionali minimi .

#### Informazioni base :

- Definire ed implementare la grammatica context-free del linguaggio in ANTLR
- Definire la semantica ed implementarla tramite un interprete ( basato sul pattern visitor ANTLR )
- Definire dei programmi che serviranno da esempi e che mostrino i cotrutti e caratteristiche principali 
- Documentazione del linguaggio

---

### Requisiti del Linguaggio

Complessità delle funzionalità extra il linguaggio deve supportare almeno n delle seguenti funzionalità avanzate,
dove n è il numero di partecipanti al progetto. Ogni funzionalità avanzata è assegnata un livello di complessità crescente: Facile << Normale << Difficile.

#### Funzionalità scelte : 

- Strutture Dati  
- Non Determinismo 
- Zucchero Sintattico  
- Flusso di Controllo Condizionato

#### Strutture Dati

Supporto per array di valori a dimensione fissa o variabile. Gli elementi
di un array sono acceduti tramite indice numerico, ad esempio array[2] accede
al terzo elemento dell’array array. In alternativa, supporto per record di valori a
struttura fissa o variabile. Gli attributi di un record sono acceduti tramite notazione
puntata, ad esempio record.campo accede all’attributo campo del record record.

#### Non Determinismo

Supporto per un costrutto di scelta non deterministica, che esegue
un comando tratto da una lista con una probabilit`a proporzionale alla dimensione
della lista. Ad esempio, la valutazione del comando x = 1 @ x = 2 esegue il comando x = 1 con probabilit`a 1/2 (o il comando x = 2 con probabilit`a 1/2), mentre
la valutazione del comando x = 1 @ x = 2 @ x = 3 esegue il comando x = 1 con
probabilit`a 1/3. Supporto per un comando che cattura l’input da tastiera.

#### Zucchero Sintattico  

Gli operatori composti e gli operatori di incremento/decremento unitario sono gestiti direttamente nel visitor: vengono tradotti nella corrispondente operazione semplice più un aggiornamento della memoria.

Come metodo alternativo serve per la scrittura delle espressioni che verranno interpretate come stringhe `${expr}`.
Nel metodo `print` non serve utilizzare questo costrutto poiché viene effettuato il casting a stringa in modo implicito.

#### Flusso di Controllo Condizionato

Supporto per un costrutto iterativo con possibilit`a
di uscita prematura dall’iterazione tramite un apposito comando. Il costrutto prevede
un blocco di codice da eseguire se e solo se la condizione d’iterazione diventa
falsa (quindi il comando di uscita prematura non viene eseguito). Ad esempio,
nel seguente comando for i from 2 to (n-1) { if (n % i == 0) break }{ print "Not prime!"} la stampa a video avviene solo quando n non `e un numero primo.
Viceversa, se n `e un numero primo nulla viene stampato ed il ciclo viene interrotto,
ad un certo punto, dal comando break. In alternativa, supporto per un costrutto
condizionale a scelta multipla (switch), nel quale l’espressione di controllo pu`o assumere uno dei valori tra quelli a scelta. Solo il blocco di codice relativo ad una
delle scelte viene eseguito. Il costrutto pu`o avere o meno una scelta predefinita
(default) da eseguire quando nessuna scelta `e percorribile .

### Struttura file

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
├── test/
    └── java/
        ├── output/
        ├── TestClasses/ tutte le tipologie di test divise per classi
        ├── TestMenu/ tutti i file menu compreso il main che lo gestisce
        └── Test.java

```
