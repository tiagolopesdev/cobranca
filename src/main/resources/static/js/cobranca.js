$('#confirmacaoExclusao').on('show.bs.modal', function (event) {

    var button = $(event.relatedTarget);

    var codigoTitulo = button.data('codigo');
    var descricaoTitulo = button.data('descricao');

    var modal = $(this);
    var form = modal.find('form');
    var action = form.data('url-base');

    if (!action.endsWith('/')) {
        action += '/';
    }
    form.attr('action', action + codigoTitulo);

    modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + descricaoTitulo + '</strong>?');

});

$(function () {

    $('[rel="tooltip"]').tooltip('show').tooltip('toggle');

    $('#valor').maskMoney({
        decimal: ',',
        thousands: '.',
        allowZero: true
    });
    
    $('#valorTotal').mask('#.##0,00', {reverse: true});

    $('.js-status').on('click', function (event) {
        event.preventDefault();

        var buttonSet = $(event.currentTarget);
        var urlSet = buttonSet.attr('href');

        var response = $.ajax({
            url: urlSet,
            type: 'PUT'
        });

        response.done(function (e) {
            var codigoTitulo = buttonSet.data('codigo');
            $('[data-role=' + codigoTitulo + ']').html('<span class="badge badge-pill badge-success">' + e + '</span>');
            var codigoTitulo = buttonSet.hide();
        });

        response.fail(function (e) {
            console.log(e);
            alert("Erro recebendo cobrança!");
        });

    });

});