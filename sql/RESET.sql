/* Elimino las tablas de la base de datos en caso de que ya existan para comenzar de cero */
DROP TABLE form_casillas;
DROP TABLE casillas;
DROP TABLE formularios;
DROP TABLE comunes;
DROP TABLE expertos;
DROP TABLE administradores;
DROP TABLE usuarios;
-- Ejecutar hasta aquí si sólo se desea eliminar...
/* Ejecuto el siguiente escript para el creado de las tablas */
@@Usuarios.sql
@@Administradores.sql
@@Expertos.sql
@@Comunes.sql
@@Formularios.sql
@@Casillas.sql
@@Form_Casillas.sql
