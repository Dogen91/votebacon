$( document ).ready(function() {
	$("#addNewLink input.submitBtn").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
	
	
	// Show add-link area on btn-Click
	$("#addNewLinkBtn").click( function() {
		showAddLinkArea();
	} );
	
	// Show register area on btn-Click
	$("#registerBtn").click( function() {
		$("#register").show();
	} );
	
	$( "#addNewLink input[type=text]" ).keyup(function() {
		if( fieldsAreFilled() ) {
			$("#addNewLink input.submitBtn").removeAttr('disabled').removeClass( 'ui-state-disabled' );
		}
	});
	
	$("#addNewLink input.submitBtn").click( function() {
		$("#addNewLink input[type=text]").val("");
		hideAddLinkArea();
	} );
	
	function hideAddLinkArea() {
		$("#addNewLink").hide();
	}
	function showAddLinkArea() {
		$("#addNewLink").show();
	}
	function fieldsAreFilled() {
		// TODO: check if all fields are filled.
		var $emptyFields = $( "#addNewLink input[type=text]" ).filter(function() {
            return $.trim(this.value) === "";
        });
        return ( $emptyFields.length == 0 );
	}
});