// Call the dataTables jQuery plugin
$(document).ready(function() {
   // On Ready!
});

async function registerUser(){

      let data = {};

      data.nombre = document.getElementById('txtFirstName').value;
      data.apellido = document.getElementById('txtLastName').value;
      data.email = document.getElementById('txtEmail').value;
      data.documento = document.getElementById('txtDocument').value;
      data.password = document.getElementById('txtPassword').value;

      let repeat =document.getElementById('txtRepeatPassword').value;

      if (data.password != repeat){
            alert('Bad passwords')
            return;
      }

      const request = await fetch('api/users', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
      alert("Account created!");
      window.location.href = 'login.html';
}