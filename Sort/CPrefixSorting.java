import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 煎饼排序
 */
public class CPrefixSorting {
    private static int m_nCakeCnt = 0;  //煎饼数量  
    private static int m_nMaxSwap = 0;  // 最大交换数目
    private static int[] m_SwapArray;   //交换过程数组
    private static int[] m_ReverseCakeArray;    //倒置煎饼数组  
    private static int[] m_ReverseCakeArraySwap;    //倒置煎饼数组记录
    private static int m_nSearch = 0; //进入到search函数的次数。

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        m_nCakeCnt = split.length;  //煎饼数量  
        assert(split != null);
        int[] cakeArray = new int[split.length];    
        
        for (int i = 0; i < m_nCakeCnt; i++) { //初始化煎饼数组
            cakeArray[i] = Integer.parseInt(split[i]);
        }
        m_nMaxSwap = 2 * (m_nCakeCnt-1);       //最大交换次数
        m_SwapArray = new int[m_nMaxSwap +1];
        m_ReverseCakeArray = new int[m_nCakeCnt];   //倒置临时数组
        for (int i = 0; i < m_nCakeCnt; i++) {
            m_ReverseCakeArray[i] = cakeArray[i];
        }
        m_ReverseCakeArraySwap = new int[m_nMaxSwap];   //倒置记录
        search(0);
    }
    public static void search(int step) {
        m_nSearch++;
        int nEstimate;      //
        nEstimate = lowerBounder(m_ReverseCakeArray, m_nCakeCnt);
        if (step + nEstimate > m_nMaxSwap) {
            return;
        }
        if (isSorted(m_ReverseCakeArray, m_nCakeCnt)) {
            if (step < m_nMaxSwap) {
                m_nMaxSwap = step;
                for (int i = 0; i < m_nMaxSwap; i++) {
                    m_SwapArray[i] = m_ReverseCakeArraySwap[i];
                }
            }
        }
        for (int i = 1; i < m_nCakeCnt; i++) {
            reverse(0, i);
            m_ReverseCakeArraySwap[step] = i;
            search(step+1);
            reverse(0, i);
        }
    }
    public static int lowerBounder(int[] m_ReverseCakeArray, int m_nCakeCnt) {
        int ret=0;
        for (int i = 1; i < m_nCakeCnt; i++) {
            int temp = Math.abs(m_ReverseCakeArray[i] - m_ReverseCakeArray[i-1]);         
            if (temp != 1) {
                ret++;
            }
        }
        return ret;
    }

    public static void reverse(int nBegin, int nEnd) {
        assert(nBegin > nEnd);
        for (int i = nBegin, j = nEnd; i < j; i++, j--) {
            int temp =m_ReverseCakeArray[i];
            m_ReverseCakeArray[i] = m_ReverseCakeArray[j];
            m_ReverseCakeArray[j] = temp;
        }
    }

    public static boolean isSorted(int[] m_ReverseCakeArray, int m_nCakeCnt) {
        for (int i = 1; i < m_nCakeCnt; i++) {
            if (m_ReverseCakeArray[i-1] > m_ReverseCakeArray[i]) {
                return false;
            }
        }
        return true;
    }
}