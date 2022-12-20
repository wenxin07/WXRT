var n1=document.getElementById("username");
var n2=document.getElementById("username2");
var pwd=document.getElementById("password");
var pwd2=document.getElementById("password2");
var repwd=document.getElementById("comfirm_password");

n1.addEventListener("blur", checkn1);
    function checkn1() {
        let re = /[^a-zA-Z0-9@.]/;
        let sp = document.getElementById("idn1")
            if (n1.value == "") {
                n1.style.color = "red";
            } else if (re.test(n1.value)) {
                sp.innerHTML = "*";
                sp.style.color = "red";
            } else if (n1.value.indexOf('@') == -1) {
                sp.innerHTML = "*";
                sp.style.color = "red";
            } else if (n1.value.indexOf('.') == -1) {
                sp.innerHTML = "*";
                sp.style.color = "red";
            } else {
                sp.innerHTML = ""
            }

        }