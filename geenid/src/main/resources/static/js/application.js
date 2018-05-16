$( document ).ready(function() {
    //console.log( "ready!" );
    
    $("#add-button").on("click", function () {
        var name = $("#name").val();
        var email = $("#email").val();
        var birthyear = $("#birthyear").val();
        var competitions = $("#competitions").val();
        var url = "/lisa?name=" + name + "&email=" + email + "&birthyear=" + birthyear +
            "&competitions=" + competitions;

        console.log("url", url);
        $.get( url, function( data ) {
            //console.log("data", data);
            $(".add").append("<h3>" + data + "</h3>");
        });
    });

});

