# 2024 - Píldora 1

## Motivación

Exponer unos servicios Spring ya creados en los contextos de BND de Liferay

## Pasos

### Paso 1:

 * Iniciar el workspaces siguiendo [Creating A Liferay Workspace](https://learn.liferay.com/w/dxp/building-applications/tooling/liferay-workspace/creating-a-liferay-workspace)
 * Descargar el bundle
   > sh gradlew initBundle

### Paso 2:
 * Crear un módulo con los proyectos spring
 * Cambiar las dependencias para que tengas las mismas que Liferay si es posible
 * Crear un módulo llamado XXX-XXX-integration. Debe ser un tipo **war** 
   * Dentro del módulo, incluir una carpeta src/main/webapp
     * Dentro de la misma carpeta, crear la carpeta WEB-INF con los ficheros
       * app-context.xml
       * web.xml
       * liferay-plugin-package.properties
 * Añadir un bnd.bnd a cada uno de los módulos spring que queremos integrar en Liferay

> ¿Por qué un war?
> Para de esta forma evitar que dependencias del proyecto choquen con Liferay y empiece a dar problemas. 
> Por ejemplo, bastante útil para una integración con SAP.