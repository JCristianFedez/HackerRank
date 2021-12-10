package Advanced.JavaSingletonPattern;

class Singleton{

    public static String str;

    private Singleton() {
    }

    private static final class SingletonHolder {
        static final Singleton instance = new Singleton();
    }

    public Singleton getSingleInstance(){
        return SingletonHolder.instance;
    }
}
