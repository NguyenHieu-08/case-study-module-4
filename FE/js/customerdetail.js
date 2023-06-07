$(document).ready(function () {
    //sư kiện nào thực hiện Ajax
    let newCustomer = localStorage.getItem("newCustomer");
    // goi ajax
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/api/customers/" + JSON.parse(newCustomer).id,
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            let content = "";
            content = getCustomer(data);
            document.getElementById('customer-detail').innerHTML = content;
        }
    });
    function getCustomer(customer) {
        return `<td >${customer.fullName}</td>`
                + `<td >${customer.dob}</td>`
                + `<td >${customer.email}</td>`
                + `<td >${(customer.gender)?'Male':'Female'}</td>`
                + `<td >${customer.phoneNumber}</td>`
                + `<td >${customer.citizenIdentityCard}</td>`
                + `<td >${customer.specialRequirement}</td>`;
    }
});