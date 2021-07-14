function createNewAccount(e){
    e.preventDefault();
    let user = {
        userName: document.getElementById("Username").value,
        password: document.getElementById("password").value,
    }


    fetch("http://localhost:8080/login",
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json',},
            body: JSON.stringify(user),
        }
    ).then(()=>window.location.reload(true))

}

function login(e){
    e.preventDefault();
    let user = {
        userName: document.getElementById("Username").value,
        password: document.getElementById("password").value,
    }

    fetch("http://localhost:8080/login",
        {
            method: 'GET',
            headers: {'Content-Type': 'application/json',},
            body: JSON.stringify(user),
        }
    ).then(()=>window.location.reload(true))

}

function uploadNewReceipt(e){
    e.preventDefault();
    let receipt = {
        receiptImage: document.getElementById("receipt").value,
        /*amount: +document.getElementById("amount").value,
        date: document.getElementById("date").value*/
    }
    fetch("http://localhost:8080/users",
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json',},
            body: JSON.stringify(receipt),
        }
    ).then(()=>window.location.reload(true))
}
function deleteAll(e){
    e.preventDefault();
    fetch("http://localhost:8080/users",
    {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json',},
    }
).then(()=>window.location.reload(true))
}
async function getAllReceipts(){
    let response = await fetch("http://localhost:8080/users");
    let body = await response.json();
    let receipt = body.map(expense => {
        let date = new Date(receipt.date)
        return (
            `<li class="list-group-item receipt">
                <p>${date.getMonth()+1}/${date.getDate()+1}/${date.getFullYear()}</p>
                <p>${receipt.receiptImage}</p>

            </li>`
        );
    }).join("");
    document.getElementById("receipts").innerHTML = receipts;
}
getAllReceipts();