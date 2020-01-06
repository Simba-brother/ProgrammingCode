package DuoTai;
public class Quadrangle {
    Quadrangle[] quadrangles = new Quadrangle[6];
    int index = 0;
    public void draw(Quadrangle quadrangle) {
        if (index < quadrangles.length) {
            quadrangles[index] = quadrangle;
            System.out.println(index);
            index++;
        }
    }
    public static void main(String[] args) {
        Quadrangle q = new Quadrangle();
        q.draw(new Square());
        q.draw(new Parallelogramgle());
    }
}

class Square extends Quadrangle {
    public Square() {
        System.out.println("正方形");
    }
}

class Parallelogramgle extends Quadrangle {
    public Parallelogramgle() {
        System.out.println("平行四边形");
    }
}