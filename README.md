# GestorDeIncidencias
Proyecto para la asignatura de Desarrollo de Aplicaciones Distrubuidas, 3º de GIC en la URJC

Nombre de la aplicación: GDI

La aplicación a desarrollar es una web para gestion de indicencias en una empresa tipo PYME, donde el número de empleados permite que que esta herramienta no sea demasiado complicada, aportando una funcionalidad básica accesible a usuarios con cualquier nivel de conocimientos en informática.

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
	
El servicio interno realizará las siguientes tareas:

* Enviará un correo de notificación a los usuarios cuando su incidencia se resuelva.
* Generará informes sobre las incidencias: incidencias totales del mes desglosadas por categorias, número de incidencias atendidas por cada técnico y categoria de estas, tiempo medio de resolución de incidencia por categoría...
* actualizará la criticidad de las incidencias cada día aumentando su prioridad para evitar que haya solicitudes que se queden sin atender indefinidamente.
	
	

