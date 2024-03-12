public class Main {
    public static void main(String[] args) {
        printStartFive();
    }

    static void printStarTen(){
        for(int i=0;i<10;i++){
            System.out.print('*');
        }
        System.out.println();
    }

    static void printStartFive(){
        for(int i=0;i<5;i++){
            printStarTen();
        }
    }
}