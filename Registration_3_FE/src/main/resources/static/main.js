function message(){
    var Name = document.getElementById('name');
    var email = document.getElementById('emailId');
    var phoneNo = document.getElementById('phoneNo');
    var password = document.getElementById('password');

    var msg = document.getElementById('msg');
    const success = document.getElementById('success');
    const danger = document.getElementById('danger');

    if(Name.value === '' || email.value === '' || msg.value === ''){
        danger.style.display = 'block';
        console.log('Nothing');
    }
    else{
        setTimeout(() => {
            Name.value = '';
            email.value = '';
            msg.value = '';
        }, 2000);

        success.style.display = 'block';
    }


    setTimeout(() => {
        danger.style.display = 'none';
        success.style.display = 'none';
    }, 4000);
postUsers();
}

