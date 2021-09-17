# Sistema Clinica General
### Implementada en java 8 con netbeans 8.2.

### Importante!
Después de clonar este repositorio, al abrir el proyecto en Netbeans8.2 va a mostrar signos de error.
Puede que le aparezca una ventana indicando que hay errores, si en caso aparece cierre la ventana (Al final de este documento
se indica como resolverlo manualmente paso a paso).
Si no aparece la ventana, el error sigue existiendo, que es por causa de falta de librerías y por la configuración de la clase Conexion.java


### Configuración de librerías del proyecto
#### Pre-configuración
1. Las librerias necesarias, están en un comprimido "LibreriasNecesarias.7z" dentro package o carpeta "utils".
2. Antes de descomprimir, crear una carpeta especifica para librerias jar para darle uso en otros proyectos.
3. Recomendación: Para un mejor acceso, puede crearlo dentro de "Documentos" con el nombre "LibreriasJava".
4. Descomprimir esas librerias en esa carpeta específica para librerias, que ha creado anteriormente.
5. Listo. Hasta aquí se ha preparado para arreglar el error de falta de librerías.

#### Solucionar error de librerias
Nota!!!Antes de esto, asegúrese de haber hecho la preconfiguración anterior.
Existen 4 librerias en el proyecto:
- 2 ya vienen integradas al instalar java, por lo que no debería haber problemas. Son el jdbc de postgresql y absolute para el diseño de ventanas.
- Los otros 2, son librerias externas que son los que van a generar el error.
**Solucionemos eso!**
1. Estando el proyecto abierto desde NetBeans8.2, dar clic derecho encima del proyecto.
2. Ir a la opción "Resolver problemas del proyecto" o "Resolve projet problems" o alguna opción que se parezca a lo mencionado.
3. Una vez entrado en esa opción, en una ventana se verán las librerías que faltan y que son los causantes del error.
4. Seleccionan uno, luego clic en el boton "Resolve", lo que les va a llevar a navegar entre sus archivos.
5. Estando ahí, tendrán que buscar esa librería en la carpeta que se configuró en la Preconfiguración.
6. Seleccionan la librería correspondiente y listo.
7. Ahora hacer el mismo procedimiento con las demás librerías que faltan.



### Configurar la Clase Conexion
- Proyecto hecho en Netbeans8.2 y Java8 (por lo tanto debe considerar abrirlo con las versiones semejantes o cercanas).
- Después de haber configurado como dice el archivo Leeme.txt no debería haber ningún error extra.
#### Pasos
1. Haga una copia de "ConexionExample.java" con el nombre "Conexion.java" en este mismo package (o directorio).
2. Luego escriba dentro de la clase los datos de su usuario y contraseña para conectarse a su base de datos en postgresql.
3. Después de haber configurado esto no debería haber ningún error extra.

### Bases de datos PostgreSQL
1. Crear una base de datos nueva, ejm: `CREATE DATABASE db_clinica_general;`
2. Buscar y ejecutar el archivo **EjecutarMigracion.sql** que está en el package sql.

### Usuario Default
Después de crear la base de datos y ejecutar el scrip 01_execute_migration.sql ya puede probar el sistema clinico general.
User: admin
Pass: admin
