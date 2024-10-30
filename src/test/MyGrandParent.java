import java.util.ArrayList;
import java.util.Collection;

public class MyGrandParent {
}

class MyParent extends MyGrandParent{

}
class MyChild extends MyParent{

}

class Main{

    void test(){
        add(new ArrayList<MyGrandParent>());
    }

    void add(Collection<? super MyParent> c){ // 상한 경계 추가 가능
        c.add(new MyParent());
    }
    void print(Collection<? extends  MyParent> c){
        for(MyParent p : c){
            System.out.println(p);
        }
    }

}
