<!-- bootstrap modal div -->
<div class="modal fade" id="${modal_id}" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"
                        aria-hidden="true">&times;</button>
                <h4 class="modal-title">${modal_title}</h4>
            </div>

            <!-- modal content display here -->
            <div class="modal-body">
            </div>

            <div class="modal-footer">
                <button type="button" class="btn btn-default"
                        data-dismiss="modal"><g:message
                        code="seeko.lables.close"/></button>
                <button type="button" class="btn btn-primary"><g:message
                        code="seeko.lables.save"/></button>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<!-- end bootstrap modal div -->