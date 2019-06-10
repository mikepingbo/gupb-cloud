package com.gupb.util.mq;

import com.gupb.util.entity.GupbInvocation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * MessageEntity.
 * @author gupb
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageEntity {

    private String transId;

    private GupbInvocation gupbInvocation;

}
