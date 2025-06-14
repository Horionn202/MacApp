const userIcon = document.getElementById('userIcon');
const logoutMenu = document.getElementById('logoutMenu');

userIcon.addEventListener('click', (event) => {
    logoutMenu.classList.toggle('hidden');
})

document.addEventListener('click', (event) => {
    if(!userIcon.contains(event.target)&& !logoutMenu.contains(event.target)) {
        logoutMenu.classList.add('hidden');
    }
})
