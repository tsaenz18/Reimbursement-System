/**
 * 
 */
let logoutbtn = document.getElementById("logout").addEventListener("click", logout);

async function logout(){
	let req = await fetch('http://localhost:8080/RS/api/logout');
	let res = await req.text();
	console.log(res);
	req = await fetch('http://localhost:8080/RS/api/getSession');
	res = await req.text();
	console.log(res);
	location.href = '../html/index.html';
}