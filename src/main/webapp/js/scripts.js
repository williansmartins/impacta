function getSuccessOutput() {
    $.ajax({
        url:'/despesas/todasDespesas',
        complete: function (response) {
            $('#output').html(response.responseText);
        },
        error: function () {
            $('#output').html('Ixi: there was an error!');
        },
    });
    return false;
}