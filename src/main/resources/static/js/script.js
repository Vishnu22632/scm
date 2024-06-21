console.log("Script is loaded...");

let currentTheme = getTheme();

// initial
document.addEventListener("DOMContentLoaded", ()=>{
    changeTheme();
})





// ToDo
function changeTheme() {

    // set to web page

    // set the listener to change theme button
    changePageTheme(currentTheme, currentTheme);

    const changeThemeButton = document.querySelector("#theme_change_button");
    
    
    

    changeThemeButton.addEventListener("click", (event) => {
        console.log("change theme buttom clicked...");
        let oldTheme = currentTheme;

        if (currentTheme === "dark") {
            //theme to light
            currentTheme = "light";
        } else {
            //theme to dark
            currentTheme = "dark";
        }

        changePageTheme(currentTheme, oldTheme);

    });
}


// set theme to localStorage
function setTheme(theme) {
    localStorage.setItem("theme", theme);
}


// get theme from localStorage
function getTheme() {
    let theme = localStorage.getItem("theme");

    // if(theme){
    //     return theme;
    // }else{
    //     return "light";
    // }

    return theme ? theme : "light";
}

// change current page theme
function changePageTheme(theme, oldTheme) {

    // update the local storage
    setTheme(currentTheme);

    // remove the current theme
    document.querySelector("html").classList.remove(oldTheme);


    // set the current theme
    document.querySelector("html").classList.add(theme);

    // change the text of the button
    document
    .querySelector('#theme_change_button')
    .querySelector("span").textContent =
        theme == "light" ? "Dark" : "Light";
}