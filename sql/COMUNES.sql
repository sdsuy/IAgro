CREATE TABLE COMUNES
(
ID_USUARIO INTEGER NOT NULL,
LIST_TAREAS VARCHAR(100) NOT NULL
);

ALTER TABLE COMUNES
ADD
(
CONSTRAINT FK_ID_USUARIO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID_USUARIO)
);
