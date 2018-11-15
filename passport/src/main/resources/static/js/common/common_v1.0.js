
var base64 = new Base64();

$(document).ready(function(){
    $('#top').load("common/top_v1.0.html");
    $('#end').load("common/end_v1.0.html");
});

var commSuccess = "success";
var retSuccess = "000000";

/**
 * 校验组件为空
 * @param obj
 * @returns {boolean}
 */
function isEmpty(obj) {
    return null == obj;
}

/**
 * 验证枚举值是否为空
 * @param bool
 * @returns {boolean}
 */
function isEmptyBool(bool) {
    if(true == bool
        || false == bool
    ) {
        return false;
    }

    return true;
}

/**
 * 校验组件是否为空
 * @param str
 * @returns {boolean}
 */
function isEmptyStr(str) {
    if(isEmpty(str)
        || (typeof str) != "string"
        || 0 == str.length
    ) {
        return true;
    }

    return 0 == str.trim();
}

/**
 * 验证控件是否有内容
 * @param selector
 */
function verifyInput(selector) {
    if(isEmptyStr(selector)) {
        return false;
    }

    var empty = !isEmptyStr($(selector).val());
    // console.log($(id).val());
    setInputStatus(selector, empty);

    return empty;
}

/**
 * 设置输入组件校验状态
 * @param id
 * @param vaild
 */
function setInputStatus(selector, vaild) {

    if(isEmptyStr(selector)
        || isEmptyBool(vaild)
    ) {
        return;
    }

    var vaildClass = "is-valid";
    var inVaildClass = "is-invalid";
    var addClass, removeClass;

    if(vaild) {
        addClass = vaildClass;
        removeClass = inVaildClass;
    } else {
        addClass = inVaildClass;
        removeClass = vaildClass;
    }

    $(selector).removeClass(removeClass);
    $(selector).addClass(addClass);
}

function showInfo(selector, bool) {
    return showInfoEx(selector, bool, 300);
}

/**
 * 显示提示
 * @param selector
 * @param bool
 * @returns {boolean}
 */
function showInfoEx(selector, bool, time) {
    if(isEmptyStr(selector)
        || isEmptyBool(bool)
    ) {
        return false;
    }

    if(bool) {
        $(selector).show(time);
    } else {
        $(selector).hide(time);
    }

    return true;
}

/**
 * 设置提示信息
 * @param selector
 * @param info
 * @returns {boolean}
 */
function setInfo(selector, info) {
    if(isEmptyStr(selector)
        || isEmptyStr(info)
    ) {
        return false;
    }

    $(selector).html(info);
    return showInfo(selector, true);
}

/**
 * 是否为无效的json格式
 * @param data
 */
function isCommFailed(data) {

    if(null == data) {
        // console.log("data 为空！");
        return true;
    }

    if(null == data.head) {
        // console.log("data.head 为空！");
        return true;
    }

    if(null == data.head.status) {
        // console.log("data.head 为空！");
        return true;
    }

    return false;
}

/*
    post 通讯
    var postObj = $.post(
        "http://server.c332030.com:8080/VerifyLogin",
        {
            "username": username,
            "password": password
        },
        function (data, status) {
            postSubmit(data, status);
        },
        "json"
    );

    ajax post
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
            setInfo(loginErrorId, errorThrown);
        },
        dataType: "json"
    });
 */