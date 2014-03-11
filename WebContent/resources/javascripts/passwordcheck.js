function onLoad() {
		$("#password").keyup(checkPasswordMatch);
		$("#confirmpass").keyup(checkPasswordMatch);
		$("#details").submit(canSubmit);
	}

	function canSubmit() {
		var password = $("#password").val();
		var confirmation = $("#confirmpass").val();
		if (password != confirmation) {
			alert("passwords do not match");
			return false;
		}

		else
			return true;
	}
	function checkPasswordMatch() {
		var password = $("#password").val();
		var confirmation = $("#confirmpass").val();

		if (password.length > 3) {
			if (password==confirmation) {
				$("#matchpass").text("password match");
				$("#matchpass").addClass("valid");
				$("#matchpass").removeClass("error");
			} else {
				$("#matchpass").text("password does not match");
				$("#matchpass").addClass("error");
				$("#matchpass").removeClass("valid");
			}
		}

	}
	$(document).ready(onLoad);