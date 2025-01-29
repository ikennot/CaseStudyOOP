package CaseStudy;

public class Displays {
    public static void showLoading(String Info) {
        String[] spinner = {"[   ]", "[.  ]", "[.. ]", "[...]"};
        int spinCount = 0;

        // Loop para sa animation ng spinner
        while (spinCount < 3) { // I-adjust ang limit para sa duration ng animation
            for (int i = 0; i < spinner.length; i++) {
                // Clear the console line and print the spinner
                System.out.print("\r \t\t\t\t\t"+Info+" " + spinner[i]);

                try {
                    // Delay sa bawat frame ng animation
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            spinCount++;
        }

    
    }
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
   
    public static void delay(){
        
        try {
            // Delay sa bawat frame ng animation
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
