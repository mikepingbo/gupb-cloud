package com.gupb.util.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * GupbParticipant.
 *
 * @author gupb
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GupbParticipant implements Serializable {

    private static final long serialVersionUID = -2590970715288987627L;

    private String transId;

    private String destination;

    private Integer pattern;

    private GupbInvocation gupbInvocation;

}
