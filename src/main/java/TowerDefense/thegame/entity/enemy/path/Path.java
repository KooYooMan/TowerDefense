package TowerDefense.thegame.entity.enemy.path;

import TowerDefense.utilities.Pair;

import java.util.ArrayList;
import java.util.List;

public class Path {
    List<Pair<Double, Integer>> instructions;
    public Path () {
        instructions = new ArrayList<Pair<Double, Integer>>();
    }
    public int getNumberInstructions () {
        return instructions.size();

    }
    public void addInstruction (Pair<Double, Integer> instruction) {
        instructions.add(instruction);
    }
    public Pair<Double, Integer> getInstruction (int i) {
        return instructions.get(i);

    }

}