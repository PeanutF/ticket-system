$(document).ready(function () {

    //加载表格数据
    $.get("/flight/all",function (data) {
        for(var i = 0;i < data.length;i++){
            var tr = document.createElement('tr');
            //         "flightId": 1,
            //         "startTime": "2018-06-02T13:52:00.000+0000",
            //         "startCity": "北京",
            //         "endCity": "上海",
            //         "peopleNumber": 100,
            //         "leftTicket": 50,
            //         "ticketPrice": 1000
            var startTTd = document.createElement('td');
            startTTd.append(data[i].startTime);
            var startCTd = document.createElement('td');
            startCTd.append(data[i].startCity);
            var endCTd = document.createElement('td');
            endCTd.append(data[i].endCity);
            var leftTicketTd = document.createElement('td');
            leftTicketTd.append(data[i].leftTicket);
            var ticketPriceTd = document.createElement('td');
            ticketPriceTd.append(data[i].ticketPrice);
            tr.appendChild(startCTd);
            tr.appendChild(endCTd);
            tr.appendChild(startTTd);
            tr.appendChild(leftTicketTd);
            tr.appendChild(ticketPriceTd);
            var operateTd = document.createElement('td');
            var addA = document.createElement('a');
            addA.innerText = "修改";
            addA.href = "#";
            var delA = document.createElement('a');
            delA.innerText = "删除";
            delA.href = "#";
            operateTd.appendChild(addA);
            operateTd.append(" ");
            operateTd.appendChild(delA);
            tr.appendChild(operateTd);
            $("#tbody-flight").append(tr);
        }
    })
})