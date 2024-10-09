
class NonGeneric {

    Object obj;

    public NonGeneric(Object obj) {
        this.obj = obj;
    }

    public Object getObject() {
        return this.obj;
    }

    public void setObject(Object obj) {
        this.obj = obj;
    }

    void showType() {
        System.out.println("Type: " + obj.getClass().getName());
    }
}

class GenericJava <T>{
    int num;
    T varia;

    public GenericJava(int num,T va) {
        this.num=num;
        varia=va;
    }
    int getNum()
    {
        return num;
    }
    T getVaria(){
        return varia;
    }
    void setNum(int num)
    {
        this.num=num;
    }
    void setVaria(T va)
    {
        varia=va;
    }
    
}

public class GenericTopic {

    public static void main(String[] args) {
        NonGeneric ng = new NonGeneric(9.8f);
        System.out.println(ng.getObject());
        ng.showType();
        ng.setObject("hello");
        System.out.println(ng.getObject());
        ng.showType();
        String str = (String) ng.getObject();
        System.out.println(str);

        GenericJava<Double> gj=new GenericJava<>(7,8.6);
        System.out.println(gj.getNum());
        System.out.println(gj.getVaria());

    }

}
