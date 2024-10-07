<<<<<<< HEAD
package java.carConnect.dao;

import java.carConnect.entity.Reservation;
import java.util.List;

public interface IReservationService {
	Reservation getReservationById(int reservationId);
    List<Reservation> getReservationsByCustomerId(int customerId);
    void createReservation(Reservation reservationData);
    void updateReservation(Reservation reservationData);
    void cancelReservation(int reservationId);
}
=======
package java.carConnect.dao;

import java.carConnect.entity.Reservation;
import java.util.List;

public interface IReservationService {
	Reservation getReservationById(int reservationId);
    List<Reservation> getReservationsByCustomerId(int customerId);
    void createReservation(Reservation reservationData);
    void updateReservation(Reservation reservationData);
    void cancelReservation(int reservationId);
}
>>>>>>> cf09df744e197d6953e9e83a50eb81514f430173
