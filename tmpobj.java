public class tmpobj {
    Object ob;

    public tmpobj(Object ob) {
        this.ob=ob;
    }
    Object getData() {
        return ob;
    }

    public void typet() {
        System.out.println(ob.getClass().getName());
    }

    public static void main(String[] args) {
        tmpobj t1=new tmpobj(9);
        tmpobj t2=new tmpobj(9.5);
        tmpobj t3=new tmpobj("hello");
        t1.typet();
        t2.typet();
        t3.typet();
    }
}
