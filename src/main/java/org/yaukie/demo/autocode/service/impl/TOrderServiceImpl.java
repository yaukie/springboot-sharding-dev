
        package org.yaukie.demo.autocode.service.impl;


        import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
        import org.apache.shardingsphere.transaction.core.TransactionType;
        import org.yaukie.demo.autocode.dao.mapper.TOrderMapper;
        import org.yaukie.demo.autocode.model.TOrder;
        import org.yaukie.demo.autocode.model.TOrderExample;
        import org.yaukie.api.base.core.BaseService;
        import org.yaukie.demo.autocode.service.api.TOrderService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;



        /**
        * @author: yuenbin
        * @create: 2020/03/29 21/19/735
        **/
        @Service
        @ShardingTransactionType(value = TransactionType.XA) ///这里引入sharding的分布式事务
        @Transactional
        public class TOrderServiceImpl extends BaseService<TOrderMapper,TOrder,TOrderExample> implements TOrderService {

        @Autowired
        private TOrderMapper tOrderMapper;

        }
