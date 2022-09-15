//Basic d20 dice
function diceRoller(modifier){
    let dice = document.getElementById("status");
    dice.innerText = Math.floor(Math.random() * 20) + 1 + modifier;
}