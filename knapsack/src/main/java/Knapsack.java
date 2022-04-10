import java.util.List;

public class Knapsack {


    public int maximumValue(int weightKnapsackCapacity, List<Item> items) {

        int[] totalMaxValueKnapsack = new int[weightKnapsackCapacity+1];


        items.forEach(
                item -> {

                    int full = weightKnapsackCapacity;
                    while (full >= 0) {
                        if (item.getWi() <= full)
                            totalMaxValueKnapsack[full] = Math.max(totalMaxValueKnapsack[full],
                            totalMaxValueKnapsack[full - item.getWi()] + item.getVi());

                        full--;
                    }
                }
        );

        return totalMaxValueKnapsack[weightKnapsackCapacity];

    }
}