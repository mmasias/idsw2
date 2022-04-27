var item = Math.random() * 10                                               //MATRIZ
var cola = []
var colasCaja = [
    [0, "CAJA 1"],
    [0, "CAJA 2"],
    [0, "CAJA 3"],
    [0, "CAJA 4"]
];

var tiempo = 720                                                             //numero de minutos
var minutos = 0
var hora = 09
var vacia = 0
var atendidas = 0
var vendidos = 0


while (tiempo) {

    if (hora < 10) {                                                        //imprimir hora
        if (minutos < 10) {
            console.log("-------0" + hora + ":0" + minutos + "-------")
        } else {
            console.log("-------0" + hora + ":" + minutos + "-------")
        }
    } else {
        if (minutos < 10) {
            console.log("-------" + hora + ":0" + minutos + "-------")
        } else {
            console.log("-------" + hora + ":" + minutos + "-------")
        }
    }


    var item = Math.floor((Math.random() * 10) + 5)                         //crear cliente

    if ((Math.random() * 10) < 4) {                                         //posibilidad de llegar cliente
        cola.push(item);
        console.log("Llega un nuevo cliente con " + cola[cola.length - 1] + " articulos")
    }

    if (cola.length == 0) {                                                 //contador de minutos vacios
        vacia++
    }
    vendidos = pasarCaja(colasCaja, vendidos)


    for (let i = 0; i < colasCaja.length; i++) {
        if ((colasCaja[i][0] == 0) && (cola[0] != undefined)) {
            colasCaja[i][0] = cola[0]
            console.log("Un cliente se mueve a la " + colasCaja[i][1])
            cola.pop()
            atendidas++
            break
        }
    }

    dibujar(colasCaja, cola)

    tiempo--
    if (minutos == 59) {                                                    //adaptar el tiempo
        hora++
        minutos = 00
    } else {
        minutos++
    }
    if (tiempo == 0) {
        resultados(vacia, cola, atendidas, vendidos)
        debugger
    }
}



function dibujar(colasCaja, cola) {

    console.log("Hay " + cola.length + " personas en cola")
    console.log(cola)
    console.log("\n")

    for (let i = 0; i < colasCaja.length; i++) {
        console.log(colasCaja[i]);
    }
    console.log("\n")
}

function pasarCaja(colasCaja, vendidos) {

    for (let i = 0; i < colasCaja.length; i++) {
        if (colasCaja[i][0] > 0) {
            colasCaja[i][0]--
            vendidos++
        }
    }
    return vendidos
}

function resultados(vacia, cola, atendidas, vendidos) {
    console.log("-------------RESUMEN-------------")
    console.log("La cola ha estado vacia " + vacia + " minutos")
    console.log("Quedan " + cola.length + " personas en la cola")
    console.log("Se han atendido " + atendidas + " personas")
    console.log("Se han vendido " + vendidos + " items")
    console.log("---------------------------------")
}


//var uno = document.getElementById("0")
//uno.textContent = "5"

