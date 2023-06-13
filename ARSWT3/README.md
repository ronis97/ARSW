# Tercer taller de ARSW

Creacion de un servidor web en Java

## Preparacion

Clonamos el repositorio con la siguiente instrucción en consola:

```
https://github.com/ronis97/ARSWT3.git
```


### Prerrequisitos

Necesitamos de:
* Maven
* Intellij IDEA (O cualquier IDE de Java)

Para una correcta ejecucion del aplicativo.

### Instalacion

Ejecutamos la siguiente instruccion en consola:

```
mvn package
```

con esto maven se encargara de descargar todos los recursos necesarios para la ejecucion del aplicativo.

Para ejecutar el programa simplemente corremos la instrucción:

```
mvn exec:java -Dexec.mainClass="edu.escuelaing.arsw.app.networking.webServer.WebServer" -Dexec.args=""
```

En el navegador entramos con la dirección:

```
http://127.0.0.1:35000
```


### Ejecucion

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://infinite-headland-88795.herokuapp.com/index.html)



### Diagrama de clases

El diagrama completo se puede encontrar en el archivo `Taller2ARSW.asta` 

![]()




## Autor

**Edgar Ronaldo Henao Villarreal**


## License

Este proyecto esta bajo la licencia [GNU General Public License v2.0](https://github.com/ronis97/ARSW-T1/blob/master/LICENSE) de uso libre. 



