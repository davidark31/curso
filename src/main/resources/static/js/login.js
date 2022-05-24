// Call the dataTables jQuery plugin
$(document).ready(function() {
//on ready
});

async function login(){
let data={};
    data.user=document.getElementById('txtUser').value;
    data.password=document.getElementById('txtPassword').value;

    const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body : JSON.stringify(data)
    });
    const response = await request.text();

    if(response!='FAIL'){
    localStorage.token=response;
    localStorage.user=data.user;
        window.location.href='users.html'
    }else{
        alert('Usuario no valido');
    }
}