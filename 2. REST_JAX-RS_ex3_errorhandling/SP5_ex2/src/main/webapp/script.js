window.addEventListener("load", getNewQuote);

document.getElementById("new_quote_button").addEventListener("click", getNewQuote);

var dropdown = document.getElementById("quote_action_dropdown");

dropdown.addEventListener("change", function (evt) {
    var selectedAction = dropdown[dropdown.selectedIndex].text;
    
    switch (selectedAction) {
        case "Create" :
            document.getElementById("quote_action_input").disabled = false;
            break;
        case "Edit" :
            document.getElementById("quote_action_input").disabled = false;
            break;
        case "Delete" :
            document.getElementById("quote_action_input").disabled = true;
            break;
        default :
            alert("Something went wrong");
    }
});

document.getElementById("quote_action_button").addEventListener("click", function (evt) {

    var selectedAction = dropdown[dropdown.selectedIndex].text;

    switch (selectedAction) {
        case "Create" :
            var quoteInput = document.getElementById("quote_action_input").value;
            fetch("./api/quote/", {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json'},
                method: "post",
                body: JSON.stringify({quote: quoteInput})
            }).then(function (response) {
                return response.text();
            }).then(function (text) {
                console.log(text);
            });
            break;
        case "Edit" :
            //get currently displayed quote and replace with this
            alert("Not yet implemented");
            break;

        case "Delete" :
            //delete displayed quote. 
            alert("Not yet implemented");
            break;

        default :
            alert("Something went wrong");
    }
});

function getNewQuote() {
    fetch("./api/quote/random/", {method: "get"})
            .then(function (response) {
                return response.text();
            }).then(function (text) {
        document.getElementById("quote_div").innerText = JSON.parse(text).quote;
    });
}
