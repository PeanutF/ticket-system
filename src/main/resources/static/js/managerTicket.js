$(document).ready(function () {
    var orderFormId = location.search.split("orderFormId=")[1];
    var jsonObj = new Object();
    jsonObj.orderFormId = orderFormId;
    $.get("/ticket/all",function (data) {
        showData(data);
    })
});


function showData(data){
    /*"ticketId": 1,
        "flightId": 1,
        "orderFormId": 1,
        "price": 1000,
        "discount": 1,
        "passengerName": "liu"*/
    for(var i = 0; i < data.length; i++){
        var tr = document.createElement("tr");
        var flightIdTd = document.createElement("td");
        flightIdTd.append(data[i].flightId);
        var priceTd = document.createElement("td");
        priceTd.append(data[i].price);
        var passengerName = document.createElement("td");
        passengerName.append(data[i].passengerName);
        var operateTd = document.createElement("td");
        var addA = document.createElement('a');
        addA.innerText = "修改";
        addA.href = "alterTicket.html?ticketId=" + data[i].ticketId;
        var delA = document.createElement('a');
        delA.innerText = "删除";
        delA.href = "#";
        operateTd.appendChild(addA);
        operateTd.append(" ");
        operateTd.appendChild(delA);
        tr.appendChild(flightIdTd);
        tr.appendChild(passengerName);
        tr.appendChild(priceTd);
        tr.appendChild(operateTd);
        $("#tbody-ticket").append(tr);
    }
}
