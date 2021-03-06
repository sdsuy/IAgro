CREATE TABLE EXPERTOS
(
ID_USUARIO INTEGER NOT NULL,
LIST_TAREAS VARCHAR(100) NOT NULL,
CEDULA INTEGER NOT NULL,
PROFESION VARCHAR(30) NOT NULL
);

ALTER TABLE EXPERTOS
ADD
(
CONSTRAINT FK_ID_USUARIO_EXPERTO FOREIGN KEY (ID_USUARIO) REFERENCES USUARIOS(ID_USUARIO)
ON DELETE CASCADE,
CONSTRAINT PK_EXPERTO_CEDULA PRIMARY KEY (CEDULA),
CONSTRAINT UK_EXPERTO_ID_USUARIO UNIQUE (ID_USUARIO)
);
