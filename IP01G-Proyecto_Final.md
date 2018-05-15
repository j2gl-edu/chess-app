# IP01G Proyecto Final

### Introducción a la Programación

## Objetivo

Evaluar los conocimientos adquiridos durante todo el curso de Introducción a la Programación.

## Fecha de entrega 

**17 de mayo 2018**


## Descripción

Crear el juego de Ajedrez con las siguientes caracteristicas:

1. Numero de Jugadores: 2 (Piezas Blancas y Negras)
2. Desplegar la posicion de todas las piezas en modo texto.
3. El tablero de ajedrez es de 8x8 cuadros.
    * Las filas son numeradas del 1 al 8 
    * Las columnas de la A a la H.
    * La posicion A1 es color negro, A2 blanco, A3 Negro, ...
    * La posicion B1 es color blanco.
4. Crear el posicionamiento inicial

## Listado de Piezas

|   | Nombre | Nombre  | Cantidad|
|:-:|--------|---------|--------:|
| K | King   | Rey     | 1       |
| Q | Queen  | Dama    | 1       |
| R | Rook   | Torre   | 2       |
| B | Bishop | Alfil   | 2       |
| N | Knight | Caballo | 2       |
| P | Pawn   | Peoón   | 8       |

### Despliegue del Tablero

El tablero se debe de desplegar al inicio y despues de cada jugada.  A continuacion se presenta una sugerencia para mostrarlo en la pantalla.

```
  +----+----+----+----+----+----+----+----+
8 | bR | bN | bB | bQ | bK | bB | bN | bR |
  +----+----+----+----+----+----+----+----+
7 | bP | bP | bP | bP | bP | bP | bP | bP |
  +----+----+----+----+----+----+----+----+
6 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
5 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
4 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
3 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 | wP | wP | wP | wP | wP | wP | wP | wP |
  +----+----+----+----+----+----+----+----+
1 | wR | wN | wB | wQ | wK | wB | wN | wR |
  +----+----+----+----+----+----+----+----+
     A    B    C    D    E    F    G    H
```

Internamente se debe de guardar en una matriz de 8x8.  

```
  +----+----+----+----+----+----+----+----+
7 | bR | bN | bB | bQ | bK | bB | bN | bR |
  +----+----+----+----+----+----+----+----+
6 | bP | bP | bP | bP | bP | bP | bP | bP |
  +----+----+----+----+----+----+----+----+
5 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
4 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
3 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
1 | wP | wP | wP | wP | wP | wP | wP | wP |
  +----+----+----+----+----+----+----+----+
0 | wR | wN | wB | wQ | wK | wB | wN | wR |
  +----+----+----+----+----+----+----+----+
     0    1    2    3    4    5    6    7
```

Ejemplo de transformaciones:
* A1 en el tablero es la posicion en la matriz: [0][0]
* A2 en el tablero es la posicion en la matriz: [0][1]
* E2 en el tablero es la posicion en la matriz: [4][1]


#### Leyenda
* Primera letra
  * b - Black: Piezas Negras
  * w - White: Piezas Blancas
* Segunda Letra
  * K - Rey
  * Q - Queen
  * R - Rook
  * B - Bishop
  * N - Knight
  * P - Pawn

## Modo de Juego

* El juego estara adentro de un ciclo.
  * Al principio del ciclo se debe de desplegar el tablero.
  * Se debe de solicitar el movimiento de las piezas blancas utilizando la coordenada de origen y la coordenada de destino.
  * Luego se despliega de nuevo el tablero con el movimiento realizado.
  * Después se solicita el movimiento de las piezas negras.
  * Este proceso se repetira alternando el turno de los jugadores.
* El ciclo debe de terminar cuando la partida tenga un ganador.
* Todos los movimientos que se realizan deben de ser válidos, de lo contrario se debe de mostrar el error y volver a solicitar el movimiento.

### Ejemplo de Juego

El formato de entrada es la coordenada de origen y la coordenada de destino separados por coma.  Siempre va primero la columna y luego la fila en cada coordenanda.

#### Jugada 1 

`E2,E4` - El Peón blanco que está en la casilla **E2** se moverá a la casilla **E4**.

```
  +----+----+----+----+----+----+----+----+
8 | bR | bN | bB | bQ | bK | bB | bN | bR |
  +----+----+----+----+----+----+----+----+
7 | bP | bP | bP | bP | bP | bP | bP | bP |
  +----+----+----+----+----+----+----+----+
6 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
5 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
4 |    |    |    |    | wP |    |    |    |
  +----+----+----+----+----+----+----+----+
3 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 | wP | wP | wP | wP |    | wP | wP | wP |
  +----+----+----+----+----+----+----+----+
1 | wR | wN | wB | wQ | wK | wB | wN | wR |
  +----+----+----+----+----+----+----+----+
     A    B    C    D    E    F    G    H
```

#### Jugada 2  

`E8,C6` - El caballo negro se mueve de la casilla **E8** a la casilla **C6**.

```
  +----+----+----+----+----+----+----+----+
8 | bR |    | bB | bQ | bK | bB | bN | bR |
  +----+----+----+----+----+----+----+----+
7 | bP | bP | bP | bP | bP | bP | bP | bP |
  +----+----+----+----+----+----+----+----+
6 |    |    | bN |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
5 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
4 |    |    |    |    | wP |    |    |    |
  +----+----+----+----+----+----+----+----+
3 |    |    |    |    |    |    |    |    |
  +----+----+----+----+----+----+----+----+
2 | wP | wP | wP | wP |    | wP | wP | wP |
  +----+----+----+----+----+----+----+----+ 
1 | wR | wN | wB | wQ | wK | wB | wN | wR |
  +----+----+----+----+----+----+----+----+
     A    B    C    D    E    F    G    H
```

## Lineamientos Generales

* El proyecto debe utilizar todas las sentencias vistas en clase.
* Debe ser en modo consola
* Pueden investigar nuevas funcionalidads 
* Indicar explicitamente las entradas y salidas que debe tener el programa.
* Proyecto Individual
* Debe subirse al moodle

Fecha de entrega: **17 de mayo 2018**

## Entregables
1.	Código fuente con su documentación interna
2.	Programa ejecutable .class
3.	Manual de Usuario, indicando como debe usarse la aplicación.
4.	Documento de diseño de la aplicación(entrada, proceso, salida)

El documento con el diseño de la aplicación debe contener:
* Carátula
* Introducción
* Objetivos
* Análisis del proyecto:
    * Entradas
    * Procesos
    * Salidas
    * Validaciones
* Diseño del proyecto:
    * Diagrama de flujo
* Conclusiones
* Bibliografía consultada (incluir sitios o foros consultados).

## Criterios de Evaluación
* Aplicar los conocimientos vistos en clase
* Validación de errores de usuario
* Recuperación de la aplicación ante los errores de usuario
* Funcionalidad de la aplicación: debe cumplir con todos los aspectos mencionados en el enunciado.
* Evidencia de la creación del programa y dominio de los conceptos utilizados. Se podrá demandar una calificación presencial por parte del profesor.
* Creatividad

| | |
|-|-:|
|Documentación|  10 |
|Análisis     |  10 |
|Diseño       |  20 |
|Codificación |  60 |
|Total        | 100 |

Valoración Neta: 10 puntos (a ser tomada de las prácticas de laboratorio)