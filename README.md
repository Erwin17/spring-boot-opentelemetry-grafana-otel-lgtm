# spring-boot-opentelemetry-grafana-otel-lgtm

En este ejempo muestro como implementar **[opentelemetry]** con [String Boot 4].

Antes que todos, vamos a revisar varios putntos importantes para compreder como funciona todo esto.

### Dependencias
La dependencia inical para configurar **[opentelemtry]** es la siguiente:

```
implementation 'org.springframework.boot:spring-boot-starter-opentelemetry'
```

Esta depedencia permite obtener metricas, trazados y logs de forma simplificada al incluir todas las dependencias necesaris de OpenTelemtry.

### Micrometer
Micrometer es una biblioteca que actua como fachada para la recopilacion metricas. Esto le pemrite enviar ddatos a **[OpenTelemetry]** usando el protocolo **[OTLP]**.

Una novedad importan te es que pemrite recopilar datos mediante anotaciones; ahora es posible utilizar **[@Observer]** en los metodos y capturar argumetnos especifico como **"key-values"** usando la anotacion **[ObservationKeyValue]** directamente en los parametros de los metodos.