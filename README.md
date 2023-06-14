# IknowThatWord
Second miniProyect 

La idea principal es presentar un juego en el cual tenemos que adivinar 
las palabras presentadas en una lista por nivel y dependiendo el nivel aunmenta la dificultad
y después adivinar las palabras en otra lista que contiene palabras de la lista de las palabras memorizadas y adiciona el doble
para asi poder definir las que están y las que no.

Cabe resaltar que el proyecto no se ha terminado, sigue en proceso pero ya puedes ver diferentes funcionalidades.

**Explicación de algunas clases y metodos**: 

**Diccionario**:
En este archivo se crea una clase llamada diccionario. Sus funciones, primero es crear un array y almacenar valores tipo string. segundo con la implementación de un objeto crea un valor aleatorio.

**FileManager**:
Lee desde un archivo de texto, las frases que se pueden usar en el juego

**LogicPart**:
Es la clase que se encuentra en el controlador la cual fue creada con la intención de la interfaz con la parte lógica.

**FileText**:
Es un archivo de texto que contiene 200 palabras aleatorias

**CrearLista**:
Agrega palabras desde el diccionario a los arrays

**ResetGodWord**:
Para resetear el objeto y vaciar la lista

**Verificar**:
Para verificar cuando se tenga palabras buenas y malas y así poder comparar

**ChangeTimer**:
Para detener el hilo de ejecución por 5 segundos, y cada 5 segundos se ejecuta lo que está dentro que es el while.

**goGame**:
Le entra un nivel y conforme al nivel muestra la cantidad de palabras necesarias

**GUI**:
En la clase Escucha se implementa una serie de funciones que se irán ejecutando cada vez que el usuario de click en un botón que será visible en la ventana.

**ChangeWord**:
Este método lo que hace es actualizar el label y punta la palabra que esté en el label desde la posición 0, teniendo en cuenta las palabras correctar.

**ChangeBadWord**:
Este método lo que hace es actualizar el label y punta la palabra que esté en el label desde la posición 0, teniendo en cuenta las palabras correctas e incorrectas.

**goSi_No**:
Este método remueve el panel continuidad y agrega el panel si_no en el centro.

**goContinuar**:
Este método remueve el panelJuego y agrega el panelContinuidad en el centro.

**updatePuntaje**:
Método para actualizar el puntaje.

**Problemas**:
Las palabras antes se visualizaban en el costado izquierdo de la ventana.
Ahora lo vemos  solucionado y hemos cambiado la dicha posicion hacia el centro de la 
pantalla.






