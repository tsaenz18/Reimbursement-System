/**
 * 
 */
let userid;

let verifyLoggedIn = async () => {
	let res = await fetch('http://localhost:8080/RS/api/getSession');
	let obj = await res.json();
	
	if(obj.userid < 0){
		location.href = "../html/index.html";
	}
	else{
		userId = obj.userid;
	}
}

document.getElementById("logout").addEventListener('click', async () => {
	let res = await fetch('http://localhost:8080/RS/api/logout');
	userId = -1;
	verifyLoggedIn();
});

document.getElementById("review").addEventListener('click', () => {
	location.href = "../html/manager-review.html";
});

/* Reimbursement functions */

let populateTable = (obj) => {
	
	let table = document.getElementById("re-table");
	
	table.innerHTML = '<tr><th>Status</th><th>Type</th><th>Submitted By</th><th>Amount</th><th>Submitted Date</th><th>Resolved Date</th><th>Resolved By</th></tr>';
	
	obj.forEach((obj)=> {
		let index = 1;
		
		let row=table.insertRow(index++);
		row.id = obj.reId;
		
		let status = row.insertCell(0);
		status.innerHTML = obj.status.reimbursement_status;
		
		let type = row.insertCell(1);
		type.innerHTML = obj.type.reimbursement_type;
		
		let author = row.insertCell(2);
		author.innerHTML = obj.userConnection.username;
		
		let amount = row.insertCell(3);
		amount.innerHTML = Number (obj.amount).toFixed(2);
		
		let subDate = row.insertCell(4);
		subDate.innerHTML = new Date(obj.submitteddate).toDateString();
		
		let resDate = row.insertCell(5);
		if(obj.resolveddate !== null){
			resDate.innerHTML = new Date(obj.resolveddate).toDateString();
		}
		else{
			resDate.innerHTML = 'N/A';
		}
		
		let resolver = row.insertCell(6);
		if(obj.manager !== null){
			resolver.innerHTML = obj.manager.username;
		}
		else{
			resolver.innerHTML = 'N/A';
		}

		let descRow = table.insertRow(index++);
		let desc = descRow.insertCell(0);
		desc.setAttribute("colspan", "7");
		desc.className = "desc";
		desc.innerHTML = `<h3>Description:</h3><p>${obj.description}</p>`;
		
	});
}

document.getElementById("filter").addEventListener('click', async () => {
	let status = document.getElementById("status").value;
	console.log(status);
	if(status<3){
		if(status == 0){
			let obj = await retreiveAllPendingReimbursements();
			populateTable(obj);
		}
		else if(status == 1){
			let obj = await retreiveAllApprovedReimbursements();
			populateTable(obj);
		}
		else{
			let obj = await retreiveAllDeniedReimbursements();
			populateTable(obj);
		}
	}
	else{
		let obj = await retreiveAllReimbursements();
		populateTable(obj);
	}
});

let retreiveAllReimbursements = async () => {
	let res = await fetch(`http://localhost:8080/RS/api/getAllReimbursements`);
	let obj = await res.json();
	return obj;
}

let retreiveAllPendingReimbursements = async () => {
	let res = await fetch(`http://localhost:8080/RS/api/getAllPending`);
	let obj = await res.json();
	return obj;
}

let retreiveAllApprovedReimbursements = async () => {
	let res = await fetch(`http://localhost:8080/RS/api/getAllAccepted`);
	let obj = await res.json();
	return obj;
}

let retreiveAllDeniedReimbursements = async () => {
	let res = await fetch(`http://localhost:8080/RS/api/getAllDenied`);
	let obj = await res.json();
	return obj;
}


/*After login initalize the table */

let init = async () => {
	await verifyLoggedIn();
	let res = await fetch(`http://localhost:8080/RS/api/getUser?userid=${userId}`);
	let user = await res.json();
	let username = user.username;
	document.getElementById("welcome").innerText = `Welcome ${username}!`;
	let rows = await retreiveAllReimbursements();
	populateTable(rows);
}

init();