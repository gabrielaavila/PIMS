var activeRender = function ( data, type, full, meta ) {
	if (data == true) {
		return "<span class=\"glyphicon glyphicon-ok\"></span>";
	} else {
		return "<a href=\"#\" data-toggle=\"modal\" data-target=\"#myModal\" data-name=\""+full[0]+"\">Set active</a>";
	}
};

var showRender = function ( data, type, full, meta ) {
    return '<a href="./'+data+'/">Edit</a>';
};

$(document).ready( function () {
    $('#module-table').DataTable( {
        "ajax": '/PIMS/modules.json',
        "columnDefs": [
          {
            "targets": 2,
            "render": activeRender
          },
          {
            "targets": 3,
            "render": showRender
          }
        ]
    });
    
	$('#myModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget); // Button that triggered the modal
		  var name = button.data('name');
		  var title = "Switch active module";
		  var text = "Confirm <b>"+name+"</b> as the new active module ?";
		  var confirm = "Yes";
		  var decline = "No";
		  
		  var modal = $(this);
		  modal.find('#modal-title').text(title);
		  modal.find('#modal-text').html(text);
		  modal.find('#modal-confirm').text(confirm);
		  modal.find('#modal-decline').text(decline);
	});
    
	$('#myModal #modal-confirm').on('click', function (event) {
		$('#myModal').modal('hide');
	});
} );

