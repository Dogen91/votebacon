$( document ).ready(function() {
	//////////////////////////////////////////////////////////////
	// Overview
	//////////////////////////////////////////////////////////////
	// On start, disable the link-submit-button as well as the registration-submit-button
	$("#addNewLink input.submitBtn").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
	$(".submitRegistration").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
	
	// Show add-link area on btn-Click
	$("#addNewLinkBtn").click( function() {
		showAddLinkArea();
	} );
	
	// Show register area on btn-Click
	$("#registerBtn").click( function() {
		showRegisterArea();
	} );
	
	// This function checks if all fields are filled before enabling the sumit-Button.
	$( "#addNewLink input[type=text]" ).keyup( function() {
		if( fieldsAreFilled( "addNewLink" ) ) {
			$("#addNewLink input.submitBtn").removeAttr('disabled').removeClass( 'ui-state-disabled' );
		} else {
			$("#addNewLink input.submitBtn").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
		}
	});
	
	// After showing the link-submit-area, the user can hide/close that area again by clicking on this button.
	// This will also show the "submit new link" button in the header again.
	$("#cancelSubmit").click( function() {
		hideAddLinkArea();
	} );
	
	// Hide the Register area on click on the cancel-Button
	$("#cancelRegister").click( function() {
		hideRegisterArea();
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
	function hideRegisterArea() {
		$("#register").hide();
	}
	function showRegisterArea() {
		$("#register").show();
	}
	// checks if all textFields in a container contain text.
	function fieldsAreFilled( container ) {
		var $emptyFields = $( "#"+ container +" input[type=text]" ).filter(function() {
            return $.trim(this.value) === "";
        });
        return ( $emptyFields.length == 0 );
	}
	
	// enable button again when all fields are filled and the passwords match. TODO: doesn't work with inputsecrets...
	$( "#register input[type=password]" ).keyup( function() {
		if( fieldsAreFilled( "register" ) && $("#register .password").val() == $("#register .confirmPassword").val() && $("#register .confirmPassword").val() != ""  ) {
			$(".submitRegistration").removeAttr('disabled').removeClass( 'ui-state-disabled' );
		} else {
			$(".submitRegistration").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
		}
	});
	
	//////////////////////////////////////////////////////////////
	// Detail
	//////////////////////////////////////////////////////////////
	// disable submitButton and empty the textarea on start
	$(".submitComment").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
	$( "#commentForm textarea" ).val("");
	
	// enable/disable submitButton depending on the content of the textArea
	$( "#commentForm textarea" ).keyup( function() {
		if( $(this).val() != "" ) {
			$(".submitComment").removeAttr('disabled').removeClass( 'ui-state-disabled' );
		} else {
			$(".submitComment").attr('disabled', 'disabled' ).addClass( 'ui-state-disabled' );
		}
	});
});