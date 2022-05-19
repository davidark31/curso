// Call the dataTables jQuery plugin
$(document).ready(function() {
//on ready
});

async function registerUser(){
let data={};
    data.user=document.getElementById('txtUser').value;
    data.name=document.getElementById('txtName').value;
    data.password=document.getElementById('txtPassword').value;
    data.id_type=2;
    let repeatpassword = document.getElementById('txtrepeatpassword').value;

    if(repeatpassword!= data.password){
        alert('contraseñas diferentes!!')
       return;
    }

    const request = await fetch('api/users', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body : JSON.stringify(data)
    });
    const users = await request.json();
}

