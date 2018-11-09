
var loadingModal = "#loadingModal";

function showLoad(bool) {

    if(bool) {
        $(loadingModal).modal({backdrop: 'static', keyboard: false});
        return;
    }

    setTimeout(function () {
        $(loadingModal).modal('hide');
    }, 500);
}