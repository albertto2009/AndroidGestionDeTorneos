Mi proyecto trata sobre la gestion de torneos y que usuarios son los que pueden acceder a el

1�- Hay dos formas de acceder a la aplicacion la
- Cuenta de administrador(usuario: root, contrase�a: root)
- Cuenta de usuario creado previamente por el administrador y esta almacenado en la tabla usuarios cuyo login es su codigo y su pass su nombre
  se comprueba si la contrase�a es valida haciendo una consulta a la tabla
**en el menu hay un textview con la contrase�a del usuario por si es el caso que no la recordamos**

2� Si iniciamos como administrador nos aparece un menu para crear usuarios o torneos que a su vez nos llevaran a un layout en el que podremos 
ingresar los datos correspondientes

3� si iniciamos con un usuario de la tabla usuarios podremos inscribirnos a un torneo,automaticamente nos dar� la bienvenida personalizada y nuestro codigo
debemos introducir el codigo de torneo proporcionado por el administrador para inscribirnos, posteriormente nos mostrara de que tipo es el torneo y el premio
que podemos optar