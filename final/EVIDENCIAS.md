# Evidencias de Funcionamiento - BiblioExpress API

**Asignatura:** Programación III  
**Examen:** Final Práctico 01 - BiblioExpress  
**Tecnologías:** Java 21 + Spring Boot 3  

---

## 1. Instrucciones para Ejecutar la Aplicación

1. Abrir la terminal en la carpeta del proyecto `final/`.
2. Compilar y levantar la aplicación ejecutando:
   ```bash
   ./mvnw spring-boot:run
   ```
3. La API estará escuchando en el puerto `8080` (`http://localhost:8080`).

---

## 2. Endpoints Obligatorios Evaluados

### 1. POST /api/prestamos/prestar
- **Descripción:** Presta un material cambiando su disponibilidad a `false`.
- **Cuerpo JSON enviado:**
  ```json
  {
    "codigoMaterial": "LIB-001",
    "idSocio": 101
  }
  ```
- **Respuesta HTTP 200 OK:**
  ```
  "Prestamo realizado con exito del material 'Cien Anos de Soledad' al socio Juan Perez."
  ```

---

### 2. POST /api/prestamos/devolver
- **Descripción:** Devuelve un material, cambia su disponibilidad a `true`, calcula la multa usando la estrategia activa (`NORMAL`, `CAMPANIA`, `FIN_DE_SEMANA`) y aplica el beneficio del socio (`SocioRegular` / `SocioPremium`).
- **Cuerpo JSON enviado:**
  ```json
  {
    "codigoMaterial": "LIB-001",
    "idSocio": 102,
    "diasAtraso": 3,
    "tipoEstrategia": "CAMPANIA"
  }
  ```
- **Respuesta HTTP 200 OK:**
  ```json
  {
    "codigoMaterial": "LIB-001",
    "idSocio": 102,
    "diasAtraso": 3,
    "multaBase": 180.0,
    "descuentoAplicado": 90.0,
    "multaFinal": 90.0,
    "mensaje": "Devolucion registrada. Material 'Cien Anos de Soledad' devuelto por Maria Lopez."
  }
  ```

---

### 3. GET /api/materiales/disponibles
- **Descripción:** Retorna la lista de materiales bibliográficos con `disponible = true`.
- **Respuesta HTTP 200 OK:**
  ```json
  [
    {
      "codigo": "LIB-002",
      "titulo": "El Aleph",
      "disponible": true,
      "tipo": "Libro",
      "detalleExtra": "Autor: Jorge Luis Borges"
    },
    {
      "codigo": "REV-001",
      "titulo": "National Geographic",
      "disponible": true,
      "tipo": "Revista",
      "detalleExtra": "Edicion Nro: 150"
    },
    {
      "codigo": "REV-002",
      "titulo": "Ciencia Hoy",
      "disponible": true,
      "tipo": "Revista",
      "detalleExtra": "Edicion Nro: 42"
    }
  ]
  ```

---

### 4. POST /api/socios/depurar-duplicados
- **Descripción:** Recibe una lista de DNIs duplicados y devuelve solo los únicos en una sola pasada usando `HashSet`.
- **Cuerpo JSON enviado:**
  ```json
  [
    "40123456",
    "38987654",
    "40123456",
    "42111222",
    "38987654"
  ]
  ```
- **Respuesta HTTP 200 OK:**
  ```json
  [
    "40123456",
    "38987654",
    "42111222"
  ]
  ```

---

## 3. Capturas de Pantalla de Postman

> Reemplazar o adjuntar aquí las capturas tomadas de la ejecución de cada endpoint en Postman.
