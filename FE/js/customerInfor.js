$(document).ready(function () {
    //sư kiện nào thực hiện Ajax
    $('#customerInfo').click(function (event) {
        //lay du lieu
        let fullName = $('#fullName').val();
        let dob = $('#dob').val();
        let email = $('#email').val();
        let gender = $('#gender').val();
        let phoneNumber = $('#phoneNumber').val();
        let citizenIdentityCard = $('#citizenIdentityCard').val();
        let specialRequirement = $('#specialRequirement').val();
        let newCustomer = {
            // id: id,
            fullName: fullName,
            dob: dob,
            email: email,
            gender: gender,
            phoneNumber: phoneNumber,
            citizenIdentityCard: citizenIdentityCard,
            specialRequirement: specialRequirement
        };
        // goi ajax
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: "POST",
            data: JSON.stringify(newCustomer),
            //tên API
            url: "http://localhost:8080/api/customers/add",
            //xử lý khi thành công
            success: function (data) {
                localStorage.setItem("newCustomer",JSON.stringify(data));
                window.location.href = "/customerDetail.html"
                alert('Create A new Customer successfully!'); 
            }
        });
        //chặn sự kiện mặc định của thẻ
        event.preventDefault();
    });
});