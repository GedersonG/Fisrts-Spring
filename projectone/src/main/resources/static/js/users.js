// Call the dataTables jQuery plugin
$(document).ready(function() {
  chargeUsers();
  $('#users').DataTable();
  updateEmailUser();
});

function updateEmailUser(){
    document.getElementById("txt-Email-User").outerHTML = localStorage.email;
}

function getHeaders(){
    return {
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    }
}

async function chargeUsers(){

      const request = await fetch('api/users', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json',
            'Authorization': localStorage.token
        }
      });
      const users = await request.json();

      let listHTML = '';
      for (let user of users){
          let userHTML = '<tr><td>'+user.id+'</td><td>'+user.nombre+' '+user.apellido+'</td><td>'+user.email+'</td><td>'+user.documento+'</td><td>'+user.password+'</td><td><a href="#" onclick="deleteUser(' + user.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
          listHTML += userHTML;
      }

          document.querySelector("#users tbody").outerHTML = listHTML;
}

async function deleteUser(id){
    if (confirm('Delete user?')){
        const request = await fetch('api/users/'+ id, {
                    method: 'DELETE',
                    headers: getHeaders()
                    });
                    location.reload();
                    }
}