package carConnect.dao;

import java.util.List;

import carConnect.entity.Reservation;

public interface IReservationService {
	Reservation getReservationByID(int reservationID);
    List<Reservation> getReservationsByCustomerID(int customerID);
    void createReservation(Reservation reservationData);
    void updateReservation(Reservation reservationData);
    void cancelReservation(int reservationID);
}
