function validatePhoneNumber(inputtxt) {
			
				if(libphonenumber.isValidNumber(inputtxt.value, 'UA')){
					console.log(true)
				}
				else{
					 alert("Not a valid Phone Number");
					return false;
				}
			}