package com.suyh.custom.validation.constraints;

/**
 * 自定义实现接口参数校验注解
 * 允许null值，但是不允许元素空
 *
 * @author 苏雲弘
 * @since 2021-03-25
 */
@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR,
        ElementType.PARAMETER, ElementType.TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {NonBlankValidator.class})
@Repeatable(value = NonBlank.List.class)
public @interface NonBlank {

    String message() default "cannot be blank";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE,
            ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE })
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        NonBlank[] value();
    }
}
