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
    public Double getLength (int i) {
        return instructions.get(i).getA();
    }
    public Integer getDirect (int i) {
        return instructions.get(i).getB();
    }

    @Override
    public String toString() {

        String pathString = "Path\n" + instructions.size() + "\n";
        for (Pair<Double, Integer> p : instructions) {
            pathString += p.getA().toString() + " " + p.getB().toString() + "\n";
        }
        return pathString;
    }
}