document.getElementById("get_data_button").addEventListener("click", function () {

    var amount = document.getElementById("amount_input").value;

    var args = [];
    var inputElements = document.getElementsByClassName('checkbox');
    for (var i = 0; inputElements[i]; ++i) {
        if (inputElements[i].checked) {
            args.push(inputElements[i].value);
        }
    }
    
    fetch("http://localhost:8084/SP5_ex5/api/data/" + amount + "/" + args, {method: "get"})
            .then(function (response) {
                return response.text();
            }).then(function (text) {
                var arr = JSON.parse(text);
                
                var table = document.getElementById("data_table");
                
                for (var i = 0; i < arr.length; i++) {
                    var data = arr[i];
                    var row = table.insertRow(i);
                    var index = 0;
                    for (var prop in data) {
                        row.insertCell(index).innerHTML = data[prop];
                        index++;
                    }
        }
                
    });
    
    
    

});