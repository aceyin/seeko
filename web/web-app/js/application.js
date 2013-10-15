// main javascript based on bootstrap and jquery
var RepositoryController = {
    // create repository
    create: function () {

    }
}

var ProjectController = {
    init: function () {
        $('#create-project-link').magnificPopup({
            type: 'ajax'
        });

        $('#save-project-link').click(function () {
            ProjectController.save();
        });

        $('.add-repository-link').magnificPopup({
            type: 'ajax'
        });
    },
    save: function () {
        var resultElmt = $("#projectCreationResult");
        $.post("/project/save", $("#projectCreationForm").serialize())
            .success(function (data) {
                resultElmt.innerHTML = data;
            })
            .error(function (data) {
                resultElmt.innerHTML = "Something error";
            });
    }
}