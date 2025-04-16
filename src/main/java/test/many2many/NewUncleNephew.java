package test.many2many;

import infra.DAO;
import model.many2many.Nephew;
import model.many2many.Uncle;

public class NewUncleNephew {
    public static void main(String[] args) {
        Uncle aunt1 = new Uncle("Mary");
        Uncle uncle1 = new Uncle("John");

        Nephew nephew1 = new Nephew("Bob");
        Nephew nephew2 = new Nephew("Anna");

        aunt1.getNephews().add(nephew1);
        nephew1.getUncles().add(aunt1);

        aunt1.getNephews().add(nephew2);
        nephew2.getUncles().add(aunt1);

        uncle1.getNephews().add(nephew1);
        nephew1.getUncles().add(uncle1);

        uncle1.getNephews().add(nephew2);
        nephew2.getUncles().add(uncle1);

        DAO<Object> dao = new DAO<>();

        dao.beginTransaction()
            .insert(aunt1)
            .insert(uncle1)
            .insert(nephew1)
            .insert(nephew2)
            .commitTransaction()
            .close();

    }
}
