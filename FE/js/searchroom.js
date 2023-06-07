var total = -1;
var amount1 = 0;
$(document).ready(function () {
    var booking;
    $('#submit').click(function (event) {
        let dateStart1 = $('#dateStart').val();
        let dateEnd1 = $('#dateEnd').val();
        amount1 = $('#amount').val();
        total = 0;
        booking = {
            dateStart: dateStart1,
            dateEnd: dateEnd1,
            amount: amount1,
        };
        localStorage.setItem("newBooking", JSON.stringify(booking));
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'POST',
            data: JSON.stringify(booking),
            url: 'http://localhost:8080/api/booking/available_rooms',
            success: function (data) {
                var html = '';
                $.each(data, function (index, object) {
                    html += '<tr>';
                    html += '<td>' + object.id + '</td>';
                    html += '<td>' + object.roomNum + '</td>';
                    html += '<td>' + object.capacity + '</td>';
                    html += '<td><button name = "' + object.id + '" onclick="addRoom(this)" value = "' + object.capacity + '">Select</button></td>';
                    html += '<td><button name = "' + object.id + '" onclick="removeRoom(this)" value = "' + object.capacity + '">Unselect</button></td>';
                    html += '</tr>';
                });
                $('#rooms tbody').html(html);
            },
        });
        event.preventDefault();
    });

    $('#nextStep').click(function (event) {
        let final = {
            booking: booking,
            roomId: roomId
        }
        console.log(final);
        $.ajax({
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            type: 'POST',
            data: JSON.stringify(final),
            url: 'http://localhost:8080/api/booking/add',
            complete: function (xhr) {
                Redirect(xhr);
            }
        });
        event.preventDefault();
    })
});
function Redirect(e) {
    if (e.status == 201) {
        window.location.href = "/customerinfor.html";
    } else {
        alert("Have error, please try again!!");
    }
}

let roomId = [];
function addRoom(addBtn) {
    total += parseInt(addBtn.value);
    let id = addBtn.name;
    roomId.push(id);
    if (total >= amount1) {
        document.getElementById("nextStep").disabled = false;
    }
}

function removeRoom(removeBtn) {
    total -= parseInt(removeBtn.value);
    let id = removeBtn.name;
    let index = roomId.indexOf(id);
    if (index > -1) {
        roomId.splice(index, 1);
    }
    if (total < amount1) {
        document.getElementById("nextStep").disabled = true;
    }
}