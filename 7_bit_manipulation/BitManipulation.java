public class BitManipulation{

    public static void oddOrEven(int number){
        if((number & 1) == 0){
            System.out.println("number is Even");
        }else{
            System.out.println("number is Odd");
        }
    }
    
    public static void getIthBit(int number,int i){
        int bitMask = 1 << i;
        if((number & bitMask) == 0){
            System.out.println("the bit is: 0");
        }else{
            System.out.println("the bit is: 1");
        }
    }
    
    public static int setIthBit(int number,int i){
        int bitMask = 1 << i;
        return number | bitMask;
    }

    public static int clearIthBit(int number,int i){
        int bitMask = ~(1 << i);
        return number & bitMask;
    }

    public static int updateIthBit(int number,int i,int bit){
       number = clearIthBit(number, i);
    //    return number = bit == 0?number: setIthBit(number, i);
       //or
       if(bit == 0)return number;
       int bitMask = bit << i;
       return number | bitMask;
    }
   
    public static int clearIbits(int number,int i){
        int bitMask = (-1) << i;
        // or
        // int bitMask = (~0) << i;
        return number & bitMask;
    }

    public static int clearBitsInRange(int number,int si,int ei){
        int r1 = (~0) << ei;
        int r2 = (1 << si) - 1;
        int bitMask = r1 | r2;
        return number & bitMask;
    }
    
    public static boolean twosPowerOrNot(int number){
        return (number & (number-1)) == 0;
    }
   
    public static int countSetBits(int number){
        int count = 0;
        while(number > 0){
            if((number & 1) != 0){
                count++;
            }
            number = number >> 1;
        }
        return count;
    }

    public static int fastExponantiation(int number,int pow){
        int ans = 1;
        while(pow > 0){
            if((pow & 1) != 0){
                ans = ans * number;
            }
            number *= number;
            pow = pow >> 1;
        }
        return ans;
    }
    public static void main(String args[]){
        System.out.println("----------------------- Question 1 ------------------------");
        oddOrEven(21);
        System.out.println("----------------------- Question 2 ------------------------");
        getIthBit(10,2);
        System.out.println("----------------------- Question 3 ------------------------");
        System.out.println(setIthBit(10, 2));
        System.out.println("----------------------- Question 4 ------------------------");
        System.out.println(clearIthBit(31, 2));
        System.out.println("----------------------- Question 5 ------------------------");
        System.out.println(updateIthBit(7,2,0));
        System.out.println("----------------------- Question 6 ------------------------");
        System.out.println(clearIbits(15, 3));
        System.out.println("----------------------- Question 7 ------------------------");
        System.out.println(clearBitsInRange(63, 1, 4));
        System.out.println("----------------------- Question 8 ------------------------");
        System.out.println(twosPowerOrNot(31));
        System.out.println("----------------------- Question 9 ------------------------");
        System.out.println(countSetBits(32));
        System.out.println("----------------------- Question 10 ------------------------");
        System.out.println(fastExponantiation(5,5));
    }
}