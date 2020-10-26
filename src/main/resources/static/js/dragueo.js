function showPrint(time) {
    $('#entryLeft').html('-');
    $('#entryRight').html('-');
    $('#treespeedLeft').html('-');
    $('#treespeedRight').html('-');
    $('#dialinLeft').html('-');
    $('#dialinRight').html('-');
    $('#reactionLeft').html('-');
    $('#reactionRight').html('-');
    $('#ft60Left').html('-');
    $('#ft60Right').html('-');
    $('#ft330Left').html('-');
    $('#ft330Right').html('-');
    $('#ft660Left').html('-');
    $('#ft660Right').html('-');
    $('#mph1Left').html('-');
    $('#mph1Right').html('-');
    $('#ft1320Left').html('-');
    $('#ft1320Right').html('-');
    $('#mphLeft').html('-');
    $('#mphRight').html('-');
    $('#firstLeft').html('-');
    $('#firstRight').html('-');
    $('#statusLeft').html('-');
    $('#statusRight').html('-');
    $('#winnerLeft').html('-');
    $('#winnerRight').html('-');
    $('#driverLeft').html('-');
    $('#driverRight').html('-');
    $('#flagLeft').removeAttr('src');
    $('#flagRight').removeAttr('src');
    $('#flagLeft').hide();
    $('#flagRight').hide();

    var url="/api/v1/dragtree/time/" + time.id;

    $.getJSON(url, function(time) {
        $('#entryLeft').html(time.entryLeft);
        $('#entryRight').html(time.entryRight);
        $('#treespeedLeft').html(time.treespeedLeft);
        $('#treespeedRight').html(time.treespeedRight);
        $('#dialinLeft').html(time.dialinLeft);
        $('#dialinRight').html(time.dialinRight);
        $('#reactionLeft').html(time.reactionLeft);
        $('#reactionRight').html(time.reactionRight);
        $('#ft60Left').html(time.ft60Left);
        $('#ft60Right').html(time.ft60Right);
        $('#ft330Left').html(time.ft330Left);
        $('#ft330Right').html(time.ft330Right);
        $('#ft660Left').html(time.ft660Left);
        $('#ft660Right').html(time.ft660Right);
        $('#mph1Left').html(time.mph1Left);
        $('#mph1Right').html(time.mph1Right);
        $('#ft1320Left').html(time.ft1320Left);
        $('#ft1320Right').html(time.ft1320Right);
        $('#mphLeft').html(time.mphLeft);
        $('#mphRight').html(time.mphRight);
        $('#firstLeft').html(time.firstLeft);
        $('#firstRight').html(time.firstRight);
        $('#statusLeft').html(time.statusLeft);
        $('#statusRight').html(time.statusRight);

        if(time.firstLeft) {
                $('#winnerLeft').html('WINNER');
        }else if(time.firstRight) {
                $('#winnerRight').html('WINNER');
        }else if(time.statusRight) {
                $('#winnerLeft').html('WINNER');
        }else if(time.statusLeft) {
                $('#winnerRight').html('WINNER');
        }

        if(time.driverLeft) {
                $('#driverLeft').html((time.driverLeft||'') + '<br>' + (time.carLeft||''));
        }

        if(time.driverRight) {
                $('#driverRight').html((time.driverRight||'') + '<br>' + (time.carRight||''));
        }

        if(time.countryLeft) {
                $('#flagLeft').attr('src','/images/flags/' + time.countryLeft + '.png');
                $('#flagLeft').show();
        }

        if(time.countryRight) {
                $('#flagRight').attr('src','/images/flags/' + time.countryRight + '.png');
                $('#flagRight').show();
        }
    });

	$('#print').modal('show');
}

$("#search").on("keyup", function() {
	var value = $(this).val();
        var l;
        $("#times tr").each(function(index) {
        	$row = $(this);
            var id = $row.find("td").eq(1).text().toLowerCase();
            var current = $row.attr("id");
            if (id.indexOf(value.toLowerCase()) == -1 && l != current){
        	   $("#times").find("[id='" + current + "']").hide();
            }else{
                $("#times").find("[id='" + current + "']").show();
                l = current;
        	}
        });
});