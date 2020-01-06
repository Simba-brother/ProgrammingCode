import java.util.Arrays;

public class BFS1 {

    static class NodeAndDep {
        int id;
        int dep;

        /**
         * @param id    //图中节点id
         * @param dep   //id为0的节点到该节点的路径，直接连接为1
         */

        public NodeAndDep() {
            this.id = -1;
            this.dep = -1;
        }

        public void setNodeAndDep(int id, int dep) {
            this.id = id;
            this.dep = dep;
        }

        /**
         * @return the id
         */
        public int getId() {
            return id;
        }

        /**
         * @param id the id to set
         */
        public void setId(int id) {
            this.id = id;
        }

        /**
         * @return the dep
         */
        public int getDep() {
            return dep;
        }

        /**
         * @param dep the dep to set
         */
        public void setDep(int dep) {
            this.dep = dep;
        }
        

    }
    public static void main(String[] args) {
        int[][] graph = {       // 10 * 10
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 1, 0, 0, 1, 1, 0, 0, 0, 0},
            {1, 0, 0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 1, 0, 0, 1, 1, 0, 0},
            {0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 0, 1, 1},
            {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0}
        };
        boolean[] vis = new boolean[graph.length];  //一行是一个节点
        Arrays.fill(vis, false);
        NodeAndDep[] queue = new NodeAndDep[graph.length];
        for (int i = 0; i < queue.length; i++) {
            queue[i] = new NodeAndDep();           
        }
        bfs(queue, graph, vis);
    }   

    public static void bfs(NodeAndDep[] queue, int[][] graph, boolean[] vis) {
        int base = 0;  //bfs的基
        int top = 0;    //bfs最外层的最后一个元素的索引
        for (int i = 0; i < graph.length; i++) {  // 遍历行，其实就是遍历图中的节点  //寻找每一个节点的bfs
            if (vis[i] == false) {  //如果该节点没有被访问过
                queue[top].setNodeAndDep(i, 0); //队列中的top来了（id = 0, dep =0） 节点0到节点0的层数就是0
                top++;  //队尾索引加一
                vis[i] =true;   //将该节点的设置为被访问过
                while (base != top) {   //中心不等于队尾时
                    int dep = queue[base].dep + 1;  //当前深度加一 
                    int id = queue[base].id;    //得到中心节点的id
                    for (int j = 0; j < 10; j++) {  // 遍历矩阵的列，也就是看看与该节点相邻的有哪些节点
                        if (graph[id][j] == 1 && vis[j] == false) { //遇到相邻节点并且该节点未被访问过
                            queue[top].setNodeAndDep(j, dep);   //把节点加入到队尾，
                            top++;  //队尾索引++
                            vis[j] = true;  //设置该节点被访问过
                        }
                    }
                    base++;
                }
            }

            //else 该节点访问过直接遍历下一个节点
        }
    }
}


