document.getElementById('emailForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevent form from submitting
    
    const emailInput = document.getElementById('email').value;
    const errorMessage = document.getElementById('errorMessage');
    
    if (validateEmail(emailInput)) {
        errorMessage.textContent = '';
        alert('Email is valid!');
    } else {
        errorMessage.textContent = 'Invalid email format. Please enter a valid email address.';
    }
});

function validateEmail(email) {
    // Regular expression for validating an email
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
}