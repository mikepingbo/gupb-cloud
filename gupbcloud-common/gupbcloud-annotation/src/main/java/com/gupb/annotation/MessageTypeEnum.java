package com.gupb.annotation;

/**
 * Message Type Enum.
 *
 * @author gupb
 */
@SuppressWarnings("ALL")
public enum MessageTypeEnum {

    /**
     * P 2 p message type enum.
     */
    P2P(1, "点对点模式"),

    /**
     * Topic message type enum.
     */
    TOPIC(2, "TOPIC模式");

    private final Integer code;

    private final String desc;

    MessageTypeEnum(final Integer code, final String desc) {
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
