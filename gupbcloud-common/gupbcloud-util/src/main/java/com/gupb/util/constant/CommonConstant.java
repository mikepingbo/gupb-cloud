package com.gupb.util.constant;

/**
 * CommonConstant.
 *
 * @author gupb
 */
public interface CommonConstant {

    /**
     * The constant LINE_SEPARATOR.
     */
    String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * The constant DB_MYSQL.
     */
    String DB_MYSQL = "mysql";

    /**
     * The constant DB_SQLSERVER.
     */
    String DB_SQLSERVER = "sqlserver";

    /**
     * The constant DB_ORACLE.
     */
    String DB_ORACLE = "oracle";

    /**
     * The constant PATH_SUFFIX.
     */
    String PATH_SUFFIX = "/gupb";

    /**
     * The constant DB_SUFFIX.
     */
    String DB_SUFFIX = "gupb_";

    /**
     * The constant RECOVER_REDIS_KEY_PRE.
     */
    String RECOVER_REDIS_KEY_PRE = "gupb:transaction:%s";

    /**
     * The constant GUPB_TRANSACTION_CONTEXT.
     */
    String GUPB_TRANSACTION_CONTEXT = "GUPB_TRANSACTION_CONTEXT";

    /**
     * The constant TOPIC_TAG_SEPARATOR.
     */
    String TOPIC_TAG_SEPARATOR = ",";

    /**
     * The constant SUCCESS.
     */
    int SUCCESS = 1;

    /**
     * The constant ERROR.
     */
    int ERROR = 0;

}
