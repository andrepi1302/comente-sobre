function toUpperCase() {
	var valorPalavraChave = document.getElementById('formPrincipal').getAttribute('palavraChave').toUpperCase();
	document.getElementById('formPrincipal').setAttribute('palavraChave', valorPalavraChave);
}