// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadCargas();
  $('#cargas').DataTable();
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

async function loadCargas(){
    const request = await fetch('api/cargas', {
    method: 'GET',
    headers: getHeaders()
    });
    const cargas = await request.json();

    let datos='';
        for(let u of carga){
         btn_delete='<a href="#" class="btn btn-danger btn-circle btn-sm" onclick="editCarga('+u.id_carga+')" ><i class="fas fa-trash"></i></a>';
        let html ='<tr><td>'+u.patente+'</td><td>'+u.nro_bus+'</td><td>'+u.kil_ini+'</td><td>'+u.kil_act+'</td><td>'+
        u.litros_carg+'</td><td>'+u.fecha+'</td><td>'+u.costo+'</td><td>'+u.nombre_conductor+'</td><td>'+u.persona+'</td><td>'+btn_delete+'</td></tr>';
        datos+=html;
        document.querySelector('#users tbody').outerHTML=datos;
    }
}

async function editCarga (id){

if (!confirm('Desea eliminar el carga?')){
    return;
}else{
     const request = await fetch('api/cargas/'+id, {
        method: 'DELETE',
        headers: getHeaders()
     });
     location.reload();
    }
}