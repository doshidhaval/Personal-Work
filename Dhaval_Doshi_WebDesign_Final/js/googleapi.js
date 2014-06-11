/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    var map, placesList;

            function initialize() {
              var city = new google.maps.LatLng(42.364506, -71.038887);
              var request = {
                location: city,
                radius: 2000,
                types: ['restaurant']
              };
              
              var service = new google.maps.places.PlacesService(document.getElementById('maps'));
              service.nearbySearch(request, callback);
          }
            

            function callback(results, status, pagination) {
              if (status !== google.maps.places.PlacesServiceStatus.OK) {return;} 
              else {createTiles(results);}
            }
            
            function createTiles(places) {
                    getLocation();
                $( "#signup" ).dialog({
                    autoOpen: false,
                     position: { my: "center", at: "center", of: window }
                     
                  });
                
               initializeAutoComplete();
              for (var i = 0, place; place = places[i]; i++) {
                 var photos = place.photos;
                 if(photos)
                var pic = photos[0].getUrl({'maxWidth': 500, 'maxHeight': 500});
                var ref = place.reference;
                //alert(ref);
                var html = '<div class="tile-content getId" id='+ref+' onclick="viewDetails();"><img src="'+pic+'"></div>';
                html +='<div class="brand bg-dark opacity"><span class="text">'+place.name;
                html +='<span class="rating small fg-white" data-role="rating" data-static="false" data-score="'+place.rating+'" data-stars="5" data-show-score="false" data-score-hint="Rating: ">';
                html +='<ul><li></li><li></li><li></li><li></li><li></li></ul></span></span></div>';
                $("#likeGroup").find(".tile").eq(i).append(html);
                $("#restaurantsGroup").find(".tile").eq(i).append(html);
                
                 
                 $(".rating").rating({
                    static: false,
                    score: place.rating,
                    stars: 5,
                    showHint: true,
                    hints: ['bad', 'poor', 'regular', 'good', 'gorgeous'],
                    showScore: true,
                    scoreHint: "Current score: ",
                    click: function(value, rating){rating.rate(value);}
                });
                }
                
              $(".getId").click(function(){
                        var id = this.id;
                        sessionStorage.setItem("reference",id);
                        location.href="details.html";
                   });     
            }
            
            
            function initializeList() {
              var lat = sessionStorage.getItem("lat"); 
              var lon = sessionStorage.getItem("lon"); 
              var location = sessionStorage.getItem("location"); 
              var city = new google.maps.LatLng(lat,lon);
              var type=['restaurant'];
              var request = {
                location: city,
                radius: 1609,
                types: type
              };
              
              var service = new google.maps.places.PlacesService(document.getElementById('maps'));
              service.nearbySearch(request, callback1);
          }
            

            function callback1(results, status, pagination) {
              if (status !== google.maps.places.PlacesServiceStatus.OK) {return;} 
              else {createList(results); }
            }
            
            function createList(places)
            {
                var html;
                var lat = sessionStorage.getItem("lat"); 
                var lon = sessionStorage.getItem("lon"); 
                var strtype="";
                for (var i = 0, place; place = places[i]; i++) {
                var lat1 =place.geometry.location.lat(); 
                var lon1 =place.geometry.location.lng(); 
                var ref = place.reference;
                for(var j=0, type; type = place.types[j];j++)
                {
                    strtype+=type+' , ';
                }
                html = '<li class="getId" data-geo-lat="'+lat1+'" data-geo-long="'+lon1+'" id="'+ref+'"><h3>'+place.name+'</h3><p>'+place.types[0]+'</p><br/>'+
                        '<p class="longdesc"><strong>About:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\
                        The type of establishment is '+strtype+'&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n\
                       </strong></p></li>';
                strtype='';
                 $("#locations").append(html);
            }
               $(".getId").click(function(){
                        var id = this.id;
                        sessionStorage.setItem("reference",id);
                        location.href="details.html";
                   });     
                
                 $(function() {
    
                var boston = new google.maps.LatLng(42.364506, -71.038887),
                    pointToMoveTo, 
                    first = true,
                    curMarker = new google.maps.Marker({}),
                    $el;

                var myOptions = {
                    zoom: 16,
                    center: boston,
                    mapTypeId: google.maps.MapTypeId.ROADMAP
                  };

                var map = new google.maps.Map($("#map_canvas")[0], myOptions);

                $("#locations li").mouseenter(function() {

                  $el = $(this);

                  if (!$el.hasClass("hover")) {

                    $("#locations li").removeClass("hover");
                    $el.addClass("hover");

                    if (!first) { curMarker.setMap(); }

                    pointToMoveTo = new google.maps.LatLng($el.attr("data-geo-lat"), $el.attr("data-geo-long"));
                    map.panTo(pointToMoveTo);

                    // Add new marker
                    curMarker = new google.maps.Marker({
                        position: pointToMoveTo,
                        map: map,
                        icon: "images/marker.png"
                    });

                    // On click, zoom map
                    google.maps.event.addListener(curMarker, 'click', function() {
                       map.setZoom(14);
                    });

                    // Fill more info area
                    $("#more-info")
                      .find("h2")
                        .html($el.find("h3").html())
                        .end()
                      .find("p")
                        .html($el.find(".longdesc").html());

                    // No longer the first time through (re: marker clearing)        
                    first = false; 
                  }

                  $("#stick").sticky({topSpacing:50});


                   });
                $("#locations li:first").trigger("mouseenter");
           });
            }
            
             function getLocation()
            {
                
            if (navigator.geolocation)
              {
              navigator.geolocation.getCurrentPosition(showPosition);
              }
            else{alert("Geolocation is not supported by this browser.");}
            }

          function showPosition(position)
            {
                lat=position.coords.latitude;
                lon=position.coords.longitude;
               
                 $.ajax({
                    url : "http://maps.googleapis.com/maps/api/geocode/json?latlng="+lat+","+lon+"&sensor=true",
                    dataType : "json",
                    success : function(place) {
                    
                    $("#autocompleteaddress").val(place.results[0].formatted_address);
                    }
                });
            }
//weather api
        jQuery(document).ready(function($) {
            $.ajax({
                url : "http://api.wunderground.com/api/ec7bfbb2962f4817/geolookup/conditions/q/autoip.json",
                dataType : "jsonp",
                success : function(parsed_json) {
                var city = parsed_json['location']['city'];
                var temp_f = parsed_json['current_observation']['temp_f'];
                var temp_c = parsed_json['current_observation']['temp_c'];
                var weather = parsed_json['current_observation']['weather'];
                var weatherimage = parsed_json['current_observation']['icon_url'];
                var latitude= parsed_json['location']['latitude'];
                var longitude= parsed_json['location']['longitude'];
                $("#temp_F").html(temp_f+"&deg;F");
                $("#temp_C").html(temp_c+"&deg;C");
                $("#weather").html(weather);
                $("#city").html(city);
                $("#weathermapimage").css("background", "url(http://api.wunderground.com/api/ec7bfbb2962f4817/radar/image.gif?centerlat=42.364&centerlon=-71&radius=10&width=250&height=250&newmaps=1)");
                $("#weatherimage").css("background", "url(images/boston.jpg)");
                }
            }); 
            $.ajax({
                url : "http://api.wunderground.com/api/ec7bfbb2962f4817/geolookup/alerts/q/autoip.json",
                dataType : "jsonp",
                success : function(parsed_json) {
                var message = parsed_json['message'];

                $("#message").html(message);

                }
            });
           
            
            $("#gototop").hide();
            });
          
        
        