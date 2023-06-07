package com.codegym.hotelmanagement.repository;

import com.codegym.hotelmanagement.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("select bkrm.room.id from Booking bk join BookingRoom bkrm on bk.id = bkrm.booking.id where :date between bk.dateStart and bk.dateEnd")
    public List<Long> isNotAvailableIdRooms(@Param("date") LocalDate date);

    //    @Query("SELECT LAST_INSERT_ID() from Booking limit 1;")
    @Query("SELECT max(id) FROM Booking")
    public Long getNewId();

    @Modifying
    @Query("UPDATE Booking bk SET bk.idCustomer = :idCustomer WHERE bk.id = :idBooking")
    public void insertCustomerId(@Param("idCustomer") Long idCustomer,
                                 @Param("idBooking") Long idBooking);

//    @Query("select bk.id , bk.dateStart, bk.dateEnd, bk.amount, ct.fullName, ct.dob, ct.email, ct.gender, " +
//            "ct.phoneNumber, ct.citizenIdentityCard, ct.specialRequirement, rm.roomNum, rm.capacity " +
//            "from Booking bk join Customer ct on bk.idCustomer = ct.id join Room rm on bk.idRoom = rm.id")
//    public List<Booking> findAllBooking();
//
//    @Query("select bk.id , bk.dateStart, bk.dateEnd, bk.amount, ct.fullName, ct.dob, ct.email, ct.gender, " +
//            "ct.phoneNumber, ct.citizenIdentityCard, ct.specialRequirement, rm.roomNum, rm.capacity " +
//            "from Booking bk join Customer ct on bk.idCustomer = ct.id join Room rm on bk.idRoom = rm.id where ct.phoneNumber = :phone")
//    public List<Booking> findBookingByPhone(@Param("phone") String phone);
//
//    @Query("select bk.id , bk.dateStart, bk.dateEnd, bk.amount, ct.fullName, ct.dob, ct.email, ct.gender, " +
//            "ct.phoneNumber, ct.citizenIdentityCard, ct.specialRequirement, rm.roomNum, rm.capacity " +
//            "from Booking bk join Customer ct on bk.idCustomer = ct.id join Room rm on bk.idRoom = rm.id where ct.citizenIdentityCard = :number")
//    public List<Booking> findBookingByIdCard(@Param("number") String citizenIdentityCard);
//
//    @Query("UPDATE Booking bk SET bk.idCustomer = :idCustomer WHERE bk.id = :idBooking")
//    public void updateBooking (@Param("idBooking") Long idBooking,
//                               @Param("idCustomer") Long idCustomer);


}

