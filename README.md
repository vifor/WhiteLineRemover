Prueba de concepto para examinar como se puede
1. **Detectar la presencia de una línea blanca** de un pixel de altura en la parte inferior de una archivo de imágen
2. En caso de detectarla **removerla del archivo original** creando un backup de la imágen que incluía la línea blanca en el mismo directorio

Para ejecutar desde línea de comando `java -jar remover.jar imagen.jpeg > log_imagen.txt`

Tiene un solo argumento obligatorio, que es la imagen que se desea analizar. Se recomienda correrlo seguido de > `log_imagen.txt` para capturar 
en un archivo algunos mensajes indicadores de la ejecición del proceso (ToDo reemplazarlo por logger)



