CREATE TABLE EXPERTOS
(
ID_EXPERTO INTEGER NOT NULL,
LISTA_DE_TAREAS_EX VARCHAR(100) NOT NULL,
CEDULA INTEGER NOT NULL,
PROFESION VARCHAR(30) NOT NULL
);

ALTER TABLE EXPERTOS
ADD
(
CONSTRAINT PK_ID_EXPERTO PRIMARY KEY (ID_EXPERTO),
CONSTRAINT UK_EXPERTO_CEDULA UNIQUE (CEDULA)
);