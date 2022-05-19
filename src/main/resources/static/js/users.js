// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#users').DataTable();
});

async function loadUsers(){
    const request = await fetch('api/users', {
        method: 'GET',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        }

      });
      const users = await request.json();

      let datos='';
      for(let u of users){
      let html ='<tr><td>'+u.id+'</td><td>'+u.user+'</td><td>'+u.password+'</td><td>'+u.name+'</td><td>'+u.id_type+'</td><td><a href="#" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a></td></tr>';
      datos+=html;
      }
      console.log(datos);
      document.querySelector('#users tbody').outerHTML=datos;
}