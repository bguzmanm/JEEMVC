# Ejemplo de uso de Servlets en JEE con MVC

En este proyecto, encuentras una estructura clasica MVC o Modelo Vista Controlador.
Toma nota de los comentarios que te guiarán para comprender la implementación. Recuerda que esta es es básica y que nos permitirá ir implementando nuevas funcionalidades durante el transcurso del bootcamp.


## 5 de Agosto
- Agregamos editarparticipante.jsp
- Hacemos include de menu.jsp y footer.jsp
- Incluimos elementos de formateo de datos
- Incluimos css, imagenes. ç

## 6 de Agosto
- Agregamos conectividad a BD.
- Uso de patrón Singleton
- Uso de patrón DAO
- Implementaeción incompleta de CRUD
- Uso de JDBC y OJDBC

## 9 de Agosto
- Completamos CRUD de Participantes
- Incluimos funcionalidad para Crear y Eliminar Participantes
- Inclumos web.xml con información de despliegue

## Autor
- [Brian Guzmán](https://github.com/bguzmanm)

## Script SQL
```sql
CREATE TABLE PARTICIPANTES 
(
  RUT VARCHAR2(20 CHAR) NOT NULL 
, NOMBRE VARCHAR2(100 CHAR) 
, APELLIDO VARCHAR2(100 CHAR) 
, EDAD NUMBER 
, EMAIL VARCHAR2(100 CHAR) 
, APROBADO NUMBER(1, 0) DEFAULT 0 
, URLIMG VARCHAR2(100 CHAR) 
, CONSTRAINT PARTICIPANTES_PK PRIMARY KEY 
  (
    RUT 
  )
  ENABLE
);
```
