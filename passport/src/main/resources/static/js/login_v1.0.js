
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

var loginAId = "#loginA"; // 登录文字
var redistryAId = "#registryA"; // 注册文字

var usernameId = "#usernameInput"; // 用户名

var verifyCodeInputId = "#verifyCodeInput"; // 验证码
var verifyCodeInputDiv = "#verifyCodeInputDiv";

var passwordId = "#passwordInput"; // 密码

var passwordId2 = "#passwordInput2"; // 二次密码
var passwordDivId2 = "#passwordDiv2"; // 二次密码 Div


var alertSuccessId = "#alertSuccess"; // 警告 Div
var alertWarnId = "#alertWarn"; // 警告 Div
var alertErrorId = "#alertError"; // 错误 Div

var rememberDivId = "#rememberDiv"; // 记住我 div
var rememberInputId = "#rememberInput"; // 记住我 input

var verifyButText = '获取验证码';

var verifyButId = "#verifyCodeBut"; // 验证码按钮
var submitButId = "#submitBut"; // 按钮


var onfocusClass = "a-onfocus";
// var onblurClass = "a-onblur";

var loginText = "登录";
var registryText = "注册";


$(document).ready(function(){

    $(usernameId).val("c332030");
    $(passwordId).val("余巧玲");

    $("#loadingDiv").load("common/loading_v1.0.html");

    showInfoEx(alertSuccessId, false, 0);
    showInfoEx(alertWarnId, false, 0);
    showInfoEx(alertErrorId, false, 0);

    $(verifyCodeInputDiv).hide();
    $(passwordDivId2).hide();
});

function hideInfo() {
    showInfoEx(alertSuccessId, false);
    showInfoEx(alertWarnId, false);
    showInfoEx(alertErrorId, false);
}

/* 输入动作 */
function onFocus(id) {
    hideInfo();

    $(id).addClass(onfocusClass);
}

function onBlur(id) {
    $(id).removeClass(onfocusClass);
}

/* 鼠标事件 */
$(function () {
    $(loginAId).focus(function () {

        onFocus(loginAId);
        onBlur(redistryAId);

        $(verifyCodeInputDiv).hide();
        $(rememberDivId).show();
        $(passwordDivId2).hide();
        $(submitButId).html(loginText);
    });

    $(redistryAId).focus(function () {

        onFocus(redistryAId);
        onBlur(loginAId);

        $(passwordDivId2).show();
        $(rememberDivId).hide();
        $(submitButId).html(registryText);
    });
});

/* 设置提示信息 */
function loginSetInfo(id, info) {

    setInfo(id, info);
    showLoad(false);
}

/**
 * 用户名是否为手机
 * @param phone
 * @returns {boolean}
 */
function isPhone(phone) {
    if(isEmptyStr(phone)) {
        return false;
    }

    if(11 != phone.length) {
        // console.log("手机号位数不符！");
        return false;
    }

    // console.log("测试是否为手机注册！");
    var reg = /^[0-9]*$/;
    return reg.test(phone);
}

/**
 * 用户名是否为邮箱
 * @param email
 * @returns {boolean}
 */
function isEMail(email) {
    if(isEmptyStr(email)) {
        return false;
    }

    var strs = email.split('@');
    if(2 != strs.length
        || '' == strs[0]
        || '' == strs[1]
    ) {
        // console.log("数组长度不为2！");
        return false;
    }

    // console.log("strs[0]= " + strs[0]);
    // console.log("strs[1]= " + strs[1]);

    var strs2 = strs[1].split('.');

    if(2 > strs2.length
            || '' == strs2[0]
            || '' == strs2[1]
    ) {
        // console.log("数组长度小于2！");
        return false;
    }

    // console.log("strs2[0]= " + strs2[0]);
    // console.log("strs2[1]= " + strs2[1]);

    // console.log("邮箱注册！");
    return true;
}

/**
 * 是否为注册
 * @returns {boolean}
 */
function isRegistry() {
    return registryText == $(submitButId).html();
}

/**
 * 验证注册时的用户名
 * @returns {boolean}
 */
function verifyRegUsername() {
    if(!isRegistry()) {
        verifyInput(usernameId);
        return false;
    }
    hideInfo();

    var username = $(usernameId).val();
    var isphone = isPhone(username);
    var isemail = isEMail(username);

    if(!isphone && !isemail) {
        setInputStatus(usernameId, false);
        setInfo(alertWarnId, "只支持手机号/邮箱注册");
        return false;
    }

    return true;
}

/**
 * 验证重复输入的密码
 * @returns {boolean}
 */
function verifyPassword2() {
    hideInfo();

    var isVaild = !isEmptyStr($(passwordId2).val());

    if(isVaild) {
        isVaild = $(passwordId).val() == $(passwordId2).val();

        if(!isVaild) {
            setInfo(alertWarnId, "两次密码输入不一致！");
        }
    } else {
        setInfo(alertWarnId, "请再输入一遍密码！");
    }

    setInputStatus(passwordId2, isVaild);
    return isVaild;
}

/* 登录逻辑 */
$(function () {

    $(usernameId).focus(function () {
        if(isRegistry()) {
            $(verifyCodeInputDiv).show(300);
        }
    });

    $(usernameId).blur(function () {
        if(isRegistry()) {
            setInputStatus(usernameId, verifyRegUsername());
            return;
        }

        verifyInput(usernameId);
    });

    $(passwordId).blur(function () {
        verifyInput(passwordId);
    });

    $(passwordId2).blur(function () {
        verifyPassword2();
    });
});

/**
 * 通讯失败逻辑
 * @param data
 * @returns {boolean}
 */
function isCommFailedEx(data) {

    if(isCommFailed(data)) {
        return true;
    }

    var retcode = data.head.status.retCode;
    if (retSuccess != retcode) {

        loginSetInfo(alertErrorId, '操作失败，' + retcode + '： ' + data.head.status.retMsg);
        return true;
    }

    return false;
}

/**
 * 通讯失败处理
 * @param XMLHttpRequest
 * @param status
 * @param errorThrown
 */
function commFail(XMLHttpRequest, status, errorThrown) {
    showLoad(false);

    console.log(XMLHttpRequest);
    // console.log(status);
    // console.log(errorThrown);
    loginSetInfo(alertErrorId,
        XMLHttpRequest.status
        + '：'
        + XMLHttpRequest.statusText
    );
}

var restTime = 0;
var interval;
function showRestTime() {

    if(0 >= restTime) {
        $(verifyButId).html(verifyButText);
        $(verifyButId).attr("disabled", false);
        clearInterval(interval);
        return;
    }

    $(verifyButId).html((restTime--) + "秒后重试");
}

/**
 * 验证码
 */
$(function () {

    /**
     * 发送验证码
     */
    $(verifyButId).click(function () {
        hideInfo();
        showLoad(true);

        // console.log("发送验证码");

        if(!verifyRegUsername()) {
            showLoad(false);
            return;
        }

        var username = $(usernameId).val().trim();

        $.ajax({
            type: "POST",
            url: "SendVerifyCode" ,
            data: {
                "username": base64.encode(username)
            },
            success: function(data, status, XMLHttpRequest){
                if(isCommFailedEx(data)) {
                    showLoad(false);
                    return;
                }

                setInfo(alertSuccessId, "验证码发送成功！");
                showLoad(false);

                restTime = data.body.WaitingTime;
                interval = setInterval(showRestTime, 1000);
                $(verifyButId).attr("disabled", true);
            },
            error: function (XMLHttpRequest, status, errorThrown) {
                commFail(XMLHttpRequest, status, errorThrown);
            },
            dataType: "json"
        });
    });

    /**
     * 校验验证码
     */
    $(verifyCodeInputId).blur(function () {
        hideInfo();

        var username = $(usernameId).val().trim();
        var verifyCode = $(verifyCodeInputId).val();

        if(isEmptyStr(verifyCode)) {
            setInputStatus(verifyCodeInputId, false);
            setInfo(alertWarnId, "验证码错误！");
            showLoad(false);
            return;
        }

        showLoad(true);

        $.ajax({
            type: "POST",
            url: "VerifyCode",
            data: {
                "username": base64.encode(username),
                "code": base64.encode(verifyCode)
            },
            success: function(data, status, XMLHttpRequest){
                if(isCommFailedEx(data)) {
                    showLoad(false);
                    return;
                }

                setInfo(alertSuccessId, "验证码验证成功！");
                setInputStatus(verifyCodeInputId, true);
                showLoad(false);
            },
            error: function (XMLHttpRequest, status, errorThrown) {
                commFail(XMLHttpRequest, status, errorThrown);
            },
            dataType: "json"
        });
    });
});

/* 通讯 */
$(function () {

    /**
     * 登录注册
     */
    $(submitButId).click(function () {

        hideInfo();

        var isReg = isRegistry();

        var username = $(usernameId).val().trim();
        var password = $(passwordId).val().trim();
        var password2 = $(passwordId2).val().trim();

        // console.log("username: " + username);
        // console.log("password: " + password);

        if (isEmptyStr(username)) {
            setInfo(alertErrorId, "请输入用户名！");
            return;
        }

        if (isEmptyStr(password)) {
            setInfo(alertErrorId, "请输入密码！");
            return;
        }

        if(isReg
            && isEmptyStr(password2)
            ) {
            return;
        }

        var jsonData = {
            'username': base64.encode(username),
            'password': base64.encode(hex_md5(password))
        };

        if(isReg) {
            var code = $(verifyCodeInputId).val();
            if(isEmptyStr(code)) {
                setInfo(alertErrorId, "请输入验证码！");
                return;
            }

            jsonData['code'] = base64.encode(code);
        }

        showLoad(true);
        $.ajax({
            type: "POST",
            url: isReg ? "Registry" : "VerifyLogin",
            data: jsonData,
            success: function(data, status, XMLHttpRequest){
                postSubmit(data, status);
            },
            error: function (XMLHttpRequest, status, errorThrown) {
                commFail(XMLHttpRequest, status, errorThrown);
            },
            dataType: "json"
        });
    });

    function postSubmit(data, status) {
        showLoad(false);

        if(isCommFailedEx(data)) {
            return false;
        }

        if(isRegistry()) {
            setInfo(alertSuccessId, "注册成功！");

            setTimeout(function () {
                location.reload(true);
            }, 3000);
            return true;
        }

        if(null == data.body) {
            console.log("data.body 为空！");
            return false;
        }

        var url = data.body.url;
        if(isEmptyStr(url)) {
            loginSetInfo(alertErrorId, '未获取到链接地址！');
            return false;
        }

        location = url;
        return true;
    }
});