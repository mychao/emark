var siteUrl = "http://test.yuehetong.com";
var scriptsUrl = "http://s2.yuehetong.com";
var storage = null;
if (window.localStorage) {
    var storage = window.localStorage
}
function getLocalStorage(b) {
    var a = "";
    if (storage) {
        a = storage.getItem(b);
        if (a == null || a == "") {
            a = getCookie(b);
            storage.setItem(b, a)
        }
    } else {
        a = getCookie(b)
    }
    return a
}
function setLocalStorage(a, b) {
    if (storage) {
        storage.setItem(a, b)
    } else {
        ret = setCookie(a, b)
    }
}
function getCookie(b) {
    var a, c = new RegExp("(^| )" + b + "=([^;]*)(;|$)");
    if (a = document.cookie.match(c)) {
        return unescape(a[2])
    } else {
        return ""
    }
}
function setCookie(a, c) {
    var b = 30;
    var d = new Date();
    d.setTime(d.getTime() + b * 24 * 60 * 60 * 1000);
    document.cookie = a + "=" + escape(c) + ";expires=" + d.toGMTString() + ";path=/"
}
function isFuncExist(funcName) {
    try {
        if (typeof(eval(funcName)) == "function") {
            return true
        } else {
            return false
        }
    } catch (e) {
    }
    return false
}
var canLoginRegSubmit = true;
function switchToModal(a) {
    if (a == "reg") {
        $("#modalLogin").modal("hide");
        $("#modalReg").modal("show")
    } else {
        if (a == "login") {
            $("#modalReg").modal("hide");
            $("#modalLogin").modal("show")
        }
    }
}
function login() {
    if ($("#modalLogin .lblerr").length > 0) {
        return
    }
    if (!$("#modalLoginErr").is(":hidden")) {
        return
    }
    var a = $.trim($("#modal-login-name").val());
    var b = $.trim($("#modal-login-pwd").val());
    var d = true;
    if (a == "") {
        var c = "请输入邮箱/手机号/昵称";
        $("#modal-login-name").parent().append("<label class='lblerr'>" + c + "</label>");
        d = false
    }
    if (b == "") {
        var c = "请输入密码";
        $("#modal-login-pwd").parent().append("<label class='lblerr'>" + c + "</label>");
        d = false
    }
    if (d) {
        $.post("/account/check", {name: a, pwd: b, rmb: ($("#chk-rmb").prop("checked") ? 1 : 0)}, function (g) {
            if (g && g.r == 1) {
                hasLogin = true;
                var e = g.rdi;
                var f = window.location.href;
                if (isFuncExist("loginCallBack")) {
                    loginCallBack()
                } else {
                    if (getQueryString("rdi")) {
                        window.location.href = getQueryString("rdi")
                    } else {
                        if (e == "/" && f.indexOf("/account/login") < 0) {
                            window.location.reload()
                        } else {
                            window.location.href = e
                        }
                    }
                }
            } else {
                if (g.msg && g.msg != "") {
                    $("#modal-login-pwd").blur();
                    $("#modalLoginErrCont").html(g.msg);
                    $("#modalLoginErr").show()
                }
            }
        }, "json")
    }
}
function reg() {
    if ($("#modalReg .lblerr").length > 0) {
        return
    }
    if (!$("#modalRegErr").is(":hidden")) {
        return
    }
    var a = $.trim($("#modal-reg-name").val());
    var b = $.trim($("#modal-reg-pwd").val());
    var d = true;
    if (a == "") {
        var c = "请输入邮箱/手机号";
        $("#modal-reg-name").parent().append("<label class='lblerr'>" + c + "</label>");
        d = false
    }
    if (b == "") {
        var c = "请输入密码";
        $("#modal-reg-pwd").parent().append("<label class='lblerr'>" + c + "</label>");
        d = false
    } else {
        if (b.length < 6) {
            var c = "密码不足6位";
            $("#modal-reg-pwd").parent().append("<label class='lblerr'>" + c + "</label>");
            d = false
        }
    }
    if (d) {
        $.post("/account/reg", {
            name: a,
            pwd: b,
            pcode: $("#modal-reg-pcode").val(),
            captcha: $("#modal-reg-captcha").val()
        }, function (f) {
            if (f && f.r == 1) {
                if (f.hasSendMail == 1) {
                    var e = "<p>我们给您发送了验证邮件，请前往您的邮箱查收。</p>";
                    if (f.loginAddr && f.loginAddr != "") {
                        e += "<p style='text-align:center;'><a href='" + f.loginAddr + "' target='_blank' rel='nofollow' role='button' class='btn' id='btn-tomymail'>前往邮箱查收</a></p>"
                    }
                    $("#reg-succ-tips").html(e)
                } else {
                    window.location.reload()
                }
            } else {
                if (f.msg && f.msg != "") {
                    $("#modalRegErrCont").html(f.msg);
                    $("#modalRegErr").show()
                }
                if (f.nameerr && f.nameerr != "") {
                    $("#modal-reg-name").parent().append("<label class='lblerr'>" + f.nameerr + "</label>")
                }
                if (f.pwderr && f.pwderr != "") {
                    $("#modal-reg-pwd").parent().append("<label class='lblerr'>" + f.pwderr + "</label>")
                }
                $("#captcha-a").click()
            }
        }, "json")
    }
}
function resetLoginErr() {
    $(this).siblings().each(function () {
        if ($(this).hasClass("lblerr")) {
            $(this).remove()
        }
    });
    $("#modalLoginErr").hide();
    $("#modalLoginErrCont").html("");
    $("#modalRegErr").hide();
    $("#modalRegErrCont").html("");
    canLoginRegSubmit = true
}
var captchaPass = false;
function checkSameName() {
    var a = $.trim($("#modal-reg-name").val());
    if (a == "") {
        var b = "请输入邮箱/手机号";
        $("#modal-reg-name").parent().append("<label class='lblerr'>" + b + "</label>");
        canLoginRegSubmit = false
    } else {
        $.post("/account/checkSameName", {name: a}, function (c) {
            if (c && c.r == 1) {
                if (c.hasSame == 1) {
                    var d = "已存在";
                    $("#modal-reg-name").parent().append("<label class='lblerr'>" + d + "</label>");
                    canLoginRegSubmit = false
                } else {
                    if (c.hasSame == -1) {
                        var d = "邮箱/手机格式错误";
                        $("#modal-reg-name").parent().append("<label class='lblerr'>" + d + "</label>");
                        canLoginRegSubmit = false
                    } else {
                        if (isPhone(a)) {
                            if (captchaPass) {
                                $("#pcode-area").slideDown(300);
                                sendPCode("pcode-a", "modal-reg-name")
                            }
                        }
                    }
                }
            }
        }, "json")
    }
}
function checkCaptcha() {
    var a = $(this).val();
    if (a.length == 4) {
        $.post(scriptsUrl + "captcha/check", {captcha: a}, function (b) {
            if (b.r != 1) {
                $("#reg-captcha").append("<label class='lblerr' style='right:120px'>验证码出错</label>");
                $("#captcha-a").click();
                captchaPass = false
            } else {
                if (b.r == 1) {
                    captchaPass = true;
                    if (isPhone($.trim($("#modal-reg-name").val()))) {
                        $("#pcode-area").slideDown(300);
                        sendPCode("pcode-a", "modal-reg-name")
                    }
                }
            }
        }, "json")
    } else {
        $("#reg-captcha").append("<label class='lblerr' style='right:120px'>验证码出错</label>");
        captchaPass = false
    }
}
var sendCodeCounter = null;
var initSec = 60;
var isDelay = false;
function sendPCode(b, a) {
    if (!isDelay && captchaPass && isPhone($.trim($("#" + a).val()))) {
        $.post(scriptsUrl + "sendphonecode", {phone: $.trim($("#" + a).val())}, function (c) {
            if (c && c.r == 1) {
                isDelay = true;
                setSendBtStatus(b)
            }
        }, "json")
    }
}
function setSendBtStatus(a) {
    showMsg("短信验证码已经发送");
    $("#" + a).html("<span id='" + a + "-cd'>" + initSec + "</span> 秒后可以重新发送").prop("disabled", true);
    if (sendCodeCounter) {
        clearInterval(sendCodeCounter)
    }
    sendCodeCounter = setInterval("updateSendCounter('" + a + "')", 1000)
}
function updateSendCounter(a) {
    var b = parseInt($("#" + a + "-cd").html());
    if (b > 1) {
        $("#" + a + "-cd").html(--b)
    } else {
        isDelay = false;
        $("#" + a).html("发送验证码").prop("disabled", false)
    }
}
$(function () {
    $("#modal-reg-name").focus(resetLoginErr);
    $("#modal-reg-pwd").focus(resetLoginErr);
    $("#modal-login-name").focus(resetLoginErr);
    $("#modal-login-pwd").focus(resetLoginErr);
    $("#modal-reg-name").blur(checkSameName);
    $("#modal-reg-captcha").blur(checkCaptcha);
    $("#modal-reg-captcha").focus(function () {
        $("#reg-captcha .lblerr").remove()
    });
    $("#modalLogin").on("hide.bs.modal", function (a) {
        $("#modalLogin .form-group .lblerr").remove();
        $("#modalLogin .form-group input").val("");
        $("#modalLoginErr").hide();
        $("#modalLoginErrCont").html("");
        $("#alertLoginTips").hide();
        $("#alertLoginTipsCont").html("")
    });
    $("#modalReg").on("hide.bs.modal", function (a) {
        $("#modalReg .form-group .lblerr").remove();
        $("#modalReg .form-group input").val("");
        $("#modalRegErr").hide();
        $("#modalRegErrCont").html("");
        $("#pcode-area").hide()
    });
    $("#modalReg").on("show.bs.modal", function (a) {
        $("#captcha-a").click()
    });
    $("#modal-mail-addr").focus(resetMailErr);
    $("#modal-reg-name").keypress(function (a) {
        if (a.which == "13" || a.which == "9") {
            $("#modal-reg-pwd").focus().select();
            a.stopPropagation()
        }
    });
    $("#modal-reg-pwd").keypress(function (a) {
        if (a.which == "13") {
            reg()
        }
    });
    $("#modal-login-name").keypress(function (a) {
        if (a.which == "13" || a.which == "9") {
            $("#modal-login-pwd").focus().select();
            a.stopPropagation()
        }
    });
    $("#modal-login-pwd").keypress(function (a) {
        if (a.which == "13") {
            login()
        }
    });
    $(document).click(function (b) {
        if ($(window).width() > 990) {
            return
        }
        if (b.target && b.target.id == "nav-login-area") {
            return
        }
        var a = $("#nav-login-area");
        if (!a.is(":hidden")) {
            a.slideUp(300)
        }
    })
});
function showLogin() {
    $("#modalLogin").modal("show")
}
function toggleMore() {
    var a = $("#nav-login-area");
    if (a.is(":hidden")) {
        a.slideDown(300)
    } else {
        a.slideUp(300)
    }
}
function getRandomNum(a, c) {
    var d = c - a;
    var b = Math.random();
    return (a + Math.round(b * d))
}
$(function () {
    var a = parseInt(getLocalStorage("cmtidTipsCount"));
    if (isNaN(a) || a <= 0) {
        a = 1
    } else {
        a++
    }
    setLocalStorage("cmtidTipsCount", a);
    if (getCookie("cmtids") != "" && a <= 3) {
        $("#cmtidCountHref").attr("data-content", "您新建的合同都在这里.").popover().focus()
    }
});
function resetMailErr() {
    $("#modalMailErr").hide();
    $("#modalMailErrCont").html("")
}
function YueSendMail() {
    var a = $("#cmtid").val();
    if (a != "") {
        var b = $("#modal-mail-addr").val();
        var c = $("#modal-mail-msg").val();
        if (b != "") {
            if (b.indexOf("@") < 0) {
                $("#modalMailErrCont").html("发送地址有误，请检查");
                $("#modalMailErr").show()
            } else {
                $(".btn-mail").html("发送中...");
                $.post("/mail/send", {cmtid: a, addrs: b, msg: c}, function (d) {
                    if (d && d.r == 1) {
                        showMsg("邮件发送成功");
                        $("#modalMail").modal("hide")
                    } else {
                        if (d.msg != "") {
                            $("#modalMailErrCont").html(d.msg);
                            $("#modalMailErr").show()
                        }
                    }
                    $(".btn-mail").html("发送<i class='fa fa-share'></i>")
                }, "json")
            }
        } else {
            $("#modalMailErrCont").html("发送地址为空");
            $("#modalMailErr").show()
        }
    }
}
function saveToLocalZanList(a, d) {
    if (d == "") {
        return
    }
    var b = getLocalStorage(a);
    var c = b.split("|");
    for (i = 0; i < c.length; i++) {
        if (c[i] == d) {
            return
        }
    }
    c.push(d);
    c = $.grep(c, function (e) {
        return $.trim(e).length > 0
    });
    setLocalStorage(a, c.join("|"))
}
function addZan() {
    var b = $("#pid").val();
    if (!hasLogin) {
        var a = getLocalStorage("zanlist");
        if (a.indexOf(b) >= 0) {
            showMsg("您已经赞过了");
            return
        } else {
            saveToLocalZanList("zanlist", b)
        }
    }
    $.post("/contract/zan", {pid: b}, function (c) {
        if (c && c.r == 1) {
            var d = parseInt($("#zan-num").html());
            if (isNaN(d)) {
                d = 1
            } else {
                d++
            }
            $("#zan-num").html(d)
        } else {
            if (c.msg != "") {
                showMsg(c.msg)
            }
        }
    }, "json")
}
function addFav() {
    if (hasLogin) {
        $.post("/my/favorites/add", {pid: $("#pid").val()}, function (b) {
            if (b && b.r == 1) {
                var a = parseInt($("#zan-shou-num").html());
                if (isNaN(a)) {
                    a = 1
                } else {
                    a++
                }
                $("#zan-shou-num").html(a)
            } else {
                if (b.msg != "") {
                    showMsg(b.msg)
                }
            }
        }, "json")
    } else {
        $("#modalLogin").modal("show")
    }
}
function submitComment() {
    var a = $.trim($("#comment-txt").val());
    if (a.length == 0) {
        showMsg("评论内容不能为空")
    } else {
        $.post("/comment/add", {cont: a, name: $("#comment-txt-name").val(), pid: $("#pid").val()}, function (c) {
            if (c && c.r == 1) {
                var b = "<div class='comment-item'><div class='comment-avatar'><a href='#nogo' ><img src='/sitemedia/pics/avt.png'></a></div><div class='comment-body'><div class='comment-name'>" + c.nick + "</div><div class='comment-cont'>" + c.cont + "<p class='comment-tips'>(评论已成功发表，审核后将在此显示)</p></div></div></div>";
                $("#comment-outer").prepend(b)
            }
        }, "json")
    }
}
var queryDom = null;
$(function () {
    if ($("#search-key").length > 0) {
        queryDom = $("#search-key")
    }
    if (queryDom && queryDom.length > 0) {
        queryDom.keydown(function (a) {
            if (a.which == "13") {
                search()
            }
        });
        $("#query-sug-outer").width(queryDom.outerWidth());
        queryDom.bind("input propertychange", function () {
            getQuerySug($(this).attr("id"))
        })
    }
    $(".d-num").each(vibeNum)
});
function search() {
    var b = $.trim(queryDom.val());
    if (b != "") {
        var a = "/query/1/" + b;
        window.location.href = a
    }
}
var sugTimer = null;
var sugCountDown = 500;
var sugCurMark = 0;
var sugDomId = "";
function getQuerySug(a) {
    sugDomId = a;
    if (sugTimer) {
        clearTimeout(sugTimer)
    }
    sugTimer = setTimeout("getQuerySugAct()", sugCountDown)
}
function getQuerySugAct() {
    if (sugDomId == "") {
        return
    }
    var b = $.trim($("#" + sugDomId).val());
    if (b == "") {
        return
    }
    var a = Date.parse(new Date()) / 1000;
    sugCurMark = a;
    $.get("/query/suggest?wd=" + b + "&ts=" + sugCurMark, setQuerySug)
}
function setQuerySug(b) {
    if (b == "") {
        $("#query-sug-outer").css("left", "-1100px").html("");
        return
    }
    var a = "";
    var d = b.split("|");
    if (parseInt(d[0]) == sugCurMark) {
        a = d[1]
    } else {
        return
    }
    $("#query-sug-outer").html(a);
    var c = queryDom.offset().top + queryDom.outerHeight();
    $("#query-sug-outer").css("top", c + "px").css("left", queryDom.offset().left + "px").show();
    $(document).one("click", function () {
        $("#query-sug-outer").css("left", "-1100px").html("")
    })
}
var msgETA = 3 * 1000;
var msgTimer = null;
function hideMsg() {
    $("#msg_area").fadeOut(300);
    $("#msg_mask").hide()
}
function showMsg(b, a) {
    if (b != "") {
        if ($("#msg_area").length == 0) {
            $("body").append("<div id='msg_area'><span id='msg_cont'></span></div><div id='msg_mask'></div>");
            $("#msg_mask").click(hideMsg)
        }
        $("#msg_cont").html(b);
        $("#msg_mask").show();
        $("#msg_area").fadeIn(100);
        msgTimer = setTimeout(function () {
            hideMsg();
            if (typeof(a) === "function") {
                a()
            }
        }, msgETA)
    }
}
window.onresize = function () {
    if (typeof(chartArr) != "undefined" && chartArr.length > 0) {
        $("#chart-area").width($("#chart-area").parent().width() - 2);
        for (i = 0; i < chartArr.length; i++) {
            chartArr[i].resize()
        }
    }
    var b = $("#nav-login-area");
    var c = $("#top-main-menu");
    var a = $("#top-my-menu");
    if ($(window).width() > 990) {
        if (b.is(":hidden")) {
            b.show().css("display", "inline-block")
        } else {
            b.css("display", "inline-block")
        }
        c.show();
        a.hide()
    } else {
        b.hide();
        c.hide();
        a.show()
    }
    if (queryDom && queryDom.length > 0) {
        $("#query-sug-outer").width(queryDom.outerWidth());
        var d = queryDom.offset().top + queryDom.outerHeight();
        $("#query-sug-outer").css("top", d + "px").css("left", queryDom.offset().left + "px")
    }
};
$(document).scroll(function () {
    if ($(this).scrollTop() > 150) {
        $("#right-nav").fadeIn(300)
    } else {
        $("#right-nav").fadeOut(300)
    }
});
function toTop() {
    $("body,html").animate({scrollTop: 0}, 200)
}
function isEmail(c) {
    var a = false;
    var b = /^(\w-*\.*)+@(\w-?)+(\.\w{2,})+$/;
    if (b.test(c)) {
        a = true
    }
    return a
}
function isPhone(c) {
    var a = false;
    var b = /^1[345789]\d{9}$/;
    if (b.test(c)) {
        a = true
    }
    return a
}
function gblen(c) {
    var a = 0;
    for (var b = 0; b < c.length; b++) {
        if (c.charCodeAt(b) > 127 || c.charCodeAt(b) == 94) {
            a += 2
        } else {
            a++
        }
    }
    return a
}
function GetRandomNum(a, c) {
    var d = c - a;
    var b = Math.random();
    return (a + Math.round(b * d))
}
function getQueryString(a) {
    var b = new RegExp("(^|&)" + a + "=([^&]*)(&|$)", "i");
    var c = window.location.search.substr(1).match(b);
    if (c != null) {
        return unescape(c[2])
    }
    return null
}
$(function () {
    $("#agreeModalCont").height($(window).height() * 0.7)
});
var agreechk = $("#agreeChk");
function agreeToggle() {
    if (agreechk.hasClass("fa-square-o")) {
        agreechk.removeClass("fa-square-o").addClass("fa-check-square");
        $("#bt-create").prop("disabled", false)
    } else {
        agreechk.removeClass("fa-check-square").addClass("fa-square-o");
        $("#bt-create").prop("disabled", true)
    }
}
function loadUserAgree() {
    $("#agreeModal").modal("show")
}
function agreeModalAccept() {
    agreechk.removeClass("fa-square-o").addClass("fa-check-square");
    $("#bt-create").prop("disabled", false);
    $("#agreeModal").modal("hide");
    var a = $("#contract-maker");
    if (a.length > 0) {
        a.submit()
    } else {
        saveFormDIYCont()
    }
}
function agreeModalRefuse() {
    agreechk.removeClass("fa-check-square").addClass("fa-square-o");
    $("#bt-create").prop("disabled", true);
    $("#agreeModal").modal("hide")
}
function saveFormDIYCont() {
    if ($("#agreeChk").hasClass("fa-square-o")) {
        $("#agreeModal").modal("show");
        return
    }
    if ($("#bt-create").prop("disabled")) {
        return
    }
    var a = $.trim(UE.getEditor("cont").getContent());
    if (a == "") {
        showMsg("请输入内容");
        return
    }
    $.post("/form/save", {
        cont: a,
        cid: $("#contract_id").val(),
        pid: $("#pid").val(),
        ctitle: $("#contract_title").val()
    }, function (b) {
        if (b && b.r == 1) {
            cmtid = b.cmtid;
            showMsg("保存成功，正在跳转...", jumpToResult)
        } else {
            if (b.msg != "") {
                showMsg("保存失败，请检查后重试")
            }
        }
    }, "json")
}
function jumpToResult() {
    window.location.href = "/diy/view/" + cmtid
}
function submitDIY() {
    if (hasLogin) {
        if ($("#agreeChk").hasClass("fa-square-o")) {
            $("#agreeModal").modal("show")
        } else {
            $("#contract-maker").submit()
        }
    } else {
        $("#alertLoginTipsCont").html("悦合同温馨提示：请登录后使用该功能");
        $("#alertLoginTips").show();
        $("#modalLogin").modal("show")
    }
}
var vibeDelay = 80;
var nArr1 = new Array();
var nArr2 = new Array();
var nArr3 = new Array();
var countTime = 8;
function vibeNum() {
    var d = $(this);
    var c = $(this).attr("id");
    var e = parseInt(d.html());
    var b = c.substr(3);
    for (var a = 0; a < countTime; a++) {
        if (c == "num1") {
            nArr1[a] = GetRandomNum(100, e)
        } else {
            if (c == "num2") {
                nArr2[a] = GetRandomNum(100, e)
            } else {
                if (c == "num3") {
                    nArr3[a] = GetRandomNum(100, e)
                }
            }
        }
    }
    if (c == "num1") {
        nArr1[countTime] = e
    } else {
        if (c == "num2") {
            nArr2[countTime] = e
        } else {
            if (c == "num3") {
                nArr3[countTime] = e
            }
        }
    }
    setTimeout("vibeNumAct('" + c + "'," + b + ",0)", vibeDelay)
}
function vibeNumAct(g, f, b) {
    var a = 0;
    var h = 0;
    if (f == 1) {
        a = nArr1.length;
        h = nArr1[b]
    } else {
        if (f == 2) {
            a = nArr2.length;
            h = nArr2[b]
        } else {
            if (f == 3) {
                a = nArr3.length;
                h = nArr3[b]
            }
        }
    }
    var c = h;
    if (c > 0) {
        var e = "";
        while (c > 0) {
            var d = c % 10;
            e = "<i>" + d + "</i>" + e;
            c = parseInt(c / 10)
        }
        $("#" + g).html(e)
    }
    if (b <= a) {
        b++;
        setTimeout("vibeNumAct('" + g + "'," + f + "," + b + ")", vibeDelay)
    }
}
var touliScrollLimit = 5;
var touliInterval = 3500;
var toulitimer = null;
$(function () {
    if ($("#tou-index-ul").length > 0) {
        var b = $("#tou-index-ul");
        var a = b.children();
        if (a.length > touliScrollLimit) {
            toulitimer = setInterval("scrollTouLi()", touliInterval);
            $("#tou-index-ul").hover(function () {
                if (toulitimer) {
                    clearInterval(toulitimer)
                }
            }, function () {
                toulitimer = setInterval("scrollTouLi()", touliInterval)
            })
        }
    }
});
function scrollTouLi() {
    var a = $("#tou-index-ul>li:last-child");
    lasLiDom = a.remove();
    lasLiDom.css("display", "none");
    $("#tou-index-ul").prepend(lasLiDom);
    lasLiDom.slideDown(350)
};