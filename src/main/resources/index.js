function createNewUser(e){
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

function login(form){
    /*e.preventDefault();
    let user = {
        userName: document.getElementById("Username").value,
        password: document.getElementById("password").value,
    }*/
    if((form.username.value == "test") && (form.password.value == "test")) {
        self.location.href = "index.html";
    }
    else {
        alert("username or password is wrong");
        return false;
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
    let receipts = {
        receiptImage: document.getElementById("receiptPicture").value,
        username: +document.getElementById("username").value,
        date: document.getElementById("date").value
    }
    fetch("http://localhost:8080/users",
        {
            method: 'POST',
            headers: {'Content-Type': 'application/json',},
            body: JSON.stringify(receipts),
        }
    ).then(()=>window.location.reload(true))
}
function deleteAll(e){
    e.preventDefault();
    fetch("http://localhost:8080/removeReciept/",
    {
        method: 'DELETE',
        headers: {'Content-Type': 'application/json',},
    }
).then(()=>window.location.reload(true))
}

async function getAllReceipts(){
    let response = await fetch("http://localhost:8080/users");
    let body = await response.json();
    let receipt = body.map(receipt => {
    let date = new Date(receipt.date)
        return (
            `<li class="list-group-item receipt">
                <p>${date.getMonth()+1}/${date.getDate()+1}/${date.getFullYear()}</p>
                <p>${receipts.username}</p>
                <p>${receipts.receiptPicture}</p>

            </li>`
        );
    }).join("");
//    document.getElementById("receiptPicture").innerHTML;
}
getAllReceipts();