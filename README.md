# GestorDeIncidencias
Proyecto para la asignatura de Desarrollo de Aplicaciones Distrubuidas, 3º de GIC en la URJC

Nombre de la aplicación: GDI

La aplicación a desarrollar es una web para gestion de indicencias en una empresa tipo PYME, donde el número de empleados permite que que esta herramienta no sea demasiado complicada, aportando una funcionalidad básica accesible a usuarios con cualquier nivel de conocimientos en informática.

Interactuarán con la aplicación varios tipos de personas:

	* Usuario: Puede ser cualquier persona dentro de la empresa que desee reportar un problema abriendo una incidencia
	* Técnico: Aquellos empleados de la empresa encargados de atender y solucionar las incidencias de los usuarios
	* Administrador: Usuario con privilegios en la aplicación, puede dar de alta o baja a un técnico, reabrir incidencias cerradas, modificar o borrar comentarios y descripciones...
	
Las incidencias estarán compuestas por:

	* Descripción: descripción que hace el usuario sobre el problema que tiene
	* Comentario: Anotaciones que van realizando los técnicos según van avanzando en la resolución de la incidencia
	* Solución: Breve descripción de las acciones realizadas para solucionar el problema.
	* Adjuntos: Tanto usuarios como técnicos podrán adjuntar ficheros de texto o capturas de pantalla que ayuden a documentar la incidencia.

Durante la apertura de la incidencia habrá que categorizarla para que los técnicos puedan priorizarlas a la hora de atenderlas. Algunas de estas categorias y subcategorias serán:

	* RRHH: altas, bajas y modificación de datos de empleados.
	* Correo: creación de cuenta, ampliación de cuota de buzón, borrado de buzón, recuperación correos.
	* Microinformática: solicitud de entrega de equipo, solicitud de retirada de equipo, Ampliación recursos, Problema HW.
	* Infraestructura: alta y bajas de servidores, ampliación de recursos, uso elevado de CPU/Memoria/FS, servidor caido, BBDD caida
	* AplicacionX: inaccesible, bajo rendimiento, bloqueada, error al recuperar datos, error al grabar datos.
	
En la parte publica de la web se mostrará una ventana de login para cualquier usuario y en función de que tipo de usuario se conecte se mostrará lo siguiente:
	
	* Usuario: podrá abrir una nueva incidencia, consultar aquellas que tuviese abiertas y añadir comentarios o ficheros en estas si fuese necesario
	* Tecnico: verá la cola de incidencias ordenada por criticidad, podrá asignarse incidencias a su nombre, añadir comentarios y adjuntos, escribir sobre el campo solución y cerrar incidencias
	* Administrador: Tendrá una vista similar a la de un técnico pero con más privilegios, pudiendo modificar cualquier campo (Descripción, comentario o solución), tambián podrá reabrir incidencias. Además dará de alta y baja a los técnicos y les podrá dar privilegios de administrador
	

	

