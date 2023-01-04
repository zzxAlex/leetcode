package old;

/**
 * 单例
 *
 */
public class Code007 {
    private static volatile Code007 INSTANCE;
    private Code007() {

    }

    private static Code007 getInstance(){
        if (null == INSTANCE) {
            synchronized (Code007.class) {
                if (null == INSTANCE) {
                    INSTANCE= new Code007();
                }
            }

        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        Code007 instance = Code007.getInstance();
    }


}
