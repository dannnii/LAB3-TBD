# LAB3-TBD
Para correr el proyecto se necesitan las siguientes tecnologias:
Maven: 3.9.x ; JDK 17 ; Postman (o similares) ; GIT

Previo a la ejecución o prueba de la aplicación enviar a jovanni.schneider@usach.cl la IP desde la cual se conectará para ejecutar la aplicación, esto debido a que la aplicación trabaja con una base de datos MongoDB Cloud que se encuentra en un cluster de Atlas y este tiene una whitelist por seguridad para aceptar solo ciertas conexiones

+ Descargar el proyecto y configurar la rama:
  - Abrir una terminal en el directorio de preferencia
  - Clonar el proyecto usando "git clone https://github.com/dannnii/LAB3-TBD.git"
  - Acceder a la carpeta del proyecto usando "cd LAB3-TBD"
  - Cambiar a la branch maven usando "git checkout maven"
+ Ejecutar Desde IDE:
  - Abrir la carpeta del proyecto en el IDE de preferencia
  - Cargar el pom.xml del proyecto en el IDE
  - Configurar el entorno del IDE para que ejecute con JDK17
  - Correr el runner desde el IDE
+ Desde terminal:
  - Abrir una terminal en el directorio "backend"
  - Ejecutar en la terminal el comando para empaquetar el proyecto "mvn clean package -DskipTests"
  - Ejecutar la aplicación con el comando "java -jar target/lab_3-0.0.1-SNAPSHOT.jar"

Utilizar la coleccion de Postman adjunta en el correo para probar la api.

Nota: No existe un script de poblado de datos, ya que la base de datos ya se encuentra poblada en la nube.
