# Instrucciones para su correcto funcionamiento.
# Proyecto final DAW Back (APIRest quetepica)
 
 1.Clonar o descargar el repositorio existente.
 	1.1 Importarlo al IDE. 
 
 2.Tener Apache/Mysql corriendo.
 	2.1. Necesario tener un entorno montado (por ejemplo XAMPP). Esto es para la bbdd y subida de imagenes al servidor. 	     
 	2.3. La variable: public String uploadDir = "S:\\Xampp\\htdocs\\img\\"; Esta variable hay que darle el valor de la ruta donde tenemos la carpeta del servidor (con las imagenes).  
 	2.4. En el aplication.properties se define la url y propiedades de conexión para la base de datos.
 	
 3.Recomendable ejecutarlo como APP Spring Boot (RunAss --> Spring Boot App).En mi caso se monta en: localhost:8080/api/v0
 	
 4.La ApiRest viene documentada con Swagger, por lo que accediendo a http://localhost:8080/api/v0/swagger-ui.html nos vamos encontrar detallados todos los recursos
 		de la API. También desde Swagger se pueden probar dichos recursos ya que funciona como cliente.
   


