// window.addEventListener('load', function () {
//
// })

let map;
let directionManager;

window.addEventListener('load', function () {
    let waypoint = document.getElementsByClassName('dirWp')[0].getElementsByTagName('input')[0]

    waypoint.disabled = true

    waypoint.className = "disabled"
})

function GetMap() {
    map = new Microsoft.Maps.Map('#myMap', {
        credentials: 'Ai_KF8afanFf4bWmXjsFzj0tBgWAYKPyyLqjCyYRKzLUcVr1AmjdElPKAQ2_ednr',
        center: new Microsoft.Maps.Location(-34.668856, -58.565657),
        zoom: 13
    });
    Microsoft.Maps.loadModule('Microsoft.Maps.Directions', function () {
        directionManager = new Microsoft.Maps.Directions.DirectionsManager(map);
        directionManager.setRenderOptions({itineraryContainer: document.getElementById('printoutPanel')});
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

    // let time = Math.round(e.routeSummary[routeIdx].timeWithTraffic / 60);

    let priceElement = document.getElementById("price");
    let price = priceElement.textContent;
    let parsedPrice = Number(price.replace(/[^0-9\.]+/g, ''));
    let pricePerDistance = 50;

    let finalPrice = distance > 200 ? parsedPrice + 500 : parsedPrice + distance * pricePerDistance;

    document.getElementById('routeInfoPanel').innerHTML = 'Distancia: ' + distance + ' ' + distanceUnits + '<br/>Precio del envio: ' + finalPrice;

    if (finalPrice) {
        priceElement.textContent = `$ ${finalPrice}`;

        localStorage.setItem('price', finalPrice);
    }
}