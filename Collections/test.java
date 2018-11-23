package Collections;
class test {
    public static void main(String[] args) {
        Linkedlist<Integer> ll = new Linkedlist<>();
        Hashset<Integer> hs = new Hashset<>();
        for(int i = 2; i <= 20; i=i+2) {
            ll.add(i);
            hs.add(i);
        }
        Iterator<Integer> it_ll = ll.iterator();
        Iterator<Integer> it_hs = hs.iterator();
        int sum1 = 0;
        int sum2 = 0;
        while(it_ll.hasNext() && it_hs.hasNext()) {
            sum1 = sum1 + it_ll.next();
            System.out.println(it_hs.next());
        }
        sum1 = sum1 + ll.get(0) + ll.get(9);
        if(hs.contains(20)) System.out.println(sum1);
    }
}
