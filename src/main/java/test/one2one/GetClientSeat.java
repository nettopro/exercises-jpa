package test.one2one;

import infra.DAO;
import model.one2one.Client;
import model.one2one.Seat;

public class GetClientSeat {
    public static void main(String[] args) {

        DAO<Client> daoClient = new DAO<>(Client.class);

        Client client = daoClient.getById(1L);
        System.out.println(client.getSeat().getName());

        daoClient.close();

        DAO<Seat> daoSeat = new DAO<>(Seat.class);
        Seat seat = daoSeat.getById(1L);
        System.out.println(seat.getClient().getName());

        daoSeat.close();
    }
}
