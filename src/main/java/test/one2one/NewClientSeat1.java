package test.one2one;

import infra.DAO;
import model.one2one.Client;
import model.one2one.Seat;

public class NewClientSeat1 {
    public static void main(String[] args) {
        
        Seat seat = new Seat("2D");
        Client client = new Client("Carl",seat);

        DAO<Object> dao = new DAO<>();

        dao.beginTransaction()
            .insert(seat)
            .insert(client)
            .commitTransaction()
            .close();
    }
}
