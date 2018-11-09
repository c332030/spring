
/*
var b = new Base64();
var str = b.encode("88714480");
console.log("base64 encode:\n" + str);

str = b.decode(str);
console.log("base64 decode:\n" + str);


var md5v = hex_md5("88714480");
console.log("md5:\n" + md5v);
console.log("md5v:\n" + md5v.length + "\n");

var sha256v = sha256_digest("88714480");
console.log("sha256:\n" + sha256v);
console.log("sha256:\n" + sha256v.length + "\n");

console.log("IDNO:\n" + "".length + "\n");
*/

var loginWarnId = "#loginWarn";
var loginErrorId = "#loginError";

var usernameId = "#usernameInput";
var passwordId = "#passwordInput";
var submitButId = "#submitBut";

function loginSetInfo(id, info) {

    setInfo(id, info);
    showLoad(false);
}

$(document).ready(function(){
    $("#loadingDiv").load("common/loading_v1.0.html");

    showInfoEx(loginWarnId, false, 0);
    showInfoEx(loginErrorId, false, 0);
});

$(function () {
    $(usernameId).val("c332030");
    $(passwordId).val("余巧玲");

    $(usernameId).blur(function () {
        verifyInput(usernameId);
    });

    $(passwordId).blur(function () {
        verifyInput(passwordId);
    });

    $(submitButId).click(function () {

        showLoad(true);

        showInfo(loginWarnId, false, 0);
        showInfo(loginErrorId, false);

        var username = $(usernameId).val().trim();
        var password = $(passwordId).val().trim();

        // console.log("username: " + username);
        // console.log("password: " + password);

        if (null == username
            || 0 == username.length
        ) {
            loginSetInfo(loginErrorId, "请输入用户名！");
            return;
        }

        if (null == password
            || 0 == username.length
        ) {
            loginSetInfo(loginErrorId, "请输入密码！");
            return;
        }

        var base64 = new Base64();
        username = base64.encode(username);

        password = base64.encode(hex_md5(password));

        // console.log("password: " + password);

        $.ajax({
            type: "POST",
            url: "VerifyLogin",
            data: {
                "username": username,
                "password": password
            },
            success: function(data, status, XMLHttpRequest){
                postSubmit(data, status);
            },
            error: function (XMLHttpRequest, status, errorThrown) {
                console.log(XMLHttpRequest);
                // console.log(status);
                // console.log(errorThrown);
                loginSetInfo(loginErrorId,
                    XMLHttpRequest.status
                    + '：'
                    + XMLHttpRequest.statusText
                );
                // loginSetInfo(loginErrorId, "操作失败，请确认站点可用并检查网络连接！");
            },
            dataType: "json"
        });
    });

    function postSubmit(data, status) {

        var retcode = data.head.status.retCode;
        if (retSuccess != retcode) {

            loginSetInfo(loginErrorId, '操作失败，' + retcode + '： ' + data.head.status.retMsg);
            return;
        }

        showLoad(false);
        var url = data.body.url;
        if(isEmptyStr(url)) {
            loginSetInfo(loginErrorId, '未获取到链接地址！');
            return;
        }

        location = url;
    }
});