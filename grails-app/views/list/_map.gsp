<script src="https://maps.googleapis.com/maps/api/js?v=3.exp"></script>
<script>
    function initialize() {
        var myLatlng = new google.maps.LatLng(${restaurantInstance.address.coordinate.latitude}, ${restaurantInstance.address.coordinate.longitude});
        var mapOptions = {
            zoom: 13,
            center: myLatlng
        };
        var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

        var marker = new google.maps.Marker({
            position: myLatlng,
            map: map,
            title: 'Hello World!'
        });
    }

    google.maps.event.addDomListener(window, 'load', initialize);
</script>

<div align="center">
    <div align="center" id="map-canvas" style="width: 500px; height: 400px; max-width: 100%"></div>
</div>