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
	
	// This function checks if all fields are filled before enabling the sumit-Button.
	$( "#addNewLink input[type=text]" ).keyup( function() {
		if( fieldsAreFilled() ) {
			$("#addNewLink input.submitBtn").removeAttr('disabled').removeClass( 'ui-state-disabled' );
		}
	});
	
	// After showing the link-submit-area, the user can hide/close that area again by clicking on this button.
	// This will also show the "submit new link" button in the header again.
	$("#cancelSubmit").click( function() {
		hideAddLinkArea();
	} );
	
	
	$("#addNewLink input.submitBtn").click( function() {
		$("#addNewLink input[type=text]").val("");
		hideAddLinkArea();
	} );
	
	function hideAddLinkArea() {
		$("#addNewLink").hide();
		$("#addNewLinkBtn").show();
	}
	function showAddLinkArea() {
		$("#addNewLink").show();
		$("#addNewLinkBtn").hide();
	}
	function fieldsAreFilled() {
		// TODO: check if all fields are filled.
		var $emptyFields = $( "#addNewLink input[type=text]" ).filter(function() {
            return $.trim(this.value) === "";
        });
        return ( $emptyFields.length == 0 );
	}
});