
<html>
<head>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="jquery-ui-1.9.0.custom.min.js"></script>
<script type="text/javascript">
$("#product li").draggable({

    // brings the item back to its place when dragging is over
    revert:true,

    // once the dragging starts, we decrease the opactiy of other items
    // Appending a class as we do that with CSS
    drag:function () {
        $(this).addClass("active");
        $(this).closest("#product").addClass("active");
    },

    // removing the CSS classes once dragging is over.
    stop:function () {
        $(this).removeClass("active").closest("#product").removeClass("active");
    }
});


// jQuery UI Droppable
$(".basket").droppable({

    // The class that will be appended to the to-be-dropped-element (basket)
    activeClass:"active",

    // The class that will be appended once we are hovering the to-be-dropped-element (basket)
    hoverClass:"hover",

    // The acceptance of the item once it touches the to-be-dropped-element basket
    // For different values http://api.jqueryui.com/droppable/#option-tolerance
    tolerance:"touch",
    drop:function (event, ui) {

        var basket = $(this),
                move = ui.draggable,
                itemId = basket.find("ul li[data-id='" + move.attr("data-id") + "']");

        // To increase the value by +1 if the same item is already in the basket
        if (itemId.html() != null) {
            itemId.find("input").val(parseInt(itemId.find("input").val()) + 1);
        }
        else {
            // Add the dragged item to the basket
            addBasket(basket, move);

            // Updating the quantity by +1" rather than adding it to the basket
            move.find("input").val(parseInt(move.find("input").val()) + 1);
        }
    }
});



function addBasket(basket, move) {
    basket.find("ul").append('<li data-id="' + move.attr("data-id") + '">'
            + '<span class="name">' + move.find("h3").html() + '</span>'
            + '<input class="count" value="1" type="text">'
            + '<button class="delete">X</button>');
}


$(".basket ul li button.delete").live("click", function () {
    $(this).closest("li").remove();
});


</script>
</head>
<body>
<h2>Contact Manager</h2>
<section id="product">
    <ul class="clear">
        <li data-id="1">
            <a href="#">
                <img src="http://lorempixel.com/150/100/technics/1/" alt="">
                <h3>Product name</h3>
                <p>Product detail</p>
            </a>
        </li>
        <li data-id="2">...</li>
        <li data-id="3">...</li>
    </ul>
</section>


<aside id="sidebar">
    <div class="basket">
        <div class="basket_list">
            <div class="head">
                <span class="name">Product name</span>
                <span class="count">Quantity</span>
            </div>
            <ul>
            </ul>
        </div>
    </div>
</aside>
</body>
</html>
