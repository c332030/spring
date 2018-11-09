package c332030.ddns.model.test;

import c332030.utils.data.model.interfaces.CTest;

public class CThreadTest implements CTest {

    @Override
    public void test() {
        System.out.println("CThreadTest.test");
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
