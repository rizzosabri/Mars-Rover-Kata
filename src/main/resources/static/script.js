createTablero()
async function createTablero() {

    let roverResponse = await fetch('http://localhost:8080/api/rover', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    });

    let roverJson = await roverResponse.json()
    console.log(roverJson)

    let obstaculoResponse = await fetch('http://localhost:8080/api/obstaculo', {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        }
    });

    let obstaculoJson = await obstaculoResponse.json()
    console.log(obstaculoJson)




    moveRover(roverJson.x, roverJson.y)
    crearObstaculo(obstaculoJson[0].x, obstaculoJson[0].y)
    crearObstaculo(obstaculoJson[1].x, obstaculoJson[1].y)



}

function moveRover(x, y) {
    document.getElementById("rover").style.top = (y * 100) + "px"
    document.getElementById("rover").style.left = (x * 100) + "px";

}

function crearObstaculo(x, y) {
    var obstaculo = document.createElement("img")
    obstaculo.setAttribute("src", "images/obstaculo.png");
    obstaculo.setAttribute("class", "obstaculo");

    var container = document.getElementById("container");
    container.appendChild(obstaculo)

    obstaculo.style.top = (y * 100) + "px"
    obstaculo.style.left = (x * 100) + "px";

}

function enviarPOST(data) {

    const url = 'http://localhost:8080/api/rover/mover';
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json' // Tipo de contenido JSON
        },
        body: JSON.stringify(data) // Convierte los datos a JSON
    };

    // Realiza la solicitud POST
    fetch(url, options)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error en la solicitud.');
            }
            return response.text();
        })
        .then(data => {
            // Maneja la respuesta del servidor aquí
            console.log('Respuesta del servidor:', data);
        })
        .catch(error => {
            // Maneja los errores aquí
            console.error('Error:', error);
        });
};



function clickBtnRetroceder() {
    let data = {
        mensaje: 'b'
    };
    enviarPOST(data)
    location.reload()
}

function clickBtnAvanzar() {
    let data = {
        mensaje: 'f'
    };
    enviarPOST(data)
    location.reload()

}


function clickBtnGirarDerecha() {
    const data = {
        mensaje: 'r'
    };
    enviarPOST(data)
    location.reload()
}

function clickBtnGirarIzq() {
    const data = {
        mensaje: 'l'
    };
    enviarPOST(data)
    location.reload()
}




async function clickBtnStart() {
    const data = {
        mensaje: 'inicio'
    };

let inicioResponse = await fetch( 'http://localhost:8080/api/tablero', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    let inicioJson = await inicioResponse.text()
    console.log(inicioJson)
    location.reload()

    createTablero()
        
};




