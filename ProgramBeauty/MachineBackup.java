import java.util.HashMap;
import java.util.Set;


public class MachineBackup {
    public static void main(String[] args) {
        int[] machines = {1,2,3,1,2};
        methodOne(machines);
        methodTwo(machines);
        methodThree(machines);
    }
    private static Set<Integer> methodOne(int[] machines) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int machine : machines) {
            if (map.containsKey(machine)) {
                map.remove(machine);
            }else {
                map.put(machine, 1);
            }
        }   
        return map.keySet();
    }

    private static int methodTwo(int[] machines){
        int result = 0;
        for (int machine : machines) {
            result = result ^ machine;
        }
        return result;
    }

    private static void methodThree(int[] machines) {
        int result = 0;
        for (int machine : machines) {
            result = result ^ machine;
        }
        int count = 0;
       // int temp = result & 1;
        while ((result & 1) == 0) {
            count++;
            result = result >>1;
        }
        // 此时count指向的那位二进制不等于1
        int i = 0;
        int j = 0;
        for (int machine : machines) {
            int tempMachine = machine >> count;
            if ((tempMachine & 1) == 0) {
                i = i ^ machine;
            }else {
                j = j ^ machine;
            }
        }
        System.out.println(i);
        System.out.println(j);
    }
    
}