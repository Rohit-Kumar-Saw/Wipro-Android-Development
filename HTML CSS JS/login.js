function validateLogin(event)
{
    event.preventDefault();

    const username=document.getElementById("username").value;
    const password=document.getElementById("password").value;
    const email=document.getElementById("email").value;
    const messageElement=document.getElementById("message");

    const hardcodedUsername="admin";
    const hardcodedPassword="123";
    const hardcodedEmail="rohit@gmail.com"

    if(username === hardcodedUsername && password === hardcodedPassword && email === hardcodedEmail)
    {
        messageElement.style.color="green";
        messageElement.textContent="Login successfull";
        setTimeout(()=>{
            window.location.href="index.html";
        },1000);
    }else{
        messageElement.style.color="red";
        messageElement.textContent="Invalid login. Please try again."
    }

}