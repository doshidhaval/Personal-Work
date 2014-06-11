/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var placeSearch, autocomplete;
var searchBox;
var componentForm = {
  street_number: 'short_name',
  route: 'long_name',
  locality: 'long_name',
  administrative_area_level_1: 'short_name',
  country: 'long_name',
  postal_code: 'short_name'
};

function initializeAutoComplete() {
  // Create the autocomplete object, restricting the search
  // to geographical location types.
  
  autocomplete = new google.maps.places.Autocomplete(
      /** @type {HTMLInputElement} */(document.getElementById('autocompleteaddress')),
      { types: ['geocode'] });
  // When the user selects an address from the dropdown,
  // populate the address fields in the form.
  google.maps.event.addListener(autocomplete, 'place_changed', function() {
    fillInAddress();
  });
  
   var input = (document.getElementById('place'));
   var input1 = (document.getElementById('place1'));
   var input2 = (document.getElementById('place2'));
  searchBox = new google.maps.places.SearchBox((input));
  searchBox1 = new google.maps.places.SearchBox((input1));
searchBox2 = new google.maps.places.SearchBox((input2));

  // Listen for the event fired when the user selects an item from the
  // pick list. Retrieve the matching places for that item.
  google.maps.event.addListener(searchBox, 'places_changed', function() {
    var places = searchBox.getPlaces(); 
  });
  google.maps.event.addListener(searchBox1, 'places_changed', function() {
    var places = searchBox1.getPlaces(); 
  });
  google.maps.event.addListener(searchBox2, 'places_changed', function() {
    var places = searchBox2.getPlaces(); 
  });
}
function nextPage(){ 
    if($("#place").val()!="")
    {   
        var places = searchBox.getPlaces();
        var lat = places[0].geometry.location.lat();
        var lon = places[0].geometry.location.lng();
        location.href = "type.html";
        sessionStorage.setItem("lat",lat);
        sessionStorage.setItem("lon",lon);
        sessionStorage.setItem("location",places[0].geometry.location);
    }
};
function nextPage1(){ 
     

    if($("#place1").val()!="")
    {   
        var places = searchBox1.getPlaces();
        var lat = places[0].geometry.location.lat();
        var lon = places[0].geometry.location.lng();
        location.href = "type.html";
        sessionStorage.setItem("lat",lat);
        sessionStorage.setItem("lon",lon);
        sessionStorage.setItem("location",places[0].geometry.location);
    }
};

function nextPage2(){ 
     

    if($("#place2").val()!="")
    {   
        var places = searchBox2.getPlaces();
        var lat = places[0].geometry.location.lat();
        var lon = places[0].geometry.location.lng();
        location.href = "type.html";
        sessionStorage.setItem("lat",lat);
        sessionStorage.setItem("lon",lon);
        sessionStorage.setItem("location",places[0].geometry.location);
    }
};
// [START region_fillform]
function fillInAddress() {
  // Get the place details from the autocomplete object.
  var place = autocomplete.getPlace();

  for (var component in componentForm) {
    document.getElementById(component).value = '';
    document.getElementById(component).disabled = false;
  }

  // Get each component of the address from the place details
  // and fill the corresponding field on the form.
  for (var i = 0; i < place.address_components.length; i++) {
     
    var addressType = place.address_components[i].types[0];
    if (componentForm[addressType]) {
      var val = place.address_components[i][componentForm[addressType]];
      document.getElementById(addressType).value = val;
    }
  }
  $("#address").show();
 
}
// [END region_fillform]

// [START region_geolocation]
// Bias the autocomplete object to the user's geographical location,
// as supplied by the browser's 'navigator.geolocation' object.
function geolocate() {
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(function(position) {
      var geolocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
      autocomplete.setBounds(new google.maps.LatLngBounds(geolocation,geolocation));
    });
  }
  
}


        function windowSignUp(){
            $("#signup").dialog( "open" );
        };
        function callReset(){
            $("#address").hide();
        };
        function dialogClose(){
            $("#signup").dialog( "close" );
        };
        function signUp(){
            $("#signup").dialog( "close" );
        };