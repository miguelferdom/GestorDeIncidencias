# Gestor de Incidencias (GDI)

Proyecto para la asignatura de Desarrollo de Aplicaciones Distrubuidas, 3º de GIC en la URJC

- [Fase 1 - Equipo de desarrollo y tematica de la web](#Fase-1---Equipo-de-desarrollo-y-tematica-de-la-web)
	- [Descripcion de la aplicacion](#Descripcion-de-la-aplicación)
	- [Descripcion de las entidades](#Descripción-de-las-entidades)
	- [Descripcion del servicio interno](#Descripcion-del-servicio-interno)
- [Fase 2 - Desarrollo de la aplicacion web en local](#Fase-2---Desarrollo-de-la-aplicacion-web-en-local)
	- [Paginas de la aplicacion](#Paginas-de-la-aplicacion)
	- [Modelo Entidad Relacion](#Modelo-Entidad-Relacion)
	- [Diagrama de clases UML](#Diagrama-de-clases-UML)
- [Fase 3 - Inclusion de seguridad y servicio interno](#Fase-3---Inclusion-de-seguridad-y-servicio-interno)
- [Fase 4 - Incluir tolerancia a fallos en la aplicacion](#Fase-4---Incluir-tolerancia-a-fallos-en-la-aplicacion)
- [Fase 5 - Automatizar el despliegue de la aplicacion](#Fase-5---Automatizar-el-despliegue-de-la-aplicacion)

## Fase 1 - Equipo de desarrollo y tematica de la web

Alumno: Miguel Fernández Domínguez

Correo: m.fernandezdo@alumnos.urjc.es

### Descripcion de la aplicacion

La aplicación a desarrollar es una web para gestion de indicencias en una empresa tipo PYME, donde el número de empleados permite que que esta herramienta no sea demasiado complicada, aportando una funcionalidad básica accesible a usuarios con cualquier nivel de conocimientos en informática.

### Descripcion de las entidades

Interactuarán con la aplicación varios tipos de personas:

* Usuario: Puede ser cualquier persona dentro de la empresa que desee reportar un problema abriendo una incidencia
* Técnico: Aquellos empleados de la empresa encargados de atender y solucionar las incidencias de los usuarios
* Administrador: Usuario con privilegios en la aplicación, puede dar de alta o baja a un técnico, reabrir incidencias cerradas, modificar o borrar comentarios y descripciones...
	
Las incidencias estarán compuestas por:

* Título: Un texto breve que normalmente dará una idea global del problema
* Descripción: Descripción que hace el usuario sobre el problema que tiene
* Comentarios: Anotaciones que van realizando los técnicos según van avanzando en la resolución de la incidencia
* Solución: Breve descripción de las acciones realizadas para solucionar el problema.
* Adjuntos: Tanto usuarios como técnicos podrán adjuntar ficheros de texto o capturas de pantalla que ayuden a documentar la incidencia.

Durante la apertura de la incidencia habrá que categorizarla para que los técnicos puedan priorizarlas a la hora de atenderlas. Para realizar esta categorización se indicará un departamento y un tipo de problema. Algunas de estas categorias y subcategorias serán:

+ Correo
	+ Alta de correo
	+ Baja de correo
	+ Recuperacion de correos
	+ Recepcion de correo malicioso
	+ Recepcion Spam
	+ Problema al enviar correos
	+ Problema al recibir correos
+ Ventas
	+ SW ventas no funciona
	+ SW ventas funciona muy lento
	+ SW Ventas no guarda datos
	+ SW Ventas no recupera datos
	+ Recuperacion de archivos historicos
+ Microinformatica
	+ No funciona la pantalla
	+ No funciona el raton
	+ No funciona el teclado
	+ Entrega de PC
	+ Retirada de PC
	+ Instalacion de SW ofimatico
	+ Revision de configuracion de SW
+ RRHH
	+ Alta empleado
	+ Baja empleado
	+ SW RRHH no funciona
	+ SW RRHH funciona muy lento
+ Sistemas
	+ Ampliacion espacio de disco

+ Llenado de disco
	+ Caida de servidor
	+ Caida de proceso
	+ Antivirus
	+ Ampliacion recursos de servidor
	+ Retirada de servidor
+ BBDD
	+ Caida BD
	+ Caida Listener
	+ Llenado de archivers
	+ Lentitud en consultas
+ Comunicaciones
	+ Caida de red
	+ Lentitud en red
	+ Error en llamadas entrantes
	+ Error en llamadas salientes
	+ Linea de datos principal caida
	+ Linea de datos backup caida
	
En la parte publica de la web se mostrará una ventana de login para cualquier usuario y en función de que tipo de usuario se conecte se mostrará lo siguiente:
	
* Usuario: Podrá abrir una nueva incidencia, consultar aquellas que tuviese abiertas y añadir comentarios o ficheros en estas si fuese necesario
* Tecnico: Verá la cola de incidencias ordenada por criticidad, podrá asignarse incidencias a su nombre, añadir comentarios y adjuntos, escribir sobre el campo solución y cerrar incidencias
* Administrador: Tendrá una vista similar a la de un técnico pero con más privilegios, pudiendo modificar cualquier campo (Descripción, comentario o solución), tambián podrá reabrir incidencias. Además dará de alta y baja a los técnicos y les podrá dar privilegios de administrador

### Descripcion del servicio interno

El servicio interno realizará las siguientes tareas:

* Enviará un correo de notificación a los usuarios cuando su incidencia se resuelva.
* Generará informes sobre las incidencias: incidencias totales del mes desglosadas por categorias, número de incidencias atendidas por cada técnico y categoria de estas, tiempo medio de resolución de incidencia por categoría...
* actualizará la criticidad de las incidencias cada día aumentando su prioridad para evitar que haya solicitudes que se queden sin atender indefinidamente.


## Fase 2 - Desarrollo de la aplicacion web en local

### Paginas de la aplicacion

A continuación de muestran las páginas de la aplicación según los perfiles de usuario de Técnico/Admistrador, que son los que pueden ver todos los elementos sin resticciones:

En primer lugar tenemos la página de Login:

![](Capturasdepantalla/login.png)

Desde ella un usuario introducirá un nombre de usuario y password y seleccionará un perfil (usuario, tecnico o administrador) y se conectará a la aplicación mostrándo la siguiente página de bienvenida:

![](Capturasdepantalla/bienvenida.png)

Aquí se ofrecen dos opciones a todos los usuarios, abrir una nueva incidencia o hacer una consulta de una incidencia a través de su Id. En caso de que el usuario sea un técnico o un administrador, además se mostrárá una tabla con las incidencias del sistema. Estos usuarios podrán acceder a estas o bien usando el cuadro de búsqueda comentado antes o pinchando en el hiperenlace del Id de la incidencia.

Si elegimos abrir una nueva incidencia se cargara el siguiente formulario:

![](Capturasdepantalla/nuevaincidencia.png)

Aquí se nos solicitarán los datos necesarios para abrir una nueva incidencia.

Si deseamos consultar una incidencia se mostrará esta otra web:

![](Capturasdepantalla/consultarincidencia.png)

En esta página los usuarios podrán ver la información de la incidencia, junto con los avances que se hayan podido llevar a cabo visibles en la tabla de comentarios y en el campo solución, también podrá añadir comentarios a la incidencia si fuera necesario y cerrar la incidencia si esta está solucionada y el usuario está de acuerdo con ello. Los técnicos y administradores podrán asignarse incidencias para resolverlas, añadir comentarios y solucionarlas, un administrador podrá, además, modificar y borrar comentarios, y reabrir incidencias que se encuentren cerradas.

Si un administrador quiere actuar sobre un comentario, podrá acceder a él pinchando en el hipervínculo de su Id con lo que accederá a la siguiente página:

![](Capturasdepantalla/modificarcomentario.png)

Desde aquí podrá modificar el texto de una anotación o borrar el comentario por completo y hacer esos cambios efectivos.

### Modelo Entidad Relacion

![](Capturasdepantalla/EER-gdidb.png)

### Diagrama de clases UML

![](Capturasdepantalla/UMLGDI.png)


## Fase 3 - Inclusion de seguridad y servicio interno


## Fase 4 - Incluir tolerancia a fallos en la aplicacion


## Fase 5 - Automatizar el despliegue de la aplicacion
