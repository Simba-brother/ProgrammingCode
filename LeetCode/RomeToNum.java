

/**
 * RomeToNum
 */
public class RomeToNum {

    public static void main(String[] args) {
        RomeToNum r = new RomeToNum();
        r.romanToInt("MCMXCIV");
    }

    
    public int romanToInt(String s) {
        //参数检查
        if (s == null || s.length() < 1) {
            return 0;
        }
        //返回值先初始化为0
        int res = 0;
        if (s.indexOf("IV") != -1) res -= 2;  //1+5 -> 4：-2
        if (s.indexOf("IX") != -1) res -= 2; //1+10 -> 9: -2
        if (s.indexOf("XL") != -1) res -= 20; // 10+50 -> 40: -20
        if (s.indexOf("XC") != -1) res -= 20;
        if (s.indexOf("CD") != -1) res -= 200;
        if (s.indexOf("CM") != -1) res -= 200;
        for (char c : s.toCharArray()) {
            if (c == 'I') res += 1;
            if (c == 'V') res += 5;
            if (c == 'X') res += 10;
            if (c == 'L') res += 50;
            if (c == 'C') res += 100;
            if (c == 'D') res += 500;
            if (c == 'M') res += 1000;
        }
        System.out.println(res);
        return res;
    }
}