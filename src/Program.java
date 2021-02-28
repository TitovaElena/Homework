public class Program {
    public static void main(String[] args) throws Exception {

        SimpleList<Integer> list = new HomeList<>();
        AuthorHolder authorHolder= new HomeList();

        System.out.println(authorHolder.author());

        list.add(1);
        list.add(2);
        list.add(3);

        list.insert(1, 5);
        list.remove(0);
        list.get(0);
        list.size();
        list.addAll(list);
        list.first(5);
        list.last(2);
        list.contains(10);
        list.isEmpty();
//        for(int i = 0; i < list.size(); i++)
//            System.out.println(list.get(i));
    }
}
