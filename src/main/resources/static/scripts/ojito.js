
const passwordInput = document.getElementById('password');
const togglePassword = document.getElementById('togglePassword');
const ojito = document.getElementById('ojito');

togglePassword.addEventListener('click', () => {
    const isPasswordHidden = passwordInput.type === 'password';
    passwordInput.type = isPasswordHidden ?   "text" : "password";

    ojito.classList.remove(isPasswordHidden ? 'bi-eye-fill' : 'bi-eye-slash-fill');
    ojito.classList.add(isPasswordHidden ? 'bi-eye-slash-fill' : 'bi-eye-fill');

})
