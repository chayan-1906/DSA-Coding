public class SumOfNNumbersTC {
    static double now = System.currentTimeMillis ( );

    public static void main(String[] args) {
        System.out.println ( "Time taken with formula: " + findSumFormula ( 999999 ) );
        System.out.println ( "Time taken with logic: " + findSumLogic ( 999999 ) );
    }

    public static double findSumFormula(int n) {
        int sum = n * (n + 1) / 2;
        return (System.currentTimeMillis ( ) - now);
    }

    public static double findSumLogic(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += i;
        return (System.currentTimeMillis ( ) - now);
    }
}
