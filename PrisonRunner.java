public class PrisonRunner {
    public static void main(String[] args) {
        // some rules to try: 2, 108, 30, 110, 255
        Prison prison = new Prison(100, 2);
        prison.randomizeSchedule(); // randomize the starting configuration of cells

        for (int i = 0; i < 100; i++) {
            System.out.println(prison.toString('*', '.'));
            prison.updateSchedule();
        }
        System.out.println(prison.toString());
    }
}