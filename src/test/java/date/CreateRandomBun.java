package date;
import praktikum.Bun;
import praktikum.Database;

import java.util.List;
import java.util.Random;

public class CreateRandomBun {
    Database db = new Database();
    private final List<Bun> buns = db.availableBuns();

    public Bun getRandomBun() {
        return buns.get(new Random().nextInt(buns.size()));
    }
}
