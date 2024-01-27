$('#btnLogin').on('click', () => {
    loginUserRequest();
});

    loginUserRequest=()=>{
    const email = document.getElementById('email').value;
    const pass = document.getElementById('password').value;
    loginUserObj(email, pass);
}



loginUserObj = ( email,password) => {

    const ob ={
        email:email,
        password:password
    }

    loginAjaxUserRequest(ob);
};

loginAjaxUserRequest = (userLoginData) => {
    console.log("Login now");
    $.ajax({
        url: "http://localhost:8086/Mapping/api/app1/log",
        type: "POST",
        data: JSON.stringify(userLoginData),
        contentType: "application/json",
        success:function (resp) {
            console.log(resp);
            swal("Login  successful !", "Click the ok !", "success");
            //window.open('homepage.html', '_blank');
            window.location.href = 'homepage.html';
            // alert(resp.message);

        },
        error: (e) => {
            console.error(e);
            alert(e.responseJSON.message);
        }
    });
};

