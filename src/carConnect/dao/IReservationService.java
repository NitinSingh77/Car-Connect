package carConnect.dao;

import carConnect.entity.Reservation;
import carConnect.exception.ReservationException;

import java.sql.SQLException;
import java.util.List;

public interface IReservationService {
	Reservation getReservationByID(int reservationID) throws SQLException, ReservationException;
    List<Reservation> getReservationsByCustomerID(int customerID) throws SQLException, ReservationException;
    void createReservation(Reservation reservationData) throws SQLException, ReservationException;
    void updateReservation(Reservation reservationData) throws SQLException;
    void cancelReservation(int reservationID) throws SQLException, ReservationException;
}
