public class EditDistance {
    public static void main(String[] args) {
        String strA = "abcdefg";
        String strB = "abcdef";
        int res = method_1(strA, 0, strA.length()-1, strB, 0, strB.length()-1);
        System.out.println(res);
    }

    private static int  method_1(String strA, int aBegin, int aEnd, String strB, int bBegin, int bEnd) {
        if (aBegin > aEnd) {
            if (bBegin > bEnd) {
                return 0;
            }else {
                return bEnd - bBegin +1;
            }
        }   
        if (bBegin > bEnd) {
            if (aBegin > aEnd) {
                return 0;
            }else {
                return aEnd - aBegin +1;
            }
        }
        if (strA.charAt(aBegin) == strB.charAt(bBegin)) {
            return method_1(strA, aBegin+1, aEnd, strB, bBegin+1, bEnd);
        }else {
            int xiugai =  method_1(strA, aBegin+1, aEnd, strB, bBegin+1, bEnd);
            int shanchuB = method_1(strA, aBegin, aEnd, strB, bBegin+1, bEnd);
            int shanchuA = method_1(strA, aBegin+1, aEnd, strB, bBegin, bEnd);
            return minValue(xiugai, shanchuA, shanchuB)+1;
        }
    }

    private static int minValue(int a, int b, int c) {
        if (a<b && b<c) {
            return a;
        }else {
            return Math.min(b, c);
        }
    }
}