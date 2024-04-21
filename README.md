# Conversor de monedas
## Fase 1:

En esta fase se inicia con el proyecto.

[Link al video explicando la primera fase.](https://youtu.be/7YED9MDmjJA)

- [x] Obtener lista de codigos soportados.
- [x] Preguntarle si desea convertir a una sola moneda o a todas las monedas.
- [x] Guardar su decisión

### Convertir a una moneda especifica.

- [x] Mostrar lista de codigos soportados.
- [x] Preguntarle al usuario cual es su moneda local.
- [x] Preguntarle a que moneda desea realizar su conversión.
- [x] Solicitar el monto a convertir.
- [x] Mostrar el monto convertido.


### Lista de montos convertidos.

- [x] Solicitar el monto a convertir.
- [x] Mostrar la lista de montos convertidos.


### Problemas encontrados:
- El programa no convierte la cantidad indicada a todas las monedas.
- La experiencia no es lo suficientemente agradable.
- El usuario no puede terminar el proceso cuando quiere.
- El programa no acompaña al usuario.

## Fase 2:
### Soluciones:
- [x] Multiplicar el valor traído por el valor de cambio.
- [X] Agregar al inicio la opción de revisar la lista de monedas. Y manejarse únicamente por el código de moneda.
- [ ] Agregar opciones de "Cancelar" o "Terminar proceso".
- [X] Agregar mensajes de confirmación para el usuario.

### Cosas por implementar:
- [ ] Refactorizar el código (eliminar código repetido, agregar excepciones).
- [ ] Agregar historial de conversiones (Monedas convertidas, montos convertidos, fecha y hora).