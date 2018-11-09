package c332030.utils.aop.process;

import c332030.utils.aop.annotation.Factory;
import com.google.common.collect.Sets;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.io.File;
import java.util.Set;

/**
 * @ClassName FactoryProcess
 * @Description TODO
 * @Author c332030
 * @Date 2018-10-24 08:57
 * @Version 1.0
 */
public class FactoryProcess extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        File file = new File("D:\\1.txt");
        if(file.exists()) {
            file.delete();
        }

        if(null == annotations
                || annotations.isEmpty()
                || null == roundEnv
            ) {
            return false;
        }

        processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,"type , id ");

        System.out.println("annotations: \n" + annotations.toString());
        System.out.println("roundEnv: \n" + roundEnv.toString());

        for (TypeElement typeElement : annotations) {    // 遍历annotations获取annotation类型
            for (Element element : roundEnv.getElementsAnnotatedWith(typeElement)
                ) {// 使用roundEnv.getElementsAnnotatedWith获取所有被某一类型注解标注的元素，依次遍历
                // 在元素上调用接口获取注解值

                processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
                       "type, id", element);
//                Class<?> type = element.getAnnotation(Factory.class).type();
//                String id = element.getAnnotation(Factory.class).id();
//
//                // 向当前环境输出warning信息
//                processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING,
//                        "type = " + type + ", id = " + id, element);
            }
        }

        return false;
    }

    /**
     *
     * @return 支持的注解
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        return Sets.newHashSet(Factory.class.getCanonicalName());
    }

    /**
     *
     * @return 资源版本
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }
}
