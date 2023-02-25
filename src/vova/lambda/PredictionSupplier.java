package vova.lambda;

import java.util.ArrayList;
import java.util.function.Supplier;

import static java.lang.Math.*;
import static java.lang.System.*;

public class PredictionSupplier {
    public static void main(String[] args) {
        ArrayList<String> predictions = new ArrayList<>();
        predictions.add("At 5.04pm today you will find 1,000 roubles");
        predictions.add("Your bike will be stolen tomorrow");
        predictions.add("Today is going to be perfectly normal accident free day");

        Supplier<String> randomName = () -> {
            int value = (int)(random() * predictions.size());
            return predictions.get(value);
        };

        out.println(randomName.get());
    }
}
