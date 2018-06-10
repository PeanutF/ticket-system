$(document).ready(function () {
    $("#login-btn").click(function () {
        var name = $("#name").val();
        var pwd = $("#pwd").val();
        var jsonObj = new Object();
        jsonObj.username = name;
        jsonObj.password = pwd;
        $.ajax({
            url:"/user",
            data:JSON.stringify(jsonObj),
            type:"POST",
            contentType:"application/json; charset=utf-8",
            success:function () {
                alert("aa");
                $.cookie('username',name);
                window.location.href="/showForm.html";
            }
        });
        //这里的post地址是本地的，记得后面修改
    })
})