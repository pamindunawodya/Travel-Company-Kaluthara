
$('#btnHotelAdd').on('click', () => {
    console.log("helooooooooooooooo")
    alert("okay added")
    HotelAddRequest();
});

HotelAddRequest=()=>{

    const name=document.getElementById('txtName0').value;
    const category=document.getElementById('txtCategory0').value;
    const location=document.getElementById('txtLocation0').value;
    const contact=document.getElementById('txtContact0').value;
    const email = document.getElementById('txtEmail0').value;
    const petsAllowOrNot = document.getElementById('txtpets0').value;
    const fileinput=document.getElementById('txtHotelImage0');
    const opt1 =document.getElementById('txtOption1').value;
    const opt2 =document.getElementById('txtOption2').value;
    const opt3 =document.getElementById('txtOption3').value;
    RegisterUserObj(name,category,location,contact,email,petsAllowOrNot,fileinput,opt1,opt2,opt3);

}



RegisterUserObj=(name,category,location,contact,email,petsAllowOrNot,fileinput,opt1,opt2,opt3) => {
    const hotelData = new FormData();

    const hotel = JSON.stringify({
        id:null,
        name:name,
        category:category,
        location:location,
        contact:contact,
        email:email,
        petsAllowOrNot:petsAllowOrNot,
        fileData:null,
        opt1:opt1,
        opt2:opt2,
        opt3:opt3
    });

    console.log(petsAllowOrNot)
    hotelData.append("fileData", fileinput.files[0]);
    hotelData.append("hotel", new Blob([hotel], { type: "application/json" }));

    console.log(email)
    console.log(fileinput);

    sendAjaxUserRequest(hotelData);
};

sendAjaxUserRequest = (hotelData) => {
    console.log("Added User");
    $.ajax({
        url: "http://localhost:8080/Mapping/api/hotel",
        type: "POST",
        data: hotelData,
        processData: false,  // Prevent jQuery from processing the data
        contentType: false,  // Set the content type to false to let the browser set it to "multipart/form-data"
        success:function (resp) {
            console.log(resp);
            // alert(resp.message);
            swal("save hotel details successful !", "Click the ok !", "success");
        },
        error: (e) => {
            console.error(e);
            alert(e);
        }
    });
};


//Update Hotel


$('#btnHotelUpdate').on('click', () => {
    console.log("helooooooooooooooo")
    alert("okay Update Button")
    HotelUpdateRequest();
});

HotelUpdateRequest=()=>{

    const name=document.getElementById('txtName0').value;
    const category=document.getElementById('txtCategory0').value;
    const location=document.getElementById('txtLocation0').value;
    const contact=document.getElementById('txtContact0').value;
    const email = document.getElementById('txtEmail0').value;
    const petsAllowOrNot = document.getElementById('txtpets0').value;
    const fileinput=document.getElementById('txtHotelImage0');
    const opt1 =document.getElementById('txtOption1').value;
    const opt2 =document.getElementById('txtOption2').value;
    const opt3 =document.getElementById('txtOption3').value;
    UpdateHotelObj(name,category,location,contact,email,petsAllowOrNot,fileinput,opt1,opt2,opt3);

}



UpdateHotelObj=(name,category,location,contact,email,petsAllowOrNot,fileinput,opt1,opt2,opt3) => {
    const updateHotelData = new FormData();

    updateHotelData.append("name", name);
    updateHotelData.append("category", category);
    updateHotelData.append("location", location);
    updateHotelData.append("contact", contact);
    updateHotelData.append("email", email);
    updateHotelData.append("petsAllowOrNot", petsAllowOrNot);
    updateHotelData.append('fileData', fileinput.files[0]);
    updateHotelData.append("opt1", opt1);
    updateHotelData.append("opt2", opt2);
    updateHotelData.append("opt3", opt3);

    console.log(email)
    console.log(fileinput);



    UpdateAjaxUserRequest(updateHotelData);
};

UpdateAjaxUserRequest = (hotelData) => {

    $.ajax({
        url: "http://localhost:8080/Mapping/api/hotel/update",
        type: "PUT",
        data: hotelData,
        processData: false,  // Prevent jQuery from processing the data
        contentType: false,  // Set the content type to false to let the browser set it to "multipart/form-data"
        success:function (resp) {
            console.log(resp);
            // alert(resp.message);
            swal("update hotel details successful !", "Click the ok !", "success");
        },
        error: (e) => {
            console.error(e);
            alert(e);
        }
    });
};

//delete hotel by email

$("#btnHotelDelete").click(function () {
    let Email=$("#txtEmail0").val();
    $.ajax({
        url: "http://localhost:8080/Mapping/api/hotel?email="+Email,
        type:"DELETE",
        dataType: "json",
        success:function (resp){
            // alert(resp.message);
            swal("delete hotel details successful !", "Click the ok !", "success");
            loadAllUsers();
        },
        error:function (e) {
            alert(JSON.parse(e.responseText).message);

        }
    });
});




// Reg Ex
// let cusIdRegEx = /^C00\d+$/;
// let cusNameRegEx = /^[A-z| ]{5,20}$/;
// let email=/b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}\b;
// let cusAddressRegEx = /^[A-z| |0-9|,]{5,}$/;
// let cusSalaryRegEx = /^\d{1,7}(?:\.\d{0,2})?$/;
//
// $('#txtName0,#txtCategory0,#txtLocation0,#txtContact0,#txtEmail0,#txtpets0,#txtOption1,#txtOption2,#txtOption3').on('keyup', function (event) {
//     let input1 = $('#txtName0').val();
//     let input2 = $('#txtCategory0').val();
//     let input3 = $('#txtLocation0').val();
//     let input4 = $('#txtContact0').val();
//     let input5 = $('#txtEmail0').val();
//     let input6 = $('#txtpets0').val();
//     let input7 = $('#txtOption1').val();
//     let input8 = $('#txtOption2').val();
//     let input9 = $('#txtOption3').val();
//
//     if (cusNameRegEx.test(input1)) {
//         $('#txtName0').css('border', '2px solid green');
//         $('#lblhotelname').text("");
//         if (event.key === "Enter") {
//             $('txtName0').focus();
//         }
//         if (cusNameRegEx.test(input2)) {
//             $('#txtCategory0').css('border', '2px solid green');
//             $('#lblhotelcategory').text("");
//             if (event.key === "Enter") {
//                 $('#txtCategory0').focus();
//             }
//             if (cusAddressRegEx.test(input3)) {
//                 $('#txtCustomerAddress0').css('border', '2px solid green');
//                 $('#lblcusaddress').text("");
//                 if (event.key === "Enter") {
//                     $('#txtCustomerSalary0').focus();
//                 }
//                 if (cusSalaryRegEx.test(input4)) {
//                     $('#txtCustomerSalary0').css('border', '2px solid green');
//                     $('#lblcussalary').text("");
//                     enableButton();
//                     if (event.key === "Enter") {
//                         $('#btnCustomerAdd').click();
//                         $('#txtCustomerId0').focus();
//                     }
//                 } else {
//                     $('#txtCustomerSalary0').css('border', '2px solid red');
//                     $('#lblcussalary').text("Required field. Pattern:-(100.00 or 100)");
//                     $('#lblcussalary').css('color', 'red');
//                     $('#lblcussalary').css('font-size', '8px');
//                     disableButton();
//                 }
//             } else {
//                 $('#txtCustomerAddress0').css('border', '2px solid red');
//                 $('#lblcusaddress').text("Required field. Minimum 5");
//                 $('#lblcusaddress').css('color', 'red');
//                 $('#lblcusaddress').css('font-size', '8px');
//                 disableButton();
//             }
//         } else {
//             $('#txtCustomerName0').css('border', '2px solid red');
//             $('#lblcusname').text("Required field. 5 to 20 characters Allowed.");
//             $('#lblcusname').css('color', 'red');
//             $('#lblcusname').css('font-size', '8px');
//             disableButton();
//         }
//     } else {
//         $('#txtCustomerId0').css('border', '2px solid red');
//         $('#lblcusid').text("Required field. Pattern:-(C00)");
//         $('#lblcusid').css('color', 'red');
//         $('#lblcusid').css('font-size', '8px');
//         disableButton();
//     }
// });
//
//
// $('#txtName0,#txtCustomerName0,#txtCustomerAddress0,#txtCustomerSalary0').on('keydown', function (event) {
//     if (event.key == "Tab") {
//         event.preventDefault();
//     }
// });
//
// $('#lblhotelname,#lblcusname,#lblcusaddress,#lblcussalary').text("");
// $('#lblhotelname,#lblcusname,#lblcusaddress,#lblcussalary').css('color',"");
// $('#txtName0,#txtCustomerName0,#txtCustomerAddress0,#txtCustomerSalary0').css('border','');
