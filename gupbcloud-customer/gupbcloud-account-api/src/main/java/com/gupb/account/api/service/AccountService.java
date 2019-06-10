package com.gupb.account.api.service;

import com.gupb.account.api.dto.AccountDTO;
import com.gupb.account.api.entity.AccountDO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    /**
     * logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountService.class);

//    private AccountMapper accountMapper;

//    @Autowired
//    private GupbMqSendService gupbMqSendService;

    /**
     * 扣款支付
     *
     * @param accountDTO 参数dto
     * @return true
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean payment(AccountDTO accountDTO) {
        LOGGER.info("============springcloud执行付款接口===============");
//        final AccountDO accountDO = accountMapper.findByUserId(accountDTO.getUserId());
//        if (accountDO.getBalance().compareTo(accountDTO.getAmount()) <= 0) {
//            throw new GupbRuntimeException("spring cloud account-service 资金不足！");
//        }
//        accountDO.setBalance(accountDO.getBalance().subtract(accountDTO.getAmount()));
//        accountDO.setUpdateTime(new Date());
//        final int update = accountMapper.update(accountDO);
//        if (update != 1) {
//            throw new GupbRuntimeException("spring cloud account-service 资金不足！");
//        }

        String destination = "inventory, inventory";
        final byte[] message = "bbb".getBytes();

//        gupbMqSendService.sendMessage(destination, null, message);

        return Boolean.TRUE;
    }

    /**
     * 获取用户账户信息
     *
     * @param userId 用户id
     * @return AccountDO
     */
    public AccountDO findByUserId(String userId) {
//        return accountMapper.findByUserId(userId);

        return null;
    }
}
