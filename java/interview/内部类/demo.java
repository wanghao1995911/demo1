package interview.内部类;



class father{
    public String gte(){
        return "gte father from";
    }
}

class mother{
    public String mte(){
        return "gte mother from";
    }
}
/**
 * @Author:wanghao
 * @Date: 2022/1/20
 */
public class demo {

    class Myfather extends father{
        @Override
        public String gte(){
            return "love fa";
        }
    }
    class  MyMother extends  mother{
        @Override
        public String mte(){
            return "love mo";
        }
    }
    public void get_newfa(){
        System.out.println(new Myfather().gte());
    }
    public void get_newmo(){
        System.out.println(new MyMother().mte());
    }

    public static void main(String[] args) {
        demo demo = new demo();
        demo.get_newfa();
        demo.get_newmo();
    }

}
