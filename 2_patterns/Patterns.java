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

    public static void butterfily(int size){
        for(int i = 0;i < size;i++){
            for(int j = 0;j < size*2;j++){
                if(j <= i || j >= size*2-i-1){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
         for(int i = size;i > 0;i--){
            for(int j = 0;j < size*2;j++){
                if(j < i || j >= size*2-i){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }

    public static void solidRhombus(int size){
        for(int i = 0;i < size;i++){
            for(int j = 0;j < size-i;j++){
                System.out.print("   ");
            }
            for(int k = 0;k < size;k++){
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    
    public static void hollowRhombus(int size){
        for(int i = 0;i < size;i++){
            for(int k = 0;k < size-i;k++){
                System.out.print("   ");
            }
            for(int j = 0;j < size;j++){
                if(i == 0 || i == size-1 || j == 0 || j == size-1){
                    System.out.print(" * ");
                }else{
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
    
    public static void diamond(int size){
        int num = 1;
        for(int i = 0;i < size;i++){
            for(int j = 0;j < size-1-i;j++){
                System.out.print("   ");
            }
            for(int k = 0;k < num;k++){
                if(i == 0){
                    System.out.print(" * ");
                    break;
                }else{
                    System.out.print(" * ");
                }
            }
            num += 2;
            System.out.println();
        }
        num -= 2;
        for(int i = size;i >= 0;i--){
            for(int j = size;j > i;j--){
                System.out.print("   ");
            }
            for(int k = 0;k < num;k++){
                if(i == 0){
                    System.out.print(" * ");
                    break;
                }else{
                    System.out.print(" * ");
                }
            }
            num -= 2;
            System.out.println();
        }
    }
    
    public static void numberPyramid(int size){
        for(int i = 1;i <= size;i++){
            for(int j = i;j < size;j++){
                System.out.print(" ");
            }
            for(int k = 0;k < i;k++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
    
    public static void palindromicPattern(int size){
        int num = 1;
        for(int i = 1;i <= size;i++){
            for(int j = i;j < size;j++){
                System.out.print("   ");
            }
            int temp = i;
            while(temp > 0 ){
                System.out.print(" "+temp+" ");
                temp--;
            }
            temp = 2;
            while(temp <= i){
                System.out.print(" "+temp+" ");
                temp++;
            }
            num += 2;
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
        System.out.println("--------------------- Question 6 ---------------------");
        butterfily(5);
        System.out.println("--------------------- Question 7 ---------------------");
        solidRhombus(5);
        System.out.println("--------------------- Question 8 ---------------------");
        hollowRhombus(5);
        System.out.println("--------------------- Question 9 ---------------------");
        diamond(5);
        System.out.println("--------------------- Question 10 ---------------------");
        numberPyramid(5);
        System.out.println("--------------------- Question 11 ---------------------");
        palindromicPattern(5);
    }
}