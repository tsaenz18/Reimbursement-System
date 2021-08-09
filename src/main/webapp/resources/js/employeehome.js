/**
 * 
 */
 async function logout(e){
    e.preventDefault();
    let req = await fetch('http://localhost:8080/RS/api/login',{
			method: 'POST',
			headers:{
				'Content-Type' : 'application/json'
			},
			body: JSON.stringify(user)
		});
}