Prompt ******  Creando tabla FORM_CASILLAS ....

CREATE TABLE form_casillas
    ( id_formulario     INTEGER NOT NULL
    , id_casilla        INTEGER NOT NULL
    ) ;

ALTER TABLE form_casillas
ADD ( CONSTRAINT fk_form_casi_form
       		 FOREIGN KEY (id_formulario)
        	  REFERENCES formularios(id_formulario)
    , CONSTRAINT fk_form_casi_casi
       		 FOREIGN KEY (id_casilla)
        	  REFERENCES casillas(id_casilla)
    ) ;
