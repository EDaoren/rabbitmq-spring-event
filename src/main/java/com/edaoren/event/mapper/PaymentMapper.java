package com.edaoren.event.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.edaoren.event.entity.Payment;
import org.apache.ibatis.annotations.Mapper;


/**
 * Mapper 接口
 *
 * @author EDaoren
 */
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

    /**
     * 创建支付记录
     *
     * @param payment
     * @return
     */
    int create(Payment payment);

}
