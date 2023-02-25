package vova.lambda;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Supplier;
import static java.lang.System.*;

// Supplier только взвращает
// Consumer - противоположность Supplier, он только принимает

public class SupplierAndConsumerClass {
    public static ArrayList<Stormtrooper> createTreeStormtroopers(Supplier<Stormtrooper> stormtrooperSupplier) {
        ArrayList<Stormtrooper> al = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            al.add(stormtrooperSupplier.get());
        }
        return al;
    }

    // это про Consumer
    public static void changeStormtroopers(Stormtrooper stormtrooper, Consumer<Stormtrooper> stormtrooperConsumer) {
        stormtrooperConsumer.accept(stormtrooper);
    }

    public static void main(String[] args) {
        ArrayList<Stormtrooper> ourStormtroopers = createTreeStormtroopers(() ->
                new Stormtrooper("Blaster", 1.1, 4.3));
        out.println("Our Stormtroopers: " + ourStormtroopers);

        // это про Consumer
        changeStormtroopers(ourStormtroopers.get(0), stormtrooper -> {
            stormtrooper.machineGun = "Super Blaster";
            stormtrooper.intelligence = 2.0;
            stormtrooper.speed = 5.5;
            out.println("Upgraded stormtrooper: " + stormtrooper);
        });
        out.println("Our Stormtroopers: " + ourStormtroopers);
    }
}

class Stormtrooper {
    String machineGun;
    Double intelligence;
    Double speed;

    public Stormtrooper(String machineGun, Double intelligence, Double speed) {
        this.machineGun = machineGun;
        this.intelligence = intelligence;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Stormtrooper{" +
                "machineGun='" + machineGun + '\'' +
                ", intelligence=" + intelligence +
                ", speed=" + speed +
                '}';
    }
}
