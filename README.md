# Conversor de Monedas a Dólares 💱

Una aplicación de consola desarrollada en Java que permite convertir diferentes monedas a dólares estadounidenses utilizando tasas de cambio en tiempo real.

## 📋 Características

- Conversión de 5 monedas principales a USD:
  - Pesos Mexicanos (MXN)
  - Euros (EUR) 
  - Pesos Argentinos (ARS)
  - Yenes Japoneses (JPY)
  - Yuan Chino (CNY)
- Tasas de cambio actualizadas en tiempo real
- Interfaz de consola intuitiva y fácil de usar
- Manejo de errores para conexiones de red

## 🛠️ Tecnologías Utilizadas

- **Java 11+** - Lenguaje de programación principal
- **Gson** - Librería para deserialización JSON
- **HttpClient** - Cliente HTTP nativo de Java para consumir APIs
- **ExchangeRate-API** - Servicio de tasas de cambio

## 📁 Estructura del Proyecto

```
src/
└── main/
    └── java/
        └── org/
            └── example/
                ├── Main.java          # Clase principal con la lógica de la aplicación
                ├── Currency.java      # Record para mapear la respuesta de la API
                └── Moneda.java        # Clase para manejar conversiones
```

## 🏗️ Arquitectura

### Currency (Record)
```java
public record Currency(double conversion_rate) {}
```
- **Propósito**: Mapear la respuesta JSON de la API ExchangeRate-API
- **Campo**: `conversion_rate` - Tasa de conversión de USD a la moneda seleccionada

### Moneda (Clase)
```java
public class Moneda {
    private double valor;
    // Constructors y métodos...
}
```
- **Propósito**: Encapsular la lógica de conversión de monedas
- **Método principal**: `convertirADolares(double cantidad)` - Realiza el cálculo de conversión

### Main (Clase Principal)
- Contiene la interfaz de usuario
- Maneja las peticiones HTTP a la API
- Procesa las respuestas JSON con Gson

## 🚀 Instalación y Ejecución

### Prerrequisitos
- Java JDK 11 o superior
- Maven o Gradle (para gestión de dependencias)
- Conexión a internet

### Dependencias (Maven)
```xml
<dependencies>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.10.1</version>
    </dependency>
</dependencies>
```

### Dependencias (Gradle)
```gradle
dependencies {
    implementation 'com.google.code.gson:gson:2.10.1'
}
```

### Ejecutar la aplicación
1. Clona el repositorio
2. Compila el proyecto
3. Ejecuta la clase `Main`

```bash
javac -cp ".:gson-2.10.1.jar" src/main/java/org/example/*.java
java -cp ".:gson-2.10.1.jar:src/main/java" org.example.Main
```

## 📖 Uso

1. Ejecuta la aplicación
2. Selecciona la moneda que deseas convertir (1-5)
3. Ingresa la cantidad a convertir
4. La aplicación mostrará el equivalente en dólares estadounidenses
5. Selecciona 0 para salir

### Ejemplo de uso:
```
┌─────────────────────────────────┐
│         CONVERSOS A DOLARES     │
├─────────────────────────────────┤
│ 1. Pesos Mexicanos (MXN)        │
│ 2. Euros (EUR)                  │
│ 3. Pesos Argentinos (ARS)       │
│ 4. Yenes Japoneses (JPY)        │
│ 5. Yuan Chino (CNY)             │
│ 0. Salir                        │
└─────────────────────────────────┘
Seleccione una opción (1-5): 1
Ingrese la cantidad de dinero a convertir: 100
$5.85 dolares
```

## 🔑 API Configuration

La aplicación utiliza ExchangeRate-API para obtener las tasas de cambio:
- **URL Base**: `https://v6.exchangerate-api.com/v6/`
- **Endpoint**: `/pair/USD/{CURRENCY_CODE}`
- **API Key**: Configurada en la constante `API_KEY`

## ⚠️ Notas Importantes

- La aplicación requiere conexión a internet para funcionar
- Las tasas de cambio se obtienen en tiempo real
- Se recomienda manejar tu propia API key de ExchangeRate-API para uso en producción

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para cambios importantes:
1. Haz fork del proyecto
2. Crea una nueva rama (`git checkout -b feature/nueva-caracteristica`)
3. Commit tus cambios (`git commit -am 'Agrega nueva característica'`)
4. Push a la rama (`git push origin feature/nueva-caracteristica`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo la Licencia MIT - ver el archivo [LICENSE](LICENSE) para más detalles.

## 📧 Contacto

Si tienes preguntas o sugerencias, no dudes en contactarme.

---
⭐ Si este proyecto te ha sido útil, ¡dale una estrella!
