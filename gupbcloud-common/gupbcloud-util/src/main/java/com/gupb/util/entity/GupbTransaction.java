package com.gupb.util.entity;

import com.google.common.collect.Lists;
import com.gupb.util.IdWorkerUtils;
import com.gupb.util.enums.GupbRoleEnum;
import com.gupb.util.enums.GupbStatusEnum;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * GupbTransaction.
 * @author gupb
 */
@Data
public class GupbTransaction implements Serializable {

    private static final long serialVersionUID = -6792063780987394917L;

    private String transId;

    /**
     * status. {@linkplain GupbStatusEnum}
     */
    private int status;

    /**
     * role. {@linkplain GupbRoleEnum}
     */
    private int role;

    private volatile int retriedCount;

    private Date createTime;

    private Date lastTime;

    private Integer version = 1;

    private String targetClass;

    private String targetMethod;

    private String errorMsg;

    private List<GupbParticipant> gupbParticipants;

    public GupbTransaction() {
        this.transId = IdWorkerUtils.getInstance().createUUID();
        this.createTime = new Date();
        this.lastTime = new Date();
        gupbParticipants = Lists.newCopyOnWriteArrayList();
    }

    public GupbTransaction(final String transId) {
        this.transId = transId;
        this.createTime = new Date();
        this.lastTime = new Date();
        gupbParticipants = Lists.newCopyOnWriteArrayList();
    }

    /**
     * add gupbParticipant.
     * @param gupbParticipant {@linkplain GupbParticipant}
     */
    public void registerParticipant(final GupbParticipant gupbParticipant) {
        gupbParticipants.add(gupbParticipant);
    }

}
