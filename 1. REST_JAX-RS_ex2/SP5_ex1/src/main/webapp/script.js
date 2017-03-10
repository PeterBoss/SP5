window.addEventListener("load", function () {
    fetch("http://localhost:8084/SP5_ex2/api/person/", {method: "GET"})
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