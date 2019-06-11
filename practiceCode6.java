public class HW1 {
    public static boolean canPack ( int bigCount, int smallCount, int goal){
        boolean canPack = false;
        if (bigCount < 0 || smallCount < 0 || goal < 0){
            return canPack;
        }
        int bigCountWeight = 5;
        int smallCountWeight = 1;
        bigCount *= bigCountWeight;
        smallCount *= smallCountWeight;
        if ( bigCount > goal){
            return canPack;
        }
        else if ( (bigCount + smallCount) >= goal){
            canPack = true;
        }
        return canPack;
    }
    public static void main(String[] args){
        System.out.println(canPack(2, 2, 11));

    }
}

