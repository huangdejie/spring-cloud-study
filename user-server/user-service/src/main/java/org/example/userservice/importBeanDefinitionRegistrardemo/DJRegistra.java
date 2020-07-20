package org.example.userservice.importBeanDefinitionRegistrardemo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @Author: huangdj
 * @Date: 2020/7/20
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(DjImportBeanDefinitionRegister.class)
public @interface DJRegistra {
}
