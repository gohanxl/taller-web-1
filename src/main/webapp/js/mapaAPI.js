let map;
let directionManager;
let cancelDelivery = document.getElementById('deliveryBtn')
const routePanel = document.getElementById('routeInfoPanel') || null

window.addEventListener('load', function () {
    let waypoint = document.getElementsByClassName('dirWp')[0].getElementsByTagName('input')[0]
    let waypoint2 = document.getElementsByClassName('dirWp')[1].getElementsByTagName('input')[0]
    let walkingMan = document.getElementsByClassName("dirBtnWalk")[0]
    let car = document.getElementsByClassName("dirBtnDrive")[0]
    let optionsButton = document.getElementsByClassName("dirBtnOptions")[0]
    let addButton = document.getElementsByClassName("dirBtnAdd")[0]
    let timeButton = document.getElementsByClassName("dirBtnTime")[0]
    let reverseButton = document.getElementsByClassName("dirBtnRev")[0]
    let gripButton1 = document.getElementsByClassName("dirWpGrip")[0]
    let gripButton2 = document.getElementsByClassName("dirWpGrip")[1]
    let goButton = document.getElementsByClassName("dirBtnGo")[0]
    let lineaGris = document.getElementsByClassName("searchboxWithAS")[0]
    let priceElement = document.getElementById("price");
    let inputContainer = document.getElementById("directionsInputContainer");
    let price = priceElement.textContent;
    let parsedPrice = Number(price.replace(/[^0-9\.]+/g, ''));

    waypoint.disabled = true
    waypoint.className = "disabled"

    walkingMan.remove();
    car.remove();
    optionsButton.className = "hidden"
    addButton.className = "hidden"
    timeButton.className = "hidden"
    reverseButton.className = "hidden"
    gripButton1.className = "hidden"
    gripButton2.className = "hidden"
    goButton.className = "hidden"
    lineaGris.className += "hide-linea"
    inputContainer.className += "px-4"

    localStorage.removeItem('price');

    cancelDelivery.addEventListener('click', function () {
        localStorage.removeItem('price');
        priceElement.textContent = `$ ${parsedPrice}`;

        cancelDelivery.className = "hidden"
        routePanel.innerHTML = '';
    })

})

function GetMap() {
    map = new Microsoft.Maps.Map('#myMap', {
        credentials: 'Ai_KF8afanFf4bWmXjsFzj0tBgWAYKPyyLqjCyYRKzLUcVr1AmjdElPKAQ2_ednr',
        center: new Microsoft.Maps.Location(-34.668856, -58.565657),
        zoom: 13
    });
    Microsoft.Maps.loadModule('Microsoft.Maps.Directions', function () {
        directionManager = new Microsoft.Maps.Directions.DirectionsManager(map);
        directionManager.setRequestOptions({maxRoutes: 1, routeDraggable: false});
        directionManager.setRenderOptions({
            itineraryContainer: document.getElementById('printoutPanel'),
        });
        let depositWaypoint = new Microsoft.Maps.Directions.Waypoint({
            address: 'Deposito',
            location: new Microsoft.Maps.Location(-34.668856, -58.565657)
        });
        directionManager.addWaypoint(depositWaypoint);
        directionManager.showInputPanel('directionsInputContainer');

        Microsoft.Maps.Events.addHandler(directionManager, 'directionsUpdated', directionsUpdated)
    });

}

function directionsUpdated(e) {
    let routeIdx = directionManager.getRequestOptions().routeIndex;

    let distance = Math.round(e.routeSummary[routeIdx].distance * 100) / 100;

    let units = directionManager.getRequestOptions().distanceUnit;
    let distanceUnits = '';

    if (units == Microsoft.Maps.Directions.DistanceUnit.km) {
        distanceUnits = 'km'
    } else {
        distanceUnits = 'miles'
    }

    let canjearPuntosForm = document.getElementById("canjear-puntos");
    let priceElement = document.getElementById("price");
    let price = priceElement.textContent;
    let parsedPrice = Number(price.replace(/[^0-9\.]+/g, ''));
    let pricePerDistance = 50;

    let finalPrice = distance > 50 ? parsedPrice + 500 : parsedPrice + distance * pricePerDistance;
    let precioEnvio = distance > 200 ? 500 : distance * pricePerDistance;

    const routePanel = document.getElementById('routeInfoPanel')

    routePanel.innerHTML = 'Distancia: ' + distance + ' ' + distanceUnits + '<br/>Precio del envio: $' + precioEnvio;

    if (finalPrice) {
        priceElement.textContent = `$ ${finalPrice}`;

        console.log("entra ca")

        cancelDelivery.className = 'btn btn-primary btn-md mx-0 my-3 ml-3 show'

        localStorage.setItem('price', finalPrice);

        canjearPuntosForm.action = '/checkout';
    }
}


