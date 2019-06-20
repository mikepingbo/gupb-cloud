package com.gupb.annotation;

/**
 * Message Type Enum.
 *
 * @author gupb
 */
@SuppressWarnings("ALL")
public enum ModelTypeEnum {

    /**
     * service type enum.
     */
    SERVICE(1, "service"),

    /**
     * feign type enum.
     */
    FEIGN(2, "feign");

    private final Integer code;

    private final String desc;

    ModelTypeEnum(final Integer code, final String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public Integer getCode() {
        return code;
    }


    /**
     * Gets desc.
     *
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

}
