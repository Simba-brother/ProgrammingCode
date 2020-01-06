import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SectionContain {
    static class Section {
        int begin;
        int end;
        public Section(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        ArrayList<Section> data = new ArrayList<>();
        ArrayList<Section> res = method_1(data);
        Section target = new Section(1,4);
        for (int i = 0; i < res.size(); i++) {
            if ((res.get(i).begin <= target.begin) && (target.end <= res.get(i).end)) {
                System.out.println("目标区间被包含");
                return; 
            }
        }
    }

    private static ArrayList<Section> method_1(ArrayList<Section> data) {
        ArrayList<Section> res = new ArrayList<>();
        Collections.sort(data, new Comparator<Section>() {

            @Override
            public int compare(Section o1, Section o2) {
                return o1.begin-o2.begin;
            }
            
        });
        int n = data.size();
        Section preSection = data.get(0);
        for (int i = 1; i < n; i++) {
            Section curSection = data.get(i);
            if (preSection.end >=  curSection.begin) {
                preSection.end = Math.max(preSection.end, curSection.end);
            }else {
                res.add(preSection);
                preSection = curSection;
            }
        }
        res.add(preSection);
        return res;
    }
}