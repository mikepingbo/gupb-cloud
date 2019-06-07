package com.gupb.util.bean.context;

import com.gupb.util.enums.GupbRoleEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * GupbTransactionContext.
 * @author gupb
 */
@Data
public class GupbTransactionContext implements Serializable {

    private static final long serialVersionUID = -5289080166922118073L;

    private String transId;

    /**
     * role. {@linkplain GupbRoleEnum}
     */
    private int role;


}
