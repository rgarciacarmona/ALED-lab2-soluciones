# ALED (Algorithms and Data Structures) Lab Session 2 - Solution

This repository contains the code for a Java application with a GUI that draws a 2D full-body representation of an exoskeleton in which the position of the bones are calculated using a Forward Kinematics recursive algorithm. This code is the solution for this lab session: https://github.com/rgarciacarmona/ALED-lab2

## Respuestas a las preguntas

### Sección 1.6

- **¿Tienen `Segment` y `Node` métodos *getters*? ¿Cuáles son?:** Sí: `getLength()`, `getAngle()`, `getChildren()`, `getX()`, `getY()` y `getChildren()`.
- **¿Tienen `Segment` y `Node` métodos *setters*? ¿Cuáles son?:** Sí: `setAngle()`, `addChild()` y `addChild()`.
- **¿Son `Segment` y `Node` tipos de datos recursivos?:** Sí, porque ambos tienen referencias a objetos de su misma clase.

### Sección 3

- **¿Qué tareas realiza el constructor?:** Crea una ventana (`JFrame`) de tamaño 600x600 y ubica el `SkeletonPanel` en su interior.
- **¿Qué hace el método `paintComponent()`?:** Calcula las posiciones de los `Node` del esqueleto y los dibuja.
- **¿A qué dos métodos, que representan cada uno un algoritmo recursivo distinto, llama el método `paintComponent()`? ¿Cuál de ellos ya está implementado?:** ``computePositions()`` (ya implementado), que calcula las posiciones de los `Node`, y `drawSkeleton()`, que los va dibujando uno a uno. 
- **¿Alguno de los métodos de `SkeletonPanel` se llama a sí mismo?:** Sí, `drawSkeleton()`.

### Sección 3.1

- **¿Qué líneas de código representan el caso base?:**
```Java
if (node.getChildren().size() == 0) {
	return;
}
```
- **¿Qué líneas de código representan el paso recursivo?:**
```Java
for (Node child : node.getChildren()) {
	drawSkeleton(g, node.getX(), node.getY(), child);
}
```
- **¿Qué líneas de código representan el código general o común?:**
```Java
g.fillOval((int) node.getX() - 4, (int) node.getY() - 4, 8, 8);
g.drawLine((int) parentX, (int) parentY, (int) node.getX(), (int) node.getY());
```
- **¿Qué se dibuja primero, el final (extremo final del último segmento) o el principio (punto inicial del segmento raíz) de la cadena cinemática? Le recomiendo recurrir al depurador para confirmar si su respuesta es correcta o no.:** El final.

### Sección 4.3

- **¿Cómo debe modificar el código del `main` para que los segmentos sean más largos o más cortos?:** Cambiando el primer argumento de las llamadas a los constructores de `Segment`.
- **¿Cómo debe modificar el código del `main` para añadir tres dedos a cada mano?:**
```Java
// Para una mano
Segment finger1 = new Segment(10, Math.toRadians(-45));
Segment finger2 = new Segment(10, Math.toRadians(0));
Segment finger3 = new Segment(10, Math.toRadians(45));
leftForearm.addChild(finger1);
leftForearm.addChild(finger2);
leftForearm.addChild(finger3);
```

### Sección 5

- **¿Cómo varía el tiempo de ejecución en función del número de hijos del `Segment`?:** Se incrementa conforme al número de hijos.
- **¿Tiene alguna teoría de por qué ocurre esto?:** Porque un método que llama recursivamente a otro no termina hasta que ha terminado al que ha llamado. Este último, a su vez, llama recursivamente a otros, repitiéndose el proceso.