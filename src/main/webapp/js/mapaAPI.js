let map;
let directionManager;

function GetMap() {
    map = new Microsoft.Maps.Map('#myMap', {
        credentials: 'Ai_KF8afanFf4bWmXjsFzj0tBgWAYKPyyLqjCyYRKzLUcVr1AmjdElPKAQ2_ednr',
        center: new Microsoft.Maps.Location(-34.606525, -58.437384),
        zoom: 10
    });
    Microsoft.Maps.loadModule('Microsoft.Maps.Directions', function () {
        directionManager = new Microsoft.Maps.Directions.DirectionsManager(map);
        directionManager.setRenderOptions({itineraryContainer: document.getElementById('printoutPanel')});
        directionManager.showInputPanel('directionsInputContainer');

        Microsoft.Maps.Events.addHandler(directionManager, 'directionsUpdated', directionsUpdated)
    });



}
function directionsUpdated(e) {
    //Get the current route index.
    let routeIdx = directionManager.getRequestOptions().routeIndex;

    //Get the distance of the route, rounded to 2 decimal places.
    let distance = Math.round(e.routeSummary[routeIdx].distance * 100)/100;

    //Get the distance units used to calculate the route.
    let units = directionManager.getRequestOptions().distanceUnit;
    let distanceUnits = '';

    if (units == Microsoft.Maps.Directions.DistanceUnit.km) {
        distanceUnits = 'km'
    } else {
        //Must be in miles
        distanceUnits = 'miles'
    }

    //Time is in seconds, convert to minutes and round off.
    let time = Math.round(e.routeSummary[routeIdx].timeWithTraffic / 60);

    document.getElementById('routeInfoPanel').innerHTML = 'Distance: ' + distance + ' ' + distanceUnits + '<br/>Time with Traffic: ' + time + ' minutes';
}