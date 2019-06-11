public class HW1 {
    public static int getGreatestCommonDivisor( int first, int second ) {
        if (first < 10 || second < 10) {
            return -1;
        }
        int greaterValue = 0;
        if (first > second) {
            greaterValue = first;
        } else {
            greaterValue = second;
        }
        int firstGreatestDivisor = 0;
        int secondGreatestDivisor = 0;
        int greatestDivisor = 0;
        for (int i = greaterValue; i > 0; i--) {
            if (first % i == 0) {
                firstGreatestDivisor = i;
            }
            if (second % i == 0) {
                secondGreatestDivisor = i;
            }
            if (secondGreatestDivisor == firstGreatestDivisor) {
                greatestDivisor = firstGreatestDivisor;
                break;
            }
        }
        return greatestDivisor;
    }
    public static void main(String[] args){
        System.out.println(getGreatestCommonDivisor(25,15));
    }
}

