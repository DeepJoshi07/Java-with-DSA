public class Patterns{

    public static void rectanglePattern(int size){
        for(int i = 0;i < size-1;i++){
            for(int j = 0;j < size;j++){
                if(i == 0 || j == 0 || i == size-2 || j == size-1){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }

    }
    
    public static void invertedAndRotatedHalfPyramid(int size){
        for(int i = 0;i < size;i++){
            for(int k = size-i;k > 0;k--){
                System.out.print("   ");
            }
            for(int j = 0;j <= i;j++){
               System.out.print(" * ");
            }
            System.out.println();
        }
    }

    public static void invertedHalfPyramidWithNumbers(int size){
        for(int i = 0;i < size;i++){
            for(int j = 1;j <= size-i;j++){
                System.out.print(" "+j+" ");
            }
            System.out.println();
        }
    }

    public static void floydsTriangle(int size){
        int num = 1;
        for(int i = 0;i < size;i++){
            for(int j = 0;j <= i;j++){
                System.out.print(" "+num+" ");
                num+=1;
            }
            System.out.println();
        }
    }
   
    public static void zerOneTriagle(int size){
        for(int i = 0;i < size;i++){
           int num = (i % 2 == 0)?1:0;
            for(int j = 0;j <= i;j++){
                System.out.print(" "+num+" ");
                num = num == 1? 0:1;
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        System.out.println("--------------------- Question 1 ---------------------");
        rectanglePattern(5);
        System.out.println("--------------------- Question 2 ---------------------");
        invertedAndRotatedHalfPyramid(5);
        System.out.println("--------------------- Question 3 ---------------------");
        invertedHalfPyramidWithNumbers(5);
        System.out.println("--------------------- Question 4 ---------------------");
        floydsTriangle(5);
        System.out.println("--------------------- Question 5 ---------------------");
        zerOneTriagle(5);
        System.out.println("--------------------- Question 4 ---------------------");
        System.out.println("--------------------- Question 4 ---------------------");

    }
}