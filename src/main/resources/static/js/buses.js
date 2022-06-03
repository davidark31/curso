// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadBuses();
  $('#buses').DataTable();
  updateUserName();
});

updateUserName=()=>{
    document.getElementById('txtusername').outerHTML=localStorage.user;
}

async function loadBuses(){
    const request = await fetch('api/buses', {
    method: 'GET',
    });
    const buses = await request.json();
    let datos='';
        for(let b of buses){
             btn_delete='<a href="#" class="btn btn-danger btn-circle btn-sm" onclick="deleteBus('+b.patente+')" ><i class="fas fa-trash"></i></a>';
            let html ='<tr><td>'+b.patente+'</td><td>'+b.nro_bus+'</td><td>'+b.kilometraje+'</td><td>'+b.asientos+'</td><td>'+
            b.año+'</td><td>'+b.empresa.nombre+'</td><td>'+b.modelo.nombre+'</td><td>'+btn_delete+'</td></tr>';
            datos+=html;
            document.querySelector('#buses tbody').outerHTML=datos;
    }
}

async function deleteBus (id){
    if (!confirm('Desea eliminar el bus?')){
        return;
    }else{
        const request = await fetch('api/buses/'+id, {
            method: 'DELETE',
            headers: getHeaders()
        });
        location.reload();
    }
}