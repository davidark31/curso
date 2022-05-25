// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#users').DataTable();
  updateUserName();
});

getHeaders=()=>{
    return {
         'Accept': 'application/json',
         'Content-Type': 'application/json',
         'Authorization':localStorage.token
       }
}
updateUserName=()=>{
    document.getElementById('txtusername').outerHTML=localStorage.user;
}

async function loadUsers(){
    const request = await fetch('api/users', {
    method: 'GET',
    headers: getHeaders()

    });
    const users = await request.json();

    let datos='';
        for(let u of users){
         btn_delete='<a href="#" class="btn btn-danger btn-circle btn-sm" onclick="deleteUser('+u.id+')" ><i class="fas fa-trash"></i></a>';
        let html ='<tr><td>'+u.id+'</td><td>'+u.user+'</td><td>'+u.name+'</td><td>'+u.id_type+'</td><td>'+btn_delete+'</td></tr>';
        datos+=html;

        document.querySelector('#users tbody').outerHTML=datos;
    }
}

async function deleteUser (id){

if (!confirm('Desea eliminar el usuario?')){
    return;
}else{
     const request = await fetch('api/users/'+id, {
        method: 'DELETE',
        headers: getHeaders()
     });
     location.reload();
    }
}