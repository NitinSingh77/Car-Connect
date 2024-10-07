package carConnect.dao;

import java.util.List;

import carConnect.entity.Reservation;

public interface IReservationService {
	Reservation getReservationById(int reservationId);
    List<Reservation> getReservationsByCustomerId(int customerId);
    void createReservation(Reservation reservationData);
    void updateReservation(Reservation reservationData);
    void cancelReservation(int reservationId);
}
