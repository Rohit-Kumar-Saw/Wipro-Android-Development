function clickme()
{
    let a=document.getElementById("a").value;
    let b=document.getElementById("b").value;

    document.getElementById("result").innerText="Result:"+(Number(a)+Number(b));

}