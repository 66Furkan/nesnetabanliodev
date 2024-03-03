public class RaceRunners {
    private String[] runnerNames;
    private int[] runnerTimes;

    public RaceRunners(String[] names, int[] times) {
        this.runnerNames = names;
        this.runnerTimes = times;
    }
    public void classifyAndPrintRunnerCounts() {
        int classA = 0;
        int classB = 0;
        int classC = 0;

        for (int time : runnerTimes) {
            if (time >= 200 && time <= 299) {
                classA++;
            } else if (time >= 300 && time <= 399) {
                classB++;
            } else if (time >= 400) {
                classC++;
            }
        }

        // Sınıfları ve koşucu sayılarını ekrana yazdır
        System.out.println("Class A (200-299 minutes): " + classA + " runners");
        System.out.println("Class B (300-399 minutes): " + classB + " runners");
        System.out.println("Class C (400+ minutes): " + classC + " runners");
    }

    public void findAndPrintTopThreeRunners() {
        Integer[] originalIndices = new Integer[runnerTimes.length];
        for (int i = 0; i < originalIndices.length; i++) {
            originalIndices[i] = i;
        }

        for (int i = 0; i < runnerTimes.length - 1; i++) {
            for (int j = 0; j < runnerTimes.length - i - 1; j++) {
                if (runnerTimes[j] > runnerTimes[j + 1]) {

                    int tempTime = runnerTimes[j];
                    runnerTimes[j] = runnerTimes[j + 1];
                    runnerTimes[j + 1] = tempTime;

                    String tempName = runnerNames[j];
                    runnerNames[j] = runnerNames[j + 1];
                    runnerNames[j + 1] = tempName;

                    int tempIndex = originalIndices[j];
                    originalIndices[j] = originalIndices[j + 1];
                    originalIndices[j + 1] = tempIndex;
                }
            }
        }

        // İlk üç koşucuyu ekrana yazdırmak için System out metodunu kullanıyorum
        System.out.println("Top Three Runners:");

        for (int i = 0; i < Math.min(3, runnerTimes.length); i++) {
            System.out.println((i + 1) + ". " + runnerNames[i] + " - " + runnerTimes[i] + " minutes");
        }
    }

    public static void main(String[] args) {
        String[] runnerNames = {"Kadir", "Gökhan", "Hakan", "Suzan", "Pınar", "Mehmet", "Ali", "Emel","Fırat","James","Jale","Ersin","Deniz", "Gözde","Anıl", "Burak"};
        int[] runnerTimes = {341, 273, 278, 329,445,402,388,270,243,334,412,393,299,343,317,265};

        RaceRunners race = new RaceRunners(runnerNames, runnerTimes);


        race.findAndPrintTopThreeRunners();

        race.classifyAndPrintRunnerCounts();
    }


}
