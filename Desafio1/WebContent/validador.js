/**
 * 
 */


function validar(){
	
	let nome =frmContato.nome.value
	let cpf =frmContato.cpf.value
	let comida =frmContato.comida.value
	
	if(nome === ""){
		alert('preencha campo Nome')
		frmContato.nome.focus()
		return false
	} else if(cpf === ""){
			alert('preencha campo CPF')
		frmContato.cpf.focus()
		return false
	} else if(comida === ""){
			alert('preencha campo Comida')
		frmContato.comida.focus()
		return false
	} else{
		document.forms["frmContato"].submit()
	}
}