const user = {
    name: 'khalfan hussain',
    email: 'khalfan.hussain01@gmailcom',
    age: 23
};

// Function to change the name
function changeName(newName) {
    user.name = newName;
}

// Function to update the email
function updateEmail(newEmail) {
    user.email = newEmail;
}

// Function to calculate the birth year
function calculateBirthYear() {
    const currentYear = new Date().getFullYear();
    return currentYear - user.age;
}

// Example usage:
console.log('Initial User:', user);

// Change the name
changeName('Shabrin');
console.log('After Name Change:', user);

// Update the email
updateEmail('shabrink@gmail.com');
console.log('After Email Update:', user);

// Calculate and log the birth year
const birthYear = calculateBirthYear();
console.log('User Birth Year:', birthYear);