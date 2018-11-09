package c332030.utils.data.model;

import c332030.utils.data.model.interfaces.C;

import java.lang.reflect.Method;

public class CThread<E> implements C, Runnable {

    private E e;
    private Method method;
    private Object[] parameters;

    private boolean finish = false;
    private Object result = null;

    private CThread(E e, Method method, Object[] parameters) {
        this.e = e;
        this.method = method;
        this.parameters = parameters;
    }

    public static <E> CThread<E> newInstance(
            E e, String methodName,
            Class<?>[] parameterTypes,
            Object[] parameters
    ) throws Exception {

        if(null == e
                || null == methodName
                || 0 == methodName.length()
                || !verifyParaAndType(parameterTypes, parameters)
        ) {
            return null;
        }

        Class<?> eClass = e.getClass();
        return new CThread<E>(e, eClass.getMethod(methodName, parameterTypes) , parameters);
    }

    public static <E> CThread<E> newInstance(
            Class<E> eClass, String methodName,
            Class<?>[] parameterTypes,
            Object[] parameters
    ) throws Exception {

        if(null == eClass) {
            return null;
        }

        return newInstance(eClass.newInstance(), methodName,
                parameterTypes, parameters);
    }

    public static boolean verifyParaAndType(
            Class<?>[] parameterTypes,
            Object[] parameters
    ) {

        if(null == parameters
                || parameters == parameterTypes
        ) {
            return true;
        }

        if (parameterTypes.length != parameters.length) {
            return false;
        }

        for(int i = 0; i < parameters.length; i++) {
            if(null == parameters[i]) {
                continue;
            }

            if(parameters[i].getClass() != parameterTypes[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void run() {

        if(isEmpty()) {
            return;
        }

        try {

            result = method.invoke(e, parameters);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finish = true;
        }
    }

    @Override
    public boolean isEmpty() {
        return null == e
                || null == method;

    }

    public E getE() {
        return e;
    }
    public void setE(E e) {
        this.e = e;
    }

    public Method getMethod() {
        return method;
    }
    public void setMethod(Method method) {
        this.method = method;
    }

    public Object[] getParameters() {
        return parameters;
    }
    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public boolean isFinish() {
        return finish;
    }
    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Object getResult() {
        return result;
    }
    public void setResult(Object result) {
        this.result = result;
    }
}
