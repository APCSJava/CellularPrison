/***
 * The class Prison and its "cells" models a one-dimensional cellular automata.
 */

public class Prison {

    private boolean[] schedule;

    private int calculateScore(int cellNumber) {
        int score = 0;
        if (schedule[cellNumber]) {
            score += 2;
        }
        if (cellNumber > 0 && schedule[cellNumber - 1]) {
            score += 4;
        }
        if (cellNumber < schedule.length - 1 && schedule[cellNumber + 1]) {
            score += 1;
        }
        return score;
    }

    private boolean mustInspect(int score) {
        return ruleTable[score];
    }

    public void updateSchedule() {
        boolean[] replacement = new boolean[schedule.length];
        for (int i = 0; i < schedule.length; i++) {
            replacement[i] = mustInspect(calculateScore(i));
        }
        schedule = replacement;
    }

    private boolean[] ruleTable; // used by mustInspect

    public Prison(int numCells, int rule) {
        schedule = new boolean[numCells];
        schedule[schedule.length/2] = true; // seed the middle cell
        ruleTable = new boolean[8];
        for (int i = 0; i < ruleTable.length; i++) {
            ruleTable[i] = ((rule >> i) & 1) == 1;
        }
    }

    public void randomizeSchedule() {
        for (int i = 0; i < schedule.length; i++) {
            schedule[i] = Math.random() > 0.5;
        }
    }

    public String toString() {
        return toString('*', '.');
    }

    public String toString(char trueChar, char falseChar) {
        String result = "";
        for (int i = 0; i < schedule.length; i++) {
            result+=schedule[i]? trueChar : falseChar;
        }
        return result;
    }


}
