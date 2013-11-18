// main javascript based on bootstrap and jquery
var ProjectController = {
    init: function () {
        $('#create-project-link').magnificPopup({
            type: 'ajax'
        });

        $('.add-repository-link').magnificPopup({
            type: 'ajax'
        });

        $('.edit-repository-link').magnificPopup({
            type: 'ajax'
        });
    },
    /** saveProject project **/
    saveProject: function () {
        var resultElmt = $("#projectCreationResult");
        $.post("/project/save", $("#projectCreationForm").serialize())
            .success(function (data) {
                resultElmt.html(data);
            })
            .error(function (data) {
                resultElmt.html(data);
            });
    },
    /** save a repository **/
    saveRepository: function () {
        var resultElmt = $("#addRepositoryResult");
        $.post("/repository/save", $("#addRepositoryForm").serialize())
            .success(function (data) {
                resultElmt.html(data);
            })
            .error(function (data) {
                resultElmt.html(data);
            });
    },
    /** edit repository **/
    updateRepository: function () {
        var resultElmt = $("#updateRepositoryResult");
        $.post("/repository/update", $("#updateRepositoryForm").serialize())
            .success(function (data) {
                resultElmt.html(data);
            })
            .error(function (data) {
                resultElmt.html(data);
            });
    }
}