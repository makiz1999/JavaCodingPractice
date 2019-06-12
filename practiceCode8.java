
public class HW1 {
    public static int getBucketCount ( double width, double height, double areaPerBucket, int extraBuckets){
        double area = 0;
        if ( width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0){
            return -1;
        }
        area = width*height;
        return ((int)Math.ceil(area/areaPerBucket) - extraBuckets);
    }
    public static int getBucketCount ( double width, double height, double areaPerBucket){
        if ( width <= 0 || height <= 0 || areaPerBucket <= 0 ){
            return -1;
        }
        return ((int)Math.ceil((width*height)/areaPerBucket));
    }
    public static int getBucketCount ( double area, double areaPerBucket){
        if ( area <= 0 || areaPerBucket <= 0){
            return -1;
        }
        return((int)Math.ceil(area/areaPerBucket));
    }
    public static void main(String[] args){
        System.out.println(getBucketCount(10,1.5));
        System.out.println(getBucketCount(5, 3, 5));
        System.out.println(getBucketCount(3,4,2, 1));

    }
}

