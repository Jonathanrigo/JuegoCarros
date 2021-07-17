Para la ejecucion de este proyecto, se debe tener instalada una base de datos mysql y un
IDE de programacion de java.

-- Como primer paso se debe ejecutar el script que se encuentra dentro de la carpeta del proyecto.
-- instalar los driver de conextividad entre java y MySql.

Una vez se cuente con las herramientas y la base de datos instalada y conectada se procede a ejecutar
el proyecto, el cual pedira una cantidad de participantes con un valor de 3 o mas, luego
se asigna el valor numerico correspondiente a los kilometros a recorrer en la pista, el juego
asigna aleatoriamente metros para cada uno de los conductores participantes de la carrera, siendo
los ganadores los 3 primeros en superar los kilometros asignados a la pista.


/** descripcion del proyecto ***/

El proyecto cuenta con varias entidades, correspondientes al problema planteado y a las
especificaciones de los criterios de evaluacion, dentro de estas podemos encontrar

Clase conexion: que permite al IDE acceder a la base de datos y guardar la informacion de los ganadores.
Clase Juego: Se encarga de configurar el juego e instanciar los objetos de las demas clases.
Clase conductor: tiene la informacion de los jugadores.
Clase Carro: contiene los datos de los carros asociados a los conductores.
Clase pista: Define los kilometros a recorrer por cada uno de los carros y tiene asociado carriles.
Clase Carril: marca la distancia recorrida por los carro en la pista.
Clase Podio:`almacena la informacion de los ganadores, la cual se guarda en la Base de datos.