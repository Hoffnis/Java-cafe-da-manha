/**
 * 
 */

function confirmar(cpf){
	
	let respostar = confirm("Excluir Colaborador?")
	
	if(respostar === true){
		window.location.href = "delete?cpf" + cpf
	}
}