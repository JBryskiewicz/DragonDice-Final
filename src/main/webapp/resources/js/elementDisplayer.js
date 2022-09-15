function LevelSelectorController() {
    let lvlCheck = document.querySelector('#lvl-condition');
    let lvlSelectedCheck = lvlCheck.options[lvlCheck.selectedIndex].value;
    let showLvlFour = document.querySelector('#lvl-4');
    let showLvlEight = document.querySelector('#lvl-8');

    if (lvlSelectedCheck >= 4) {
        showLvlFour.style.display = 'block';
    } else {
        showLvlFour.style.display = 'none';
    }
    if (lvlSelectedCheck >= 8){
        showLvlEight.style.display = 'block';
    } else {
        showLvlEight.style.display = 'none';
    }
}

function handleFeatsButton(button, level) {
    const elements = [null, document.querySelector(`#lvl-${level}-feat`), document.querySelector(`#lvl-${level}-increase`)];
    const text = ["None", `Level ${level} Feat`, `Level ${level} Increase`];
    // 0 - #lvl-n-placeholder
    // 1 - #lvl-n-feat
    // 2 - #lvl-n-increase

    button.state = (button.state + 1) % 3;
    button.innerHTML = text[button.state];
    elements.forEach((element) => {
        if (!element)
            return;

        element.style.display = elements[button.state] === element ? 'block' : 'none';
    })
}

document.querySelector('#lvl-4-feat-carouse').state = 0;
document.querySelector('#lvl-8-feat-carouse').state = 0;