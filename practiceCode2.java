public class HW1 {
    public static boolean hasSameLastDigit( int num1, int num2, int num3) {
        if ((num1 < 10 || num1 > 1000) || (num2 < 10 || num2 > 1000) || (num3 < 10 || num3 > 1000)){
            return false;
        }
        int num1LastDigit = num1 % 10;
        int num2LastDigit = num2 % 10;
        int num3LastDigit = num3 % 10;
        if ((num1LastDigit == num2LastDigit) || (num1LastDigit == num3LastDigit) ||
                (num2LastDigit == num3LastDigit)){
            return true;
        } else {
            return false;
        }
    }
    public static boolean isValid ( int number ){
        if ( number < 10 || number > 1000){
            return false;
        } else {
            return true;
        }
    }
    public static void main(String[] args){
    }
}

