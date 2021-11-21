document.getElementsByClassName('show-menu')[0].addEventListener("click", function () {
    if (isMobile()) {
        document.getElementsByClassName('wrapper')[0].classList.toggle('active-menu-mobile');
    } else {
        document.getElementsByClassName('wrapper')[0].classList.toggle('active-menu');
    }
});
document.getElementsByClassName('sidebar-overlay')[0].addEventListener("click", function () {
    document.getElementsByClassName('wrapper')[0].classList.remove('active-menu-mobile');
});
/*
 *   Check if screen size is less than 768px
 */
function isMobile() {
    return window.matchMedia("(max-width: 768px)").matches;
}

document.querySelectorAll('.submenu').forEach(function (element, index, array) {
    element.addEventListener("click",
            function (event) {
                let submenu = this.nextElementSibling;
                submenu.classList.toggle('submenu-active');

            }
    );
}
); 