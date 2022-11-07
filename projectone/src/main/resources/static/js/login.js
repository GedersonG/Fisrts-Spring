// Call the dataTables jQuery plugin
$(document).ready(function() {
   // On Ready!
});

async function login(){

      let data = {};

      data.email = document.getElementById('txtEmail').value;
      data.password = document.getElementById('txtPassword').value;

      const request = await fetch('api/login', {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      });
      const log = await request.text();
      if(log != 'FAIL'){
            localStorage.token = log;
            localStorage.email = data.email;
            window.location.href = 'users.html'
      } else {
            alert("Bad login");
      }
}