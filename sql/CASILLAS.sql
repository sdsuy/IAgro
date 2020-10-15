Prompt ******  Creando tabla CASILLAS ....

CREATE TABLE casillas
    ( id_casilla    INTEGER NOT NULL
    , parametro     VARCHAR(30) NOT NULL
    , uni_medida    VARCHAR(30) NOT NULL
    , descripcion   VARCHAR(40) NOT NULL
    , tipo_input    VARCHAR(30) NOT NULL
    ) ;
    
ALTER TABLE casillas
ADD ( CONSTRAINT pk_casillas
       		 PRIMARY KEY (id_casilla)
    ) ;
