# Mars-Rover-Kata

Api Rest ROVER 

 

## Endpoint: /api/tablero 

Método HTTP: <font color="orange">POST</font> .
Descripción: Utiliza este endpoint para iniciar el tablero. Al ejecutar esta operación, se generará un tablero y se inicializará con objetos, como rovers y obstáculos. 
Cuerpo de la Solicitud: 
json 
{ 
  "mensaje": "inicio" 
} 
Respuesta: 
Si el mensaje es "inicio", el tablero se inicializará y se responderá con un mensaje indicando que la función se ejecutó con éxito. 

 

## Endpoint: /api/tablero 

Método HTTP: <font color="blue">GET</font> 
Descripción: Utiliza este endpoint para obtener información sobre el estado actual del tablero según su ID. 
Ejemplo de Respuesta: 
Json 
{ 
  "id": 1, 
  "tamanoX": 4, 
  "tamanoY": 4, 
} 

## Endpoint: /api/rover

Método HTTP: <font color="blue">GET</font> 
Descripción: Este endpoint te permite obtener el estado actual EN BD del rover según su ID. 
Ejemplo de Respuesta: 
{ 
  "id": 1, 
  "posX": 2, 
  "posY": 3, 
  "direccion": "Norte" 
} 

## Endpoint: /api/rover/mover 

Método HTTP: <font color="orange">POST</font>  
Descripción: Utiliza este endpoint para enviar una serie de comandos que moverán el rover en el tablero. 
Cuerpo de la Solicitud: 
json 
{ 
  "mensaje": "RFBL" 
} 
Respuesta: 
La API responderá con un mensaje indicando que los comandos fueron recibidos. 
 

## Endpoint: /api/rover/guardar 

Método HTTP: <font color="orange">POST</font>  
Descripción: Utiliza este endpoint para guardar en BD la nueva posicion del Rover y quede actualizado. 
Cuerpo de la Solicitud: 
json 
{ 
  "mensaje": "guardar" 
} 
Respuesta: 
Si el mensaje es "guardar", se actualizará la BD y se responderá con un mensaje indicando que la función se ejecutó con éxito. 

 

 
